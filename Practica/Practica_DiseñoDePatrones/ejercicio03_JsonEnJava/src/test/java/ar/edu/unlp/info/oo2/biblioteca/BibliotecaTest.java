package ar.edu.unlp.info.oo2.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BibliotecaTest {
	Biblioteca biblioteca;
	Socio arya;
	Socio tyron;
	JSONParser jsonParser;

	@BeforeEach
	void setUp() throws Exception{
		biblioteca = new Biblioteca();
		arya = new Socio("Arya Stark", "needle@stark.com", "5234-5");
		tyron = new Socio("Tyron Lannister", "tyron@thelannisters.com", "2345-2");
		jsonParser = new JSONParser();
	}
	
	@Test
	void testExportarSocios() {
		biblioteca.agregarSocio(arya);
		assertEquals("[\n"
				+ "\t{\n"
				+ "\t\t\"nombre\": \"Arya Stark\",\n"
				+ "\t\t\"email\": \"needle@stark.com\",\n"
				+ "\t\t\"legajo\": \"5234-5\"\n"
				+ "\t}\n"
				+ "]", biblioteca.exportarSocios());
		
		
		biblioteca.agregarSocio(tyron);
		assertEquals("[\n"
				+ "\t{\n"
				+ "\t\t\"nombre\": \"Arya Stark\",\n"
				+ "\t\t\"email\": \"needle@stark.com\",\n"
				+ "\t\t\"legajo\": \"5234-5\"\n"
				+ "\t},\n"
				+ "\t{\n"
				+ "\t\t\"nombre\": \"Tyron Lannister\",\n"
				+ "\t\t\"email\": \"tyron@thelannisters.com\",\n"
				+ "\t\t\"legajo\": \"2345-2\"\n"
				+ "\t}\n"
				+ "]", biblioteca.exportarSocios());
	}

	@Test
	void testExportarSociosConJson() throws ParseException {
		VoorheesExporter exporter = new JSONsimpleAdapter();
		biblioteca.setExporter(exporter);
		
		biblioteca.agregarSocio(arya);
		assertEquals(jsonParser.parse("[\n"
				+ "\t{\n"
				+ "\t\t\"nombre\": \"Arya Stark\",\n"
				+ "\t\t\"email\": \"needle@stark.com\",\n"
				+ "\t\t\"legajo\": \"5234-5\"\n"
				+ "\t}\n"
				+ "]"), jsonParser.parse(biblioteca.exportarSocios()));
		
		biblioteca.agregarSocio(arya);
		assertEquals(jsonParser.parse("[\n"
				+ "\t{\n"
				+ "\t\t\"nombre\": \"Arya Stark\",\n"
				+ "\t\t\"email\": \"needle@stark.com\",\n"
				+ "\t\t\"legajo\": \"5234-5\"\n"
				+ "\t},\n"
				+ "\t{\n"
				+ "\t\t\"nombre\": \"Arya Stark\",\n"
				+ "\t\t\"email\": \"needle@stark.com\",\n"
				+ "\t\t\"legajo\": \"5234-5\"\n"
				+ "\t}\n"
				+ "]"), jsonParser.parse(biblioteca.exportarSocios()));
	}

}
