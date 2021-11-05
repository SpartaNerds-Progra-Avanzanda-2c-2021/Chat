package Cliente.Manejadores;

import App.Mensaje;
import Graficos.JFramePrincipal;
import Utils.Peticion;

public class ManejadorDeMensajeDeUsuarioEnSalaDelCliente extends ManejadorDelCliente<Mensaje>{

	@Override
	public void manejar(Peticion<Mensaje> peticion, JFramePrincipal jFramePrincipal) throws Exception {
		System.out.println(peticion.getData().getInfo()+"\n");
		
		//jFramePrincipal.jPanelComunication.addPanelMensaje(peticion.getData().getPropietario(), peticion.getData().getCreatedAt(), peticion.getData().getInfo());
	}
}
