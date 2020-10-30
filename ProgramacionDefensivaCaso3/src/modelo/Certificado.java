package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Certificado {

	private ArrayList<Alumno> listaAlumnos;
	private Alumno alumnoCertificado = null;
	
	
	public Certificado(ArrayList<Alumno> lista)
	{
		this.listaAlumnos = lista;
	}
	
	
	/**
	 * Se busca el alumno en base al legajo y se actualiza la variable alumnoCertificado con sus datos.
	 * 
	 * <b>Pre: </b> legajo != null
     * <b>Post: </b> se actualiza alumnoCertificado con el alumno buscado. 
     * Si la operación fracasa (numero de legajo no existe) se lanza una excepción
	 * 
	 * @param legajo
	 * @throws Exception : el numero de legajo no existe
	 */
	public void pedirCertificado(Integer legajo) throws Exception
	{
		assert legajo != null : "El legajo no debe ser null";
		
		Alumno al = null;
		for(Alumno aux : listaAlumnos) { 
		      if(aux.getLegajo() == legajo) { 
		          al = aux;
		      }
		}
		if (al != null)
			this.alumnoCertificado = al;
		else
			throw new Exception("alumno no existe");
	}
	
	/**
	 * Metodo que devuelve el apellido y nombre del alumnoCertificado
	 * <b>Post: </b> retorna el apellido y nombre del certificado.
	 * 
	 * @return apellido y nombre del alumno
	 * @throws Exception: si no existe el legajo
	 */
	public String traerApellidoyNombre() throws Exception
	{
		if (this.alumnoCertificado != null)
			return alumnoCertificado.getApellido() + " " + alumnoCertificado.getNombre();
		else
			throw new Exception("alumno no existe");
	}
	
	/**
	 * Metodo que devuelve el estado de una materia del certificado pedido
	 * <b>Pre: </b> materia != null
     * <b>Post: </b> retorna el estado de la materia dada
     * 
	 * @param materia: nombre de la materia
	 * @return estado de la materia
	 * @throws Exception: si no existe el legajo
	 */
	public String traerEstado(String materia) throws Exception
	{
		assert materia != null : "La materia no debe ser null";
		if (this.alumnoCertificado != null)
			return alumnoCertificado.getMateria(materia).getEstado();
		else
			throw new Exception("alumno no existe");
	}
	
	/**
	 * Metodo que devuelve la nota de una materia del certificado pedido
	 * <b>Pre: </b> materia != null
     * <b>Post: </b> retorna la nota de la materia dada
     * 
	 * @param materia: nombre de la materia
	 * @return nota de la materia
	 * @throws Exception: si no existe el legajo
	 */
	public String traerNota(String materia) throws Exception
	{
		assert materia != null : "La materia no debe ser null";
		if (this.alumnoCertificado != null)
			return alumnoCertificado.getMateria(materia).getNota().toString();
		else
			throw new Exception("alumno no existe");
	}
	
	
	
	/**
	 * Metodo que devuelve la condicion de un alumno, regular o irregular.
	 * <b>Post: </b> se devuelve la condicion
	 * 
	 * @return condicion del alumno
	 * @throws Exception: si no existe el legajo
	 */
	public String traerCondicion() throws Exception
	{
		if (this.alumnoCertificado != null)
		{
			ArrayList<Materia> listaAux = alumnoCertificado.getListaMaterias();
			Iterator it = listaAux.iterator();
			int cont = 0;
			while(it.hasNext())
			{
				Materia materia = (Materia)it.next();
				if(materia.getEstado().equals("A cursar"))
					cont++;
			}
			if (cont >= 2)
				return "regular";
			else
				return "irregular";
		}
		else
			throw new Exception("alumno no existe");
	}
	
	
	
}
