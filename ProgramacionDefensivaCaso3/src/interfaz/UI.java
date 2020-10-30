package interfaz;

import java.util.Scanner;

import modelo.Certificado;
import negocio.Negocio;

public class UI {

	private Negocio negocio = null;
	private int legajo;
	
	
	public void ingresarLegajo()
	{
		System.out.println ("Ingresar numero de legajo");
		String entradaTeclado = "";
		Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
		entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
		 
		this.legajo=Integer.parseInt(entradaTeclado);
		
		this.pedirCertificado(legajo);
		
	}
	
	/**
	 * <b>Pre:</b> legajo!=null
	 * <b>Post:</b> Se pide al modelo el certificado del alumno
	 * @param legajo
	 */
	public void pedirCertificado(Integer legajo)
	{
		assert legajo != null : "el legajo no debe ser null";
		
		try {
			this.negocio.pedirCertificado(legajo);
			System.out.println("Certificado para legajo nro:"+legajo);
			this.mostrarCertificado();
		} catch (Exception e) {
			this.mostrarEstado(e.getMessage());
		}
		
	}	
	
	/**
	 * Metodo para mostrar un estado de error en la pantalla
	 * <b>Pre: </b> mensaje!=null
	 * @param mensaje
	 */
	public void mostrarEstado(String mensaje)
	{
		System.out.println(mensaje);
	}
	
	
	/**
	 * Metodo para mostrar el certificado del alumno por pantalla
	 * <b>Post: </b> se muestra con exito los datos del certificado. 
	 * En caso de fallo, se muestran los mensajes de cualquiera
     * de las excepciones correspondientes: CertificadoInexistenteException o NombreMateriaInvalidoException.
	 */
	public void mostrarCertificado()
	{
		String nomb = this.negocio.traerApellidoyNombre();
		String materia;
		String condicion = this.negocio.traerCondición();
		
		System.out.println("Alumno: "+nomb);
		System.out.println("Condicion: "+condicion);
		
		System.out.println("/// Materias ///");
		
		materia = "Historia";
		System.out.print("- "+materia+": ");
		try {
			System.out.print(this.negocio.traerNota(materia)+" ("+this.negocio.traerEstado(materia)+")");
			System.out.println();
		} catch (Exception e) {
			this.mostrarEstado(e.getMessage());
		}
		
		materia = "Matematica";
		System.out.print("- "+materia+": ");
		try {
			System.out.print(this.negocio.traerNota(materia)+" ("+this.negocio.traerEstado(materia)+")");
			System.out.println();
		} catch (Exception e) {
			this.mostrarEstado(e.getMessage());
		}
		
		materia = "Literatura";
		System.out.print("- "+materia+": ");
		try {
			System.out.print(this.negocio.traerNota(materia)+" ("+this.negocio.traerEstado(materia)+")");
			System.out.println();
		} catch (Exception e) {
			this.mostrarEstado(e.getMessage());
		}
		
		
		materia = "Fisica";
		System.out.print("- "+materia+": ");
		try {
			System.out.print(this.negocio.traerNota(materia)+" ("+this.negocio.traerEstado(materia)+")");
			System.out.println();
		} catch (Exception e) {
			this.mostrarEstado(e.getMessage());
		}
		
		
	}
	
	public void setNegocio(Negocio negocio)
	{
		this.negocio = negocio;
	}
	
	
	
}
