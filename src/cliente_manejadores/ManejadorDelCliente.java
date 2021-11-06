package cliente_manejadores;

import java.net.UnknownHostException;

import graficos.JFramePrincipal;
import utils.Peticion;

public abstract class ManejadorDelCliente<T> {
	public abstract void manejar(Peticion<T> peticion, JFramePrincipal jFramePrincipal) throws UnknownHostException, Exception;
}
