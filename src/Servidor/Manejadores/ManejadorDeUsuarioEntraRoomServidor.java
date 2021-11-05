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
import Utils.Acciones;
import Utils.Peticion;

public class ManejadorDeUsuarioEntraRoomServidor extends ManejadorDelServidor<String> {

	@Override
	public void manejar(Peticion<String> peticion, ArrayList<Socket> clientes, Socket solicitante, Lobby lobby)
			throws Exception {

		Sala salaBuscada = new Sala(peticion.getData());
		ArrayList<Sala> salas = lobby.getSalas();

		for (Sala sala : salas) {
			if (sala.getNombre().equals(salaBuscada.getNombre()))
				salaBuscada = sala;
		}

		Usuario nuevoUser = new Usuario(); 
		Conexion nuevaConex = new Conexion(nuevoUser, new Date());
		salaBuscada.addConexion(nuevaConex);

		for (Socket cliente : clientes) {
			Peticion<Sala> serverMessage = new Peticion<Sala>(Acciones.USER_ENTERS_ROOM, salaBuscada);
			new ObjectOutputStream(cliente.getOutputStream()).writeObject(serverMessage);
		}
	}
}
