package ud.prog3.pr0506;

/** Clase b�sica para realizar pruebas de eficiencia de memoria y tiempo de ejecuci�n de c�digo.
 * @author Andoni Egu�luz Mor�n
 * Facultad de Ingenier�a - Universidad de Deusto
 */
public class BancoDePruebas {
	private static long ultimoTiempo;
	
	/** Realiza un test del banco de pruebas, inicializ�ndolo previamente y devolviendo el tiempo que tarda
	 * @param proc	Proceso a probar
	 * @param tamanyoPrueba	Tama�o a pasar a ese proceso (t�picamente, tama�o de la estructura que ese proceso maneja)
	 * @return	Tiempo que tarda el proceso (en milisegundos)
	 */
	public static long realizaTest( ProcesoProbable proc, int tamanyoPrueba ) {
		proc.init( tamanyoPrueba );
		ultimoTiempo = System.currentTimeMillis();
		proc.test( tamanyoPrueba );
		return System.currentTimeMillis() - ultimoTiempo;
	}
	
	/** Devuelve el tama�o del objeto creado por el test ya realizado del banco de pruebas.<p>
	 * Previamente debe llamarse a millisTest para que el proceso se realice y retorne ese objeto resultado.
	 * @param proc
	 * @return
	 */
	public static int getTamanyoTest( ProcesoProbable proc ) {
		return ExploradorObjetos.getTamanyoObjeto( proc.getResultado() );
	}
	
		// Clase de prueba del banco de pruebas
		// Prueba a recorrer un array completo de enteros en un sentido y en otro y calcula y visualiza su suma  (ver m�todo test)
		private static class RecorridoArray implements ProcesoProbable {
			int[] arrayPrueba;
			@Override
			public void init(int tamanyoTest) {
				arrayPrueba = new int[tamanyoTest];
			}
			@Override
			public void test(int tamanyoTest) {
				int suma = 0;
				if (arrayPrueba.length<tamanyoTest) throw new NullPointerException( "Error en test no inicializado" );  // Proceso no puede realizarse
				// Recorrido arriba
				for (int i=0; i<tamanyoTest; i++) {
					suma += arrayPrueba[i];
				}
				// Recorrido abajo
				for (int i=tamanyoTest-1; i>=0; i--) {
					suma += arrayPrueba[i];
				}
				System.out.println( "Proceso de prueba <RecorridoArray>. Suma " + suma );
			}
			@Override
			public Object getResultado() {
				return arrayPrueba;
			}
		}
		
	public static void main(String[] args) {
		ProcesoProbable proc = new RecorridoArray();
		// Realiza la prueba para 10, 100, 1000... hasta 1000000.
		int tamanyo = 10;
		while (tamanyo <= 1000000) {
			long tiempo = realizaTest( proc, tamanyo );
			int espacio = getTamanyoTest( proc );
			System.out.println( "Prueba array de " + tamanyo + " -- tiempo: " + tiempo + " msgs. / espacio = " + espacio + " bytes.");
			tamanyo *= 10;
		}
	}

}