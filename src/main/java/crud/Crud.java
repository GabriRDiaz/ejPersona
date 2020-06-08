package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

import conexion.Conexion;
import persona.Persona;

public class Crud {
	private Connection conexionC = null;
	public Crud() {
		super();
	}

	public void insertPersona() {
			Persona persona = new Persona();
			persona.crearPersona();
			try {
			PreparedStatement ps = establishConnection().getConexion().prepareStatement("INSERT INTO personas "
				+ "(nombre, apellido, edad, dni)" 
				+ "VALUES (?, ?, ? , ?)");
			ps.setString(1, persona.getNombre());
			ps.setString(2, persona.getApellido());
			ps.setInt(3, persona.getEdad());
			ps.setString(4, persona.getDni());
			ps.executeUpdate();
			actualizadoExito();
			} catch (SQLException e) {
				System.out.println("ERROR: "+ e.getMessage());
			}
		}
	
	public void delPersona(String dni){
		try {
		PreparedStatement ps = establishConnection().getConexion().prepareStatement(
				"DELETE FROM personas WHERE dni = ?");
		ps.setString(1, dni);
		ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		actualizadoExito();
		}

	public void editDni(String dni) {
		try {
			PreparedStatement ps = establishConnection().getConexion().prepareStatement(
					"SELECT * "
					+ "FROM personas WHERE dni = ?");
			ps.setString(1, dni);
			ResultSet rs = ps.executeQuery();
			 if (rs.next() == true) {
				System.out.println("Entra");
		        Persona persona = new Persona();
		        persona.crearPersona();
					PreparedStatement psUp = establishConnection().getConexion().prepareStatement(
							"UPDATE personas " 
							+ "SET nombre = ?, "
							+ "apellido = ?, "
							+ "edad = ?, "
							+ "dni = ? " 
							+ "WHERE dni = ?");
					psUp.setString(1, persona.getNombre());
					psUp.setString(2, persona.getApellido());
					psUp.setInt(3, persona.getEdad());
					psUp.setString(4, persona.getDni());
					psUp.setString(5, dni);
					psUp.executeUpdate();
			      } else {
			    	System.out.println("\nNo hay registros\n");
			      }

		} catch (SQLException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
	
	public void showPersona() {
		try {
			PreparedStatement ps = establishConnection().getConexion().prepareStatement(
					"SELECT * "
					+ "FROM personas");
			ResultSet rs = ps.executeQuery();
			 if (rs.next() == false) {
			        System.out.println("\nNo hay registros\n");
			      } else {
			        do {
			        	showInfo(rs);
			        } while (rs.next());
			      }
		} catch (SQLException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
	
	public void searchDni(String dni) {
		try {
			PreparedStatement ps = establishConnection().getConexion().prepareStatement(
					"SELECT * "
					+ "FROM personas WHERE dni = ?");
			ps.setString(1, dni);
			ResultSet rs = ps.executeQuery();
			 if (rs.next() == false) {
			        System.out.println("\nNo hay registros\n");
			      } else {
			        do {
			        	showInfo(rs);
			        } while (rs.next());
			      }

		} catch (SQLException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
	}
	public boolean menoresEdad() {
		try {
			PreparedStatement ps = establishConnection().getConexion().prepareStatement(
					"SELECT * "
					+ "FROM personas WHERE edad <18");
			ResultSet rs = ps.executeQuery();
			if(rs.next() == false) {
				System.out.println("No hay registros");
				return false;
			} else {
				do {
					showInfo(rs);
				}while(rs.next());
			}
	}
		catch (SQLException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}
		return true;
	}
	
	public String detectarPelusos() {
		try {
			PreparedStatement ps = establishConnection().getConexion().prepareStatement(
					"SELECT * "
					+ "FROM personas WHERE nombre = \"peluso\"");
			ResultSet rs = ps.executeQuery();
			if(rs.next() == false) {
				System.out.println("No hay registros");
				return null;
			}else {
				do {
					showInfo(rs);
				}while(rs.next());
			}
		}
	catch (SQLException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}			
		String peluso = "\nSal de clase, peluso\n";
		return peluso;
	}

	private void actualizadoExito(){
		System.out.println("\nDatos actualizados con éxito\n");
	}
	
	private Conexion establishConnection() {
		conexionC = null;
		try {
			Conexion conexion = new Conexion(conexionC);
			return conexion;
		} catch (SQLException e) {
			System.out.println("Error en la conexión a la DB");
			e.printStackTrace();
		}
		return null;
	}
	
	private void showInfo(ResultSet rs) {
		try {
			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			String dni = rs.getString("dni");
			int edad = rs.getInt("edad");
			
			System.out.println("");
			System.out.println("Nombre: " + nombre);
			System.out.println("Apellido: " + apellido);
			System.out.println("DNI: " + dni);
			System.out.println("Edad: " + edad);
			System.out.println("-------------------");
		} catch (SQLException e) {
			System.out.println("Error al extraer la info");
			e.printStackTrace();
		}
	}
}
