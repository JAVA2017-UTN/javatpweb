package controllers;

import java.util.ArrayList;

import data.DataPeople;
import entity.People;

public class CtrlABMPeople {

	private DataPeople dataPer;
	
	public CtrlABMPeople(){
		dataPer = new DataPeople();
	}
	
	public void add(People p) throws Exception{
		dataPer.add(p);
	}
	
	public void delete(People p)throws Exception{
		dataPer.delete(p);
	}
	
	public void update(People p)throws Exception{
		dataPer.update(p);
	}
	
	public People getByDni(People p) throws Exception{
		return this.dataPer.getByDni(p);
	}
	
	public People getByDni(String dni)throws Exception{
		People p=new People();
		p.setDni(dni);
		return getByDni(p);
	}
	

	public ArrayList<People> getAll()throws Exception{
		return dataPer.getAll();
	}
	
	public People validaUsuario(People p) throws Exception{
		return this.dataPer.validaUsu(p);
	}
}