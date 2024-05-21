package ar.edu.unlp.info.oo2.proyecto_ejemplo;

//Target - Strategy
public interface Connection {

    String sendData(String data, long crc);
    String pict();
    
}
