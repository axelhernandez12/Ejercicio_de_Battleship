package battleship;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		
		Scanner sc = new Scanner(System.in);
		Tablero[] tablero = new Tablero[2];
		boolean finJuego = false;
		int jugadorActual=0;
		
		// Crear los tableros y ubicar los barcos
		for (int i=0;i<2;i++)
		{
			System.out.println("Ubicación barcos jugador "+i);
			tablero[i] = new Tablero(sc,i,8,10); // Rango y rondas
			tablero[i].setBarcos();
		}
		
		do
		{
			if (tablero[jugadorActual].getNRondas()!=0)
			{
				System.out.println("Turno jugador "+jugadorActual);
				if (tablero[1-jugadorActual].disparar()==false)
					tablero[jugadorActual].consumeRonda();
				else
					tablero[jugadorActual].incrementarPuntos();
			}
			jugadorActual=1-jugadorActual;
			if (tablero[0].getNRondas()==0 && tablero[1].getNRondas()==0)
				finJuego=true;
		} while (!finJuego);
		
		if (tablero[0].getPuntos()==tablero[1].getPuntos())
			System.out.println("Empate");
		else
			if (tablero[0].getPuntos()>tablero[1].getPuntos())
				System.out.println("Gana el jugador 0");
			else
				System.out.println("Gana el jugador 1");
		
		System.out.println("Jugador 0");
		System.out.println(tablero[0]);
		System.out.println("Jugador 1");
		System.out.println(tablero[1]);
		
		sc.close();
	}
}