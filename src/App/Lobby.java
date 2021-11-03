package App;

import java.util.ArrayList;

public class Lobby {
	private ArrayList<Sala> salas;

	public Lobby() {
		super();
		this.salas = new ArrayList<Sala>();
	}

	public ArrayList<Sala> getSalas() {
		return salas;
	}

	public void addSala(Sala sala) {
		this.salas.add(sala);
	}
}
