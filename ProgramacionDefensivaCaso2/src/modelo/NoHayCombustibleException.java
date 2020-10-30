package modelo;

public class NoHayCombustibleException extends Exception {
	public NoHayCombustibleException () {
		System.out.println("No hay combustible");
	}
}

