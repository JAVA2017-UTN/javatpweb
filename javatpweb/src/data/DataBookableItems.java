package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.BookableItems;
import util.AppDataException;

public class DataBookableItems {
	
	public ArrayList<BookableItems> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<BookableItems> bookItems= new ArrayList<BookableItems>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from bookable_items");
			if(rs!=null){
				while(rs.next()){
					BookableItems bi =new BookableItems();
							bi.setId(Integer.parseInt(rs.getString("id")));
							bi.setNombre(rs.getString("nombre"));
							bi.setId_tipoElemento(Integer.parseInt(rs.getString("id_tipo_elemento")));
							bookItems.add(bi);
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
		
		return bookItems;
		
	}
	
	public ArrayList<BookableItems> getAllByType(int id_tipoEle) throws Exception{
		
		ResultSet rs=null;
		PreparedStatement stmt=null;
		ArrayList<BookableItems> bookitems= new ArrayList<BookableItems>();
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select *  from bookable_items where id_tipo_elemento=?");
			stmt.setInt(1, id_tipoEle);
			rs=stmt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					BookableItems bi =new BookableItems();
					bi.setId(Integer.parseInt(rs.getString("id")));
					bi.setNombre(rs.getString("nombre"));
					bi.setId_tipoElemento(Integer.parseInt(rs.getString("id_tipo_elemento")));
					bookitems.add(bi);
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
		
		return bookitems;
	}	
	
	public ArrayList<String> getAllNames(int id_tipo) throws Exception{
			ResultSet rs=null;
			PreparedStatement stmt=null;
			ArrayList<String> names= new ArrayList<String>();
			try {
				stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
						"select *  from bookable_items where id_tipo_elemento=?");
				stmt.setInt(1, id_tipo);
				rs=stmt.executeQuery();
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
	
	public BookableItems getById(int id) throws Exception{
		BookableItems bi = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select *  from bookable_items where id=?");
			stmt.setString(1, String.valueOf(id));
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					bi = new BookableItems();
					bi.setBookableItems(Integer.parseInt(rs.getString("id")), rs.getString("nombre"), Integer.parseInt(rs.getString("id_tipo_elemento")));
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
		return bi;
	}
	
	public int getItemId(String elem) throws Exception{
		Integer idElem = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select *  from bookable_items where nombre=?");
			stmt.setString(1, elem);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					idElem = (Integer.parseInt(rs.getString("id")));
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
		return idElem;
	}
	
	public void update(BookableItems bi) throws Exception {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"UPDATE bookable_items SET nombre=?, id_tipo_elemento=? where id=? "
					);
			stmt.setString(1, bi.getNombre());
			stmt.setString(2, String.valueOf(bi.getId_tipoElemento()));
			stmt.setString(3, String.valueOf(bi.getId()));
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
	
	public void delete(BookableItems bi) throws Exception {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"delete from bookable_items where id=? "
					);
			stmt.setString(1, String.valueOf(bi.getId()));
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
	
	public void add(BookableItems bi) throws Exception{
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into bookable_items(nombre, id_tipo_elemento) values (?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setString(1, bi.getNombre());
			stmt.setString(2, String.valueOf((bi.getId_tipoElemento())));
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				bi.setId(keyResultSet.getInt(1));
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
	
	public BookableItems getByNombre(BookableItems bookitems) throws Exception{
		BookableItems bi =null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from bookable_items where nombre=?");
			stmt.setString(1, bookitems.getNombre());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					bi=new BookableItems();
					
					bi.setId(Integer.parseInt(rs.getString("id")));
					bi.setNombre(rs.getString("nombre"));
					bi.setId_tipoElemento(Integer.parseInt(rs.getString("id_tipo_elemento")));
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
		return bi;
	}
}
