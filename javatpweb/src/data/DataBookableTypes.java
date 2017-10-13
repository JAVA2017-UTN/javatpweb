package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.BookableItems;
import entity.BookableTypes;
import entity.People;
import util.AppDataException;

public class DataBookableTypes {
	
	public ArrayList<BookableTypes> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<BookableTypes> booktypes= new ArrayList<BookableTypes>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from bookable_types");
			if(rs!=null){
				while(rs.next()){
					BookableTypes bt =new BookableTypes();
							bt.setId(Integer.parseInt(rs.getString("id")));
							bt.setNombre(rs.getString("nombre"));
							bt.setCantReservasPendientes(Integer.parseInt(rs.getString("cantReservasPendientes")));
							booktypes.add(bt);
				}
			}
		} catch (SQLException e) {
			
			throw e;
		} catch (AppDataException ade){
			throw ade;
		}
		

		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return booktypes;
		
	}
	
	public ArrayList<String> getAllNames() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<String> names= new ArrayList<String>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from bookable_types");
			if(rs!=null){
				while(rs.next()){
					names.add(rs.getString("nombre"));
				}
			}
		} catch (SQLException e) {
			
			throw e;
		} catch (AppDataException ade){
			throw ade;
		}
		

		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return names;
		
	}

	public int getTypeId(String type) throws Exception{
		Integer idtype = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select *  from bookable_types where nombre=?");
			stmt.setString(1, type);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					idtype = (Integer.parseInt(rs.getString("id")));
			}
			
		} catch (Exception e) {
			throw e;
		} finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return idtype;
	}
	
	public BookableTypes getById(BookableTypes bookt) throws Exception{
		
		BookableTypes bt=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from bookable_types where id=?");
			stmt.setInt(1, bookt.getId());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					bt = new BookableTypes();
					bt.setId(Integer.parseInt(rs.getString("id")));
					bt.setNombre(rs.getString("nombre"));
					bt.setCantReservasPendientes(Integer.parseInt(rs.getString("cantReservasPendientes")));
			}
			
		} catch (Exception e) {
			throw e;
		} finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return bt;
	}
	
	
	public void add(BookableTypes bt) throws Exception{
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into bookable_types(nombre, cantReservasPendientes) values (?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setString(1, bt.getNombre());
			stmt.setString(2, String.valueOf((bt.getCantReservasPendientes())));
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				bt.setId(keyResultSet.getInt(1));
			}
		} catch (SQLException | AppDataException e) {
			throw e;
		}
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public BookableTypes getByNombre(BookableTypes booktypes) throws Exception{
		BookableTypes bt =null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from bookable_types where nombre=?");
			stmt.setString(1, booktypes.getNombre());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					bt=new BookableTypes();
					bt.setId(Integer.parseInt(rs.getString("id")));
					bt.setNombre(rs.getString("nombre"));
					bt.setCantReservasPendientes(Integer.parseInt(rs.getString("cantReservasPendientes")));
			}
			
		} catch (Exception e) {
			throw e;
		} finally{
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		return bt;
	}
	
	public void delete(BookableTypes bt) throws Exception {
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"delete from bookable_types where id=? "
					);
			stmt.setString(1, String.valueOf(bt.getId()));
			stmt.execute();
		} catch (SQLException | AppDataException e) {
			throw e;
		}
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(BookableTypes bt) throws Exception {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"UPDATE bookable_types SET nombre=? , cantReservasPendientes=? where id=? "
					);
			
			stmt.setString(1, bt.getNombre());
			stmt.setString(2, String.valueOf(bt.getCantReservasPendientes()));
			stmt.setString(3, String.valueOf(bt.getId()));
			stmt.execute();
		} catch (SQLException | AppDataException e) {
			throw e;
		}
		try {
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
