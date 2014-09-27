package pr00;

public class Coche {
	// Atributos (datos)
	private int miVelocidadX;  // Velocidad en X en pixels/segundo
	private int miVelocidadY;  // Velocidad en Y en pixels/segundo
	protected double miDireccionActual;  // Dirección en la que estoy mirando en grados (de 0 a 360)
	protected double posX;  // Posición en X (horizontal)
	protected double posY;  // Posición en Y (vertical)
	private String piloto;  // Nombre de piloto
	
	// Constructores
	
	public Coche() {
		miVelocidadX = 0;
		miVelocidadY = 0;
		miDireccionActual = 0;
		posX = 300;
		posY = 300;
	}
	
	
	// Métodos trigonométricos
	private double calculaDireccion() {
		// Expresiones lógicas de comparación:
		//   >     <     ==     >=    <=    !=    
		if (miVelocidadX >= 0) {
			return Math.atan( 1.0 * miVelocidadY / miVelocidadX ) / Math.PI * 180;
		} else {
			return 180.0 - (Math.atan( 1.0 * miVelocidadY / -miVelocidadX ) / Math.PI * 180);
		}
	}
	
	// Métodos   SET - los que modifican    GET - los que consultan
	// getters y setters

	
	
	public int getMiVelocidadX() {
		return miVelocidadX;
	}

	public void setMiVelocidadX(int miVelocidadX) {
		this.miVelocidadX = miVelocidadX;
		miDireccionActual = calculaDireccion();
	}


	public int getMiVelocidadY() {
		return miVelocidadY;
	}


	public void setMiVelocidadY(int miVelocidadY) {
		this.miVelocidadY = miVelocidadY;
		miDireccionActual = calculaDireccion();
	}

	public double getMiDireccionActual() {
		return miDireccionActual;
	}

	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}
	
	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}


	/** Cambia la velocidad actual del coche
	 * @param aceleracion	Incremento de la velocidad en pixels/segundo, tanto en X como en Y
	 */
	public void acelera( int aceleracion ) {
		miVelocidadX = miVelocidadX + aceleracion;
		miVelocidadY = miVelocidadY + aceleracion;
	}
	

	/** Cambia la dirección actual del coche
	 * @param giro	Angulo de giro a sumar o restar de la dirección actual, en grados (-180 a +180)
	 */
	public void gira( double giro ) {
		miDireccionActual = miDireccionActual + giro;
	}
	
	/** Cambia la posición del coche dependiendo de su velocidad y dirección
	 * @param tiempoDeMovimiento	Tiempo del movimiento, en segundos
	 */
	public void mueve( double tiempoDeMovimiento ) {
		posX = posX + miVelocidadX * tiempoDeMovimiento;
		posY = posY + miVelocidadY * tiempoDeMovimiento;
	}
	
	public String toString() {
		return piloto + " (" + posX + "," + posY + ") - " +
			   "Velocidad X: " + miVelocidadX + " Y: " +
			   miVelocidadY + " ## Dirección: " + miDireccionActual; 
	}
}
