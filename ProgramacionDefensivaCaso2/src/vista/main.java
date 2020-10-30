package vista;

import controlador.Negocio;
import modelo.Surtidor;

public class main {

	public static void main(String[] args)
	{
		
		//Clase para probar los metodos
		Surtidor modelo = new Surtidor();
		UI vista = new UI();
		Negocio control = new Negocio (modelo, vista);
		
		vista.inicializaSurtidor();
		
		control.InicializarSurtidor(vista.getCombustible());
		
		vista.cargarSurtidor();
		control.cargarSurtidor(vista.getCombustible());
		
		control.activaManguera1();
		//control.desactivaManguera1();
		//control.activaManguera2();
		
		System.out.println("fin");
		
		
		
		
		
	}

}
