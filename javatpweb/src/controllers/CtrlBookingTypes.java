package controllers;

import java.util.ArrayList;

import data.DataBookableTypes;

import entity.BookableTypes;
import util.DuplicatedException;


public class CtrlBookingTypes {
	
	private DataBookableTypes databt;
	
	private ArrayList<BookableTypes> booktypes;
	
	
	public CtrlBookingTypes(){
		databt = new DataBookableTypes();
		booktypes = new ArrayList<BookableTypes>();
	}
	
	public void add(BookableTypes bt) throws DuplicatedException, Exception{
		if(databt.getByNombre(bt)!=null){
			throw new DuplicatedException("El tipo de elemento elemento ya existe");
		} else {
			databt.add(bt);
		}
		
	}
	
	public void delete(BookableTypes bt)throws Exception{
		databt.delete(bt);
	}
	
	public void update(BookableTypes bt)throws Exception{
		databt.update(bt);
	}
	
	public BookableTypes getByNombre(BookableTypes bt) throws Exception{
		
		return this.databt.getByNombre(bt);
	}
	
	
	public BookableTypes getByNombre(String nombre) throws Exception{

		BookableTypes bt = new BookableTypes();
		bt.setNombre(nombre);
		
		return getByNombre(bt);

	}

	public ArrayList<BookableTypes> getAll()throws Exception{

		return databt.getAll();
	}
	
	public ArrayList<BookableTypes> getAllReduc()throws Exception{

		return databt.getAllReduc();
	}
	
	public ArrayList<String> getAllNames()throws Exception{
		return databt.getAllNames();
	}
	
	public BookableTypes getById(BookableTypes bt)throws Exception{
		return this.databt.getById(bt);
	}
	
	public BookableTypes getById(int id) throws Exception{
		BookableTypes bt = new BookableTypes();
		bt.setId(id);
		return getById(bt);
	}
	
	public int getTypeId(String type)throws Exception{
		return databt.getTypeId(type);
	}
	
	
	public BookableTypes getRow(int index) throws Exception{
		booktypes = databt.getAll();
		return booktypes.get(index);
	}
	
}
