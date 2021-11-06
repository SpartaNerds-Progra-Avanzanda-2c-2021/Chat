package Servidor;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.Socket;
import java.util.ArrayList;

import Servidor.Manejadores.ManejadorDelServidor;
import Servidor.Manejadores.ManejadoresServidorEnum;
import Utils.Acciones;
import Utils.Peticion;
import app.Lobby;

public class HiloEnrrutadorDeServidor extends Thread{
	private ServerClient cliente;
	private ArrayList<ServerClient> clientes;
	public Lobby lobby;
	
	public HiloEnrrutadorDeServidor(ServerClient cliente, ArrayList<ServerClient> clientes, Lobby lobby) {
		super();
		this.cliente = cliente;
		this.clientes = clientes;
		this.lobby = lobby;
	}

	public void run() {
		Peticion<?> peticion;
		try {
			peticion = (Peticion<?>) new ObjectInputStream(cliente.cliente.getInputStream()).readObject();
			while (peticion.getTipo() != Acciones.USER_DISCONNECTED_FROM_SERVER) {
				enrrutar(peticion);										
				peticion = (Peticion<?>) new ObjectInputStream(cliente.cliente.getInputStream()).readObject();
			}
			
			System.out.println("El cliente se ha desconectado");
		} catch (Exception e) {
			System.out.println("El cliente se ha desconectado: "+e.getMessage());
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void enrrutar(Peticion<?> peticion) {
		ManejadorDelServidor manejador = ManejadoresServidorEnum.map.get(peticion.getTipo());
		try {
			manejador.manejar(peticion,this.clientes, this.cliente, this.lobby);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String sStackTrace = sw.toString();
			
			System.out.println("No se obtuvo un manejador para la accion | "+sStackTrace);
		}
	}
}
