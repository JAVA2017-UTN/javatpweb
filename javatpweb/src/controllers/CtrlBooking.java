package controllers;

import java.util.ArrayList;

import data.DataBookableTypes;
import data.DataBooking;
import entity.BookableTypes;
import entity.Booking;
import util.AppDataException;
import util.DuplicatedException;



public class CtrlBooking {
	
	private DataBooking dataBook;
	private DataBookableTypes databt;
	
	public CtrlBooking() {
		dataBook = new DataBooking();
		databt = new DataBookableTypes();
	}
	
	public void add(Booking b) throws Exception , DuplicatedException{
		CtrlBookingTypes ctrlTypes = new CtrlBookingTypes();
		BookableTypes bt = new BookableTypes();
		bt = ctrlTypes.getById(b.getId_tipoElemento());
		if(dataBook.cantidadReservas(b) >= databt.getById(bt).getCantReservasPendientes()){
			throw new DuplicatedException("No se pueden reservar mas elementos de este tipo");
		} else {
			if (b.getCant_horas() <= bt.getLimite()) {
				dataBook.add(b);				
			}
			else {
				throw new DuplicatedException("El máximo de horas a reservar de este tipo es de: "+bt.getLimite());
			}
		}
	}
	
	public void deleteById(int id) throws Exception {
		dataBook.delete(id);
	}
	
	public void anularById(int id) throws Exception {
		dataBook.anularById(id);
	}
	
	
	public void update(Booking b) throws Exception {
		dataBook.update(b);
	}
	
	public ArrayList<Booking> getList() throws Exception {
		return dataBook.getAll();
	}
	
	public ArrayList<Booking> getReservasByPerson(int id_pers) throws Exception {
		return dataBook.getReservasByPerson(id_pers);
	} 

}
