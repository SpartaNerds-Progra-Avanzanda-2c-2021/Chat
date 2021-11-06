package Cliente.Manejadores;

import java.net.UnknownHostException;
import java.util.ArrayList;

import Graficos.JFramePrincipal;

import Utils.Peticion;
import app.Sala;

public class ManejadorDeSalaCreadaCliente extends ManejadorDelCliente<Sala> {

	@Override
	public void manejar(Peticion<Sala> peticion, JFramePrincipal jFramePrincipal)
			throws UnknownHostException, Exception {
		Sala sala = peticion.getData();

		jFramePrincipal.jPanelSalas.addJPanelSala(sala.getNombre(), sala.getConexiones().size(), 0);
	}
}
