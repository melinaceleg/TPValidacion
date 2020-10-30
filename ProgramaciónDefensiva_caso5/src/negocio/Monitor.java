package negocio;

import excepciones.JuegoFinalizadoException;
import excepciones.NumeroInvalidoException;
import modelo.Juego;

/**
 * <b>Invariante de clase:</b> El juego no puede ser null. 
 *
 */
public class Monitor {
	
	private Juego juego= new Juego();
	
	/**
	 * M�todo que recibe el pedido de un nuevo juego desde la interfaz y lo pasa al modelo.
	 */
	public void inicializarJuego() {
		verificarInvariantes();
		juego.inicializarJuego();
		verificarInvariantes();
	}
	
	/**
	 * M�todo que recibe el n�mero a probar desde la interfaz y lo pasa al modelo.<br>
	 * <b>PRE:</b> numero!= null.
	 * @param numero  Par�metro ingresado por el usuario.
	 * @throws NumeroInvalidoException  Excepci�n lanzada si numero es menor a 1 o mayor a 100.
	 * @throws JuegoFinalizadoException  Excepci�n lanzada si el juego finaliz�.
	 */
	public void probarNumero(Integer numero) throws NumeroInvalidoException, JuegoFinalizadoException {
		verificarInvariantes();
		assert numero != null: "Fallo PRE.";
		juego.probar(numero);
		verificarInvariantes();
	}
	
	/**
	 * M�todo que trae desde el modelo los intentos realizados
	 * 
	 * @return Cantidad de intentos realizados.
	 */
	public Integer traerIntentos() {
		verificarInvariantes();
		return juego.traerIntentos();
	}
	
	/**
	 * M�todo que trae desde el modelo el estado del juego.
	 * 
	 * @return Estado del juego.
	 */
	public String traerEstado() {
		verificarInvariantes();
		return juego.traerEstado();
	}
	
	/**
	 * M�todo que verifica las invariantes de clase.
	 */
	private void verificarInvariantes() {
		assert juego != null : "El juego no existe.";
		
	}

	
}
