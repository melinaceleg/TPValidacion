package negocio;

import exceptions.OperadorInvalidoException;
import exceptions.OperandosInvalidosException;
import exceptions.ResultadoInvalidoException;
import modelo.Calcular;

/**
 * Capa de Negocio.
 * 
 * @author Grupo 7
 *
 */
public class Monitor {

	private Calcular calculadora;

	public Monitor() {
		super();
	}

	public Calcular getCalculadora() {
		return calculadora;
	}

	public void setCalculadora(Calcular calculadora) {
		this.calculadora = calculadora;
	}

	/**
	 * Este metodo delega la responsabilidad de realizar el calculo de la operacion
	 * a la clase Calcular. Si la operacion falla, delega el manejo de la excepcion
	 * a la clase invocante.<br>
	 * 
	 * PRE: calculadora != null <br>
	 * 
	 * POST: Ejecuta el metodo calcular() de la clase Calcular. Propaga la excepcion
	 * en el caso de arrojarse alguna.<br>
	 * 
	 * @param primerOp  int
	 * @param segundoOp int
	 * @param operacion String
	 * @throws OperadorInvalidoException   Propaga la excepcion en caso de de ser
	 *                                     arrojada por el metodo calcular() de la
	 *                                     clase Calcular.
	 * @throws OperandosInvalidosException Propaga la excepcion en caso de de ser
	 *                                     arrojada por el metodo calcular() de la
	 *                                     clase Calcular.
	 */
	public void calcular(int primerOp, int segundoOp, String operacion)
			throws OperadorInvalidoException, OperandosInvalidosException {
		this.invariante();
		this.calculadora.calcular(primerOp, segundoOp, operacion);
	}

	/**
	 * Este metodo invoca a traerResultado() de la clase Calcular y retorna el
	 * resultado.<br>
	 * 
	 * @return El resultado del metodo traerResultado() de la clase Calcular.
	 * @throws ResultadoInvalidoException Propaga la excepcion en caso de de ser
	 *                                    arrojada por el metodo traerResultado() de
	 *                                    la clase Calcular.
	 */
	public int traerResultado() throws ResultadoInvalidoException {
		this.invariante();
		return this.calculadora.traerResultado();
	}

	public void invariante() {
		assert calculadora != null : "No existe calculadora.";
	}
}
