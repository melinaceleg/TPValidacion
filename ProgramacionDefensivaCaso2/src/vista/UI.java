package vista;

import java.util.Scanner;

public class UI {
	
	private double combustible=0;
	
	public double getCombustible() {
		return combustible;
	}

	public void inicializaSurtidor() {
		 System.out.println ("Ingrece la cantidad de combustible inicial");
		 String entradaTeclado = "";
		 Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
		 entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
		 
		 combustible=Integer.parseInt(entradaTeclado);
		 
	}
	
	public void cargarSurtidor() {
		 System.out.println ("Ingrece la cantidad de combustible a cargar");
		 String entradaTeclado = "";
		 Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
		 entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
		 
		 combustible+=Integer.parseInt(entradaTeclado);
	}
	//Simula activar la manguera
	public boolean activaManguera1() {
		this.mangueraActivada();
		return true;
	}
	//Simula activar la manguera
	public boolean activaManguera2() {
		this.mangueraActivada();
		return true;
	}
	//Simula desactivar la manguera
	public boolean DesactivaManguera1() {
		this.mangueraDesactivada();
		return true;
	}
	//Simula desactivar la manguera
	public boolean DesactivaManguera2() {
		this.mangueraDesactivada();
		return true;
	}
	
	public void operacionExitosa() {
		System.out.println("Operacion exitosa");
	}
	public void mangueraActivada() {
		System.out.println("Manguera activada");
	}
	public void mangueraDesactivada() {
		System.out.println("Manguera desactivada");
	}
	
}
