package Cliente.Manejadores;

import java.net.UnknownHostException;

import Graficos.JFramePrincipal;
import Utils.Peticion;

public abstract class ManejadorDelCliente<T> {
	public abstract void manejar(Peticion<T> peticion, JFramePrincipal jFramePrincipal) throws UnknownHostException, Exception;
}
