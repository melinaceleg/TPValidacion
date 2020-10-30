import java.util.ArrayList;
import java.util.Iterator;


public class BeerHouse {
	
	
	private ArrayList<Mesa> mesas = new ArrayList<Mesa>(); 
	
	public ArrayList<Mesa> getMesas() {
		return mesas;
	}
	public void setMesas(ArrayList<Mesa> mesas) {
		this.mesas = mesas;
	}
	
	/**
	 *<b>PRE:</b> La cantidad de mesas es mayor o igual a 1 
	 *<b>PRE:</b> La cantidad o el listado de productos  no puede ser null
	 *Metodo que recorre todas las mesas y las inicializa, indicando cada una como libre
	 *<b>POST:</b> El listado de mesas se inicializa 
	 */
	public void abrirLocal (int cantMesas) {
			
			
		for (int i=0;i<cantMesas;++i) {
		
			Mesa mesa=new Mesa();
			mesa.setUso('L');
			mesa.setImporte(0);
			mesa.getProductos().add("cubiertos");
			
			assert mesa.getProductos() !=null : "El listado de productos no puede ser null"
			
			mesas.add(mesa);
		}
		assert verificarInvariante();
		
	}
	
	/**
	 *<b>PRE:</b> El uso de la mesa esta seteado en Libre "L"
	 *Retorna la instancia de mesa de la lista de mesas que tiene el nroMesa indicado en el
      parámetro y establece el atributo uso como ocupada (‘O’)
	 *<b>POST:</b> Devuelve la mesa con su atributo Uso modificado como Ocupado
	 */
	public Mesa ocuparMesa (int nroMesa) {
		
		assert this.getMesas(nroMesa).getUso != "L" : "La mesa debe estar libre":
		
		this.mesas.get(nroMesa).setUso('O');
		return this.mesas.get(nroMesa);
		
	}
	
	/**
	 *<b>PRE:</b> La mesa esta ocupada
	 *Calcula y retorna el importe total consumido de la mesa indicada como parámetro y
	 establece el atributo uso como libre (‘L’).
	 *<b>POST:</b> Devuelve la mesa con su atributo Uso modificado como Libre
	 */
	public double cerrarMesa (int nroMesa) {
		
		assert this.getMesas(nroMesa).getUso != "O" : "La mesa debe estar ocupada para poder cerrarla"
		
		this.mesas.get(nroMesa).setUso('L');
		return this.mesas.get(nroMesa).getImporte();
		
	}
	public void mostrarMesas() {
		Iterator<Mesa> iter  = this.mesas.iterator(); 

      while (iter.hasNext()) { 
    	  Mesa actual = iter.next();
          System.out.println(actual.getUso() + " " + actual.getImporte()); 
      } 
	
	}
	
	private void verificarInvariante() {
  	   assert this.mesas != null: "El listado de mesas no puede ser null";
    }



}
