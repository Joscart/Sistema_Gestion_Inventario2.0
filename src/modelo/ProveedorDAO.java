package modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import controlador.SesionActual.VENTANA_TIPO;
import libreria.Files;


public class ProveedorDAO implements Config{
	
	private Files file;
	private final String RUTA_ESPECIFICA = Config.getRutaEspecifica(VENTANA_TIPO.PROVEEDOR);

	/**
	 * Constructor de la clase ProveedorDAO.
	 * Inicializa el objeto Files para manejar archivos.
	 */
	public ProveedorDAO() {
		super();
		// Inicializar el objeto Files con la ruta absoluta definida en Config
		file = new Files(RUTA_ABSOLUTA);
	}

	/**
	 * Agrega un proveedor al archivo de proveedores.
	 * 
	 * @param p El proveedor a agregar
	 * @return true si se agregó correctamente, false si no
	 * @throws IOException si ocurre un error de entrada/salida
	 */
	public boolean agregarProveedor(Proveedor p) throws IOException {
		if(p == null) return false;
		// Establecer el archivo en la ruta específica para proveedores
		file.setFile(new File(RUTA_ESPECIFICA, ARCHIVO_PROVEEDOR));
		// Escribir el proveedor en el archivo
		return file.writerFile(p.toFile(), false);
	}

	/**
	 * Modifica la base de datos de proveedores con la lista proporcionada.
	 * 
	 * @param list La lista de proveedores a modificar
	 * @return true si se modificaron correctamente, false si no
	 * @throws IOException si ocurre un error de entrada/salida
	 */
	public boolean modificarDB(List<? extends Proveedor> list) throws IOException {
		// Establecer el archivo en la ruta específica para proveedores
		file.setFile(new File(RUTA_ESPECIFICA, ARCHIVO_PROVEEDOR));
		// Limpiar el archivo antes de escribir nuevos datos
		file.writerFile("", true);

		boolean flag = true;

		for (Proveedor c : list) {
			try {
				// Agregar cada proveedor de la lista al archivo
				agregarProveedor(c);
			} catch (IOException e) {
				flag = false;
				e.printStackTrace();
			}
		}

		return flag;
	}

	/**
	 * Lee la base de datos de proveedores desde el archivo.
	 * 
	 * @return La lista de proveedores leída desde el archivo
	 * @throws IOException si ocurre un error de entrada/salida
	 */
	public List<Proveedor> leerDB() throws IOException {
		// Establecer el archivo en la ruta específica para proveedores
		file.setFile(new File(RUTA_ESPECIFICA, ARCHIVO_PROVEEDOR));
		// Crear el archivo si no existe
		file.create(1);
		List<Proveedor> list = new Vector<>();
		// Leer el contenido del archivo
		String texto = file.readerFile();
		for (String linea : texto.split("\n")) {
			if(linea.isEmpty()) continue;
			Proveedor aux = new Proveedor();
			if(!aux.fromFile(linea)) continue;
			list.add(aux);
		}
		return list;
	}

}
