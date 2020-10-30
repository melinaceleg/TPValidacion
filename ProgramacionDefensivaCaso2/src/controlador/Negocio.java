package controlador;

import modelo.NoHayCombustibleException;
import modelo.Surtidor;
import vista.UI;
public class Negocio {
	
	private Surtidor modelo;
	private UI vista;
	private byte mangueraActiva; //0 ninguna activa, 1 MG 1 activa, 2 MG 2 activa

	public Negocio(Surtidor modelo, UI vista) {
		super();
		this.modelo = modelo;
		this.vista = vista;
	}
	/**
	 *<b>PRE</b>
	 *Recibe de la interfaz de usuario la cantidad de combustible con la que se iniciara el surtidor sin
	 *ningún tipo de validación.
	 *<b>POST:</b> Se inicializa el surtidor y avisa el exitoso o fracaso de la operacion
	 */
	public void InicializarSurtidor (double carga) {
		this.modelo.InicializarSurtidor(carga);
		this.mangueraActiva=0;
		vista.operacionExitosa();
	}
	/**
	 *<b>PRE</b>
	 *Recibe de la interfaz de usuario la cantidad de combustible con la que se agregara al surtidor sin
	 *ningún tipo de validación.
	 *<b>POST:</b> Se carga el surtidor y avisa el exitoso o fracaso de la operacion
	 */
	public void cargarSurtidor (double carga) {
		this.modelo.cargarSurtidor(carga);
		vista.operacionExitosa();
	}
	
	/**
	 *<b>PRE</b> La interfaz de usuario activa la manguera 1
	 *Recibe de la interfaz de usuario la señal para que se active la manguera 1
	 *ningún tipo de validación.
	 *<b>POST:</b> Informa si la accion fue posible o no
	 */
	public void activaManguera1() {
		if (vista.activaManguera1()) {
			this.mangueraActiva=1;
			
			while (this.mangueraActiva==1) {
				try {
					this.modelo.descargarManguera1();
					
			
				}
				catch (NoHayCombustibleException e) {
					this.mangueraActiva=0;
					
				}
					
			}
		}

	
	}
	/**
	 *<b>PRE</b> La interfaz de usuario activa la manguera 2
	 *Recibe de la interfaz de usuario la señal para que se active la manguera 2 sin
	 *ningún tipo de validación.
	 *<b>POST:</b> Informa si la accion fue posible o no
	 */
	public void activaManguera2() {
		if (vista.activaManguera2()) {
			this.mangueraActiva=2;
			
			while (this.mangueraActiva==2) {
				try {
					this.modelo.descargarManguera2();
					
			
				}
				catch (NoHayCombustibleException e) {
					this.mangueraActiva=0;
					
				}
					
			}
		}

	
	}
	/**
	 *<b>PRE</b> La interfaz de usuario desactiva la manguera 1
	 *Recibe de la interfaz de usuario la señal para desactivar la manguera 1 sin
	 *ningún tipo de validación.
	 *<b>POST:</b> Desactiva la carga e informa si la accion fue posible o no
	 */
	public void desactivaManguera1() {
		if (vista.DesactivaManguera1()) {
			this.mangueraActiva=0;
			this.modelo.setUltimaVentaManguera1(this.modelo.getAcumuladoManguera1()*20);  
		}
		
	
	}
	/**
	 *<b>PRE</b> La interfaz de usuario desactiva la manguera 2
	 *Recibe de la interfaz de usuario la señal para desactivar la manguera 2 sin
	 *ningún tipo de validación.
	 *<b>POST:</b> Desactiva la carga e informa si la accion fue posible o no
	 */
	public void desactivaManguera2() {
		if (vista.DesactivaManguera2()) {
			this.mangueraActiva=0;
			this.modelo.setUltimaVentaManguera2(this.modelo.getAcumuladoManguera2()*20);  
		}
	}
	
	public double getExistenciaDeposito() {
		return this.modelo.getExistenciaDeposito();
	}

	public double getUltimaVentaMG1() {
		return this.modelo.getUltimaVentaMG1();
	}

	public double getUltimaVentaMG2() {
		return this.modelo.getUltimaVentaMG2();
	}

	public double getAcumuladoManguera2() {
		return this.modelo.getAcumuladoManguera2();
	}

	public double getAcumuladoManguera1() {
		return this.modelo.getAcumuladoManguera1();
	}

	
	
	
	
	
}
