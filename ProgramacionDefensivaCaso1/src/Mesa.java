import java.util.ArrayList;

public class Mesa {

	
	private char uso;
	private double importe;
	private ArrayList productos=new ArrayList();
	
	public char getUso() {
		return uso;
	}

	public void setUso(char uso) {
		this.uso = uso;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public ArrayList getProductos() {
		return productos;
	}

	public void setProductos(ArrayList productos) {
		this.productos = productos;
	}
	
	
	
}
