package Cliente.Manejadores;

import java.awt.Color;
import java.net.UnknownHostException;
import java.util.ArrayList;

import App.Mensaje;
import App.Sala;
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
		
		for (JPanelSala panelSala : panelSalas) { 
			if (sala.getNombre().equals(panelSala.getNombre())) {
				panelSala.setBackground(new Color(0,0,0));
				panelSala.actualizarCantConexiones(sala.getConexiones().size());
				panelSala.updateJLabel();
				
			}
		}
		
		//jFramePrincipal.jPanelSalasYChats.addJPanelSala(sala.getNombre(), sala.getConexiones().size(), 0); 
		//ERROR - necesito modificar el Panel existente
		
		ArrayList<Mensaje> msj = sala.getMensajes();
		
		for (Mensaje mensaje : msj) {
			//pintar todos los mensajes
			//jFramePrincipal.jPanelSalasYChats.addJPanelMensaje(mensaje, 0, 0);			
		}
	}
}
