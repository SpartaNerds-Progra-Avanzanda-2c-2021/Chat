package Utils;

import java.io.Serializable;

public class Peticion<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private int tipo;
	T data;

	public Peticion(int tipo, T data) {
		super();
		this.tipo = tipo;
		this.data = data;
	}

	public int getTipo() {
		return tipo;
	}

	public T getData() {
		return data;
	}
}
