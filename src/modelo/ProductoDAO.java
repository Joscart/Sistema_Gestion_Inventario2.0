package modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import controlador.SesionActual.VENTANA_TIPO;
import libreria.Files;

public class ProductoDAO implements Config{

	private Files file;
	private final String RUTA_ESPECIFICA = Config.getRutaEspecifica(VENTANA_TIPO.PRODUCTO);

	public ProductoDAO() {
		super();
		// TODO Auto-generated constructor stub
		file = new Files(RUTA_ABSOLUTA);
	}

	public boolean agregarProducto(Producto p) throws IOException {
		if(p == null) return false;
		file.setFile(new File(RUTA_ESPECIFICA, ARCHIVO_PRODUCTO));
		return file.writerFile(p.toFile(), false);
	}

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
