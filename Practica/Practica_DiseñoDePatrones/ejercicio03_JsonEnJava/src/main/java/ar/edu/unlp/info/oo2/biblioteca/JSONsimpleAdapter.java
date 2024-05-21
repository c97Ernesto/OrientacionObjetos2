package ar.edu.unlp.info.oo2.biblioteca;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONsimpleAdapter extends VoorheesExporter{

	private JSONObject convertirSocio(Socio socio) {
		JSONObject socioJSON = new JSONObject();
		socioJSON.put("nombre", socio.getNombre());
		socioJSON.put("email", socio.getEmail());
		socioJSON.put("legajo", socio.getLegajo());
		
		return socioJSON;
	}
	
	public String exportar(List<Socio> socios) {
		JSONArray sociosJSON = new JSONArray();
		
		for (Socio socio : socios) 
			sociosJSON.add(this.convertirSocio(socio));
		
		return sociosJSON.toJSONString();
	}
	

	
}
