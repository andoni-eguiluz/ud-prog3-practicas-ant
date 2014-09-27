package pr00;

import pr00.utils.ventanaGrafica.*;

public class PruebaCoches {

	private static VentanaGrafica miVentana;
	private static CocheJuego coche1;
	private static CocheJuego coche2;
	
	// Inicializa los coches
	private static void inicializar() {
		miVentana = new VentanaGrafica( 1000, 600, true, true, false, "Juego Coches" );
		miVentana.setFondo( new ObjetoGrafico( "circuito1.jpg", true ) );
		coche1 = new CocheJuego( miVentana );
		coche1.setMiVelocidadX( 5 );
		coche1.setMiVelocidadY( 5 );
		coche1.setPiloto( "Robin" );
		System.out.println( "El coche empieza: " + coche1 );
		coche1.muestra( true );

		coche2 = new CocheJuego( miVentana );
		coche2.setMiVelocidadX( -2 );
		coche2.setMiVelocidadY( -7 );
		coche2.setPiloto( "Richard" );
		System.out.println( "El coche empieza: " + coche2 );
		coche2.muestra( true );
	}
	
	// Hace que corran los coches
	private static void correr() {
		miVentana.esperaUnRato( 5000 );
		int miTiempo = 0;
		while (miTiempo < 50) {
			coche1.mueve( 1 );
			coche2.mueve( 1 );
			System.out.println( "  " + coche1 );
			System.out.println( "  " + coche2 );
			miTiempo++;  //  miTiempo = miTiempo + 1;
			miVentana.esperaUnRato( 60 );
		}
	}
	
	// Muestra los coches al final
	private static void acabar() {
		miVentana.esperaUnRato( 10000 );
		miVentana.dispose();
	}
	
	public static void main(String[] args) {
		// Pruebas trigonométricas
		/*
		System.out.println( Math.sin( 30.0 / 180 * Math.PI ));
		System.out.println( Math.sin( 45.0 / 180 * Math.PI ));  // raiz de 2 / 2
		System.out.println( Math.sin( 60.0 / 180 * Math.PI ));
		*/
		
		inicializar();
		correr();
		acabar();
	}

}
