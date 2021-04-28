package view;
import java.security.*;
import java.time.*;
import java.util.*;

import domain.Video;

//import domain.Video;

public class NewVideo {
	
	//Creamos un m�todo con la clase scanner para preguntar al usuario.

	public static String preguntarUsuario(String pregunta) {

		System.out.println("\nPor favor, dinos " + pregunta + " para tu v�deo");
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
			
			//Abrimos el try para introducir el c�digo dentro, para que el catch pueda capturar el error en caso de producirse.
			try {
	
				//Crear variables para preguntar al usuario.
					
					String url;
					String title;
					String[] tags = new String[5];
					
				//Preguntar al usuario por consola.
				//Vamos a exigir que ning�n campo quede vac�o. Para eso creamos el string de la excepci�n.
				//En cada scanner desarrollaremos un IF con la excepci�n.
					
					String excepcionVacio = "El campo no puede estar vac�o.";
		
					title = preguntarUsuario("un T�TULO");
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
					
					//Para los tags creamos un loop.
					//El loop va a tener en cuenta el n�mero de tags aceptados (ponemos 5 por ejemplo).
					//El loop tambi�n tiene en cuenta si el usuario quiere a�adir m�s tags o no.
					int i = 0;
					boolean bn = false;
					
					do {
						tags[i] = preguntarUsuario("una ETIQUETA (sin espacios)");
						System.out.print("\t�Quieres a�adir m�s etiquetas? M�ximo 5.\n\t\tS� = true.\n\t\tNo = false.\n");
						Scanner sc = new Scanner(System.in);  
						bn = sc.nextBoolean();  

					}while (i < 5 && bn == true) ;
					
					
				//Crear objeto v�deo.
					
					Video newVideo = new Video(url, title);
					
				//A�adir las tags.
					
					//tags.add(null)
				
			//Fin del bucle.
			fin=true;
			System.out.print("\nGracias, todos los datos han sido guardados.");
			System.out.println("\n\nT�tulo: " + newVideo.title + "\nURL: www.youtube.com/" + newVideo.url + "\nEtiquetas: " + Arrays.toString(tags));

			//Bloque catch
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("\n\n\tERROR!\n\t" + e.getMessage() + "\n");
			}
		}while(!fin);
		
	}
	
}

		