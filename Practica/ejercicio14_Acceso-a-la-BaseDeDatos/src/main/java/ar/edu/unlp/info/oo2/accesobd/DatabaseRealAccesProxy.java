package ar.edu.unlp.info.oo2.accesobd;

import java.util.Collection;
import java.util.List;

public class DatabaseRealAccesProxy implements DatabaseAccess{
	//refernecia al objeto original
	private DatabaseAccess realDatabase;
	
	private boolean isLogged;
	
	public DatabaseRealAccesProxy(String password) {
		passwordValidate(password);
	}

	private void passwordValidate(String password) {
		if (password.equals("1234")) {
			this.realDatabase = new DatabaseRealAccess();
			this.isLogged = true;
		}
		else
			this.isLogged = false;
	}

	@Override
	public Collection<String> getSearchResults(String queryString) {
		if (this.isLogged) {
			return this.realDatabase.getSearchResults(queryString);
		}
		else {
			throw new RuntimeException("ALERTA DE INTRUSO");
		}
	}

	@Override
	public int insertNewRow(List<String> rowData) {
		if (this.isLogged){
			return this.realDatabase.insertNewRow(rowData);
		}
		else {
			throw new RuntimeException("ALERTA DE INTRUSO");
		}
	}
	
	
}
