package modelo;

import java.io.File;

import controlador.SesionActual.VENTANA_TIPO;


public interface Config {
    
    /** La ruta base para los archivos de datos. */
    public final String RUTA = "Datos/";

    /** La ruta absoluta para los archivos de datos. */
    public final String RUTA_ABSOLUTA = getRutaAbsoluta();

    /** El nombre del archivo de login. */
    public final String ARCHIVO_LOGIN = "db_login.txt";

    /** El nombre del archivo de usuario. */
    public final String ARCHIVO_USUARIO = "db_usuario.txt";

    /** El nombre del archivo de proveedor. */
    public final String ARCHIVO_PROVEEDOR = "db_proveedor.txt";

    /** El nombre del archivo de producto. */
    public final String ARCHIVO_PRODUCTO = "db_producto.txt";

    /**
     * Método para crear un directorio en la ruta especificada si no existe.
     *
     * @param ruta La ruta del directorio a crear.
     */
    private static void crearDirectorio(String ruta) {
        File directorio = new File(ruta);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }
    }

    /**
     * Obtiene la ruta absoluta para los archivos de datos.
     *
     * @return La ruta absoluta para los archivos de datos.
     */
    private static String getRutaAbsoluta() {
        crearDirectorio(RUTA);
        return new File(RUTA).getAbsolutePath() + "/";
    }

    /**
     * Obtiene la ruta específica para un tipo de ventana.
     *
     * @param tipo El tipo de ventana.
     * @return La ruta específica para el tipo de ventana.
     */
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

    /**
     * Obtiene la ruta específica para el archivo de login.
     *
     * @return La ruta específica para el archivo de login.
     */
    public static String getRutaEspecifica() {
        String ruta = getRutaAbsoluta() + "Login/";
        crearDirectorio(ruta);
        return ruta;
    }

}
