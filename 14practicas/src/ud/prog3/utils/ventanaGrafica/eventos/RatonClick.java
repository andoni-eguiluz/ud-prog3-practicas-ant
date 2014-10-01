package ud.prog3.utils.ventanaGrafica.eventos;

import java.awt.Point;
import java.awt.event.MouseEvent;

public class RatonClick implements EventoRaton {
	private MouseEvent me;
	public RatonClick( MouseEvent me ) {
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
		return "RatonClick: (" + getPosicion().getX() + "," + getPosicion().getY() + ")";
	}
}
