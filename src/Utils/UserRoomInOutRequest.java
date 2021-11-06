package Utils;

import java.io.Serializable;

import App.Sala;
import App.Usuario;

public class UserRoomInOutRequest implements Serializable  {
	private Sala sala;
	private int usuarioId;
	
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
}
