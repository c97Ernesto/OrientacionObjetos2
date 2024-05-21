package ar.edu.unlp.info.oo2.accesobd;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DatabaseRealAccesProxyTest {

	DatabaseAccess database;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAutenticado() {
		database = new DatabaseRealAccesProxy("1234");
		assertEquals(Arrays.asList("Spiderman", "Marvel"), this.database.getSearchResults("select * from comics where id=1"));
        assertEquals(Collections.emptyList(), this.database.getSearchResults("select * from comics where id=10"));
	}
	
	@Test
	void testNoAutenticado() {
		database = new DatabaseRealAccesProxy("12345");
		assertEquals(Arrays.asList("Spiderman", "Marvel"), this.database.getSearchResults("select * from comics where id=1"));
        assertEquals(Collections.emptyList(), this.database.getSearchResults("select * from comics where id=10"));
	}

}
