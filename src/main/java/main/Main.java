package main;

import java.util.Random;
import java.util.Scanner;

import crud.Crud;

public class Main {

	public static void main(String[] args) {
		while (true) {
			Crud crud = new Crud();
			System.out.print("Elija una opción:\n" + "1.Crear persona\n" + "2.Editar por DNI\n" + "3.Eliminar por DNI\n"
					+ "4.Leer personas\n" + "5.Leer personas por DNI\n" + "6.Ver menores de edad\n"
					+ "7.Detectar Pelusos\n" + "8.Crear DNI\n" + "0.Salir\n" + "Elección: ");

			switch (getInfoInt()) {
			case 1:
				crud.insertPersona();
				break;
			case 2:
				System.out.print("Introduzca un DNI: ");
				crud.editDni(getInfoStr());
				break;
			case 3:
				System.out.print("Introduzca un DNI: ");
				crud.delPersona(getInfoStr());
				break;
			case 4:
				crud.showPersona();
				break;
			case 5:
				System.out.print("Introduzca un DNI: ");
				crud.searchDni(getInfoStr());
				break;
			case 6:
				if(crud.menoresEdad()) {
					System.out.println("Hay menores");
				}
				break;
			case 7:
				System.out.println(crud.detectarPelusos());
				break;
			case 8:
				System.out.println("\n");
				System.out.println("----------------");
				System.out.println("DNI: " + genDni());
				System.out.println("----------------");
				System.out.println("\n");
				break;
			case 0:
				System.out.println("\nCerrando programa...");
				System.exit(0);
			}
		}
	}

	public static String genDni() {
		int numDni = new Random().nextInt(100000000);
		String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
		int numLetra = numDni%23;
		String letraDNI = letras[numLetra];
		String dni = Integer.toString(numDni);
		return dni = dni+"-"+letraDNI;
	}
	private static int getInfoInt() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}

	private static String getInfoStr() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
}
