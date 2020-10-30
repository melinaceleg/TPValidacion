package modelo;

import exceptions.OperadorInvalidoException;
import exceptions.OperandosInvalidosException;
import exceptions.ResultadoInvalidoException;

/**
 * Capa de Modelo.
 * 
 * @author Grupo 7
 *
 */
public class Calcular {

	private int ultimoResult;

	public Calcular() {
		super();
		this.ultimoResult = -1;
	}

	/**
	 * Este metodo verifica que los operandos sean positivos y que la operacion sea
	 * valida y pueda realizarse. En ese caso realiza el calculo y lo guarda, de lo
	 * contrario arroja una excepcion segun sea el caso y la propaga.<br>
	 * 
	 * PRE: operacion != null <br>
	 * 
	 * POST: Guarda el resultado del calculo en la variable ultimoResult, o arroja
	 * una excepcion.<br>
	 * 
	 * @param primerOp  int
	 * @param segundoOp int
	 * @param operacion String
	 * @throws OperadorInvalidoException   Si el operador es distinto de +, -, /, *
	 * @throws OperandosInvalidosException Si alguno de los operandos no es
	 *                                     positivo.
	 */
	public void calcular(int primerOp, int segundoOp, String operacion)
			throws OperadorInvalidoException, OperandosInvalidosException {
		assert operacion != null : "No existe operacion.";

		if (primerOp > 0 && segundoOp > 0) {
			switch (operacion) {
			case "+":
				this.ultimoResult = primerOp + segundoOp;
				break;
			case "-":
				if (primerOp < segundoOp)
					throw new OperandosInvalidosException("La resta dio negativa.");
				else
					this.ultimoResult = primerOp - segundoOp;
				break;
			case "/":
				this.ultimoResult = primerOp / segundoOp;
				break;
			case "*":
				this.ultimoResult = primerOp * segundoOp;
				break;
			default:
				throw new OperadorInvalidoException("Operacion invalida.");
			}
		} else {
			throw new OperandosInvalidosException("Los operandos deben ser enteros positivos.");
		}
	}

	/**
	 * Este metodo retorna el valor del ultimo calculo realizado. Si no se ha
	 * realizado ningun calculo valido arroja una excepcion.<br>
	 * 
	 * @return El resultado de la ultima operacion valida.
	 * @throws ResultadoInvalidoException Si no se realizaron calculos con exito.
	 */
	public int traerResultado() throws ResultadoInvalidoException {
		if (ultimoResult == -1)
			throw new ResultadoInvalidoException("No se realizaron calculos exitosos.");
		else
			return this.ultimoResult;
	}
}
