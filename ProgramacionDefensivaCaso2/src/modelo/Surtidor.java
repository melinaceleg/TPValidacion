package modelo;



public class Surtidor {

	private double cantidad_Combustible;
	private double acumuladoDeVentas;
	private double ultimaVentaManguera1;
	private double ultimaVentaManguera2;
	private double acumuladoManguera1;
	private double acumuladoManguera2;
	
	
	public Surtidor() {
		super();
	}

	/**
	 *<b>PRE:</b> El valor inicial indicado por el usuario es>=1
	 *<b>PRE:</b> Ese valor inicial no es >2000
	 *Metodo que inicializa las variables del surtidor, con la cantidad inicial de combustible que indica el usuario
	 *<b>POST:</b> El surtidor se inicializa
	 */
	
	public void InicializarSurtidor(double carga) {
		assert carga<2000 : "La capacidad maxima del surtidor es de 2000 litros";
		this.cantidad_Combustible = carga;
		this.ultimaVentaManguera1=0;
		this.ultimaVentaManguera2=0;
		this.acumuladoManguera1=0;
		this.acumuladoManguera2=0;
		
	}
	/**
	 *<b>PRE:</b> El valor que indica el usuario es >=1 y <2000
	 *Metodo que agrega combustible al surtidor
	 *<b>POST:</b> Se agrega el valor de la carga, a los existente en el surtidor
	 */
	public void cargarSurtidor (double carga) {	
		assert cantidad_Combustible+carga<2000 : "La capacidad maxima del surtidor es de 2000 litros";
		this.cantidad_Combustible += carga ;
	}
	/**
	 *<b>PRE:</b> Si hay una cantidad >=1 de combustible en el surtidor, se descarga usando la manguera 1
	 *Metodo que descarga combustible usando la manguera 1
	 *<b>POST:</b> Se agrega lo descargado a acumuladoManguera1 y se resta a cantidad_Combustible
	 */
	public void descargarManguera1() throws NoHayCombustibleException{
		if (this.verificarInvariante()) {

			this.cantidad_Combustible-=1;
			this.acumuladoManguera1+=1;
			System.out.println("Cantidad combustible:"+cantidad_Combustible+" Acumulado manguera 1:"+acumuladoManguera1);
		}
		else
			throw new NoHayCombustibleException();
	}
	/**
	 *<b>PRE:</b> Si hay una cantidad >=1 de combustible en el surtidor, se descarga usando la manguera 2
	 *Metodo que descarga combustible usando la manguera 2
	 *<b>POST:</b> Se agrega lo descargado a acumuladoManguera2 y se resta a cantidad_Combustible
	 */
	public void descargarManguera2() throws NoHayCombustibleException {
		if (this.verificarInvariante()) {
			
			this.cantidad_Combustible-=1;
			this.acumuladoManguera2+=1;
			
		}
		else
			throw new NoHayCombustibleException();
	}
	
	
	public double getExistenciaDeposito() {
		return cantidad_Combustible;
	}

	public double getUltimaVentaMG1() {
		return ultimaVentaManguera1;
	}

	public double getUltimaVentaMG2() {
		return ultimaVentaManguera2;
	}

	public double getAcumuladoManguera2() {
		return acumuladoManguera1;
	}

	public double getAcumuladoManguera1() {
		return acumuladoManguera2;
	}


	public void setUltimaVentaManguera1(double ultimaVentaManguera1) {
		this.ultimaVentaManguera1 = ultimaVentaManguera1;
	}

	
	public void setUltimaVentaManguera2(double ultimaVentaManguera2) {
		this.ultimaVentaManguera2 = ultimaVentaManguera2;
	}

	
	public boolean verificarInvariante() {
		return this.cantidad_Combustible>=1;
	}
	
	
	
	
	
	
	
	
	
}
