package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TopografiaTest {

	Topografia tierra1 = new Tierra();
	Topografia tierra2 = new Tierra();
	Topografia agua1 = new Agua();
	Topografia agua2 = new Agua();
	
	List<Topografia> listaTopo1 = new ArrayList<Topografia>();
	List<Topografia> listaTopo2 = new ArrayList<Topografia>();
	
	Topografia mixta1;
	Topografia mixta2;
	
	@BeforeEach
	void setUp() throws Exception {
		listaTopo1.add(tierra1);
		listaTopo1.add(tierra2);
		listaTopo1.add(tierra2);
		listaTopo1.add(tierra2);
		
		listaTopo2.add(tierra1);
		listaTopo2.add(tierra1);
		listaTopo2.add(tierra1);
		listaTopo2.add(tierra2);
		
		mixta1 = new Mixta(listaTopo1);
		mixta2 = new Mixta(listaTopo2);
	}
	
	@Test
	void testAguaYTierra() {
		assertEquals(true, tierra1.sonIguales(tierra2));
		assertEquals(true, agua1.sonIguales(agua2));
		assertEquals(false, tierra1.sonIguales(agua2));
		assertEquals(false, agua2.sonIguales(tierra1));
	}
	
	@Test
	void testMixta1() {

		assertEquals(true, mixta1.sonIguales(mixta2));
		
		listaTopo1.set(3, agua1);
		mixta1 = new Mixta(listaTopo1);
		assertEquals(false, mixta1.sonIguales(mixta2));
		
	}
	
	@Test
	void testMixta2() {
		
		listaTopo1.set(3, mixta2);
		Mixta mixta3 = new Mixta(listaTopo1);
		
		listaTopo2.set(3, mixta1);
		Mixta mixta4 = new Mixta(listaTopo2);
		
		
		assertEquals(true, mixta4.sonIguales(mixta3));
		
		
		List<Topografia> listaTopo3 = new ArrayList<Topografia>();
		listaTopo3.add(mixta1);
		listaTopo3.add(mixta2);
		listaTopo3.add(mixta4);
		listaTopo3.add(mixta3);
		
		Mixta mixta5 = new Mixta(listaTopo3);
		
		
		List<Topografia> listaTopo4 = new ArrayList<Topografia>();
		listaTopo4.add(mixta2);
		listaTopo4.add(mixta1);
		listaTopo4.add(mixta3);
		listaTopo4.add(mixta4);
		
		Mixta mixta6 = new Mixta(listaTopo4);
		
		assertEquals(true, mixta5.sonIguales(mixta6));
		
	}
	
	@Test
	void testPorcionAgua() {
		assertEquals(0, tierra1.proporcionDeAgua());
		assertEquals(1, agua1.proporcionDeAgua());
		
		List<Topografia> listaTopo3 = new ArrayList<Topografia>();
		listaTopo3.add(agua1);
		listaTopo3.add(agua2);
		listaTopo3.add(tierra1);
		listaTopo3.add(tierra2);
		
		Mixta mixta3 = new Mixta(listaTopo3);
		
		assertEquals(0.5, mixta3.proporcionDeAgua());
		
		
		List<Topografia> listaTopo4 = new ArrayList<Topografia>();
		listaTopo4.add(mixta1);
		listaTopo4.add(mixta2);
		listaTopo4.add(mixta3);
		listaTopo4.add(mixta3);
		
		Mixta mixta4 = new Mixta(listaTopo4);
		
		assertEquals(0.25, mixta4.proporcionDeAgua());
		
		List<Topografia> listaTopo5 = new ArrayList<Topografia>();
		listaTopo5.add(mixta4);
		listaTopo5.add(mixta4);
		listaTopo5.add(mixta3);
		listaTopo5.add(mixta3);
		
		Mixta mixta5 = new Mixta(listaTopo5);
		
		assertEquals(((0.5*2)+(0.25*2)) / 4, mixta5.proporcionDeAgua());
	}

		
}
