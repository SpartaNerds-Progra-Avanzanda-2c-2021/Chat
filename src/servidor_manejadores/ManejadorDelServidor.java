package servidor_manejadores;import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import app.Lobby;
import servidor.ServerClient;
import utils.Peticion;

public abstract class ManejadorDelServidor<T> {
	public abstract void manejar(Peticion<T> peticion, ArrayList<ServerClient> clientes, ServerClient solicitante, Lobby lobby)
			throws UnknownHostException, Exception;
}
