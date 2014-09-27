package pr00;

import java.awt.Point;
import pr00.utils.ventanaGrafica.ObjetoGrafico;
import pr00.utils.ventanaGrafica.ObjetoGraficoRotable;
import pr00.utils.ventanaGrafica.VentanaGrafica;

public class CocheJuego extends Coche {
	// public -global-, private -sólo aquí-, protected -en hijas-, --- en este paquete
	private boolean soyVisible;
	private long ultMomentoEnPantalla;
	private VentanaGrafica miVentana;
	private ObjetoGraficoRotable miGrafico;
	
	// ESTOS ATRIBUTOS SE HEREDAN:
	//	private int miVelocidadX;  // Velocidad en X en pixels/segundo
	//	private int miVelocidadY;  // Velocidad en Y en pixels/segundo
	//	private double miDireccionActual;  // Dirección en la que estoy mirando en grados (de 0 a 360)
	//	private double posX;  // Posición en X (horizontal)
	//	private double posY;  // Posición en Y (vertical)
	//	private String piloto;  // Nombre de piloto
	
	public CocheJuego( VentanaGrafica v ) {
		// super();  // Llamada al constructor de la clase padre
		soyVisible = false;
		miVentana = v;
		miGrafico = new ObjetoGraficoRotable( "coche.png", true, 40, 40, Math.PI/2 );
	}
	
	/** Indica si el coche se muestra o no en la ventana
	 * @param seVe	true si queremos que se vea, false en caso contrario
	 */
	public void muestra( boolean seVe ) {
		if (seVe && !soyVisible) {    //   a && a - AND    a || a - OR    ! a - NOT
			miVentana.addObjeto( miGrafico, new Point( (int)(Math.round(posX)), 
					(int)(Math.round(posY)) ) );
			orientar();
		} else if (!seVe && soyVisible) {
			miVentana.removeObjeto( miGrafico );
		}
	}
	
	private void orientar() {
		miGrafico.setRotacionGrados( 90 + miDireccionActual );
	}

	@Override
	public void mueve( double tiempoDeMovimiento ) {
		super.mueve( tiempoDeMovimiento );
		miGrafico.setLocation( new Point( (int)(Math.round(posX)), 
				(int)(Math.round(posY)) ) );
	}
	
}
