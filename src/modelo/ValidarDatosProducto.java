package modelo;

import java.util.List;


public class ValidarDatosProducto implements Parametrizable {
    
    /**
     * Valida un nombre según la expresión regular definida en la interfaz Parametrizable.
     *
     * @param names El nombre a validar.
     * @return true si el nombre es válido, false en caso contrario.
     */
    public static boolean validateNames(String names) {
        return names.matches(ERNOMBRES);
    }
    
    /**
     * Valida un precio según la expresión regular definida en la interfaz Parametrizable.
     *
     * @param price El precio a validar.
     * @return true si el precio es válido, false en caso contrario.
     */
    public static boolean validateprice(String price) {
        return price.matches(ERPRECIO);
    }
    
    /**
     * Valida una descripción según la expresión regular definida en la interfaz Parametrizable.
     *
     * @param Descrip La descripción a validar.
     * @return true si la descripción es válida, false en caso contrario.
     */
    public static boolean validateDesc(String Descrip) {
        return Descrip.matches(ERDESCRIPCION);
    }
    
    /**
     * Valida un stock según la expresión regular definida en la interfaz Parametrizable.
     *
     * @param stock El stock a validar.
     * @return true si el stock es válido, false en caso contrario.
     */
    public static boolean validatestock(String stock) {
        return stock.matches(ERSTOCK);
    }
    
    /**
     * Valida un código según la expresión regular definida en la interfaz Parametrizable y verifica que no esté repetido en la lista de productos.
     *
     * @param code El código a validar.
     * @param productos La lista de productos donde verificar la unicidad del código.
     * @return true si el código es válido y único, false en caso contrario.
     */
    public static boolean validateCode(String code, List<Producto> productos) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(code)) {
                return false;
            }
        }
        return code.matches(ERCODIGO);
    }
}
