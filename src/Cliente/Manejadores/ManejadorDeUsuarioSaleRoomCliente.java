package Cliente.Manejadores;

import java.awt.Color;
import java.net.UnknownHostException;
import java.util.ArrayList;

import Cliente.Cliente;
import Graficos.JFramePrincipal;
import Graficos.JPanelSala;
import Utils.Peticion;
import Utils.UserRoomInOutRequest;
import app.Conexion;
import app.Mensaje;
import app.Sala;

public class ManejadorDeUsuarioSaleRoomCliente extends ManejadorDelCliente<UserRoomInOutRequest>{

	@Override
	public void manejar(Peticion<UserRoomInOutRequest> peticion, JFramePrincipal jFramePrincipal)
			throws UnknownHostException, Exception {
		Sala sala = peticion.getData().getSala();
		
		//actualizar los conectados
		ArrayList<JPanelSala> panelSalas = jFramePrincipal.jPanelSalas.getSalas();
		
		Sala salaBuscada = null;
		JPanelSala panelSalaBuscada = null;
		
		for (JPanelSala panelSala : panelSalas) { 
			if (sala.getNombre().equals(panelSala.getNombre())) {
				panelSala.actualizarCantConexiones(sala.getConexiones().size());
				panelSala.updateJLabel();
				Cliente.salasPosibles.remove(sala.getNombre());
				salaBuscada = sala;
				panelSalaBuscada = panelSala;
			}
		}
		
		if(salaBuscada == null) {
			return;
		}
		
		if(peticion.getData().getUsuarioId() == (int)Cliente.clienteId) {
			panelSalaBuscada.switchConection();
		}
	}
}
