import java.util.ArrayList;

import interfaz.UI;
import modelo.Alumno;
import modelo.Certificado;
import modelo.Materia;
import negocio.Negocio;

public class Prueba {

	public static void main(String[] args) {
		
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		ArrayList<Materia> listaMaterias = new ArrayList<Materia>();
		
		Materia m1;
		Materia m2;
		try {
			m1 = new Materia("Historia",6.0);
			m2 = new Materia("Matematica",8.0);
			
			listaMaterias.add(m1);
			listaMaterias.add(m2);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			Alumno a1 = new Alumno(1234,"Marcos","Aguero",listaMaterias);
			listaAlumnos.add(a1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Certificado certificado = new Certificado(listaAlumnos);
		UI interfaz = new UI();
		Negocio sistemaAlumnos = new Negocio(certificado,interfaz);
		
		interfaz.ingresarLegajo();
	}

}
