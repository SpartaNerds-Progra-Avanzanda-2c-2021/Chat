package Cliente.Manejadores;

import java.net.UnknownHostException;
import java.util.ArrayList;

import Cliente.Cliente;
import Graficos.JFramePrincipal;

import Utils.Peticion;
import app.Sala;

public class ManejadorDeUsuarioRecibeId extends ManejadorDelCliente<Number> {

	@Override
	public void manejar(Peticion<Number> peticion, JFramePrincipal jFramePrincipal)
			throws UnknownHostException, Exception {
		Number clienteId = peticion.getData();

		Cliente.clienteId = clienteId;
	}
}