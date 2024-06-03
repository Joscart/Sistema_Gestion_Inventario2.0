package modelo;

import java.util.Base64;

/**
 * La interfaz Codificador proporciona métodos para codificar y decodificar textos utilizando Base64.
 */
public interface Codificador {

    /**
     * Codifica una cadena de texto en Base64.
     *
     * @param texto El texto a codificar.
     * @return La cadena codificada en Base64.
     */
    public static String codificar(String texto) {
        return Base64.getEncoder().encodeToString(texto.getBytes());
    }

    /**
     * Decodifica una cadena de texto desde Base64.
     *
     * @param texto El texto codificado en Base64.
     * @return La cadena de texto decodificada.
     */
    public static String decodificar(String texto) {
        byte[] decodedBytes = Base64.getDecoder().decode(texto);
        return new String(decodedBytes);
    }
}
