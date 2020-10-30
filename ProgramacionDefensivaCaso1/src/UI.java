import java.util.Scanner;

public class UI {

	private int cantMesas;
	private int nroMesa;

	public void abrirLocal() {
		 System.out.println ("Ingrece la cantidad de mesas con la que va a abrir el local");
		 String entradaTeclado = "";
		 Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
		 entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
		 
		 cantMesas=Integer.parseInt(entradaTeclado);
		 assert cantMesas>=1:"ERROR, numero de mesas menor a 1";
	}

	
	public int cerrarMesa() {
		 System.out.println ("Que mesa va a cerrar?");
		 String entradaTeclado = "";
		 Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
		 entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
		 nroMesa=Integer.parseInt(entradaTeclado);
		 return nroMesa;
	}
	
	public int ocuparMesa() {
		 System.out.println ("Que mesa va a ocupar?");
		 String entradaTeclado = "";
		 Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
		 entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
		 nroMesa=Integer.parseInt(entradaTeclado);
		 return nroMesa;
	}
	
	public int getCantMesas() {
		return cantMesas;
	}

	public void setCantMesas(int cantMesas) {
		this.cantMesas = cantMesas;
	}

	public int getNroMesa() {
		return nroMesa;
	}

	public void setNroMesa(int nroMesa) {
		this.nroMesa = nroMesa;
	}
	 
	
	 
		 
	
	
	
}
