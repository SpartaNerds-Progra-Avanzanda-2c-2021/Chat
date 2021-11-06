package Servidor.Manejadores;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import Servidor.ServerClient;
import Utils.Acciones;
import Utils.Peticion;
import app.Conexion;
import app.Lobby;
import app.Sala;
import app.Usuario;

public class ManejadorDeUsuarioSolicitaUsuariosServidor extends ManejadorDelServidor<String> {

	@Override
	public void manejar(Peticion<String> peticion, ArrayList<ServerClient> clientes, ServerClient solicitante, Lobby lobby)
			throws Exception {

		String nombreDeSalaBuscada = peticion.getData();
		ArrayList<Sala> salas = lobby.getSalas();

		Sala salaBuscada = null;
		
		for (Sala sala : salas) {
			if (sala.getNombre().equals(nombreDeSalaBuscada))
				salaBuscada = sala;
		}

		Conexion conexionBuscada = null;
		
		for (Conexion conexion: salaBuscada.getConexiones()) {
			if(conexion.getUsuario().getId() == solicitante.id) {
				conexionBuscada = conexion;
			}
		}
		if(conexionBuscada == null) {
			return;
		}
		
		Peticion<ArrayList<Conexion>> serverMessage = new Peticion<ArrayList<Conexion>>(Acciones.SEND_USERS_TO_USERS, salaBuscada.getConexiones());
		new ObjectOutputStream(solicitante.cliente.getOutputStream()).writeObject(serverMessage);
	}
}
