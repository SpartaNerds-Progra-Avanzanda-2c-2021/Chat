package App;

import java.io.Serializable;
import java.util.Date;

public class Mensaje implements Serializable{
	private int propietario;
	private Long createdAt;
	private String info;
	
	public Mensaje(int propietario, Long createdAt, String info) {
		super();
		this.propietario = propietario;
		this.createdAt = createdAt;
		this.info = info;
	}
	
	public int getPropietario() {
		return propietario;
	}
	public Long getCreatedAt() {
		return createdAt;
	}
	public String getInfo() {
		return info;
	}
}
