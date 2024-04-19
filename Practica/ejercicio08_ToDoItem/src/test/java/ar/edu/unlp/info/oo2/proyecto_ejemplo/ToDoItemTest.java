package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ToDoItemTest {
	
	ToDoItem tarea = new ToDoItem("Lavar el piso");

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		
		assertEquals("Pending", tarea.getNameState());
		
		tarea.start();
		assertEquals("InProgress", tarea.getNameState());
		
		tarea.togglePause();
		assertEquals("Paused", tarea.getNameState());
		
		tarea.togglePause();
		assertEquals("InProgress", tarea.getNameState());
		
		tarea.start();
		assertEquals("InProgress", tarea.getNameState());
		
		tarea.finish();
		assertEquals("Finished", tarea.getNameState());
		
		tarea.start();
		assertEquals("Finished", tarea.getNameState());
		
	}
	
	@Test
	public void testMethodTogglePausedErrorAfterFinish() {
	    Assertions.assertThrows(RuntimeException.class, () -> {
			assertEquals("Pending", tarea.getNameState());
			
			tarea.start();
			assertEquals("InProgress", tarea.getNameState());
			
			tarea.togglePause();
			assertEquals("Paused", tarea.getNameState());
			
			tarea.finish();
			assertEquals("Finished", tarea.getNameState());
			
			tarea.togglePause();
	    });
	}
	
	@Test
	public void testMethodTogglePausedBeforeStart() {
	    Assertions.assertThrows(RuntimeException.class, () -> {
			assertEquals("Pending", tarea.getNameState());
			tarea.togglePause();
	    });
	}


	
	

}
