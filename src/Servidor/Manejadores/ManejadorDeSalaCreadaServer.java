package Servidor.Manejadores;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import Servidor.ServerClient;
import Utils.Acciones;
import Utils.Peticion;
import app.Lobby;
import app.Mensaje;
import app.Sala;

public class ManejadorDeSalaCreadaServer extends ManejadorDelServidor<String> {

	@Override
	public void manejar(Peticion<String> peticion, ArrayList<ServerClient> clientes, ServerClient solicitante, Lobby lobby)
			throws Exception {
		
		String nombreDeSalaACrear = peticion.getData();
		
		for (Sala sala : lobby.getSalas()) {
			if(sala.getNombre().equals(nombreDeSalaACrear)) {
				return;
			}
		}
		
		Sala sala = new Sala(nombreDeSalaACrear);
		lobby.addSala(sala);

		for (ServerClient cliente : clientes) {
			Peticion<Sala> serverMessage = new Peticion<Sala>(Acciones.USER_CREATE_ROOM, sala);
			new ObjectOutputStream(cliente.cliente.getOutputStream()).writeObject(serverMessage);
		}
	}
}
