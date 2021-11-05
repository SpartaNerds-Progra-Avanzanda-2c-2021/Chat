package Servidor.Manejadores;

import java.util.Map;
import java.util.TreeMap;

import Utils.Acciones;

public class ManejadoresServidorEnum {
	public static Map<Number, ManejadorDelServidor<?>> map = new TreeMap<>();
    static {
    	map.put(Acciones.USER_SEND_ROOM_SMG, new ManejadorDeMensajeDeUsuarioEnSalaDelServidor());
    	map.put(Acciones.USER_ENTERS_SERVER, new ManejadorDeNuevoUsuarioServidor());
    	map.put(Acciones.USER_CREATE_ROOM, new ManejadorDeSalaCreadaServer());
    	map.put(Acciones.USER_ENTERS_ROOM, new ManejadorDeUsuarioEntraRoomServidor());
    	map.put(Acciones.USER_LEAVE_ROOM, new ManejadorDeUsuarioSaleRoomServidor());
    }
}
