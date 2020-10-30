package negocio;

import java.util.ArrayList;

import interfaz.UI;
import modelo.Alumno;
import modelo.Certificado;

public class Negocio {
	private Certificado certificado;
	private UI ui;
	
	
	/**
	 *  Constructor de la clase Negocio
	 * <b>Pre:</b> certificado!=null, ui!=null
     * <b>Post:</b> se crea una instancia de la clase Negocio
	 * 
	 */
	public Negocio(Certificado certificado, UI ui) {
		super();
		assert certificado!=null : "el certificado no puede ser null";
		assert ui!=null : "la ui no puede ser null";
		
		this.certificado = certificado;
		this.ui = ui;
		this.ui.setNegocio(this);
	}
	
	/**
	 * Se pide el certificado de Alumno a partir del legajo
	 * 
	 * <b>Pre: </b> legajo != null
     * <b>Post: </b> se actualiza el Certificado de la capa Modelo con el alumno buscado. 
     * 
	 * @param legajo
	 * @throws Exception : legajo no existe
	 */
	public void pedirCertificado(Integer legajo) throws Exception
	{
			assert legajo != null : "El legajo no puede ser null";
			this.certificado.pedirCertificado(legajo);
	}

		
	/**
	 * Se pide el apellido y nombre al modelo de negocio y este envia el dato del alumno que se solicitó
	 * <b>Post: </b> se actualiza el Certificado de la capa Modelo con el alumno buscado. 
     * Si el certificado no existe, se le informa a la UI
	 * 
	 * @return apellido y nombre 
	 */
	public String traerApellidoyNombre()
	{
		String apellidoNombre = "";
		try {
			apellidoNombre = this.certificado.traerApellidoyNombre();
		} catch (Exception e) {
			this.ui.mostrarEstado(e.getMessage());
		}
		return apellidoNombre;
	}
	
	/**
	 * Metodo que devuelve el estado de una materia del certificado pedido
	 * <b>Pre: </b> materia != null
     * <b>Post: </b> retorna el estado de la materia dada. Si el certificado no existe, se le informa a la UI
     * 
	 * @param materia: nombre de la materia
	 * @return estado de la materia
	 * @throws Exception 
	 */
	public String traerEstado(String materia) throws Exception
	{
		assert materia !=null : "la materia no puede ser null";
		
		String estado = this.certificado.traerEstado(materia);
		return estado;
	}
	
	/**
	 * Metodo que devuelve la nota de una materia del certificado pedido
	 * <b>Pre: </b> materia != null
     * <b>Post: </b> retorna la nota de la materia dada. Si el certificado no existe, se le informa a la UI
     * 
	 * @param materia: nombre de la materia
	 * @return nota de la materia
	 * @throws Exception 
	 */
	public String traerNota(String materia) throws Exception
	{
		assert materia !=null : "la materia no puede ser null";
		
		String nota = this.certificado.traerNota(materia);
		return nota;
	}
	
	/**
	 * Metodo que devuelve la condicion del alumno
     * <b>Post: </b> retorna la condición del alumno (regular o irregular). 
     * Si el certificado no existe, se le informa a la UI
     * 
	 * @return condicion
	 */
	public String traerCondición()
	{
		String condicion = "";
		try {
			condicion = this.certificado.traerCondicion();
		} catch (Exception e) {
			this.ui.mostrarEstado(e.getMessage());
		}
		return condicion;
	}
	
	
	
}
