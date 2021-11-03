package Servidor.Manejadores;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import App.Lobby;
import App.Mensaje;
import App.Sala;
import Utils.Acciones;
import Utils.Peticion;

public class ManejadorDeSalaCreadaServer extends ManejadorDelServidor<String> {

	@Override
	public void manejar(Peticion<String> peticion, ArrayList<Socket> clientes, Socket solicitante, Lobby lobby)
			throws Exception {

		Sala sala = new Sala(peticion.getData());
		lobby.addSala(sala);

		for (Socket cliente : clientes) {
			Peticion<Sala> serverMessage = new Peticion<Sala>(Acciones.USER_CREATE_ROOM, sala);
			new ObjectOutputStream(cliente.getOutputStream()).writeObject(serverMessage);
		}
	}
}
