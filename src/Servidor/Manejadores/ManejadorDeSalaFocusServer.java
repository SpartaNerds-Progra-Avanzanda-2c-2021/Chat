package Servidor.Manejadores;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import App.Lobby;
import App.Mensaje;
import App.Sala;
import Servidor.ServerClient;
import Utils.Acciones;
import Utils.Peticion;

public class ManejadorDeSalaFocusServer extends ManejadorDelServidor<String> {

	@Override
	public void manejar(Peticion<String> peticion, ArrayList<ServerClient> clientes, ServerClient solicitante, Lobby lobby)
			throws Exception {
		
		String nombreDeSalaABuscar = peticion.getData();
		ArrayList<Mensaje> historial;
		
		for (Sala sala : lobby.getSalas()) {
			if(sala.getNombre().equals(nombreDeSalaABuscar)) {
				historial = sala.getMensajes();
			}
		}
		
		
		
		//Peticion<ArrayList<Mensaje>> serverMessage = new Peticion<ArrayList<Mensaje>>(Acciones.USER_CREATE_ROOM, historial);
		//new ObjectOutputStream(solicitante.cliente.getOutputStream()).writeObject(serverMessage);
	}
}
