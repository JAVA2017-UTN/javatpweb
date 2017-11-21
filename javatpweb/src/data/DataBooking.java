package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Booking;
import entity.People;
import util.AppDataException;

public class DataBooking {
	
	public ArrayList<Booking> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Booking> books= new ArrayList<Booking>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from booking where fecha >= CURRENT_TIMESTAMP();");
			if(rs!=null){
				while(rs.next()){
					Booking b = new Booking();
					b.setBooking(Integer.parseInt(rs.getString("id")), rs.getString("detalle"), rs.getDate("fecha"), rs.getTime("hora"), 
							Integer.parseInt(rs.getString("id_tipo_elemento")), Integer.parseInt(rs.getString("id_elemento")),
							Integer.parseInt(rs.getString("id_persona")), rs.getBoolean("anulada"), Integer.parseInt(rs.getString("cant_horas")));
					books.add(b);
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
		
		return books;
		
	}
	
	public ArrayList<Booking> getReservasByPerson(int id_pers) throws Exception{
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<Booking> books= new ArrayList<Booking>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().prepareStatement("select * from booking where id_persona =? and fecha >= CURRENT_TIMESTAMP();");
			stmt.setInt(1, id_pers);
			rs = stmt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					Booking b = new Booking();
					b.setBooking(Integer.parseInt(rs.getString("id")), rs.getString("detalle"), rs.getDate("fecha"), rs.getTime("hora"), 
							Integer.parseInt(rs.getString("id_tipo_elemento")), Integer.parseInt(rs.getString("id_elemento")),
							Integer.parseInt(rs.getString("id_persona")), rs.getBoolean("anulada"), Integer.parseInt(rs.getString("cant_horas")));
					books.add(b);
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
		
		return books;
		
	}
	
	public void delete(int id) throws Exception {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"delete from booking where id=? "
					);
			stmt.setString(1, String.valueOf(id));
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
	
	public void anularById(int id) throws Exception {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"UPDATE booking SET anulada=? where id=? "
					);
			stmt.setBoolean(1, true);
			stmt.setInt(2, id);
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
	
	public void update(Booking b) throws Exception {
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"UPDATE booking SET fecha=?, hora=?, detalle=?, id_elemento=?, id_tipo_elemento=?, id_persona=? where id=? "
					);
			stmt.setDate(1, (Date) b.getFecha());
			stmt.setTime(2, b.getHora());
			stmt.setString(3, b.getDetalle());
			stmt.setInt(4, b.getId_elemento());
			stmt.setInt(5, b.getId_tipoElemento());
			stmt.setInt(6, b.getId_persona());
			stmt.setInt(7, b.getId());
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
	
	public void add(Booking b) throws Exception{
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into booking(fecha, hora, detalle, id_elemento, id_tipo_elemento, id_persona, anulada, cant_horas) values (?,?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setDate(1, b.getFecha());
			stmt.setTime(2, b.getHora());
			stmt.setString(3, b.getDetalle());
			stmt.setInt(4, b.getId_elemento());
			stmt.setInt(5, b.getId_tipoElemento());
			stmt.setInt(6, b.getId_persona());
			stmt.setBoolean(7, b.isAnulada());
			stmt.setInt(8, b.getCant_horas());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				b.setId(keyResultSet.getInt(1));
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
	
	public int cantidadReservas(Booking b) throws Exception{
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int cantidad = 0;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("select count(*) as cant from booking where id_tipo_elemento = ? and anulada=false group by id_tipo_elemento;");
			stmt.setInt(1, b.getId_tipoElemento());
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()){
				cantidad = Integer.parseInt(rs.getString("cant"));
			}
		} catch (Exception e){
			throw e;
		} finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				throw e;
			}
		}
		
		return cantidad;
	}
	
	

}
