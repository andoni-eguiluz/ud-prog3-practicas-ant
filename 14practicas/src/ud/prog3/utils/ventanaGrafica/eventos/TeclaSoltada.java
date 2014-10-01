package ud.prog3.utils.ventanaGrafica.eventos;

import java.awt.event.KeyEvent;

public class TeclaSoltada implements EventoTeclado {
	private KeyEvent ke;
	public TeclaSoltada( KeyEvent ke ) {
		this.ke = ke;
	}
	@Override
	public long getTime() {
		return ke.getWhen();
	}
	@Override
	public int getCodigoTecla() {
		return ke.getKeyCode();
	}
	@Override
	public char getCarTecla() {
		return ke.getKeyChar();
	}
	@Override
	public String toString() {
		return "TeclaSoltada: código " + getCodigoTecla() + " (car. '" + getCarTecla() + "')";
	}
}
