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

public class ManejadorDeUsuarioSolicitaUsuariosSinCambioEnGUIServidor extends ManejadorDelServidor<String> {

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
		
		Peticion<Sala> serverMessage = new Peticion<Sala>(Acciones.UPDATE_USERS, salaBuscada);
		new ObjectOutputStream(solicitante.cliente.getOutputStream()).writeObject(serverMessage);
	}
}
