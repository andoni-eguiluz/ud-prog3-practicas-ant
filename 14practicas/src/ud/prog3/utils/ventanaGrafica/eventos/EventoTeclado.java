package ud.prog3.utils.ventanaGrafica.eventos;

import java.awt.event.KeyEvent;

/** Interfaz para eventos de teclado que se pueden producir en una ventana gráfica 
 * @author eguiluz
 */
public interface EventoTeclado extends EventoVentana {
	/** Devuelve el código de la tecla
	 * @return	Código de tecla (ver {@link KeyEvent#getKeyCode()})
	 */
	public int getCodigoTecla();
	/** Devuelve el carácter de la tecla (si procede)
	 * @return	Carácter de tecla (ver {@link KeyEvent#getKeyChar()})
	 */
	public char getCarTecla();
}
