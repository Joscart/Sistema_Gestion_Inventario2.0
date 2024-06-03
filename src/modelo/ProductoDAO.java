package modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import controlador.SesionActual.VENTANA_TIPO;
import libreria.Files;


public class ProductoDAO implements Config {

    private Files file;
    private final String RUTA_ESPECIFICA = Config.getRutaEspecifica(VENTANA_TIPO.PRODUCTO);

    /**
     * Constructor por defecto que inicializa el objeto Files con la ruta absoluta.
     */
    public ProductoDAO() {
        super();
        file = new Files(RUTA_ABSOLUTA);
    }

    /**
     * Agrega un nuevo producto al archivo de productos.
     *
     * @param p El producto a agregar.
     * @return true si el producto se agregó correctamente, false en caso contrario.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public boolean agregarProducto(Producto p) throws IOException {
        if(p == null) return false;
        file.setFile(new File(RUTA_ESPECIFICA, ARCHIVO_PRODUCTO));
        return file.writerFile(p.toFile(), false);
    }

    /**
     * Modifica la base de datos con una lista de productos.
     *
     * @param list La lista de productos a escribir en el archivo.
     * @return true si la operación se realizó correctamente, false en caso contrario.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public boolean modificarDB(List<? extends Producto> list) throws IOException {
        file.setFile(new File(RUTA_ESPECIFICA, ARCHIVO_PRODUCTO));
        file.writerFile("", true);

        boolean flag = true;

        for (Producto c : list) {
            try {
                agregarProducto(c);
            } catch (IOException e) {
                flag = false;
                e.printStackTrace();
            }
        }

        return flag;
    }

    /**
     * Lee la base de datos y retorna una lista de productos.
     *
     * @return Una lista de objetos Producto leídos del archivo.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public List<Producto> leerDB() throws IOException {
        file.setFile(new File(RUTA_ESPECIFICA, ARCHIVO_PRODUCTO));
        file.create(1);
        List<Producto> list = new Vector<>();
        String texto = file.readerFile();
        for (String linea : texto.split("\n")) {
            if(linea.isEmpty()) continue;
            Producto aux = new Producto();
            if(!aux.fromFile(linea)) continue;
            list.add(aux);
        }
        return list;
    }
}
