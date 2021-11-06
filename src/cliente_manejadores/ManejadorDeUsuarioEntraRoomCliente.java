package cliente_manejadores;

import java.awt.Color;
import java.net.UnknownHostException;
import java.util.ArrayList;

import cliente.Cliente;
import app.Conexion;
import app.Mensaje;
import app.Sala;
import graficos.JFramePrincipal;
import graficos.JPanelSala;
import utils.Peticion;
import utils.UserRoomInOutRequest;

public class ManejadorDeUsuarioEntraRoomCliente extends ManejadorDelCliente<UserRoomInOutRequest>{

	@Override
	public void manejar(Peticion<UserRoomInOutRequest> peticion, JFramePrincipal jFramePrincipal)
			throws UnknownHostException, Exception {
		Sala sala = peticion.getData().getSala();
		
		//actualizar los conectados
		ArrayList<JPanelSala> panelSalas = jFramePrincipal.jPanelSalas.getSalas();
		
		JPanelSala panelSalaBuscada = null;
		Sala salaBuscada = null;
		
		for (JPanelSala panelSala : panelSalas) { 
			if (sala.getNombre().equals(panelSala.getNombre())) {
				panelSala.actualizarCantConexiones(sala.getConexiones().size());
				panelSala.updateJLabel();
				panelSalaBuscada = panelSala;
				salaBuscada = sala;
			}
		}
		
		if(panelSalaBuscada == null) {
			return;
		}
		
		if(peticion.getData().getUsuarioId() == (int)Cliente.clienteId) {
			panelSalaBuscada.switchConection();
			ArrayList<Mensaje> msj = sala.getMensajes();
			Cliente.salasPosibles.put(salaBuscada.getNombre(), msj);
			jFramePrincipal.jPanelComunication.setearMensaje(msj);
		}
	}
}
