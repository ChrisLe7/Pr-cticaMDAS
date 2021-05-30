package es.uco.mdas.tests;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {

	static int contador = 0;
	static Timer temporizador = null;
	
	public static void main(String[] args) {
		
		System.out.println("TestTimer");
		
		Calendar hoy = Calendar.getInstance();

		temporizador = new Timer();
		TimerTask tarea = new TimerTask() {
			public void run() {
				System.out.println("Ejecuccion");
				System.out.println(contador);
				contador++;
				
				if (contador == 5) {
					Terminar();
				}
			}
		};
		
		temporizador.schedule(tarea, hoy.getTime(), 1000 * 2); 
		
	}
	
	public static void Terminar() {
		System.out.println("Finalizando");
		temporizador.cancel();
	}
	
}
