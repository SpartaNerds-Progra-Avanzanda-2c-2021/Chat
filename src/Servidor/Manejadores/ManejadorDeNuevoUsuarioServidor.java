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

public class ManejadorDeNuevoUsuarioServidor extends ManejadorDelServidor<String> {

	@Override
	public void manejar(Peticion<String> peticion, ArrayList<Socket> clientes, Socket solicitante, Lobby lobby)
			throws Exception {

		Peticion<ArrayList<Sala>> serverMessage = new Peticion<ArrayList<Sala>>(Acciones.USER_ENTERS_SERVER,
				lobby.getSalas());
		new ObjectOutputStream(solicitante.getOutputStream()).writeObject(serverMessage);
	}
}
