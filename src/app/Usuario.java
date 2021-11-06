package app;

import java.io.Serializable;

public class Usuario implements Serializable{
	private int id;
	
	public Usuario(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
