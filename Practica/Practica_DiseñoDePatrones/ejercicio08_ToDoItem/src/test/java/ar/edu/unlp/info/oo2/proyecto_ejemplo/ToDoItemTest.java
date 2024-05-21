package ar.edu.unlp.info.oo2.proyecto_ejemplo;

import static org.junit.jupiter.api.Assertions.*;

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
		
		assertEquals("Pending", tarea.getStateName());
		
		tarea.start();
		assertEquals("InProgress", tarea.getStateName());
		
		tarea.togglePause();
		assertEquals("Paused", tarea.getStateName());
		
		tarea.togglePause();
		assertEquals("InProgress", tarea.getStateName());
		
		tarea.start();
		assertEquals("InProgress", tarea.getStateName());
		
		tarea.finish();
		assertEquals("Finished", tarea.getStateName());
		
		tarea.start();
		assertEquals("Finished", tarea.getStateName());
		
	}
	
	@Test
	public void testMethodTogglePausedErrorAfterFinish() {
	    Assertions.assertThrows(RuntimeException.class, () -> {
			assertEquals("Pending", tarea.getStateName());
			
			tarea.start();
			assertEquals("InProgress", tarea.getStateName());
			
			tarea.togglePause();
			assertEquals("Paused", tarea.getStateName());
			
			tarea.finish();
			assertEquals("Finished", tarea.getStateName());
			
			tarea.togglePause();
	    });
	}
	
	@Test
	public void testMethodTogglePausedBeforeStart() {
	    Assertions.assertThrows(RuntimeException.class, () -> {
			assertEquals("Pending", tarea.getStateName());
			tarea.togglePause();
	    });
	}


	
	

}
