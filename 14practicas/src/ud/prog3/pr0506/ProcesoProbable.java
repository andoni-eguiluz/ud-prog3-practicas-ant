package ud.prog3.pr0506;

/** Interfaz Java para un proceso que puede probarse (en tiempo y espacio de memoria) en el banco de pruebas.
 * @author Andoni Egu�luz Mor�n
 * Facultad de Ingenier�a - Universidad de Deusto
 */
public interface ProcesoProbable {
	/** M�todo de inicializaci�n de test (si es necesario)
	 * @param tamanyoTest	Tama�o del test a realizar
	 */
	public void init( int tamanyoTest );
	
	/** Realizaci�n de la prueba. Debe llamarse antes al m�todo init (cuando la inicializaci�n sea necesaria).
	 * @param tamanyoTest	Tama�o del test a realizar (t�picamente, tama�o de la estructura de datos a manejar)
	 * @param objetoProducido	Objeto que se devuelve
	 */
	public void test( int tamanyoTest );
	
	/** Resultado del test. Debe llamarse antes al m�todo #test.
	 * @return	Objeto resultado del test.
	 */
	public Object getResultado();
}
