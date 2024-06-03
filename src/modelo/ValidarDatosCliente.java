package modelo;

public class ValidarDatosCliente implements Parametrizable{

	public static boolean validarNombre(String nombre) {
		return nombre.matches(ERNOMBRES_COMPLETOS);
	}

	public static boolean validarDireccion(String direccion) {
		return direccion.matches(ERDIRECCION);
	}

	public static boolean validarDNI(String dni) {
		return dni.matches(ERCEDULA);
	}

	public static boolean ValidarEmail(String email) {
		return email.matches(ERCORREO);
	}

	public static boolean ValidarTelefono(String phone) {
		return phone.matches(ERTELEFONO);
	}

}

