package servidor_manejadores;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import app.Lobby;
import app.Mensaje;
import app.Sala;
import servidor.ServerClient;
import utils.Acciones;
import utils.Peticion;

public class ManejadorDeNuevoUsuarioServidor extends ManejadorDelServidor<String> {

	@Override
	public void manejar(Peticion<String> peticion, ArrayList<ServerClient> clientes, ServerClient solicitante, Lobby lobby)
			throws Exception {

		Peticion<ArrayList<Sala>> serverMessage = new Peticion<ArrayList<Sala>>(Acciones.USER_ENTERS_SERVER,
				lobby.getSalas());
		new ObjectOutputStream(solicitante.cliente.getOutputStream()).writeObject(serverMessage);
		
		Peticion<Number> serverMessageId = new Peticion<Number>(Acciones.SEND_ID_TO_USER,solicitante.id);
		new ObjectOutputStream(solicitante.cliente.getOutputStream()).writeObject(serverMessageId);
	}
}
