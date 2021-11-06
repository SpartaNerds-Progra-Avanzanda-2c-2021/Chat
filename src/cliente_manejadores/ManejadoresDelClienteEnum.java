package cliente_manejadores;

import java.util.Map;
import java.util.TreeMap;

import utils.Acciones;

public class ManejadoresDelClienteEnum {
	public static Map<Number, ManejadorDelCliente<?>> map = new TreeMap<>();
    static {
    	map.put(Acciones.USER_SEND_ROOM_SMG, new ManejadorDeMensajeDeUsuarioEnSalaDelCliente());
    	map.put(Acciones.USER_ENTERS_SERVER, new ManejadorDeNuevoUsuarioCliente());
    	map.put(Acciones.USER_CREATE_ROOM, new ManejadorDeSalaCreadaCliente());
    	map.put(Acciones.USER_ENTERS_ROOM, new ManejadorDeUsuarioEntraRoomCliente());
    	map.put(Acciones.USER_LEAVE_ROOM, new ManejadorDeUsuarioSaleRoomCliente());
    	map.put(Acciones.SEND_ID_TO_USER, new ManejadorDeUsuarioRecibeId());
    	map.put(Acciones.SEND_USERS_TO_USERS, new ManejadorDeUsuarioSolicitaUsuarioCliente());
    	map.put(Acciones.UPDATE_USERS, new ManejadorDeUsuarioActualizaPanelDeUsuariosCliente());
    }
}
