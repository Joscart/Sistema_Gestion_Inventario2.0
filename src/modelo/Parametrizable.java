package modelo;


public interface Parametrizable {
    
    /** Expresión regular para validar nombres completos. */
    public final String ERNOMBRES_COMPLETOS = "^([A-ZÁ-Ú][a-zá-ú]{2,}\\s?){2,7}$";

    /** Expresión regular para validar precios. */
    public final String ERPRECIO = "^([0-9]+[.]?)+$";

    /** Expresión regular para validar descripciones. */
    public final String ERDESCRIPCION = "^[a-zA-Z0-9 ,.()-]{10,200}$";

    /** Expresión regular para validar el stock. */
    public final String ERSTOCK = "^[0-9]+$";

    /** Expresión regular para validar códigos. */
    public final String ERCODIGO = "^[0-9A-Z]{6}$";

    /** Expresión regular para validar nombres. */
    public final String ERNOMBRES = "^([A-ZÁ-Ú][a-zá-ú]+\\s?)+$";
    
    /** Expresión regular para validar cédulas. */
    public final String ERCEDULA = "^[0-2][0-9]{9}$";
    
    /** Expresión regular para validar correos electrónicos. */
    public final String ERCORREO = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+(\\.[a-zA-Z]{2,4})+$";
    
    /** Expresión regular para validar números de teléfono. */
    public final String ERTELEFONO = "^[0-9]{10}$";
    
    /** Expresión regular para validar direcciones. */
    public final String ERDIRECCION = "^([A-Za-z]+\\s?)+$";
    
    /** Expresión regular para validar razones sociales. */
    public final String ERRAZON_SOCIAL = "^([A-ZÁ-Ú][a-zá-ú]+[,.; ]?)+$";
}
