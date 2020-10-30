package modelo;

import java.util.ArrayList;

public class Alumno {
	private Integer legajo;
	private String nombre;
	private String apellido;
	private ArrayList<Materia> listaMaterias = null;
	
	
	/**
	 * Constructor de la clase Alumno
	 * 
	 *<b>Pre:</b>
     * nombre != null, nombre no vacio <br>
     * apellido != null, apellido no vacio <br>
     * legajo != null
     * listaMaterias != null
     * 
     * <b>Post:</b> se crea una instancia de la clase Alumno
     *
     *
     * @param legajo: legajo del alumno
     * @param nombre: nombre del alumno
     * @param apellido: apellido del alumno
     * @param listaMaterias: materias del alumno
	 * @throws Exception : si el legajo es incorrecto o contiene materias no válidas
	 */
	public Alumno(Integer legajo, String nombre, String apellido, ArrayList<Materia> listaMaterias) throws Exception
	{
			
		if(legajo < 1000 || legajo >= 10000)
			throw new Exception("el numero de legajo debe ser de 4 cifras");
		
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.listaMaterias = listaMaterias;
		
		this.verificaInvariante();
	}
	
	public Alumno(Integer legajo, String nombre, String apellido) throws Exception
	{
		this(legajo,nombre,apellido,new ArrayList<Materia>());
	}
	
	/**
	 * Metodo que retorna una Materia a partir de su nombre
	 * 
	 * <b>Pre: </b> nombre != null
     * <b>Post: </b> retorna la materia correspondiente
	 * 
	 * @param nombre : nombre de la materia
	 * @return objeto de tipo Materia que coincide con el nombre de la materia dado
	 * @throws Exception si la materia no está cargada
	 */
	public Materia getMateria(String nombre) throws Exception
	{
		assert nombre != null : "El nombre de la materia no debe ser null";
		
		Materia mat = null;
		for(Materia aux : listaMaterias) { 
		      if(aux.getNombre().equals(nombre)) { 
		          mat = aux;
		      }
		}
		if(mat == null)
			throw new Exception("materia no cargada");
		return mat;
	}
	
	

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public ArrayList<Materia> getListaMaterias() {
		return listaMaterias;
	}

	public void setListaMaterias(ArrayList<Materia> listaMaterias) {
		this.listaMaterias = listaMaterias;
	}
	
	
	private void verificaInvariante()
	{
		assert legajo != null : "El legajo debe ser distinto de null";
		assert nombre != null : "El nombre debe ser distinto de null";
		assert apellido != null : "El apellido debe ser distinto de null";
		assert listaMaterias != null : "La lista de materias debe ser distinto de null";
	}
	
	
}
