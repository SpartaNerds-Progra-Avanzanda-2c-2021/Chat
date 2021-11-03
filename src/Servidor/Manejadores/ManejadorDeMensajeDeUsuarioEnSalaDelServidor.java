package Servidor.Manejadores;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import App.Lobby;
import App.Mensaje;
import Utils.Acciones;
import Utils.Peticion;

public class ManejadorDeMensajeDeUsuarioEnSalaDelServidor extends ManejadorDelServidor<Mensaje>{

	@Override
	public void manejar(Peticion<Mensaje> peticion, ArrayList<Socket> clientes, Socket solicitante, Lobby lobby) throws Exception {
		InetAddress address = InetAddress.getLocalHost();
		String ip = address.getHostAddress();

		Mensaje mensaje = new Mensaje(
			peticion.getData().getPropietario(),
			System.currentTimeMillis(),
			ip+ ": " + peticion.getData().getInfo()
		);
		Peticion<Mensaje> serverMessage = new Peticion<Mensaje>(Acciones.USER_SEND_ROOM_SMG, mensaje); 

		for (Socket clinte: clientes) {
			if(clinte != solicitante) {
				new ObjectOutputStream(clinte.getOutputStream()).writeObject(serverMessage);
			}
		}
	}
}
