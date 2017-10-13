package entity;

import java.io.Serializable;

public class People implements Serializable {
	
	private String dni;
	private String nombre;
	private String apellido;
	private String usuario;
	private String contrasenia;
	private boolean estado;
	private int id;

	
	public People() {
	dni = null;
	nombre = null;
	apellido = null;
	usuario = null;
	contrasenia = null;
	estado = false;
	}
	
	public void setPeople(Integer idNum, String dniNum, String nom, String ape, String usu, String con, boolean est) {
		id=idNum;
		dni = dniNum;
		nombre = nom;
		apellido = ape;
		usuario = usu;
		contrasenia = con;
		estado = est;
	}
	
	
	public String getDni() {
		return dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int idNew) {
		id = idNew;
		
	}

	public boolean isHabilitado() {
		return estado;
	}

	public void setDni(String dni) {
		this.dni = dni;
		
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}
