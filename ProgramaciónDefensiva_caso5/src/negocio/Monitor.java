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
	 * Método que recibe el pedido de un nuevo juego desde la interfaz y lo pasa al modelo.
	 */
	public void inicializarJuego() {
		verificarInvariantes();
		juego.inicializarJuego();
		verificarInvariantes();
	}
	
	/**
	 * Método que recibe el número a probar desde la interfaz y lo pasa al modelo.<br>
	 * <b>PRE:</b> numero!= null.
	 * @param numero  Parámetro ingresado por el usuario.
	 * @throws NumeroInvalidoException  Excepción lanzada si numero es menor a 1 o mayor a 100.
	 * @throws JuegoFinalizadoException  Excepción lanzada si el juego finalizó.
	 */
	public void probarNumero(Integer numero) throws NumeroInvalidoException, JuegoFinalizadoException {
		verificarInvariantes();
		assert numero != null: "Fallo PRE.";
		juego.probar(numero);
		verificarInvariantes();
	}
	
	/**
	 * Método que trae desde el modelo los intentos realizados
	 * 
	 * @return Cantidad de intentos realizados.
	 */
	public Integer traerIntentos() {
		verificarInvariantes();
		return juego.traerIntentos();
	}
	
	/**
	 * Método que trae desde el modelo el estado del juego.
	 * 
	 * @return Estado del juego.
	 */
	public String traerEstado() {
		verificarInvariantes();
		return juego.traerEstado();
	}
	
	/**
	 * Método que verifica las invariantes de clase.
	 */
	private void verificarInvariantes() {
		assert juego != null : "El juego no existe.";
		
	}

	
}
