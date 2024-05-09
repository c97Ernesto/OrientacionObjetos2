package ar.edu.unlp.info.oo2.proyecto_ejemplo;

//ConcreteStrategy
public class WifiConn implements Connection{
	private String pict;

	
	public WifiConn() {
		this.pict = "Pict_WifiConn";
	}
	
	@Override
	public String sendData(String data, long crc) {
		return "Conexión Wifi: " + data + crc;
	}

	@Override
	public String pict() {
		return this.pict;
	}

}
