package ud.prog3.utils.ventanaGrafica;

import ud.prog3.utils.ventanaGrafica.img.Img;

import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

import javax.imageio.ImageIO;


/** Clase de objeto visible en pantalla con capacidad de escalarse
 * al tamaño que se desee
 * @author andoni
 */
public class ObjetoGrafico extends JLabel {
	// la posición X,Y se hereda de JLabel
	protected String nombreImagenObjeto; // Nombre del fichero de imagen del objeto
	protected boolean esVisible;  // Info de si el objeto va a ser visible en el panel
	protected int anchuraObjeto;  // Anchura del objeto en pixels (depende de la imagen)
	protected int alturaObjeto;  // Altura del objeto en pixels (depende de la imagen)
	
	protected int xInicioChoque;  // Recuadro de choque dentro del objeto
	protected int xFinChoque;     // Deben estar incluidas 0 <= x < ancho, 0 <= y < alto 
	protected int yInicioChoque;
	protected int yFinChoque;
	
	protected ImageIcon icono;  // icono del objeto
	protected boolean escalado;  // escalado del icono
	protected BufferedImage imagenObjeto;  // imagen para el escalado
	private static final long serialVersionUID = 1L;  // para serializar

	/** Crea un nuevo objeto gráfico de ventana para juegos.<br>
	 * Si no existe el fichero de imagen, se crea un rectángulo blanco con borde rojo
	 * @param nombreImagenObjeto	Nombre fichero donde está la imagen del objeto (carpeta utils/img)
	 * @param visible	true si se quiere ver, false si se quiere tener oculto
	 * @param anchura	Anchura del objeto en píxels
	 * @param altura	Altura del objeto en píxels
	 */
	public ObjetoGrafico( String nombreImagenObjeto, boolean visible, int anchura, int altura ) {
		setName( nombreImagenObjeto );
		anchuraObjeto = anchura;
		alturaObjeto = altura;
		// Cargamos el icono (como un recurso - vale tb del .jar)
		this.nombreImagenObjeto = nombreImagenObjeto;
        URL imgURL = Img.getURLRecurso(nombreImagenObjeto);
        if (imgURL == null) {
        	icono = null;
    		setOpaque( true );
    		setBackground( Color.red );
    		setForeground( Color.blue );
        	setBorder( BorderFactory.createLineBorder( Color.blue ));
        	setText( nombreImagenObjeto );
        } else {
        	icono = new ImageIcon(imgURL);
    		setIcon( icono );
        	if (anchura==icono.getIconWidth() && altura==icono.getIconHeight()) {
        		escalado = false;
        	} else {  // Hay escalado: prepararlo
        		escalado = true;
            	try {  // pone la imagen para el escalado
        			imagenObjeto = ImageIO.read(imgURL);
        		} catch (IOException e) {
        			escalado = false;
        		}
        	}
        }
    	setSize( anchura, altura );
		this.xInicioChoque = 0;
		this.xFinChoque = anchura; 
		this.yInicioChoque = 0;
		this.yFinChoque = altura;
		esVisible = visible;
		setVisible( esVisible );
	}
	
	/** Crea un nuevo objeto gráfico de ventana para juegos.<br>
	 * Si no existe el fichero de imagen, se crea un rectángulo blanco con borde rojo de 10x10 píxels<br>
	 * Si existe, se toma la anchura y la altura de esa imagen.
	 * @param nombreImagenObjeto	Nombre fichero donde está la imagen del objeto (carpeta utils/img)
	 * @param visible	Panel en el que se debe dibujar el objeto
	 */
	public ObjetoGrafico( String nombreImagenObjeto, boolean visible ) {
		this( nombreImagenObjeto, visible, 10, 10 );
		if (icono != null) {  // En este constructor se adapta la anchura y altura al icono
			anchuraObjeto = icono.getIconWidth();
			alturaObjeto = icono.getIconHeight();
			setSize( anchuraObjeto, alturaObjeto );
			this.xFinChoque = anchuraObjeto; 
			this.yFinChoque = alturaObjeto;
		}
	}

	/** Crea un nuevo objeto gráfico de ventana para juegos.<br>
	 * Si la URL de imagen es null, se crea un rectángulo blanco con borde rojo
	 * @param urlImagenObjeto	URL donde está la imagen del objeto
	 * @param visible	true si se quiere ver, false si se quiere tener oculto
	 * @param anchura	Anchura del objeto en píxels
	 * @param altura	Altura del objeto en píxels
	 */
	public ObjetoGrafico( java.net.URL urlImagenObjeto, boolean visible, int anchura, int altura ) {
		if (urlImagenObjeto!=null) setName( urlImagenObjeto.getQuery());
		anchuraObjeto = anchura;
		alturaObjeto = altura;
		nombreImagenObjeto = "";
        if (urlImagenObjeto == null) {
        	icono = null;
    		setOpaque( true );
    		setBackground( Color.red );
    		setForeground( Color.blue );
        	setBorder( BorderFactory.createLineBorder( Color.blue ));
        	setText( nombreImagenObjeto );
        } else {
        	icono = new ImageIcon(urlImagenObjeto);
    		setIcon( icono );
        	if (anchura==icono.getIconWidth() && altura==icono.getIconHeight()) {
        		escalado = false;
        	} else {  // Hay escalado: prepararlo
        		escalado = true;
            	try {  // pone la imagen para el escalado
        			imagenObjeto = ImageIO.read(urlImagenObjeto);
        		} catch (IOException e) {
        			escalado = false;
        		}
        	}
        }
    	setSize( anchura, altura );
		this.xInicioChoque = 0;
		this.xFinChoque = anchura; 
		this.yInicioChoque = 0;
		this.yFinChoque = altura;
		esVisible = visible;
		setVisible( esVisible );
	}
	
	/** Crea un nuevo objeto gráfico de ventana para juegos.<br>
	 * Si no existe el fichero de imagen, se crea un rectángulo blanco con borde rojo de 10x10 píxels<br>
	 * Si existe, se toma la anchura y la altura de esa imagen.
	 * @param urlImagenObjeto	URL donde está la imagen del objeto
	 * @param visible	Panel en el que se debe dibujar el objeto
	 */
	public ObjetoGrafico( java.net.URL urlImagenObjeto, boolean visible ) {
		this( urlImagenObjeto, visible, 10, 10 );
		if (icono != null) {  // En este constructor se adapta la anchura y altura al icono
			anchuraObjeto = icono.getIconWidth();
			alturaObjeto = icono.getIconHeight();
			setSize( anchuraObjeto, alturaObjeto );
			this.xFinChoque = anchuraObjeto; 
			this.yFinChoque = alturaObjeto;
		}
	}
	
	/** Activa o desactiva la visualización del objeto 
	 * @param visible	true si se quiere ver, false si se quiere tener oculto
	 */
	public void setVisible( boolean visible ) {
		super.setVisible( visible );
		esVisible = visible;
	}

	/** Devuelve la anchura del rectángulo gráfico del objeto
	 * @return	Anchura
	 */
	public int getAnchuraObjeto() {
		return anchuraObjeto;
	}
	
	/** Devuelve la altura del rectángulo gráfico del objeto
	 * @return	Altura
	 */
	public int getAlturaObjeto() {
		return alturaObjeto;
	}

	/** Devuelve el rectángulo de choque interno del objeto gráfico
	 * @return	rectángulo de choque. Si no está definido, es el objeto completo:
	 * (0,0,anchura,altura)
	 */
	public Rectangle getRectanguloInternoChoque() {
		return new Rectangle( xInicioChoque, yInicioChoque, xFinChoque, yFinChoque );
	}
	
	/** Pone el espacio del objeto gráfico que detecta los choques (por omisión es todo el objeto).<br>
	 * Deben estar dentro del objeto: 0 <= x <= ancho, 0 <= y <= alto
	 * xInicio < xFin, yInicio < yFin
	 * @param xInicioChoque
	 * @param yInicioChoque
	 * @param xFinChoque
	 * @param yFinChoque
	 */
	public void setRectanguloDeChoque( int xInicioChoque, int yInicioChoque, int xFinChoque, int yFinChoque ) {
		this.xInicioChoque = xInicioChoque;
		this.xFinChoque = xFinChoque; 
		this.yInicioChoque = yInicioChoque;
		this.yFinChoque = yFinChoque;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.Component#contains(java.awt.Point)
	 */
	@Override
	public boolean contains(Point p) {
		if (p==null) return false;
		return (p.getX()>=getX() && p.getX()<getX()+getWidth() &&
				p.getY()>=getY() && p.getY()<getY()+getHeight());
	}

	/** Comprueba si el objeto choca contra otro con un margen de diferencia
	 * @param o2	Objeto de comprobación
	 * @param margenPixels	Margen de pixels para el choque
	 * @return	true si chocan, false en caso contrario
	 */
	public boolean chocaCon( ObjetoGrafico o2, int margenPixels ) {
		boolean choca = !(getX()+xInicioChoque+margenPixels >= o2.getX()+o2.xFinChoque ||
				getX()+xFinChoque-margenPixels <= o2.getX()+o2.xInicioChoque ||
				getY()+yInicioChoque+margenPixels >= o2.getY()+o2.yFinChoque ||
				getY()+yFinChoque -margenPixels <= o2.getY()+o2.yInicioChoque);
		return choca;
	}	

	/** Comprueba si el objeto choca contra otro con un margen de diferencia
	 * @param o2	Objeto de comprobación
	 * @param margenPixels	Margen de pixels para el choque
	 * @return	0 si no chocan, +1 si choca arriba, +2 arriba a la derecha, +3 derecha, +4 abajo derecha,
	 * +5 abajo, +6 abajo izquierda, +7 izquierda, +8 izquierda arriba, +9 uno está dentro del otro
	 */
	public int comoChocaCon( ObjetoGrafico o2, int margenPixels ) {
		boolean montaIzq = (getX()+xInicioChoque+margenPixels < o2.getX()+o2.xFinChoque) && (getX()+xFinChoque-margenPixels > o2.getX()+o2.xFinChoque);
		boolean montaDer = (getX()+xFinChoque-margenPixels > o2.getX()+o2.xInicioChoque) && (getX()+xInicioChoque+margenPixels < o2.getX()+o2.xInicioChoque);
		boolean montaArr = (getY()+yInicioChoque+margenPixels < o2.getY()+o2.yFinChoque) && (getY()+yFinChoque-margenPixels > o2.getY()+o2.yFinChoque);
		boolean montaAba = (getY()+yFinChoque -margenPixels > o2.getY()+o2.yInicioChoque) && (getY()+yInicioChoque+margenPixels < o2.getY()+o2.yInicioChoque);
		int pxMontaIzq = o2.getX()+o2.xFinChoque - getX()-xInicioChoque;
		int pxMontaDer = getX()+xFinChoque - o2.getX()-o2.xInicioChoque;
		int pxMontaArr = o2.getY()+o2.yFinChoque - getY()-yInicioChoque;
		int pxMontaAba = getY()+yFinChoque - o2.getY()-o2.yInicioChoque;
		// int tipoChoque = (montaDer && (montaArr || montaAba)) ? +1 : 0;
		// tipoChoque += (montaIzq && (montaArr || montaAba)) ? +2 : 0;
		// tipoChoque += (montaArr && (montaIzq || montaDer)) ? +4 : 0;
		// tipoChoque += (montaAba && (montaIzq || montaDer)) ? +8 : 0;
		int sitHor;
		if (pxMontaIzq <= margenPixels) sitHor = -2; // izquierda
		else if (pxMontaDer <= margenPixels) sitHor = +2; // derecha
		else if (montaIzq && montaDer) sitHor = 0; // engloba al otro 
		else if (montaIzq) sitHor = -1; // choque izquierda
		else if (montaDer) sitHor = +1; // choque derecha
		else sitHor = 99; // dentro del otro
		int sitVer;
		if (pxMontaArr <= margenPixels) sitVer = -2; // arriba
		else if (pxMontaAba <= margenPixels) sitVer = +2; // abajo
		else if (montaArr && montaAba) sitVer = 0; // engloba al otro 
		else if (montaArr) sitVer = -1; // choque arriba
		else if (montaAba) sitVer = +1; // choque abajo
		else sitVer = 99; // dentro del otro
		int tipoChoque = 0;
		if (sitVer == -1) {
			if (sitHor == 0 || sitHor == 99) {
				tipoChoque = 1; // arriba
			} else if (sitHor == -1 && pxMontaArr < pxMontaIzq) {
				tipoChoque = 1; // arriba un poco a la izquierda
			} else if (sitHor == -1 && pxMontaArr == pxMontaIzq) {
				tipoChoque = 8; // arriba y a la izquierda igual
			} else if (sitHor == -1) {
				tipoChoque = 7; // izquierda más que arriba
			} else if (sitHor == +1 && pxMontaArr < pxMontaDer) {
				tipoChoque = 1; // arriba un poco a la derecha
			} else if (sitHor == +1 && pxMontaArr == pxMontaDer) {
				tipoChoque = 2; // arriba y a la derecha igual
			} else if (sitHor == +1) {
				tipoChoque = 3; // derecha más que arriba
			} // Si no está fuera  (sitHor == +2 o -2)
		} else if (sitVer == +1) {
			if (sitHor == 0 || sitHor == 99) {
				tipoChoque = 5; // abajo
			} else if (sitHor == -1 && pxMontaAba < pxMontaIzq) {
				tipoChoque = 5; // abajo un poco a la izquierda
			} else if (sitHor == -1 && pxMontaAba == pxMontaIzq) {
				tipoChoque = 6; // abajo y a la izquierda igual
			} else if (sitHor == -1) {
				tipoChoque = 7; // izquierda más que abajo
			} else if (sitHor == +1 && pxMontaAba < pxMontaDer) {
				tipoChoque = 5; // abajo un poco a la derecha
			} else if (sitHor == +1 && pxMontaAba == pxMontaDer) {
				tipoChoque = 4; // abajo y a la derecha igual
			} else if (sitHor == +1) {
				tipoChoque = 3; // derecha más que abajo
			} // Si no está fuera  (sitHor == +2 o -2)
		} else if (sitVer == 0 || sitVer == 99) {
			if (sitHor == 0 || sitHor == 99) {
				tipoChoque = 99; // dentro
			} else if (sitHor == -1) {
				tipoChoque = 7; // izquierda
			} else if (sitHor == +1) {
				tipoChoque = 3; // derecha
			} // Si no está fuera  (sitHor == +2 o -2)
		}
		// System.out.println( montaIzq + "|" + montaDer + "|" + montaArr + "|" + montaAba + " ## " + 
		// pxMontaIzq + "|" + pxMontaDer + "|" + pxMontaArr + "|" + pxMontaAba + " --> " + tipoChoque );
		return tipoChoque;
	}	

	// Permite cambiar el icono mientras el objeto está en pantalla
	/* (non-Javadoc)
	 * @see javax.swing.JLabel#setIcon(javax.swing.Icon)
	 */
	@Override
	public void setIcon(Icon icon) {
        if (icono == null) {
    		super.setIcon(icon);
        } else if (icon != null && icon instanceof ImageIcon){
        	icono = (ImageIcon) icon;
    		super.setIcon( icono );
        	if (escalado) { // Hay escalado: preparar el dibujado
            	try {  // pone la imagen para el escalado
            		Image source = icono.getImage();
            		int w = source.getWidth(null);
            		int h = source.getHeight(null);
            		imagenObjeto = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            		Graphics2D g2d = (Graphics2D)imagenObjeto.getGraphics();
            		g2d.drawImage(source, 0, 0, null);
            		g2d.dispose();
        		} catch (Exception e) {
        			System.err.println( "Error en cambio de imagen" );
        		}
        	}
        }
	}

	// Dibuja este componente de una forma no habitual (si es proporcional)
	@Override
	protected void paintComponent(Graphics g) {
		if (escalado) {
			Graphics2D g2 = (Graphics2D) g;  // El Graphics realmente es Graphics2D
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);	
	        g2.drawImage(imagenObjeto, 0, 0, anchuraObjeto, alturaObjeto, null);
        } else {  // sin escalado
			super.paintComponent(g);
		}
	}

	
}

