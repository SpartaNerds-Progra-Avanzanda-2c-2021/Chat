package servidor_manejadores;

import java.util.Map;
import java.util.TreeMap;

import utils.Acciones;

public class ManejadoresServidorEnum {
	public static Map<Number, ManejadorDelServidor<?>> map = new TreeMap<>();
    static {
    	map.put(Acciones.USER_SEND_ROOM_SMG, new ManejadorDeMensajeDeUsuarioEnSalaDelServidor());
    	map.put(Acciones.USER_ENTERS_SERVER, new ManejadorDeNuevoUsuarioServidor());
    	map.put(Acciones.USER_CREATE_ROOM, new ManejadorDeSalaCreadaServer());
    	map.put(Acciones.USER_ENTERS_ROOM, new ManejadorDeUsuarioEntraRoomServidor());
    	map.put(Acciones.USER_LEAVE_ROOM, new ManejadorDeUsuarioSaleRoomServidor());
    	map.put(Acciones.SEND_USERS_TO_USERS, new ManejadorDeUsuarioSolicitaUsuariosServidor());
    	map.put(Acciones.SEND_USERS_TO_USERS_WITHOUTH_OPENCLOSE_GUI, new ManejadorDeUsuarioSolicitaUsuariosSinCambioEnGUIServidor());
    }
}
