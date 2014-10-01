package ud.prog3.utils.ventanaGrafica.eventos;

/** Interfaz para eventos que se pueden producir en una ventana gráfica 
 * @author eguiluz
 */
public interface EventoVentana {
	/** Devuelve el momento en el que se ha producido el evento de ventana
	 * @return	Milisegundos transcurridos desde el 1/1/1970 (ver {@link System#currentTimeMillis})
	 */
	public long getTime();
}
