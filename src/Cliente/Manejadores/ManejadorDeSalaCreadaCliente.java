package Cliente.Manejadores;

import java.net.UnknownHostException;
import java.util.ArrayList;
import App.Sala;
import Graficos.JFramePrincipal;
import Graficos.JPanelSala;

import Utils.Peticion;

public class ManejadorDeSalaCreadaCliente extends ManejadorDelCliente<Sala> {

	@Override
	public void manejar(Peticion<Sala> peticion, JFramePrincipal jFramePrincipal)
			throws UnknownHostException, Exception {
		Sala sala = peticion.getData();

		jFramePrincipal.jPanelSalasYChats.addJPanelSala(sala.getNombre(), 0, 0);
	}
}
