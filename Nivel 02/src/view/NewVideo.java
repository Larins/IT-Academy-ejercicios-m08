package view;
import java.security.*;
import java.time.*; 

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

import domain.Video;

//import domain.Video;

public class NewVideo {
	
	//Creamos un método con la clase scanner para preguntar al usuario.

	public static String preguntarUsuario(String pregunta) {

		System.out.println("\nPor favor, dinos " + pregunta + " para tu vídeo");
		String respuesta;
		Scanner entrada = new Scanner(System.in);
		entrada = new Scanner(System.in);
		respuesta = entrada.nextLine();
		return respuesta;
	}
	
	public static <Tag> void main(String[] args) {
		
		//Creamos un bucle do-while para que en caso de error nos devuelva al principio del cuestionario.
		boolean fin=false;
		do {
			fin=false;
			
			//Abrimos el try para introducir el código dentro, para que el catch pueda capturar el error en caso de producirse.
			try {
	
				//Crear variables para preguntar al usuario.
					
					String url;
					String title;
					String tags;
					
				//Preguntar al usuario por consola.
				//Vamos a exigir que ningún campo quede vacío. Para eso creamos el string de la excepción.
				//En cada scanner desarrollaremos un IF con la excepción.
					
					String excepcionVacio = "El campo no puede estar vacío.";
		
					title = preguntarUsuario("un TÍTULO");
						if (title != null) {
							title = title;
						} else {
							throw new Exception(excepcionVacio);
						}
					
					url = preguntarUsuario("una URL (palabras separadas con guiones)");
						if (url != null) {
							url = url;
						} else {
							throw new Exception(excepcionVacio);
						}
						
					tags = preguntarUsuario("unos TAGS (palabras separadas con comas");
						if (tags != null) {
							tags = tags;
						} else {
							throw new Exception(excepcionVacio);
						}
				
				 //Creamos la hora de registro.
				
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
					LocalDateTime regDateTime = LocalDateTime.now(); 

				//Creamos los límites de tiempo para cada estado.
					
					 LocalDateTime uploadingLimit = regDateTime.plusMinutes(1);
					 LocalDateTime verifyingLimit = regDateTime.plusMinutes(3);
				
				//Creamos un condicional para checar en qué intervalo estaríamos.
					 
					 String status = null;
					 
					 //La variable CHECK nos servirá para comprobar el estatus mientras programamos.
					 //Podemos crearla parametrizada en función del momento actual.
					 //También podemos crearla en una hora concreta.
					 
					 LocalDateTime check = LocalDateTime.now().plusMinutes(2);
					 //LocalDateTime check = LocalDateTime.of( 2021, Month.APRIL, 28, 11, 16, 48 );
					 
			            if (check.isAfter(regDateTime)
			            		&& check.isBefore(uploadingLimit)) {
			            	status = "uploading, hace menos de 1 minuto que se subió el vídeo";
			            } if (check.isAfter(uploadingLimit)
			            		&& check.isBefore(verifyingLimit)) {
			            	status = "verifying, hace entre 1 y 3 minutos que se subió el vídeo";
			            } if (check.isAfter(verifyingLimit)) {
			            	status = "public, hace más de 3 minutos que se subió el vídeo";
			            }
					 
				//Crear objeto vídeo.
					
					Video newVideo = new Video(url, title, tags, regDateTime, status);
				
				
			//Fin del bucle.
			fin=true;
			System.out.print("\nGracias, todos los datos han sido guardados.");
			System.out.println("\n\nTítulo: " + newVideo.title + "\nURL: www.youtube.com/" + newVideo.url + "\nEtiquetas: " + newVideo.tags + "\nFecha y hora de registro: " + dtf.format(newVideo.regDateTime) + "\nFecha y hora de comprobación (generada en línea 88-89): " + dtf.format(check) + "\nEstatus de subida: " + newVideo.status);			

			//Bloque catch
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("\n\n\tERROR!\n\t" + e.getMessage() + "\n");
			}
		}while(!fin);
		
	}

	private static void plusMinutes(int i) {
		// TODO Auto-generated method stub
		
	}
	
}

		