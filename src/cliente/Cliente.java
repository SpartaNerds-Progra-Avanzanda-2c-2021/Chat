package cliente;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import app.Mensaje;
import graficos.JFramePrincipal;
import servidor.Constantes;
import utils.Acciones;
import utils.Peticion;

public class Cliente {
	public static Socket cliente;
	public static Number clienteId;
	public static JFramePrincipal jFramePrincipal;
	public static String salaActual;
	public static Map<String, ArrayList<Mensaje>> salasPosibles = new TreeMap<String, ArrayList<Mensaje>>();
	
	public Cliente(int puerto, String ip) {
		try {
			Cliente.cliente = new Socket(ip, puerto);
			new HiloEnrrutadorDeCliente(Cliente.cliente).start();
			jFramePrincipal = new JFramePrincipal();
			jFramePrincipal.setVisible(true);
			
			Peticion serverMessage = new Peticion<Mensaje>(Acciones.USER_ENTERS_SERVER, null);
			new ObjectOutputStream(Cliente.cliente.getOutputStream()).writeObject(serverMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		try {
			new Cliente(Constantes.puerto, "localhost");
		} catch (Exception e) {
			System.out.println("Se cerro la conexion: "+e.getMessage());
		}
	}
}
