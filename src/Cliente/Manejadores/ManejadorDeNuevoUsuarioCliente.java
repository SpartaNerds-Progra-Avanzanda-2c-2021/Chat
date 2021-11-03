package Cliente.Manejadores;

import java.net.UnknownHostException;
import java.util.ArrayList;
import App.Sala;
import Graficos.JFramePrincipal;
import Graficos.JPanelSala;

import Utils.Peticion;

public class ManejadorDeNuevoUsuarioCliente extends ManejadorDelCliente<ArrayList<Sala>> {

	@Override
	public void manejar(Peticion<ArrayList<Sala>> peticion, JFramePrincipal jFramePrincipal)
			throws UnknownHostException, Exception {
		ArrayList<Sala> salas = peticion.getData();

		for (Sala sala : salas) {
			jFramePrincipal.jPanelSalasYChats.addJPanelSala(sala.getNombre(), sala.getConexiones().size(),
					sala.getMensajes().size());
		}
	}
}
