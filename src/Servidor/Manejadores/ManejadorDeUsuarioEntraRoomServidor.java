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
			UserRoomInOutRequest userRoomInOutRequest = new UserRoomInOutRequest(salaBuscada, solicitante.id);
			Peticion<UserRoomInOutRequest> serverMessage = new Peticion<UserRoomInOutRequest>(Acciones.USER_ENTERS_ROOM, userRoomInOutRequest);
			new ObjectOutputStream(cliente.cliente.getOutputStream()).writeObject(serverMessage);
		}
	}
}
