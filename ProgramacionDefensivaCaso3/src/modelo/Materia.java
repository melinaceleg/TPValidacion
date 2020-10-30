package modelo;

public class Materia {
	private String nombre;
	private String estado;
	private Double nota;
	
	/**
	 * Constructor para la clase Materia
	 * 
	 * <b>Pre:</b>
	 * nombre != null
	 * nota != null
	 * 
	 * <b>Post:</b> se crea una instancia de la clase Alumno
	 * 
	 * @param nombre: nombre de la materia
	 * @param nota: nota de la materia
	 * @throws Exception: si los datos de la materia están fuera de lo predefinido (Historia, Matematica, Fisica, Literatura)
	 * o la nota no se encuentra dentro del rango 0=<nota<=10
	 */
	public Materia(String nombre, Double nota) throws Exception
	{
		assert nombre != null: "El nombre de la materia no puede ser null";
		assert nota != null: "la nota no puede ser null";
		
		if(verificaNombre(nombre) && (nota>=0 && nota <=10))
		{
			this.nombre = nombre;
			this.nota = nota;
			this.estado = "Aprobada";
		}
		else
			throw new Exception("Datos de materia incorrectos");
	}
	
	/**
	 * Constructor para la clase Materia
	 * 
	 * <b>Pre:</b>
	 * nombre != null
	 * estado != null
	 * 
	 * <b>Post:</b> se crea una instancia de la clase Alumno
	 * 
	 * @param nombre: nombre de la materia
	 * @param estado: estado de la materia
	 * @throws Exception: si los datos de la materia están fuera de lo predefinido (Historia, Matematica, Fisica, Literatura)
	 */
	public Materia(String nombre, String estado) throws Exception
	{
		assert nombre != null: "El nombre de la materia no puede ser null";
		assert estado != null: "El estado no puede ser null";
		
		if(verificaNombre(nombre) && verificaEstado(estado))
		{
			this.nombre = nombre;
			this.estado = estado;
		}
		else
			throw new Exception("Datos de materia incorrectos");
	}
	
	
	/**
     * Metodo que verifica que el estado de la materia sea correcto
     *
     * <b>Pre: </b> estado != null
     * <b>Post: </b> retorna un boolean que determina si el estado de la materia es correcto
     *
     * @param nombre: estado de la materia
     * @return true si es correcto, false en caso contrario
     */
	private boolean verificaEstado(String estado){
		assert estado != null : "El estado no puede ser null";
        return estado.equals("A Cursar") || estado.equals("Cursada") || estado.equals("Aprobada");
    }
	
	
	 /**
     * Metodo que verifica que el nombre de la materia sea correcto
     *
     * <b>Pre: </b> nombre != null
     * <b>Post: </b> retorna un boolean que determina si el nombre de la materia es correcto
     *
     * @param nombre: nombre de la materia
     * @return true si es correcto, false en caso contrario
     */
	private boolean verificaNombre(String nombre){
		assert nombre != null : "El nombre no debe ser null";
        return nombre.equals("Historia") || nombre.equals("Matematica") || nombre.equals("Literatura") || nombre.equals("Fisica") ;
    }
	
	/**
	 * Metodo que agrega la nota a la materia y le cambia el estado a Aprobada
	 * 
	 * <b>Pre:</b> nota != null
	 * <b>Post:</b> se setea la nota y el estado 
	 * 
	 * @param nota
	 * @throws Exception
	 */
	public void setNota(Double nota) throws Exception
	{
		assert nota != null : "la nota no puede ser null";
		if(nota>=0 && nota <=10)
		{
			this.nota = nota;
			this.estado = "Aprobada";
		}
		else throw new Exception("nota no válida");
	}
	
	public Double getNota()
	{
		return this.nota;
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
