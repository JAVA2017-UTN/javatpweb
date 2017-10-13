package entity;

import java.io.Serializable;

public class Session implements Serializable {
	
	public static int id;
	public static String nombre;
	public static String apellido;
	public static String dni;
	public static String usuario;
	public static String contrasenia;
	public static boolean estado;
	//public static int tipo_usu; CUANDO TENGAMOS QUE DIFERENCIAR ADMIN DE USUARIO NORMAL
	
	public static void setSession(int id, String nombre, String apellido, String dni, String usuario, String contrasenia, boolean estado) {
		
		Session.id = id;
		Session.nombre = nombre;
		Session.apellido = apellido;
		Session.dni = dni;
		Session.usuario = usuario;
		Session.contrasenia = contrasenia;
		Session.estado = estado;
	}
	
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Session.id = id;
	}
	public static String getNombre() {
		return nombre;
	}
	public static void setNombre(String nombre) {
		Session.nombre = nombre;
	}
	public static String getApellido() {
		return apellido;
	}
	public static void setApellido(String apellido) {
		Session.apellido = apellido;
	}
	public static String getDni() {
		return dni;
	}
	public static void setDni(String dni) {
		Session.dni = dni;
	}
	public static String getUsuario() {
		return usuario;
	}
	public static void setUsuario(String usuario) {
		Session.usuario = usuario;
	}
	public static String getContrasenia() {
		return contrasenia;
	}
	public static void setContrasenia(String contrasenia) {
		Session.contrasenia = contrasenia;
	}
	public static boolean isEstado() {
		return estado;
	}
	public static void setEstado(boolean estado) {
		Session.estado = estado;
	}

}
