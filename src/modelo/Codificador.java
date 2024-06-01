package modelo;

import java.util.Base64;

public interface Codificador {

	public static String codificar(String texto) {
		return Base64.getEncoder().encodeToString(texto.getBytes());
    }
	
	public static String decodificar(String texto) {
		byte[] decodedBytes = Base64.getDecoder().decode(texto);
		return new String(decodedBytes);
	}
}
