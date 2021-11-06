package Cliente.Manejadores;

import java.awt.Color;
import java.net.UnknownHostException;
import java.util.ArrayList;

import App.Conexion;
import App.Mensaje;
import App.Sala;
import Graficos.JFramePrincipal;
import Graficos.JPanelSala;
import Utils.Peticion;

public class ManejadorDeUsuarioSaleRoomCliente extends ManejadorDelCliente<Sala>{

	@Override
	public void manejar(Peticion<Sala> peticion, JFramePrincipal jFramePrincipal)
			throws UnknownHostException, Exception {
		Sala sala = peticion.getData();
		
		//actualizar los conectados
		ArrayList<JPanelSala> panelSalas = jFramePrincipal.jPanelSalas.getSalas();
		
		for (JPanelSala panelSala : panelSalas) { 
			if (sala.getNombre().equals(panelSala.getNombre())) {
				panelSala.actualizarCantConexiones(sala.getConexiones().size());
				panelSala.updateJLabel();
			}
		}
	}
}
