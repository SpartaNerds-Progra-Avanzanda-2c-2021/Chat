package cliente_manejadores;

import java.net.UnknownHostException;
import java.util.ArrayList;

import app.Sala;
import graficos.JFramePrincipal;
import utils.Peticion;

public class ManejadorDeNuevoUsuarioCliente extends ManejadorDelCliente<ArrayList<Sala>> {

	@Override
	public void manejar(Peticion<ArrayList<Sala>> peticion, JFramePrincipal jFramePrincipal)
			throws UnknownHostException, Exception {
		ArrayList<Sala> salas = peticion.getData();

		for (Sala sala : salas) {
			jFramePrincipal.jPanelSalas.addJPanelSala(sala.getNombre(), sala.getConexiones().size(),
					sala.getMensajes().size());
		}
	}
}
