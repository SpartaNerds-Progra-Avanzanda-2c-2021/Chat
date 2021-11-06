package servidor_manejadores;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import app.Conexion;
import app.Lobby;
import app.Mensaje;
import app.Sala;
import servidor.ServerClient;
import utils.Acciones;
import utils.Peticion;

public class ManejadorDeMensajeDeUsuarioEnSalaDelServidor extends ManejadorDelServidor<Mensaje> {

	@Override
	public void manejar(Peticion<Mensaje> peticion, ArrayList<ServerClient> clientes, ServerClient solicitante, Lobby lobby)
			throws Exception {

		Sala salaBuscada = new Sala(peticion.getData().sala);
		ArrayList<Sala> salas = lobby.getSalas();

		for (Sala sala : salas) {
			if (sala.getNombre().equals(salaBuscada.getNombre()))
				salaBuscada = sala;
		}
		
		salaBuscada.addMensaje(peticion.getData());

		//Enviar esto solo a los usuarios dentro de la salaBuscada
		for (ServerClient serverClient : clientes) {
			for (Conexion coexion : salaBuscada.getConexiones()) {
				if(coexion.getUsuario().getId() == serverClient.id) {
					Peticion<Sala> serverMessage = new Peticion<Sala>(Acciones.USER_SEND_ROOM_SMG, salaBuscada);
					new ObjectOutputStream(serverClient.cliente.getOutputStream()).writeObject(serverMessage);			
				}
			}		
		}
	}
}
