package modelo;

import java.util.List;

public class ValidarDatosProveedor implements Parametrizable{

    public static boolean validarEmail(String email) {
        return email.matches(ERCORREO);
    }

    public static boolean validarDni(String dni) {
        return dni.matches(ERCEDULA);
    }

    public static boolean validarCodigo(String codigo, List<Proveedor> proveedores) {
    	
    	for (Proveedor proveedor : proveedores) {	
			if (proveedor.getCodigo().equals(codigo)) {
				return false;
			}
    	}
    	
        return codigo.matches(ERCODIGO);
    }

    public static boolean validarTelefono(String telefono) {
        return telefono.matches(ERTELEFONO);
    }

    public static boolean validarRazonSocial(String razonSocial, boolean esPersonaFisica) {
        if (esPersonaFisica) {
            return razonSocial.matches(ERNOMBRES_COMPLETOS);
        } else {
            return razonSocial.matches(ERRAZON_SOCIAL);
        }
    }
}
