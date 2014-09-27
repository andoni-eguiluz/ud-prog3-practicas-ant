package ud.prog3.pr02;

/** Clase para definir instancias de coches con sus datos lógicos y una representación
 * visual asociada lista para incluir en un panel de Swing.
 * Según se mueva el coche, su representación (JLabel) se moverá en consonancia.
 * @author Andoni Eguíluz
 * Facultad de Ingeniería - Universidad de Deusto (2014)
 */
public class CocheJuego extends Coche {
	private JLabelCoche miGrafico;  // Etiqueta gráfica del coche
	
	/**  Crea un nuevo coche de juego
	 */
	public CocheJuego() {
		miGrafico = new JLabelCoche();
	}
	
	/** Devuelve el JLabel gráfico asociado al coche de juego
	 * @return	Etiqueta gráfica del coche
	 */
	public JLabelCoche getGrafico() {
		return miGrafico;
	}

	@Override
	public void setPosX(double posX) {
		super.setPosX(posX);
		miGrafico.setLocation( (int)posX, (int)posY );
		// miGrafico.repaint();  // Al cambiar la location, Swing redibuja automáticamente
	}

	@Override
	public void setPosY(double posY) {
		super.setPosY(posY);
		miGrafico.setLocation( (int)posX, (int)posY );
		// miGrafico.repaint();  // Al cambiar la location, Swing redibuja automáticamente
	}

	@Override
	public void setDireccionActual( double dir ) {
		super.setDireccionActual(dir);
		miGrafico.setGiro( miDireccionActual );
		miGrafico.repaint();  // Necesario porque Swing no redibuja al cambiar el giro (no pasa nada en el JLabel)
	}

}
