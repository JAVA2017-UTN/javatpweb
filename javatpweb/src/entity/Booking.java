package entity;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Booking implements Serializable {
	private String detalle;
	private Date fecha;
	private Time hora;
	private int id;
	private int id_tipoElemento;
	private int id_elemento;
	private int id_persona;
	private boolean anulada;
	
	public Booking() {
		this.detalle = null;
		this.fecha = null;
		this.hora = null;
		anulada = false;
	}
	
	
	public void setBooking(int id, String detalle, Date fecha, Time hora, int id_tipoElemento, int id_elemento, int id_persona, boolean estado) {
		this.id = id;
		this.detalle = detalle;
		this.fecha = fecha;
		this.hora = hora;
		this.id_tipoElemento = id_tipoElemento;
		this.id_elemento = id_elemento;
		this.id_persona = id_persona;
		this.anulada = estado;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Time getHora() {
		return hora;
	}


	public void setHora(Time hora) {
		this.hora = hora;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId_tipoElemento() {
		return id_tipoElemento;
	}


	public void setId_tipoElemento(int id_tipoElemento) {
		this.id_tipoElemento = id_tipoElemento;
	}


	public int getId_elemento() {
		return id_elemento;
	}


	public void setId_elemento(int id_elemento) {
		this.id_elemento = id_elemento;
	}


	public int getId_persona() {
		return id_persona;
	}


	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}


	public boolean isAnulada() {
		return anulada;
	}
	
	public String isAnuladaString() {
		String respuesta;
		if(this.anulada) {
			respuesta = "Si";
		}
		else {
			respuesta = "No";
		}
		return respuesta;
	}

	public void setAnulada(boolean anulada) {
		this.anulada = anulada;
	}
	
	
}
