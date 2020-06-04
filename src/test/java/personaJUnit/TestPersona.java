package personaJUnit;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import conexion.Conexion;
import crud.Crud;
import exceptions.myExceptions;
import main.Main;
import persona.Persona;

public class TestPersona {

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
	
	@Test
	public void dniException() throws myExceptions{
		String dni= Main.genDni();
		assertTrue(validarDni(dni));
	}

		public boolean validarDni(String dni) {
	    	if(dni.length()==10) {
	    		char letra = dni.charAt(9);
	    		if(Character.isLetter(letra)) {
	    			return true;
	    		}
	    		return false;
    	}
	    	return false;
    } 
}
