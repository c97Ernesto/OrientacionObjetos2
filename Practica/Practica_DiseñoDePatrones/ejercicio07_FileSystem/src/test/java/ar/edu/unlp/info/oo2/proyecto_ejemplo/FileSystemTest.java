package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileSystemTest {
	
	Directorio d0 = new Directorio("d0", LocalDate.of(2020, 1, 1));
	Directorio d1 = new Directorio("d1", LocalDate.of(2021, 1, 1));
	Directorio d2 = new Directorio("d2", LocalDate.of(2022, 1, 1));
	
	FileSystem a0 = new Archivo("a0", LocalDate.of(2020, 2, 1), 634);
	FileSystem a1 = new Archivo("a1", LocalDate.of(2021, 2, 1), 1);
	FileSystem a2 = new Archivo("a2", LocalDate.of(2022, 3, 1), 2);
	FileSystem a3 = new Archivo("a3", LocalDate.of(2023, 2, 1), 3);
	FileSystem a4 = new Archivo("a4", LocalDate.of(2022, 3, 1), 777);
	
	List<FileSystem> archivosMismoNombre = new ArrayList<FileSystem>();
	

	@BeforeEach
	void setUp() throws Exception {
		d0.addFile(d1);
		d0.addFile(a0);
		
		d1.addFile(d2);
		d1.addFile(a1);
		d1.addFile(a2);
		
		d2.addFile(a3);
		d2.addFile(a4);
	}

	@Test
	void testTamanio() {
		
		assertEquals(3 + 777 + 32, d2.tamanoTotalOcupado());
		
		assertEquals((1 + 2 + 32) + (d2.tamanoTotalOcupado()), d1.tamanoTotalOcupado());
		
		assertEquals((634 + 32) + d1.tamanoTotalOcupado(), d0.tamanoTotalOcupado());
	}
	
	@Test
	void testArchivoMasGrande() {
		assertTrue(d1.archivoMasGrande().nombre.equals("a4"));
		
		assertTrue(d0.archivoMasGrande().nombre.equals("a4"));
		
		assertEquals("a4", d0.archivoMasGrande().nombre);
		assertEquals("a4", d1.archivoMasGrande().nombre);
		assertEquals("a4", d2.archivoMasGrande().nombre);
	}
	
	@Test
	void testArchivoMasNuevo() {
		assertTrue(d1.archivoMasNuevo().nombre.equals("a3"));
		assertEquals("a3", d0.archivoMasNuevo().nombre);
		
//		assertTrue(d0.archivoMasGrande().nombre.equals("a4"));
//		
//		assertEquals("a4", d0.archivoMasGrande().nombre);
//		assertEquals("a4", d1.archivoMasGrande().nombre);
//		assertEquals("a4", d2.archivoMasGrande().nombre);
	}

	@Test
	void testBuscar() {
		assertEquals(a3.nombre, d2.buscar("a3").nombre);
		assertTrue(d2.buscar("a3").nombre.equals(a3.nombre));
		assertTrue(d1.buscar("a2").nombre.equals(a2.nombre));
		assertTrue(d0.buscar("d2").nombre.equals(d2.nombre));
	}
	
	@Test
	void testBuscarTodos() {
		archivosMismoNombre.add(a4);
		
		assertEquals(archivosMismoNombre, d0.buscarTodos("a4"));
	}
}
