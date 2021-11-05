package App;

import java.io.Serializable;

public class Usuario implements Serializable{
	private String nombre;
	private static int id = 0;
	
	public Usuario() {
		this.nombre =  String.valueOf(id);
		id++;
	}
}
