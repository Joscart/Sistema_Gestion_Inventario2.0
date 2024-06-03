package modelo;

import java.util.List;


public class ValidarDatosProveedor implements Parametrizable {

    /**
     * Valida un correo electrónico según la expresión regular definida en la interfaz Parametrizable.
     *
     * @param email El correo electrónico a validar.
     * @return true si el correo electrónico es válido, false en caso contrario.
     */
    public static boolean validarEmail(String email) {
        return email.matches(ERCORREO);
    }

    /**
     * Valida un número de identificación según la expresión regular definida en la interfaz Parametrizable.
     *
     * @param dni El número de identificación a validar.
     * @return true si el número de identificación es válido, false en caso contrario.
     */
    public static boolean validarDni(String dni) {
        return dni.matches(ERCEDULA);
    }

    /**
     * Valida un código según la expresión regular definida en la interfaz Parametrizable y verifica que no esté repetido en la lista de proveedores.
     *
     * @param codigo     El código a validar.
     * @param proveedores La lista de proveedores donde verificar la unicidad del código.
     * @return true si el código es válido y único, false en caso contrario.
     */
    public static boolean validarCodigo(String codigo, List<Proveedor> proveedores) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getCodigo().equals(codigo)) {
                return false;
            }
        }
        return codigo.matches(ERCODIGO);
    }

    /**
     * Valida un número de teléfono según la expresión regular definida en la interfaz Parametrizable.
     *
     * @param telefono El número de teléfono a validar.
     * @return true si el número de teléfono es válido, false en caso contrario.
     */
    public static boolean validarTelefono(String telefono) {
        return telefono.matches(ERTELEFONO);
    }

    /**
     * Valida una razón social según la expresión regular definida en la interfaz Parametrizable, teniendo en cuenta si es una persona física o jurídica.
     *
     * @param razonSocial      La razón social a validar.
     * @param esPersonaFisica  Indica si la razón social corresponde a una persona física (true) o jurídica (false).
     * @return true si la razón social es válida, false en caso contrario.
     */
    public static boolean validarRazonSocial(String razonSocial, boolean esPersonaFisica) {
        if (esPersonaFisica) {
            return razonSocial.matches(ERNOMBRES_COMPLETOS);
        } else {
            return razonSocial.matches(ERRAZON_SOCIAL);
        }
    }
}
