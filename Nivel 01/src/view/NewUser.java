package view;
import java.security.*;
import java.time.*;
import java.util.*;

import domain.User;

public class NewUser {
	
	//Creamos un método con la clase scanner para preguntar al usuario.

	public static String preguntarUsuario(String pregunta) {

		System.out.println("\nPor favor, introduce " + pregunta);
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
					
					String name;
					String surname;
					String regDate;
					
				//Preguntar al usuario por consola.
				//Vamos a exigir que ningún campo quede vacío. Para eso creamos el string de la excepción.
				//En cada scanner desarrollaremos un IF con la excepción.
					
					String excepcionVacio = "El campo no puede estar vacío.";					
					
					name = preguntarUsuario("tu NOMBRE");
						if (name != null) {
							name = name;
						} else {
							throw new Exception(excepcionVacio);
						}
						
					surname = preguntarUsuario("tu APELLIDO");
						if (surname != null) {
							surname = surname;
						} else {
							throw new Exception(excepcionVacio);
						}
						
					regDate = preguntarUsuario("la FECHA DE HOY"); //Esto se podría mejorar con un Timestamp.
						if (regDate != null) {
							regDate = regDate;
						} else {
							throw new Exception(excepcionVacio);
						}
					
				//Crear objeto usuario.
					
					User newUser = new User(name, surname, regDate);
				
			//Fin del bucle.
			fin=true;
			System.out.print("\nGracias, todos los datos han sido guardados.");
			System.out.println("\n\nNombre completo: " + newUser.name + " " + newUser.surname + "\nFecha de registro:" + newUser.regDate);

			//Bloque catch
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("\n\n\tERROR!\n\t" + e.getMessage() + "\n");
			}
		}while(!fin);
		
	}
	
}

		