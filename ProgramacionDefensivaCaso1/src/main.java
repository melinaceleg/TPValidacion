
public class main {

	public static void main(String[] args)
	{
		
		
		BeerHouse modelo = new BeerHouse();
		UI vista = new UI();
		Negocio control = new Negocio (modelo, vista);
		
		/*
		 System.out.println ("Ingrece la cantidad de mesas con la que va a abrir el local");
		 String entradaTeclado = "";
		 Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
		 entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
		 System.out.println ("Entrada recibida por teclado es: \"" + entradaTeclado +"\"");
		 */
		vista.abrirLocal();
		
		control.abrirLocal(vista.getCantMesas());
		control.mostrarMesas();
		
		control.ocuparMesa(vista.ocuparMesa());
		control.mostrarMesas();
		control.cerrarMesa(vista.cerrarMesa());
		control.mostrarMesas();
		System.out.println("fin");
	}
	
	
}
