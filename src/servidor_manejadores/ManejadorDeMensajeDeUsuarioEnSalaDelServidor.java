package servidor_manejadores;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import app.Conexion;
import app.Lobby;
import app.Mensaje;
import app.Sala;
import app.Usuario;
import servidor.ServerClient;
import utils.Acciones;
import utils.Peticion;

public class ManejadorDeMensajeDeUsuarioEnSalaDelServidor extends ManejadorDelServidor<Mensaje> {

	@Override
	public void manejar(Peticion<Mensaje> peticion, ArrayList<ServerClient> clientes, ServerClient solicitante, Lobby lobby)
			throws Exception {

		Mensaje mensaje = peticion.getData();
		
		Sala salaBuscada = new Sala(mensaje.sala);
		ArrayList<Sala> salas = lobby.getSalas();
		for (Sala sala : salas) {
			if (sala.getNombre().equals(salaBuscada.getNombre()))
				salaBuscada = sala;
		}
		
		salaBuscada.addMensaje(mensaje);

		//Enviar esto solo a los usuarios dentro de la salaBuscada
		for (ServerClient serverClient : clientes) {
			for (Conexion conexionesDeLaSala : salaBuscada.getConexiones()) {
				if(conexionesDeLaSala.getUsuario().getId() != serverClient.id) {
					continue;
				}
				if(!mensaje.privado) {
					Peticion<Sala> serverMessage = new Peticion<Sala>(Acciones.USER_SEND_ROOM_SMG, salaBuscada);
					new ObjectOutputStream(serverClient.cliente.getOutputStream()).writeObject(serverMessage);
					continue;
				}
				
				for (Usuario usuario: mensaje.destinatarios) {
					if(usuario.getId() == conexionesDeLaSala.getUsuario().getId()) {
						Peticion<Sala> serverMessage = new Peticion<Sala>(Acciones.USER_SEND_ROOM_SMG, salaBuscada);
						new ObjectOutputStream(serverClient.cliente.getOutputStream()).writeObject(serverMessage);
					}
				}
			}		
		}
		
	}
}
