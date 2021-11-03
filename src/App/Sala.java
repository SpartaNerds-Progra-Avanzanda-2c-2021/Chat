package App;

import java.io.Serializable;
import java.util.ArrayList;

public class Sala implements Serializable{
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
	
	public String getNombre() {
		return nombre;
	}
	
	public ArrayList<Conexion> getConexiones() {
		return conexiones;
	}
	
	public ArrayList<Mensaje> getMensajes() {
		return mensajes;
	}
	public ArrayList<Chat> getChats() {
		return chats;
	}
}
