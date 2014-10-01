package ud.prog3.utils.ventanaGrafica;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/** Clase de objeto visible en pantalla en juego
 * con capacidad de escalarse y rotar
 * @author eguiluz
 *
 */
public class ObjetoGraficoRotable extends ObjetoGrafico {
	protected double radsRotacion = 0;  // 0 = no rotaci�n. PI = media vuelta
	private static final long serialVersionUID = 1L;  // Para serializaci�n
	
	/** Crea un nuevo objeto gr�fico de ventana para juegos.<br>
	 * Si no existe el fichero de imagen, se crea un rect�ngulo blanco con borde rojo
	 * @param nombreImagenObjeto	Nombre fichero donde est� la imagen del objeto (carpeta utils/img)
	 * @param visible	true si se quiere ver, false si se quiere tener oculto
	 * @param anchura	Anchura del objeto en p�xels
	 * @param altura	Altura del objeto en p�xels
	 * @param rotacion	Rotaci�n en radianes (0=sin rotaci�n, 2PI=vuelta completa. Sentido horario)
	 */
	public ObjetoGraficoRotable( String nombreImagenObjeto, boolean visible, int anchura, int altura, double rotacion ) {
		super( nombreImagenObjeto, visible, anchura, altura );
		radsRotacion = rotacion;
	}
	
	/** Crea un nuevo objeto gr�fico de ventana para juegos.<br>
	 * Si no existe el fichero de imagen, se crea un rect�ngulo blanco con borde rojo de 10x10 p�xels<br>
	 * Si existe, se toma la anchura y la altura de esa imagen.
	 * @param nombreImagenObjeto	Nombre fichero donde est� la imagen del objeto (carpeta utils/img)
	 * @param visible	Panel en el que se debe dibujar el objeto
	 * @param rotacion	Rotaci�n en radianes (0=sin rotaci�n, 2PI=vuelta completa. Sentido horario)
	 */
	public ObjetoGraficoRotable( String nombreImagenObjeto, boolean visible, double rotacion ) {
		super( nombreImagenObjeto, visible );
		radsRotacion = rotacion;
	}

	/** Crea un nuevo objeto gr�fico de ventana para juegos.<br>
	 * Si la URL de imagen es null, se crea un rect�ngulo blanco con borde rojo
	 * @param urlImagenObjeto	URL donde est� la imagen del objeto
	 * @param visible	true si se quiere ver, false si se quiere tener oculto
	 * @param anchura	Anchura del objeto en p�xels
	 * @param altura	Altura del objeto en p�xels
	 * @param rotacion	Rotaci�n en radianes (0=sin rotaci�n, 2PI=vuelta completa. Sentido horario)
	 */
	public ObjetoGraficoRotable( java.net.URL urlImagenObjeto, boolean visible, int anchura, int altura, double rotacion ) {
		super( urlImagenObjeto, visible, anchura, altura );
		radsRotacion = rotacion;
	}
	
	/** Crea un nuevo objeto gr�fico de ventana para juegos.<br>
	 * Si no existe el fichero de imagen, se crea un rect�ngulo blanco con borde rojo de 10x10 p�xels<br>
	 * Si existe, se toma la anchura y la altura de esa imagen.
	 * @param urlImagenObjeto	URL donde est� la imagen del objeto
	 * @param visible	Panel en el que se debe dibujar el objeto
	 * @param rotacion	Rotaci�n en radianes (0=sin rotaci�n, 2PI=vuelta completa. Sentido horario)
	 */
	public ObjetoGraficoRotable( java.net.URL urlImagenObjeto, boolean visible, double rotacion ) {
		super( urlImagenObjeto, visible );
		radsRotacion = rotacion;
	}

	/** Cambia la rotaci�n a los radianes indicados
	 * @param rotacion	Rotaci�n en radianes (0=sin rotaci�n, 2PI=vuelta completa. Sentido horario)
	 */
	public void setRotacion( double rotacion ) {
		radsRotacion = rotacion;
		repaint();
	}
	
	/** Cambia la rotaci�n con el incremento en radianes indicado
	 * @param rotacion	Incremento de rotaci�n en radianes (0=sin incremento, 2PI=vuelta completa. Sentido horario)
	 */
	public void incRotacion( double rotacion ) {
		radsRotacion += rotacion;
		if (radsRotacion > 2*Math.PI) radsRotacion -= (2 * Math.PI);
		repaint();
	}
	
	/** Devuelve la rotaci�n actual
	 * @return	Rotaci�n actual en radianes (0=sin rotaci�n, 2PI=vuelta completa. Sentido horario)
	 */
	public double getRotacion() {
		return radsRotacion;
	}
	
	/** Cambia la rotaci�n a los grados indicados
	 * @param rotacion	Rotaci�n en grados (0=sin rotaci�n, 360=vuelta completa. Sentido horario)
	 */
	public void setRotacionGrados( double rotacion ) {
		radsRotacion = rotacion / 180 * Math.PI;
		repaint();
	}
	
	/** Devuelve la rotaci�n actual
	 * @return	Rotaci�n actual en grados (0=sin rotaci�n, 360=vuelta completa. Sentido horario)
	 */
	public double getRotacionGrados() {
		return radsRotacion / Math.PI * 180;
	}
	
	// Dibuja este componente de una forma no habitual (si es proporcional)
	@Override
	protected void paintComponent(Graphics g) {
		if (escalado) {
			Graphics2D g2 = (Graphics2D) g;  // El Graphics realmente es Graphics2D
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
            g2.rotate( radsRotacion, anchuraObjeto/2, alturaObjeto/2 );
	        g2.drawImage(imagenObjeto, 0, 0, anchuraObjeto, alturaObjeto, null);
	        // Si se quieren dibujar los rect�ngulos interior y exterior:
			// setBorder( BorderFactory.createLineBorder( Color.red ));
	        // g2.setColor( Color.white );
	        // g2.setStroke(new BasicStroke(3));
	        // g2.drawRect( xInicioChoque, yInicioChoque, xFinChoque-xInicioChoque, yFinChoque-yInicioChoque );
        } else {  // sin escalado
			Graphics2D g2 = (Graphics2D) g;  // El Graphics realmente es Graphics2D
            g2.rotate( radsRotacion, anchuraObjeto/2, alturaObjeto/2 );
	        g2.drawImage(imagenObjeto, 0, 0, anchuraObjeto, alturaObjeto, null);
	        // Si se quieren dibujar los rect�ngulos interior y exterior:
			// setBorder( BorderFactory.createLineBorder( Color.red ));
	        // g2.setColor( Color.white );
	        // g2.setStroke(new BasicStroke(3));
	        // g2.drawRect( xInicioChoque, yInicioChoque, xFinChoque-xInicioChoque, yFinChoque-yInicioChoque );
		}
	}
	
}
