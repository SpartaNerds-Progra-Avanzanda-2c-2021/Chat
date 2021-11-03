package Servidor.Manejadores;

import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import App.Lobby;
import Utils.Peticion;

public abstract class ManejadorDelServidor<T> {
	public abstract void manejar(Peticion<T> peticion, ArrayList<Socket> clientes, Socket solicitante, Lobby lobby)
			throws UnknownHostException, Exception;
}
