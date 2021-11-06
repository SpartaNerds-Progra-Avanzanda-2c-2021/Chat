package servidor_manejadores;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import app.Conexion;
import app.Lobby;
import app.Sala;
import app.Usuario;
import servidor.ServerClient;
import utils.Acciones;
import utils.Peticion;
import utils.UserRoomInOutRequest;

public class ManejadorDeUsuarioSaleRoomServidor extends ManejadorDelServidor<String> {

	@Override
	public void manejar(Peticion<String> peticion, ArrayList<ServerClient> clientes, ServerClient solicitante, Lobby lobby)
			throws Exception {

		String nombreDeSalaDejada = peticion.getData();
		ArrayList<Sala> salas = lobby.getSalas();

		Sala salaDejada = null;
		
		for (Sala sala : salas) {
			if (sala.getNombre().equals(nombreDeSalaDejada))
				salaDejada = sala;
		}
		
		if(salaDejada == null) {
			return;
		}

		Conexion conexionBuscada = null;
		
		for (Conexion conexion: salaDejada.getConexiones()) {
			if(conexion.getUsuario().getId() == solicitante.id) {
				conexionBuscada = conexion;
			}
		}
		
		if(conexionBuscada == null) {
			return;
		}

		solicitante.setConexiones(solicitante.getConexiones()-1);
		salaDejada.removeConexion(conexionBuscada);	
		
		//deberia enviarselo solamente a los clientes dentro de la sala
		for (ServerClient cliente : clientes) {
			UserRoomInOutRequest userRoomInOutRequest = new UserRoomInOutRequest(salaDejada, solicitante.id);
			Peticion<UserRoomInOutRequest> serverMessage = new Peticion<UserRoomInOutRequest>(Acciones.USER_LEAVE_ROOM, userRoomInOutRequest);
			new ObjectOutputStream(cliente.cliente.getOutputStream()).writeObject(serverMessage);
			
			Peticion<Sala> serverMessageUpdateUsers = new Peticion<Sala>(Acciones.UPDATE_USERS, salaDejada);
			new ObjectOutputStream(cliente.cliente.getOutputStream()).writeObject(serverMessageUpdateUsers);
		}	
	}
}
