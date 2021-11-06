package Servidor.Manejadores;

import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import Servidor.ServerClient;
import Utils.Peticion;
import app.Lobby;

public abstract class ManejadorDelServidor<T> {
	public abstract void manejar(Peticion<T> peticion, ArrayList<ServerClient> clientes, ServerClient solicitante, Lobby lobby)
			throws UnknownHostException, Exception;
}
