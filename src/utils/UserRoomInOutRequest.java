package utils;

import java.io.Serializable;
import java.util.ArrayList;

import app.Mensaje;
import app.Sala;
import app.Usuario;

public class UserRoomInOutRequest implements Serializable  {
	private Sala sala;
	private int usuarioId;
	public ArrayList<Mensaje> mensajes = new ArrayList<Mensaje>();
	
	public UserRoomInOutRequest(Sala sala, int usuarioId) {
		super();
		this.sala = sala;
		this.usuarioId = usuarioId;
	}

	public Sala getSala() {
		return sala;
	}

	public int getUsuarioId() {
		return usuarioId;
	}
	
	public void setMensaje(ArrayList<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
}
