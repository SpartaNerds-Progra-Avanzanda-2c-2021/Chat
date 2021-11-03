package Cliente;

import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.Socket;

import Cliente.Manejadores.ManejadorDelCliente;
import Cliente.Manejadores.ManejadoresDelClienteEnum;
import Graficos.JFramePrincipal;
import Utils.Peticion;

public class HiloEnrrutadorDeCliente extends Thread{
	private Socket cliente;

	public HiloEnrrutadorDeCliente(Socket cliente) {
		super();
		this.cliente = cliente;
	}
	
	@SuppressWarnings("resource")
	public void run() {
		Peticion<?> peticion;
		try {
			peticion = (Peticion<?>) new ObjectInputStream(cliente.getInputStream()).readObject();
			while (true) {
				enrrutar(peticion);										
				peticion = (Peticion<?>) new ObjectInputStream(cliente.getInputStream()).readObject();
			}
			
		} catch (Exception e) {
			System.out.println("El cliente se ha desconectado: "+e.getMessage());
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void enrrutar(Peticion peticion) {
		ManejadorDelCliente<?> manejador = ManejadoresDelClienteEnum.map.get(peticion.getTipo());
		try {
			manejador.manejar(peticion,Cliente.jFramePrincipal);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String sStackTrace = sw.toString();
			
			System.out.println("No se obtuvo un manejador para la accion | "+sStackTrace);
		}
	}
	 
}
