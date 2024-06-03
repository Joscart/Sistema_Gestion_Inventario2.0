package modelo;


public class ValidarDatosCliente implements Parametrizable {

    /**
     * Valida un nombre completo según la expresión regular definida en la interfaz Parametrizable.
     *
     * @param nombre El nombre completo a validar.
     * @return true si el nombre es válido, false en caso contrario.
     */
    public static boolean validarNombre(String nombre) {
        return nombre.matches(ERNOMBRES_COMPLETOS);
    }

    /**
     * Valida una dirección según la expresión regular definida en la interfaz Parametrizable.
     *
     * @param direccion La dirección a validar.
     * @return true si la dirección es válida, false en caso contrario.
     */
    public static boolean validarDireccion(String direccion) {
        return direccion.matches(ERDIRECCION);
    }

    /**
     * Valida un número de identificación según la expresión regular definida en la interfaz Parametrizable.
     *
     * @param dni El número de identificación a validar.
     * @return true si el número de identificación es válido, false en caso contrario.
     */
    public static boolean validarDNI(String dni) {
        return dni.matches(ERCEDULA);
    }

    /**
     * Valida un correo electrónico según la expresión regular definida en la interfaz Parametrizable.
     *
     * @param email El correo electrónico a validar.
     * @return true si el correo electrónico es válido, false en caso contrario.
     */
    public static boolean ValidarEmail(String email) {
        return email.matches(ERCORREO);
    }

    /**
     * Valida un número de teléfono según la expresión regular definida en la interfaz Parametrizable.
     *
     * @param phone El número de teléfono a validar.
     * @return true si el número de teléfono es válido, false en caso contrario.
     */
    public static boolean ValidarTelefono(String phone) {
        return phone.matches(ERTELEFONO);
    }
}
