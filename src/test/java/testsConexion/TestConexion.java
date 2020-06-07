package testsConexion;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import conexion.Conexion;
import exceptions.myExceptions;

public class TestConexion {
	
	@Test
	public void connectionException() throws myExceptions {
		Connection conexionC = null;
		Conexion connection;
		try {
			connection = new Conexion(conexionC);
		} catch (SQLException e) {
			myExceptions exception = new myExceptions(1);
			exception.getMessage();
			e.printStackTrace();
		}
	}
}
