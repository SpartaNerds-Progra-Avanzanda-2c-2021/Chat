package cliente_manejadores;

import java.net.UnknownHostException;
import java.util.ArrayList;

import cliente.Cliente;
import app.Sala;
import graficos.JFramePrincipal;
import utils.Peticion;

public class ManejadorDeUsuarioRecibeId extends ManejadorDelCliente<Number> {

	@Override
	public void manejar(Peticion<Number> peticion, JFramePrincipal jFramePrincipal)
			throws UnknownHostException, Exception {
		Number clienteId = peticion.getData();

		Cliente.clienteId = clienteId;
	}
}