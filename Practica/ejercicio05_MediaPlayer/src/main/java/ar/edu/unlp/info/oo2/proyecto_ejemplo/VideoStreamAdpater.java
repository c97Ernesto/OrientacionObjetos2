package ar.edu.unlp.info.oo2.proyecto_ejemplo;

public abstract class VideoStreamAdpater extends VideoStream implements Media {

	
	@Override
	public int play() {
		return (int) this.reproduce();
	}
	
}
