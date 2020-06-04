package persona;

import java.util.Scanner;

public class Persona {
	private static String nombre;
	private static String apellido;
	private static String dni;
	private static int edad;
	
	public Persona(String nombre, String apellido, String dni, int edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
	}
	public Persona() {
		super();
	}
	
		public static void crearPersona() {
			System.out.println("Introduzca nombre: ");
			nombre = getInfoStr();
			System.out.println("Introduzca apellido: ");
			apellido = getInfoStr();
			System.out.println("Introduzca DNI: ");
			dni = getInfoStr();
			System.out.println("Introduzca edad: ");
			edad = getInfoInt();
		}
		
		private static String getInfoStr() {
			Scanner scan = new Scanner(System.in);
			return scan.nextLine();
		}
		
		private static int getInfoInt() {
			Scanner scan = new Scanner(System.in);
			return scan.nextInt();
		}
			
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
}
