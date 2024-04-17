package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Component
public abstract class FileSystem {
	
	public String nombre;
	
	public LocalDate fechaCreacion;
	
	public FileSystem(String nombre, LocalDate fechaCreacion) {
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
	}
	
	/**
	* Retorna el espacio total ocupado, incluyendo todo su contenido.
	*/
	public abstract int tamanoTotalOcupado();
	
	/**
	* Retorna el archivo con mayor cantidad de bytes en cualquier nivel del
	* filesystem
	*/
	public abstract Archivo archivoMasGrande();
	
	/**
	* Retorna el archivo con fecha de creación más reciente en cualquier nivel
	* del filesystem
	*/
	public abstract Archivo archivoMasNuevo();
	
	/**
	* Retorna el primer elemento con el nombre solicitado contenido en
	cualquier nivel del filesystem
	*/
	public abstract FileSystem buscar(String nombre);
	
	/**
	* Retorna la lista con los elementos que coinciden con el nombre solicitado
	* contenido en cualquier nivel del filesystem
	*/
	public List<FileSystem> buscarTodos(String nombre){
		List<FileSystem> todos = new ArrayList<FileSystem>();
		buscarTodos(nombre, todos);
		return todos;
	}
	
	public abstract void buscarTodos(String nombre, List<FileSystem> archivos);
//	
//	/**
//	* Retorna un String con los nombres de los elementos contenidos en todos los
//	* niveles del filesystem. De cada elemento debe retornar el path completo
//	* (similar al comando pwd de linux) siguiendo el modelo presentado a
//	* continuación
//		/Directorio A
//		/Directorio A/Directorio A.1
//		/Directorio A/Directorio A.1/Directorio A.1.1
//		/Directorio A/Directorio A.1/Directorio A.1.2
//		/Directorio A/Directorio A.2
//		/Directorio B
//	*/
//	public String listadoDeContenido()
			

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
}
