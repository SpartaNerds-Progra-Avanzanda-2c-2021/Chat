package Cliente.Manejadores;

import App.Mensaje;
import App.Sala;
import Cliente.Cliente;
import Graficos.JFramePrincipal;
import Utils.Peticion;

public class ManejadorDeMensajeDeUsuarioEnSalaDelCliente extends ManejadorDelCliente<Sala>{

	@Override
	public void manejar(Peticion<Sala> peticion, JFramePrincipal jFramePrincipal) throws Exception {
		Sala sala = peticion.getData();
		
		Cliente.salasPosibles.put(sala.getNombre(),sala.getMensajes());
		
		if(sala.getNombre().equals(Cliente.salaActual)) {
			jFramePrincipal.jPanelComunication.setearMensaje(sala.getMensajes());
		}
	}
}
