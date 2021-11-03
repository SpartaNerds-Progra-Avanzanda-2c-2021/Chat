package GraficosViejos;

import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipalEventos {
	private HashMap<String, Cliente> clientes;
	
	public VentanaPrincipalEventos() {
		super();
		this.clientes = new HashMap<String, Cliente>();
	}
	
	public void agregarNuevoCliente(Cliente cli)throws Exception{
		if(clientes.containsKey(cli.getDni()))
			throw new Exception();
		clientes.put(cli.getDni(), cli);		
	}
		
	public void agregarNuevoClienteGrilla(Cliente cli, JTable tblClientes) {
		int filas = clientes.size() - 1;
		DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
		modelo.addRow(new Object[filas]);
		
		tblClientes.setValueAt(cli.getDni(), filas, 0);
		tblClientes.setValueAt(cli.getTipoDoc(), filas, 1);
		tblClientes.setValueAt(cli.getApellido(), filas, 2);
		tblClientes.setValueAt(cli.getNombre(), filas, 3);
		
	}
	
	public void modificarCliente(Cliente cli) {
		Cliente modi = clientes.get(cli.getDni());
		clientes.put(modi.getDni(), cli);
	}
	
	public void modificarClienteGrilla(Cliente cli, int fila, JTable tblClientes) {		
		tblClientes.setValueAt(cli.getDni(), fila, 0);
		tblClientes.setValueAt(cli.getTipoDoc(), fila, 1);
		tblClientes.setValueAt(cli.getApellido(), fila, 2);
		tblClientes.setValueAt(cli.getNombre(), fila, 3);
	}
	
	public void eliminarCliente(Cliente cli) {
		clientes.remove(cli.getDni());
	}
	
	public void eliminarClienteGrilla(Cliente cli, int fila, JTable tblClientes) {
		DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
		modelo.removeRow(fila);
	}
	
	public void abrirVentanaModoAltaDeCliente(VentanaPrincipal ventanaPrincipal) {
		VentanaABMCliente jCliente = new VentanaABMCliente(ventanaPrincipal);
		jCliente.cargaIconoVentana(".\\agregar.png");
		jCliente.seteaComportamientoBoton("Alta");
		jCliente.setVisible(true);
	}
	
	public void abrirVentanaModoEdicionDeCliente(VentanaPrincipal ventanaPrincipal, JTable tblClientes) {
		Cliente cli = this.obtenerDatosDelCliente(this.obtenerFilaSeleccionadaGrilla(tblClientes),tblClientes);
		if(cli == null) return;
		VentanaABMCliente jCliente = new VentanaABMCliente(ventanaPrincipal);
		jCliente.setTitle("Modificar Datos del Cliente");
		jCliente.cargaIconoVentana(".\\editar.png");
		jCliente.seteaComportamientoBoton("Modificar");
		jCliente.cargaDatosDeClienteEnComponentes(cli);	
		jCliente.seteaComponentesEditables(true);
		jCliente.setVisible(true);
	}
	
	public void abrirVentanaModoBajaDeCliente(VentanaPrincipal ventanaPrincipal, JTable tblClientes) {
		Cliente cli = this.obtenerDatosDelCliente(this.obtenerFilaSeleccionadaGrilla(tblClientes), tblClientes);
		if(cli == null) return;
		VentanaABMCliente jCliente = new VentanaABMCliente(ventanaPrincipal);
		jCliente.setTitle("Eliminar Datos del Cliente");
		jCliente.cargaIconoVentana(".\\eliminar.png");
		jCliente.seteaComportamientoBoton("Eliminar");
		jCliente.cargaDatosDeClienteEnComponentes(cli);	
		jCliente.seteaComponentesEditables(false);		
		jCliente.setVisible(true);
	}
	
	public void abrirVentanaModoVisualizarCliente(VentanaPrincipal ventanaPrincipal,JTable tblClientes) {
		Cliente cli = this.obtenerDatosDelCliente(this.obtenerFilaSeleccionadaGrilla(tblClientes), tblClientes);
		if(cli == null) return;
		
		VentanaABMCliente jCliente = new VentanaABMCliente(ventanaPrincipal);
		jCliente.setTitle("Visualizar Datos del Cliente");
		jCliente.cargaIconoVentana(".\\ver.png");
		jCliente.seteaComportamientoBoton("Salir");
		jCliente.seteaComponentesEditables(false);
		jCliente.cargaDatosDeClienteEnComponentes(cli);		
		jCliente.setVisible(true);
	}
	
	public int obtenerFilaSeleccionadaGrilla(JTable tblClientes) {
		int filaSeleccionada = tblClientes.getSelectedRow();
		if(filaSeleccionada >= 0) return filaSeleccionada;
		return -1;
	}
	
	private Cliente obtenerDatosDelCliente(int fila, JTable tblClientes) {
		if(fila >=0) return clientes.get(tblClientes.getValueAt(fila, 0));
		return null;
	}
}
