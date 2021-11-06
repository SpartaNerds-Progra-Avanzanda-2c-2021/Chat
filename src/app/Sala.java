package app;

import java.io.Serializable;
import java.util.ArrayList;

public class Sala implements Serializable {
	private String nombre;
	private ArrayList<Conexion> conexiones;
	private ArrayList<Mensaje> mensajes;
	private ArrayList<Chat> chats;

	public Sala(String nombre) {
		super();
		this.nombre = nombre;
		this.conexiones = new ArrayList<Conexion>();
		this.mensajes = new ArrayList<Mensaje>();
		this.chats = new ArrayList<Chat>();
	}

	public void addConexion(Conexion conex) {
		this.conexiones.add(conex);
	}
	
	public void removeConexion(Conexion conex) {
		this.conexiones.remove(conex);
	}
	
	public void addMensaje(Mensaje msj) {
		this.mensajes.add(msj);
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Conexion> getConexiones() {
		return conexiones;
	}

	public ArrayList<Mensaje> getMensajes() {
		return mensajes;
	}

	public Mensaje getMensajeTope() {
		return mensajes.get(0);
	}

	public ArrayList<Chat> getChats() {
		return chats;
	}
}
