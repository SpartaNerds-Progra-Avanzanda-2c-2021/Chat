package servidor_manejadores;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import app.Conexion;
import app.Lobby;
import app.Mensaje;
import app.Sala;
import app.Usuario;
import servidor.ServerClient;
import utils.Acciones;
import utils.Peticion;
import utils.UserRoomInOutRequest;

public class ManejadorDeUsuarioEntraRoomServidor extends ManejadorDelServidor<String> {

	@Override
	public void manejar(Peticion<String> peticion, ArrayList<ServerClient> clientes, ServerClient solicitante, Lobby lobby)
			throws Exception {

		Sala salaBuscada = new Sala(peticion.getData());
		ArrayList<Sala> salas = lobby.getSalas();

		for (Sala sala : salas) {
			if (sala.getNombre().equals(salaBuscada.getNombre()))
				salaBuscada = sala;
		}

		for (Conexion conexion: salaBuscada.getConexiones()) {
			if (conexion.getUsuario().getId() == solicitante.id) {
				return;
			}
		}
		
		if(solicitante.getConexiones() >= 3) {
			return;
		}
		
		Usuario nuevoUser = new Usuario(solicitante.id); 
		Conexion nuevaConex = new Conexion(nuevoUser, new Date());
		salaBuscada.addConexion(nuevaConex);

		solicitante.setConexiones(solicitante.getConexiones()+1);
		
		//deberia enviarselo solamente a los clientes dentro de la sala
		for (ServerClient cliente : clientes) {
			for (Conexion conexionesDeLaSala : salaBuscada.getConexiones()) {
				
				if(conexionesDeLaSala.getUsuario().getId() != cliente.id) {
					continue;
				}
				
				ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
				
				for (Mensaje mensaje : salaBuscada.getMensajes()) {
					for (Usuario destinatario : mensaje.destinatarios) {
						if(!mensaje.privado) {
							mensajes.add(mensaje);
							continue;
						}
						if(destinatario.getId() == cliente.id) {
							mensajes.add(mensaje);
						}
					}
				}
				
				UserRoomInOutRequest userRoomInOutRequest = new UserRoomInOutRequest(salaBuscada, solicitante.id);
				userRoomInOutRequest.setMensaje(mensajes);
				
				Peticion<UserRoomInOutRequest> serverMessage = new Peticion<UserRoomInOutRequest>(Acciones.USER_ENTERS_ROOM, userRoomInOutRequest);
				new ObjectOutputStream(cliente.cliente.getOutputStream()).writeObject(serverMessage);
				
				Peticion<Sala> serverMessageUpdateUsers = new Peticion<Sala>(Acciones.UPDATE_USERS, salaBuscada);
				new ObjectOutputStream(cliente.cliente.getOutputStream()).writeObject(serverMessageUpdateUsers);
			}
		}
	}
}
