package modelo;

import java.util.Random;

import excepciones.JuegoFinalizadoException;
import excepciones.NumeroInvalidoException;

/**
 * <b>Invariantes de clase:</b> <br>
 * 1. Los intentos van de 0 a 10.<br>
 * 2. estado != null.<br>
 * 3. El n�mero generado debe estar entre 1 y 100.<br>
 * 
 */
public class Juego {
	private Integer intentos;
	private String estado="No iniciado";
	private Integer numeroGenerado;
	
	/**
	 * M�todo que inicializa el juego.<br>
	 * 
	 * <b>POST:</b> <br>
	 * 1. El estado del juego se modifica a 'Juego iniciado'.<br>
	 * 2. La cantidad de intentos se inicializa en 0.<br>
	 * 3. Se genera un n�mero aleatorio entre 1 y 100.<br>
	 */
	public void inicializarJuego() {
		verificarInvariantes();
		estado="Juego iniciado";
		intentos=0;
		Random r= new Random();
		numeroGenerado=r.nextInt(100)+1;
		//System.out.println(numeroGenerado);
		verificarInvariantes();	
	}
	
	/**
	 * M�todo que ejecuta un intento.<br>
	 * 
	 * <b>PRE:</b> numero!= null.<br>
	 * <b>POST:</b> <br>
	 * 1. Se incrementa el atributo intentos en 1.<br>
	 * 2. Se modifica el estado del juego de acuerdo al n�mero de intentos y al n�mero ingresado por el usuario.<br>
	 * @param numero  Par�metro ingresado por el usuario.
	 * @throws NumeroInvalidoException  Excepci�n lanzada si numero es menor a 1 o numero es mayor a 100.
	 * @throws JuegoFinalizadoException  Excepci�n lanzada si el juego finaliz�.
	 */
	public void probar(Integer numero) throws NumeroInvalidoException, JuegoFinalizadoException {
		verificarInvariantes();
		assert numero != null : "Fallo PRE.";
		if (numero < 1 || numero > 100) 
			throw new NumeroInvalidoException("El numero ingresado debe estar entre 1 y 100.");
		if (estado.equals("Acert�") || estado.equals("Perdi�") || estado.equals("No iniciado")) { 
			throw new JuegoFinalizadoException("Presione 'Juego nuevo' para comenzar a jugar.");
		}
		int oldIntentos = intentos;
		intentos++;
		if(intentos>9 && numero!=numeroGenerado)
			estado="Perdi�";
		else if (numero>numeroGenerado)
			estado="Alto";
		else if(numeroGenerado==numero)
			estado="Acert�";
		else
			estado="Bajo";
		assert (oldIntentos + 1 == intentos) : "Fallo POST 1.";
		assert (estado.equals("Perdi�") || estado.equals("Alto") || estado.equals("Acert�") || estado.equals("Bajo")) : "Fallo POST 2.";
		verificarInvariantes();
	}
	
	/**
	 * M�todo que retorna la cantidad de intentos realizados.
	 * 
	 * @return Cantidad de intentos.
	 */
	public Integer traerIntentos() {
		verificarInvariantes();
		return intentos;
	}
	
	/**
	 * M�todo que retorna el estado del juego.
	 * 
	 * @return Estado del juego.
	 */
	public String traerEstado() {
		verificarInvariantes();
		return estado;
	}
	
	/**
	 * M�todo que verifica las invariantes de clase.
	 */
	private void verificarInvariantes() {
        assert (intentos >= 0 && intentos <= 10) : "El n�mero de intentos no es v�lido.";
        assert estado != null : "Estado del juego es null.";
        assert (numeroGenerado > 0 && numeroGenerado <= 100) : "El n�mero generado no es v�lido";
		
	}
}
