package Servidor;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import App.Lobby;

public class Servidor {
	private ArrayList<Socket> clientes;
	public static Lobby lobby = new Lobby();
	
	public Servidor(int puerto) {
		int i=0;
		clientes = new ArrayList<Socket>();
		
		try {
			ServerSocket server = new ServerSocket(puerto);
			System.out.println("Servidor en linea...");
			while (i < Constantes.clientesSoportados) {
				Socket cliente = server.accept();
				clientes.add(cliente);
				new HiloEnrrutadorDeServidor(cliente, clientes, lobby).start();
				i++;
			}
			server.close();
			System.out.println("El servidor esta lleno");
		} catch (Exception e) {
			System.out.println("Ocurrio un problema con el server: "+e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		try {
			new Servidor(Constantes.puerto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
