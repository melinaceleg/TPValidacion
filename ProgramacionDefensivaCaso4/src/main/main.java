package main;

import modelo.Calcular;
import negocio.Monitor;
import vista.UI;

public class main {

	public static void main(String[] args) {

		Calcular calc = new Calcular();
		Monitor monitor = new Monitor();
		UI interfaz = new UI();

		monitor.setCalculadora(calc);
		interfaz.setMonitor(monitor);

		interfaz.ingresarOperandos();
		System.out.println("\n*******************************************\n");
		interfaz.ingresarOperandos();
		System.out.println("\n*******************************************\n");
		interfaz.mostrarResultado();

	}

}
