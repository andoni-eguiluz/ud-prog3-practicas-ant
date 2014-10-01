package ud.prog3.utils.ventanaGrafica.eventos;

import java.awt.Point;

/** Interfaz para eventos de ratón que se pueden producir en una ventana gráfica 
 * @author eguiluz
 */
public interface EventoRaton extends EventoVentana {
	/** Devuelve la posición en la que se ha producido el evento de ratón
	 * @return	Posición del evento
	 */
	public Point getPosicion();
}
