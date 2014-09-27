package pr00;

//
// Algunas anotaciones
//
// Tipos de datos:
// - void : no dato (no hace falta return)
// - lo demás: si hace falta return
// - int : dato entero desde -2^31 hasta 2^31-1 
//    NOTA: valores en binario
//     En 4 bits cuántos valores hay?
//     0000 - 0001 - 0010 - ... - 1111 
//     1 bit - 2 valores / 2 bits - 4 / 3 - 8 / 
//     n bits - 2^n bits
//    Ejemplo: con 8 bits tendríamos 2^8 = 256 valores,
//      de 0 (00000000) a 255 (11111111)
//      ¿Qué pasa si queremos representar enteros con signo? (-,+)
//      Se coge el bit de mayor peso y se utiliza como signo:
//      00000001 - pasa a ser +1
//      10000001 - pasa a ser -1
//      00000011 - +3
//      10000011 - -3
//      ¿Cuántos valores podemos representar ahora?
//       0 --7 bits--    = 2^7 = 128 valores, o sea de +0 a +127
//       1 --7 bits--    =   ...              o sea de -0 a -127
//       Pero tenemos dos ceros: +0 y -0. No hace falta. Entonces el
//       10000000 en lugar de ser -0, es -128.
//       Por eso los valores van de -128 a +127, o sea de -2^7 a 2^7-1
// RETOMANDO:
// Tipos de datos en Java:   (PRIMITIVOS)
//  - void
//  - int (entero de 32bits) / short (16) / byte (8)
//    - long (entero de 64bits) - -2^63 a +2^63-1 (Le da mucho de sí trillones)
//  - double (64bits) / float (32bits)
//  - char (carácter) - letra, número o símbolo   (8 bits-ASCII - internacional / 16 bits)
//  - boolean (falso o cierto) 
// Literales en Java:
//  - int: 234, -34, 0
//  - long: sufijo L: 234L, -34L, 0L
//  - float: 2.7, -3.4
//  - double: sufijo D: 2.7D, -3.4D
//  - char: comillas simples  'a'  'A'   'á'   '\n' '\t' '\\' 
//  - boolean: false, true

public class EstaEsMiPrimeraClaseDePrueba {

	public static void miMetodo( ) {
		//  Sacar mensaje a pantalla "Ander aprende informática"
	} 
	
	public static int sumaEnteros( int valor1, int valor2 ) {
		return valor1 + valor2;
	}
	
	public static void pruebasConversionYOperadores( Coche c ) {
		System.out.println( "Todo se puede concatenar con strings: entero "
				+ 7 + " doble " + 2.5 + " boolean " + false + " char " + '?'
				);
		System.out.println( "Los objetos se convierten a string llamando al método toString(): " +
				c );
		// Operador sobrecargado: el que se comporta de maneras distintas
		// dependiendo de sus operandos
		// Por ejemplo + es suma si opera sobre int, double, float...
		// pero es concatenación si opera sobre Strings
		
		// Cuándo hace java conversiones implícitas?
		//  -  Cuando concatena strings a String
		//  -  En operaciones aritméticas al tipo con más precisión
		System.out.println( 4D / 3 + 7.5 );   //  Preced de operadores  ()  -unario  */   +-
		//  byte a short, short a int, int a long
		//  cualquier entero a float o a double
		//  float a double
		//  SI PIERDE PRECISION NO SE HACE LA CONVERSION IMPLICITA
		// Conversión explícita: la hace el programador
		// ¿Cömo?  Tipo entre paréntesis ANTES del dato
		double d = 8.7;
		// ERROR: int i = d;
		int i = (int) d;  // trunca el valor
		System.out.println( i );
	}
	
	public static void pruebasDeCopiasDeDatos( Coche c ) {
		// Los datos primitivos se copian (DUPLICAN) al asignar o al pasar parámetros
		int i = 5;
		int j = i;
		System.out.println( "Datos: " + i + " y " + j );
		j = j + 1;
		System.out.println( "Datos: " + i + " y " + j );
		// Los objetos (NO PRIMITIVOS) no se copian. 
		// Los datos OBJETOS no guardan los atributos, guardan una REFERENCIA
		//   a un lugar de memoria donde están los atributos
		// La asignación, o el paso de parámetro, NO DUPLICA el objeto
		Coche d = c;
		System.out.println( "Coches: " + c + " /// " + d );
		d.acelera( 10 );
		System.out.println( "Coches: " + c + " /// " + d );
	}
	
	public static void main(String[] args) {
		int miDato = sumaEnteros( 2, 7 );  // DEFINICION / DECLARACION DE VARIABLE
		// UNA VARIABLE SE PUEDE ACCEDER SOLO EN ESE METODO DONDE SE DECLARA
		System.out.println( miDato );
		System.out.println( "int" );
		//   1/1/1970 00:00:00.000 - hora 0 de Java
		//   Cualquier fecha msg que han pasado desde entonces
		//   ¿Nacimiento de Cristo?
		//   Con negativos
		//   ¿Y nos cabe?
		System.out.println( Long.MAX_VALUE );
		System.out.println( 1000L*60*60*24*365*2014 );
		System.out.println( Long.MAX_VALUE / 1000 / 60 / 60 / 24 / 365 );
		System.out.println( System.currentTimeMillis() );
		System.out.println( "Valores máximos double: " + Double.MAX_VALUE + " / " + Double.MIN_VALUE );
		System.out.println( "Valores máximos float: " + Float.MAX_VALUE + " / " + Float.MIN_VALUE );
		double miDoble = 4.5D;
		miDoble = miDoble * 2;
		System.out.println( miDoble );
		char miLetra = 'A';
		System.out.println( miLetra );
		boolean miLogico = false;
		System.out.println( miLogico );
		Coche miCoche;
		miCoche = new Coche();
		miCoche.acelera( 7 );
		miCoche.gira( 2.5 );
		miCoche.acelera( -2 );
		miCoche.gira( -0.3 );
		System.out.println( miCoche );
		pruebasConversionYOperadores( miCoche );
		pruebasDeCopiasDeDatos( miCoche );
	}
	
	
	
}
