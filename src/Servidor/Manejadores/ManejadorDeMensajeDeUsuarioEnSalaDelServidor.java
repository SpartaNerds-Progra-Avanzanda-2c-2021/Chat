package Servidor.Manejadores;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import App.Conexion;
import App.Lobby;
import App.Mensaje;
import App.Sala;
import Servidor.ServerClient;
import Utils.Acciones;
import Utils.Peticion;

public class ManejadorDeMensajeDeUsuarioEnSalaDelServidor extends ManejadorDelServidor<Sala> {

	@Override
	public void manejar(Peticion<Sala> peticion, ArrayList<ServerClient> clientes, ServerClient solicitante, Lobby lobby)
			throws Exception {
		InetAddress address = InetAddress.getLocalHost();
		String ip = address.getHostAddress();

		Sala salaBuscada = new Sala(peticion.getData().getNombre());
		ArrayList<Sala> salas = lobby.getSalas();

		for (Sala sala : salas) {
			if (sala.getNombre().equals(salaBuscada.getNombre()))
				salaBuscada = sala;
		}
		Mensaje mensaje = new Mensaje(peticion.getData().getMensajeTope().getPropietario(), System.currentTimeMillis(),
				ip + ": " + peticion.getData().getMensajeTope().getInfo());
		salaBuscada.addMensaje(mensaje);

		//Enviar esto solo a los usuarios dentro de la salaBuscada		
		
		for (ServerClient cliente : clientes) {
			Peticion<Mensaje> serverMessage = new Peticion<Mensaje>(Acciones.USER_SEND_ROOM_SMG, mensaje);
			new ObjectOutputStream(cliente.cliente.getOutputStream()).writeObject(serverMessage);
		}
	}
}
