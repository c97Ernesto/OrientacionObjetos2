package ar.edu.unlp.info.oo2.proyecto_ejemplo;

//Adaptee
public class CuatroGConnection extends CuatroGConnectionAdapter{
	
    private String symb;
    
    public CuatroGConnection() {
    	this.symb = "Pict_CuatroGConnection";
    }

    public String transmit(String data, long crc) {
        return "Conexión 4G: " + data + crc;
    }

	public String getSymb() {
		return this.symb;
	}
}
