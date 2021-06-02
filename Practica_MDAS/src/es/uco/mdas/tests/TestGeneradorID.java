package es.uco.mdas.tests;

import java.util.Random;

public class TestGeneradorID {

	public static void main(String[] args) {
		
		System.out.println("TestAbonoDAO");

		Random generador = new Random();

		for (int i = 0; i < 10; i++) {
			System.out.println(generador.nextInt(10000));
		}
		
		System.out.println("Exito");
		
	}
	
}
