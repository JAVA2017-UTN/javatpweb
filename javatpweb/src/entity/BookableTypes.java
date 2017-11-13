package entity;

import java.io.Serializable;

public class BookableTypes implements Serializable {
	private int id;
	private String nombre;
	private int cantReservasPendientes;
	private int limite_horas;
	private int dias_antic;
	private boolean req_encargado;
	
	
	public BookableTypes(){
		nombre = null;
		cantReservasPendientes = 0;
		limite_horas = 0;
		dias_antic = 0;
		req_encargado = false;
	}
	
	
	
	public BookableTypes(int id, String nombre, int cantReservasPendientes, int lim, int dias, boolean req_encar) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantReservasPendientes = cantReservasPendientes;
		this.limite_horas = lim;
		this.dias_antic = dias;
		this.req_encargado = req_encar;
	}
	
	public int getDias() {
		return dias_antic;
	}
	
	public void setDias(int dias) {
		this.dias_antic = dias;
	}
	
	public int getLimite() {
		return this.limite_horas;
	}
	
	public void setLimite(int limite) {
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



	public boolean isReq_encargado() {
		return req_encargado;
	}



	public void setReq_encargado(boolean req_encargado) {
		this.req_encargado = req_encargado;
	}
	
}
