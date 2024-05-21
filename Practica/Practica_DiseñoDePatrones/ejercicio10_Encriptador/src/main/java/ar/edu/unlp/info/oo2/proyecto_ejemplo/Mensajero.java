package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public class Mensajero {

	private Conexion conexion;
	
	public void enviar(String mensaje) {
		conexion.enviar(mensaje);
	}
	
}
