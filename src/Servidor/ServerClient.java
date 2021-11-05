package Servidor;

import java.net.Socket;

public class ServerClient{
	private static int ultimoId = 0;
	public int id = 0;
	public Socket cliente;
	private int conexiones = 0;
	
	public ServerClient(Socket cliente) {
		super();
		this.id = ultimoId;
		ultimoId++;
		this.cliente = cliente;
	}
	
	public int getConexiones() {
		return conexiones;
	}

	public void setConexiones(int conexiones) {
		if(conexiones < 0) {
			conexiones = 0;
		}
		this.conexiones = conexiones;
	}
}
