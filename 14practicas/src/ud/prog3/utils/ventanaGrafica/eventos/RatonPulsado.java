package ud.prog3.utils.ventanaGrafica.eventos;

import java.awt.Point;
import java.awt.event.MouseEvent;

public class RatonPulsado implements EventoRaton {
	private MouseEvent me;
	public RatonPulsado( MouseEvent me ) {
		this.me = me;
	}
	@Override
	public long getTime() {
		return me.getWhen();
	}
	@Override
	public Point getPosicion() {
		return me.getPoint();
	}
	@Override
	public String toString() {
		return "RatonPulsado: (" + getPosicion().getX() + "," + getPosicion().getY() + ")";
	}
}
