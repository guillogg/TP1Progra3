package juego;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.util.List;

import org.junit.Test;

import Interfaz.Interfaz.Dificultad;


public class WordleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Test
	public void darPalabraFacil()
	{
		String palabra;
		palabra = Funciones.DarPalabra(Dificultad.FACIL);
		assertEquals(5, palabra.length());
	}
	
	@Test
	public void darPalabraDificil()
	{
		String palabra;
		palabra = Funciones.DarPalabra(Dificultad.DIFICIL);
		assertEquals(7, palabra.length());
	}
	
	@Test
	public void palabrasIguales()
	{
		String palabra1 = "sistema";
		String palabra2 = palabra1;
		assertTrue(Funciones.palabraAcertada(Funciones.CompararPalabra(palabra1, palabra2)));
	}
	
	@Test
	public void palabrasNoCoinciden()
	{
		String palabra1 = "circo";
		String palabra2 = "juego";
		assertFalse(Funciones.palabraAcertada(Funciones.CompararPalabra(palabra1, palabra2)));
	}
	
	
	
}
