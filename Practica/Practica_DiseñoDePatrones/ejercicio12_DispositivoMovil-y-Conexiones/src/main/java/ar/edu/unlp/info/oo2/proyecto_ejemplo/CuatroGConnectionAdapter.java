package ar.edu.unlp.info.oo2.proyecto_ejemplo;

//Adapter - ConcreteStrategy
public abstract class CuatroGConnectionAdapter implements Connection{
	private CuatroGConnection adaptee;
	
	public CuatroGConnectionAdapter() {
		this.adaptee = new CuatroGConnection();
	}
	
	@Override
	public String sendData(String data, long crc) {
		return this.adaptee.transmit(data, crc);
	}

	@Override
	public String pict() {
		return this.adaptee.getSymb();
	}

}
