package ar.edu.unlp.info.oo2.proyecto_ejemplo;

//CONTEXT
public class ConexionSegura extends Conexion{

	private Encriptador encriptador;	
	
	public void enviarMensaje(String mensaje) {
		String mensajeEncriptado = this.encriptador.encriptar(mensaje);
		super.enviar(mensajeEncriptado);
	}
	
	
}
