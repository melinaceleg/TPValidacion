
public class Negocio {

	private BeerHouse modelo;
	private UI vista;
	
	public Negocio(BeerHouse modelo, UI vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
	}
	
	/**
	 *<b>PRE:</b> La cantidad de mesas no puede ser nulo 
	 *Recibe de la interfaz de usuario la cantidad de mesas que se habilitan para la jornada sin
	 *ning�n tipo de validaci�n.
	 *<b>POST:</b> El listado de mesas se inicializa 
	 */
	public void abrirLocal (int cantMesas) {
		
		assert cantMesas <= 0 : "La cantidad de mesas no pueder ser menor o igual a 0" 
		
		this.modelo.abrirLocal(cantMesas);
	}
	
	/**
	 *<b>PRE:</b> El Numero de la mesa es mayor a 0
	 *Recibe el nroMesa de la interfaz de usuario sin ning�n tipo de validaci�n. Retorna instancia
     *de mesa correspondiente. Esto lo usar� la interfaz de usuario
	 *<b>POST:</b> Devuelve la mesa ocupada a la interfaz 
	 */
	public Mesa ocuparMesa (int nroMesa) {
		
		
		return this.modelo.ocuparMesa(nroMesa);
		
	}
	
	/**
	 *<b>PRE:</b> El Numero de la mesa es mayor a 0
	 * Recibe el nroMesa de la interfaz de usuario sin ning�n tipo de validaci�n. Calcula y retorna
	 *el importe total consumido de la mesa indicada como par�metro
	 *<b>POST:</b> Devuelve el importe total de la mesa
	 */
	public double cerrarMesa (int nroMesa) {
		
		return this.modelo.cerrarMesa(nroMesa);
		
	}
	
	public void mostrarMesas () {
		
		this.modelo.mostrarMesas();
		
	}
	
	
}
