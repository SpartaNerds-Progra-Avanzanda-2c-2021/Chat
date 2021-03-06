package utils;
public class Acciones {
	public static int USER_ENTERS_SERVER = 0;
	public static int USER_ENTERS_ROOM = 1;
	public static int NEW_ROOM = 2;
	public static int USER_START_CHAT = 3; // comienza chats privados
	public static int USER_SEND_CHAT_MSG = 4; // envia mensaje privado
	public static int USER_SEND_ROOM_SMG = 5; // envia mensaje a sala
	public static int USER_DISCONNECTED_FROM_ROOM = 6;
	public static int USER_DISCONNECTED_FROM_SERVER = 7;
	public static int USER_CREATE_ROOM = 8;
	public static int USER_DOWNLOAD_ROOM_TEXT = 9;
	public static int USER_LEAVE_ROOM = 10;
	public static int SEND_ID_TO_USER = 11;
	public static int SEND_USERS_TO_USERS = 12;
	public static int UPDATE_USERS = 13;
	public static int SEND_USERS_TO_USERS_WITHOUTH_OPENCLOSE_GUI = 14;
}