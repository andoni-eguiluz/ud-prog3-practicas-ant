package ud.prog3.pr0506;

/** Interfaz Java para un proceso que puede probarse (en tiempo y espacio de memoria) en el banco de pruebas.
 * @author Andoni Eguíluz Morán
 * Facultad de Ingeniería - Universidad de Deusto
 */
public interface ProcesoProbable {
	/** Método de inicialización de test (si es necesario)
	 * @param tamanyoTest	Tamaño del test a realizar
	 */
	public void init( int tamanyoTest );
	
	/** Realización de la prueba. Debe llamarse antes al método init (cuando la inicialización sea necesaria).
	 * @param tamanyoTest	Tamaño del test a realizar (típicamente, tamaño de la estructura de datos a manejar)
	 * @param objetoProducido	Objeto que se devuelve
	 */
	public void test( int tamanyoTest );
	
	/** Resultado del test. Debe llamarse antes al método #test.
	 * @return	Objeto resultado del test.
	 */
	public Object getResultado();
}
