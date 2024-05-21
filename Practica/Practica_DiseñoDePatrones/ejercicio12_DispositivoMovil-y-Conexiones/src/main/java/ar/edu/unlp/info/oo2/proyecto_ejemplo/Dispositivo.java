package ar.edu.unlp.info.oo2.proyecto_ejemplo;


//Context - Client
public class Dispositivo {

    private CRC_Calculator crcCalculator;
    private Ringer ringer;
    private Connection connection;
    private Display display;

    
    public Dispositivo() {
    	this.crcCalculator = new CRC16_Calculator();
    	this.ringer = new Ringer();
    	this.connection = new WifiConn();
    	this.display = new Display();
    }
    
    public String send(String data) {
        long crc = this.crcCalculator.crcFor(data);
        return this.connection.sendData(data, crc);
    }
    
	public String configurarCRC(CRC_Calculator newCRC_Calculator) {
		this.crcCalculator = newCRC_Calculator;
		return ("Se cambió de CRC.");
	}
    
    public String conectarCon(Connection newConnection) {
    	this.connection = newConnection;
    	this.display.showBanner(this.connection.pict());
    	this.ringer.ring();
    	return ("Se cambió la conexión.");
    }
    
    
}
