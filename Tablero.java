package battleship;

import java.util.Scanner;

public class Tablero 
{
	private Scanner sc;
	private int rango;
	private int[][] matriz,original;
	private int jugador;
	private int nRondas;
	private int puntos;
	
	public Tablero(Scanner sc,int jugador,int rango,int rondas)
	{
		this.sc = sc;
		this.jugador = jugador;
		this.rango = rango;
		this.matriz = new int[rango][rango];
		this.original = new int[rango][rango];
		this.nRondas = rondas;
		this.puntos = 0;
	}
	
	public void setBarcos()
	{
		for (int f=0;f<rango;f++)
			setBarco(f);
		copiarTablero();
	}
	
	public void setBarco(int fila)
	{
		int columna;
		do
		{
			System.out.println("Nuevo Barco en Fila: "+fila+" Columna:");
			columna = sc.nextInt();
			if (columna<0 || columna>=rango-1)
				System.out.println("Columna incorrecta");
		} while (columna<0 || columna>=rango-1);
		
		for (int c=0;c<2;c++)
			matriz[fila][columna+c]=8;
	}

	public void copiarTablero()
	{
		for (int f=0;f<rango;f++)
			for (int c=0;c<rango;c++)
				original[f][c]=matriz[f][c];
	}
	
	public boolean disparar()
	{
		int fila,columna;
		System.out.println("Introduzca fila y columna disparo:");
		fila = sc.nextInt();
		columna = sc.nextInt();
		if (fila<0 || fila>=rango || columna<0 || columna>=rango)
			return false;
		else
		{
			if (matriz[fila][columna]!=0)
			{
				hundirBarco(fila,columna);
				return true;
			}
			else
			{
				System.out.println("Agua");
				return false;
			}
		}
		
	}
	
	public void hundirBarco(int fila,int columna)
	{
		System.out.println("Barco hundido");
		matriz[fila][columna]=0;
		if (columna-1>0)
			matriz[fila][columna-1]=0;
		if (columna+1<rango)
			matriz[fila][columna+1]=0;
	}
	
	public void consumeRonda()
	{
		this.nRondas--;
	}
	
	public int getNRondas()
	{
		return this.nRondas;
	}
	
	public void incrementarPuntos()
	{
		this.puntos++;
	}
	
	public int getPuntos()
	{
		return this.puntos;
	}
	
	public String toString()
	{
		String resultado="";
		resultado+="Tablero original\n";
		resultado+="================\n";
	
		for (int f=0;f<rango;f++)
		{
			for (int c=0;c<rango;c++)
			  resultado +=original[f][c];
			resultado+="\n";
		}
		
		resultado+="Tablero final\n";
		resultado+="=============\n";
	
		for (int f=0;f<rango;f++)
		{
			for (int c=0;c<rango;c++)
			  resultado +=matriz[f][c];
			resultado+="\n";
		}
		return resultado;
	}
}
