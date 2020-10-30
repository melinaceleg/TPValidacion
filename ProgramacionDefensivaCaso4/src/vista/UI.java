package vista;

import java.util.Scanner;

import exceptions.OperadorInvalidoException;
import exceptions.OperandosInvalidosException;
import exceptions.ResultadoInvalidoException;
import negocio.Monitor;

/**
 * Capa de Interfaz de Usuario (UI).
 * 
 * @author Grupo 7
 *
 */
public class UI {

	private Monitor monitor;

	public UI() {
		super();
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	/**
	 * Este metodo le pide al usuario que ingrese por teclado los parametros de la
	 * operacion a realizar, e invoca al metodo calcular() con los respectivos
	 * paremetros.<br>
	 */
	public void ingresarOperandos() {
		Scanner entradaEscaner = new Scanner(System.in);
		System.out.println("Ingrese primer operando:");
		String op1 = "";
		op1 = entradaEscaner.nextLine();

		System.out.println("Ingrese segundo operando:");
		String op2 = "";
		op2 = entradaEscaner.nextLine();

		System.out.println("Ingrese la operacion a realizar:");
		String operacion = "";
		operacion = entradaEscaner.nextLine();

		this.calcular(Integer.parseInt(op1), Integer.parseInt(op2), operacion);
	}

	/**
	 * Este metodo recibe los parametros de la operacion y delega la responsabilidad
	 * de realizar el calculo a la clase Monitor. Si la operacion falla, captura la
	 * excepcion e invoca al metodo mostrarEstado() con el correspondiente mensaje
	 * de error.<br>
	 * 
	 * PRE: primerOp != null, segundoOp != null, monitor != null <br>
	 * 
	 * POST: Ejecuta el metodo calcular() de la clase Monitor. Captura la excepcion
	 * en el caso de arrojarse alguna y muestra el error.<br>
	 * 
	 * @param primerOp  int
	 * @param segundoOp int
	 * @param operacion String
	 */
	public void calcular(int primerOp, int segundoOp, String operacion) {
		this.invariante();
		try {
			this.monitor.calcular(primerOp, segundoOp, operacion);
		} catch (OperadorInvalidoException e) {
			this.mostrarEstado(e.getMessage());
		} catch (OperandosInvalidosException e) {
			this.mostrarEstado(e.getMessage());
		}
	}

	/**
	 * Muestra el error ocurrido en el calculo.<br>
	 * 
	 * @param msj String que muestra el mensaje de error.
	 */
	public void mostrarEstado(String msj) {
		System.out.println(msj);
	}

	/**
	 * Invoca el metodo traeResultado() de la clase Monitor y muestra el resultado
	 * obtenido. Si se produce alguna excepcion la captura e invoca el metodo
	 * mostrarEstado() con el correspondiente mensaje de error.<br>
	 * 
	 * PRE: monitor != null <br>
	 * 
	 * POST: Muestra el resultado o el mensaje de error.<br>
	 */
	public void mostrarResultado() {
		this.invariante();
		try {
			System.out.println("El resultado de la ultima operacion exitosa es: " + this.monitor.traerResultado());
		} catch (ResultadoInvalidoException e) {
			this.mostrarEstado(e.getMessage());
		}
	}

	public void invariante() {
		assert monitor != null : "No existe monitor";
	}

}
