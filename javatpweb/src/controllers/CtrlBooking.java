package controllers;

import java.util.ArrayList;

import data.DataBooking;
import entity.Booking;

public class CtrlBooking {
	
	private DataBooking dataBook;
	
	public CtrlBooking() {
		dataBook = new DataBooking();
	}
	
	public void add(Booking b) throws Exception {
		dataBook.add(b);
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
