package Cliente.Manejadores;

import java.util.Map;
import java.util.TreeMap;

import Utils.Acciones;

public class ManejadoresDelClienteEnum {
	public static Map<Number, ManejadorDelCliente<?>> map = new TreeMap<>();
    static {
    	map.put(Acciones.USER_SEND_ROOM_SMG, new ManejadorDeMensajeDeUsuarioEnSalaDelCliente());
    	map.put(Acciones.USER_ENTERS_SERVER, new ManejadorDeNuevoUsuarioCliente());
    	map.put(Acciones.USER_CREATE_ROOM, new ManejadorDeSalaCreadaCliente());
    }
}
