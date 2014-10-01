package ud.prog3.utils.ventanaGrafica.eventos;

import java.awt.Point;

/** Interfaz para eventos de rat�n que se pueden producir en una ventana gr�fica 
 * @author eguiluz
 */
public interface EventoRaton extends EventoVentana {
	/** Devuelve la posici�n en la que se ha producido el evento de rat�n
	 * @return	Posici�n del evento
	 */
	public Point getPosicion();
}
