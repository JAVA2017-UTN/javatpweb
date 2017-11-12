package entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class BookableTypes implements Serializable {
	private int id;
	private String nombre;
	private int cantReservasPendientes;
	private Time limite_horas;
	private int dias_antic;
	
	
	public BookableTypes(){
		nombre = null;
		cantReservasPendientes = 0;
		limite_horas = null;
	}
	
	
	
	public BookableTypes(int id, String nombre, int cantReservasPendientes, Time lim, int dias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantReservasPendientes = cantReservasPendientes;
		this.limite_horas = lim;
		this.dias_antic = dias;
	}
	
	public int getDias() {
		return dias_antic;
	}
	
	public void setDias(int dias) {
		this.dias_antic = dias;
	}
	
	public Time getLimite() {
		return this.limite_horas;
	}
	
	public void setLimite(Time limite) {
		this.limite_horas = limite;
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
