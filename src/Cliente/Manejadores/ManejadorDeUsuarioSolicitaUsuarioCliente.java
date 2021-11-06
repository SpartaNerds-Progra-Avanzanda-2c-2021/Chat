package Cliente.Manejadores;

import java.awt.Color;
import java.net.UnknownHostException;
import java.util.ArrayList;

import Cliente.Cliente;
import Graficos.JFramePrincipal;
import Graficos.JPanelSala;
import Utils.Peticion;
import app.Conexion;
import app.Mensaje;
import app.Sala;
import app.Usuario;

public class ManejadorDeUsuarioSolicitaUsuarioCliente extends ManejadorDelCliente<ArrayList<Conexion>>{

	@Override
	public void manejar(Peticion<ArrayList<Conexion>> peticion, JFramePrincipal jFramePrincipal)
			throws UnknownHostException, Exception {
		ArrayList<Conexion> conexiones = peticion.getData();
		
		jFramePrincipal.switchJPanelUsuarios();
		
		for (Conexion conexion : conexiones) {
			Usuario usuario  = conexion.getUsuario();
			jFramePrincipal.jPanelUsuarios.addJPanelUsuario(String.valueOf(usuario.getId()),conexion.getCreatedAt());	
		}
	}
}
