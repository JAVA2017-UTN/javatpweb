package data;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.security.KeyStore.ProtectionParameter;
import java.sql.*;

import entity.*;
import util.AppDataException;

public class DataPeople {
	
	public ArrayList<People> getAll() throws Exception{
	
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<People> pers= new ArrayList<People>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from people");
			if(rs!=null){
				while(rs.next()){
					People p=new People();
					p.setPeople(Integer.parseInt(rs.getString("id")), rs.getString("dni"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("usuario"),
							rs.getString("contrasenia"), rs.getBoolean("estado"));
					pers.add(p);
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
		
		return pers;
		
	}
	
	public People getByDni(People per) throws Exception{
		People p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id, nombre, apellido, dni, usuario, contrasenia, estado  from people where dni=?");
			stmt.setString(1, per.getDni());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
					p=new People();
					p.setPeople(Integer.parseInt(rs.getString("id")),rs.getString("dni"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("usuario"),
							rs.getString("contrasenia"), rs.getBoolean("estado"));
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
		return p;
	}
	
	public People validaUsu(People per) throws Exception {
		People p = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id, nombre, apellido, dni, usuario, contrasenia, estado  from people where usuario=? and contrasenia=?");
			stmt.setString(1, per.getUsuario());
			stmt.setString(2, per.getContrasenia());
			rs = stmt.executeQuery();
			if(rs != null && rs.next()) {
				p = new People();
				p.setPeople(Integer.parseInt(rs.getString("id")), rs.getString("dni"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("usuario"),
						rs.getString("contrasenia"), rs.getBoolean("estado"));
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
		return p;
	}
	
	public void delete(People p) throws Exception {
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"delete from people where id=? "
					);
			stmt.setString(1, String.valueOf(p.getId()));
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
	
	public void update(People p) throws Exception {
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"UPDATE people SET dni=?, nombre=?, apellido=?, usuario=?, contrasenia=?, estado=? where id=? "
					);
			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getApellido());
			stmt.setString(4, p.getUsuario());
			stmt.setString(5, p.getContrasenia());
			stmt.setBoolean(6, p.isHabilitado());
			stmt.setString(7, String.valueOf(p.getId()));
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
	
	public void add(People p) throws Exception{
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into people(dni, nombre, apellido, usuario, contrasenia, estado) values (?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getApellido());
			stmt.setString(4, p.getUsuario());
			stmt.setString(5, p.getContrasenia());
			stmt.setBoolean(6, p.isHabilitado());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				p.setId(keyResultSet.getInt(1));
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
	
	

}