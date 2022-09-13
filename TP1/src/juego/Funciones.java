package juego; 
import java.awt.Color; 
import java.io.IOException; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths; 
import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.List; 
import java.util.Random; 
 
import Interfaz.Interfaz;
import Interfaz.Interfaz.Dificultad; 
 
public class Funciones { 
 
	public static List<Color> CompararPalabra(String PalabraUsuario , String PalabraDelDia){ 
	 
		List<String> ListaDePalabra = Arrays.asList(PalabraDelDia.split("")); // 
		String [] PalabraUsuarioArray= PalabraUsuario.split(""); 
		List<Color> CoincidenciaPalabra = new ArrayList<>(); 
		for(int i=0;i<PalabraDelDia.length(); i++) { 
			if((ListaDePalabra.contains(PalabraUsuarioArray[i]))) { 
				if (ListaDePalabra.get(i).equals(PalabraUsuarioArray[i])) { 
					CoincidenciaPalabra.add(Color.GREEN); 
				} 
				else { 
					CoincidenciaPalabra.add(Color.YELLOW); 
				} 
			} 
			else { 
				CoincidenciaPalabra.add(Color.GRAY); 
			} 
    
		} 
		return CoincidenciaPalabra; 
	}  
 
 
 //Selecciona una palabra al azar, dependiendo el valor del parametro elige una palabra fácil o difícil
 	public static String DarPalabra(Dificultad dificultad) { 

 		List<String> ListaDePalabras= new ArrayList<>(); 
 		if(dificultad == Dificultad.FACIL) {
 			Path path =Paths.get("src\\Palabras\\Palabras.txt"); 
		 
 			try { 
 				ListaDePalabras = Files.readAllLines(path); 
 			} catch (IOException e) { 
 				e.printStackTrace(); 
 			} }
		 
 		else {
 			Path path =Paths.get("src\\Palabras\\PalabrasDificiles.txt"); 
		 
 			try { 
 				ListaDePalabras = Files.readAllLines(path); 
 			} catch (IOException e) { 
 				e.printStackTrace(); 
 			} 
		
 		}
 		Random random = new Random(); 
 		int posicion = random.nextInt(ListaDePalabras.size()); 
   
 		return ListaDePalabras.get(posicion).trim().toUpperCase(); 
   
 	} 
 	
 	//Método para corroborar si todas las posiciones del arreglo están en verde	
 	public static boolean palabraAcertada(List<Color> c) {
		boolean ret = true;
		for (int i=0; i<c.size(); i++) {
			ret = ret && c.get(i).equals(Color.GREEN) ;	
		}
		return ret;
				
	}
 
 
}

