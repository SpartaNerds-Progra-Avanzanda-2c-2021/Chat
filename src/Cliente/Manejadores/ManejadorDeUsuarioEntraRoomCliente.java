package Cliente.Manejadores;

import java.awt.Color;
import java.net.UnknownHostException;
import java.util.ArrayList;

import App.Conexion;
import App.Mensaje;
import App.Sala;
import Cliente.Cliente;
import Graficos.JFramePrincipal;
import Graficos.JPanelSala;
import Utils.Peticion;

public class ManejadorDeUsuarioEntraRoomCliente extends ManejadorDelCliente<Sala>{

	@Override
	public void manejar(Peticion<Sala> peticion, JFramePrincipal jFramePrincipal)
			throws UnknownHostException, Exception {
		Sala sala = peticion.getData();
		
		//actualizar los conectados
		ArrayList<JPanelSala> panelSalas = jFramePrincipal.jPanelSalasYChats.getSalas();
		
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
		
		if(panelSalaBuscada != null) {
			for (Conexion conexion : salaBuscada.getConexiones()) {
				if(conexion.getUsuario().getId() == (int)Cliente.clienteId) {
					panelSalaBuscada.switchConection();
				}
			}
		}
		
		ArrayList<Mensaje> msj = sala.getMensajes();
		Cliente.salasPosibles.put(salaBuscada.getNombre(), msj);
		
		for (Mensaje mensaje : msj) {
			jFramePrincipal.jPanelComunication.addPanelMensaje(mensaje);
		}
	}
}
