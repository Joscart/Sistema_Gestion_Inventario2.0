package modelo;

import java.io.File;

import controlador.SesionActual.VENTANA_TIPO;

public interface Config {
	
	public final String RUTA = "Datos/";
	public final String RUTA_ABSOLUTA = getRutaAbsoluta();
	public final String ARCHIVO_LOGIN = "db_login.txt";
	public final String ARCHIVO_USUARIO = "db_usuario.txt";
	public final String ARCHIVO_PROVEEDOR = "db_proveedor.txt";
	public final String ARCHIVO_PRODUCTO = "db_producto.txt";
	
	private static void crearDirectorio(String ruta) {
		File directorio = new File(ruta);
		if (!directorio.exists()) {
			directorio.mkdirs();
		}
	}
	
	private static String getRutaAbsoluta() {
		crearDirectorio(RUTA);
		return new File(RUTA).getAbsolutePath() + "/";
	}
	
	public static String getRutaEspecifica(VENTANA_TIPO tipo) {
		String subRuta = switch (tipo) {
		case CLIENTE -> "Usuarios/";
		case PROVEEDOR -> "Proveedores/";
		case PRODUCTO -> "Productos/";
		case VENTA -> "Registros_de_Ventas/";
		};
		
		String ruta = RUTA_ABSOLUTA + subRuta;
		crearDirectorio(ruta);
		return ruta;
	}
	
	public static String getRutaEspecifica() {
		String ruta = getRutaAbsoluta() + "Login/";
		crearDirectorio(ruta);
		return ruta;
	}

}
