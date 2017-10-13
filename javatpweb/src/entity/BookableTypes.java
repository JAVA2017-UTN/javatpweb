package entity;

import java.io.Serializable;

public class BookableTypes implements Serializable {
	private int id;
	private String nombre;
	private int cantReservasPendientes;
	
	public BookableTypes(){
		nombre = null;
		cantReservasPendientes = 0;
	}
	
	
	
	public BookableTypes(int id, String nombre, int cantReservasPendientes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantReservasPendientes = cantReservasPendientes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantReservasPendientes() {
		return cantReservasPendientes;
	}

	public void setCantReservasPendientes(int cantReservasPendientes) {
		this.cantReservasPendientes = cantReservasPendientes;
	}
	
	/*@Override

	public boolean equals(Object bt){

		return (bt instanceof BookableTypes) &&

			 (((BookableTypes)bt).getNombre().equals(this.getNombre()));
				
	}*/
	
	
	

}
