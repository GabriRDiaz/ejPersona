package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Connection conexion;

	public Conexion(Connection conexion) throws SQLException {
		super();
		this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/pichoco?serverTimezone=Europe/Madrid", "root", "");
	}

	public static Connection getConexion() {
		return conexion;
	}
	
}
