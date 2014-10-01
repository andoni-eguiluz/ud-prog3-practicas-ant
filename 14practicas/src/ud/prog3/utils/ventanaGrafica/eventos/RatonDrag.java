package ud.prog3.utils.ventanaGrafica.eventos;

import java.awt.Point;
import java.awt.event.MouseEvent;

public class RatonDrag implements EventoRaton {
	private MouseEvent meFinalDrag;
	private long timeInicioDrag;
	private Point puntoInicioDrag;
	public RatonDrag( long timeInicioDrag, Point puntoInicioDrag, MouseEvent meFinalDrag ) {
		this.meFinalDrag = meFinalDrag;
		this.timeInicioDrag = timeInicioDrag;
		this.puntoInicioDrag = puntoInicioDrag;
	}
	@Override
	public long getTime() {
		return meFinalDrag.getWhen();
	}
	/* Devuelve posición de final de drag
	 * @see utils.eventosVentanaGrafica.EventoRaton#getPosicion()
	 */
	@Override
	public Point getPosicion() {
		return meFinalDrag.getPoint();
	}
	/** Devuelve momento de inicio del drag
	 * @return	msg desde 1/1/1970 en el momento de inicio del drag
	 */
	public long getTimeIni() {
		return timeInicioDrag;
	}
	/** Devuelve posición de inicio del drag
	 * @return	punto de inicio del drag
	 */
	public Point getPosicionIni() {
		return puntoInicioDrag;
	}
	@Override
	public String toString() {
		return "RatonDrag: (" + getPosicionIni().getX() + "," + getPosicionIni().getY() + ")" 
				+ "-->(" + getPosicion().getX() + "," + getPosicion().getY() + ")";
	}	
}
