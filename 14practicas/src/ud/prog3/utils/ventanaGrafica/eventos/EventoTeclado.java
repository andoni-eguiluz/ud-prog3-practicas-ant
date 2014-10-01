package ud.prog3.utils.ventanaGrafica.eventos;

import java.awt.event.KeyEvent;

/** Interfaz para eventos de teclado que se pueden producir en una ventana gr�fica 
 * @author eguiluz
 */
public interface EventoTeclado extends EventoVentana {
	/** Devuelve el c�digo de la tecla
	 * @return	C�digo de tecla (ver {@link KeyEvent#getKeyCode()})
	 */
	public int getCodigoTecla();
	/** Devuelve el car�cter de la tecla (si procede)
	 * @return	Car�cter de tecla (ver {@link KeyEvent#getKeyChar()})
	 */
	public char getCarTecla();
}
