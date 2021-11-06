package Servidor.Manejadores;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import App.Conexion;
import App.Lobby;
import App.Sala;
import App.Usuario;
import Servidor.ServerClient;
import Utils.Acciones;
import Utils.Peticion;
import Utils.UserRoomInOutRequest;

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
		}	
	}
}
