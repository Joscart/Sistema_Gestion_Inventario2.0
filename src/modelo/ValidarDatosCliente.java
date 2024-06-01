package modelo;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidarDatosCliente {
	
	 public static boolean validarNombre(String nombre) {
	        String regex = "^[a-zA-Z\\s]+$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(nombre);
	        return matcher.matches();
	    }

	    public static boolean validarDireccion(String direccion) {
	        String regex = "^[a-zA-Z0-9\\s,.-]+$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(direccion);
	        return direccion.matches(direccion);
	    }
	 
	    public static boolean validarDNI(String dni) {
			String regex = "^[0-2][0-9]{8}[-]?[0-9]$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(dni);
	        return matcher.matches();
		} 	 
	    
	    public static boolean ValidarEmail(String email) {
	        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	        Pattern pattern = Pattern.compile(emailRegex);
	        return pattern.matcher(email).matches();
	    }

	    public static boolean ValidarTelefono(String phone) {
	        String phoneRegex = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";
	        Pattern pattern = Pattern.compile(phoneRegex);
	        return pattern.matcher(phone).matches();
	    }
	    
	    
}

