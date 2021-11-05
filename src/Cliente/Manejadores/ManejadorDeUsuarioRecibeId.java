package Cliente.Manejadores;

import java.net.UnknownHostException;
import java.util.ArrayList;
import App.Sala;
import Cliente.Cliente;
import Graficos.JFramePrincipal;
import Graficos.JPanelSala;

import Utils.Peticion;

public class ManejadorDeUsuarioRecibeId extends ManejadorDelCliente<Number> {

	@Override
	public void manejar(Peticion<Number> peticion, JFramePrincipal jFramePrincipal)
			throws UnknownHostException, Exception {
		Number clienteId = peticion.getData();

		Cliente.clienteId = clienteId;
	}
}
