package view;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class pruebaHora {
	  public static void main(String[] args) { 
		
		 //Creamos la hora de registro.
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime regDateTime = LocalDateTime.now();  
			 
		//Creamos los límites de tiempo para cada estado.
			
			 LocalDateTime uploadingLimit = regDateTime.plusMinutes(1);
			 LocalDateTime verifyingLimit = regDateTime.plusMinutes(3);
			 
		//Comprobamos:
			 
			 System.out.println("Registration date is: " + dtf.format(regDateTime));
			 System.out.println("Uploading date will be until: " + dtf.format(uploadingLimit));
			 System.out.println("Verifying date will be until: " + dtf.format(verifyingLimit) + ". Video will be public after this date.");
		
		//Creamos un condicional para checar en qué intervalo estaríamos.
			 
			 String status = null;
			 //LocalDateTime check = LocalDateTime.now();
			 LocalDateTime check = LocalDateTime.of( 2021, Month.APRIL, 28, 11, 9, 48 );
			 
	            if (check.isAfter(regDateTime)
	            		&& check.isBefore(uploadingLimit)) {
	            	status = "uploading";
	            } if (check.isAfter(uploadingLimit)
	            		&& check.isBefore(verifyingLimit)) {
	            	status = "verifying";
	            } if (check.isAfter(verifyingLimit)) {
	            	status = "public";
	            }
	    
	     //Comprobamos:
	            
	            System.out.println("\nIf the time of checking is " + dtf.format(check) + " then the status of the video is " + status);
	            
	            
	            

	  }	
}