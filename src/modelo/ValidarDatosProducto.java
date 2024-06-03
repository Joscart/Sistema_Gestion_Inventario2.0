package modelo;

import java.util.List;

public class ValidarDatosProducto implements Parametrizable{
	
	public static boolean validateNames(String names) {
		return names.matches(ERNOMBRES);
	}
	
	public static boolean validateprice(String price) {
		return price.matches(ERPRECIO);
	}
	
	public static boolean validateDesc(String Descrip) {
		return Descrip.matches(ERDESCRIPCION);
	}
	
	public static boolean validatestock(String stock) {
		return stock.matches(ERSTOCK);
	}
	
	public static boolean validateCode(String code, List<Producto> productos) {
		
		for (Producto producto : productos) {
			if (producto.getCodigo().equals(code)) {
				return false;
			}
		}
		
		return code.matches(ERCODIGO);
	}

}
