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

	public ProveedorDAO() {
		super();
		// TODO Auto-generated constructor stub
		file = new Files(RUTA_ABSOLUTA);
	}

	public boolean agregarProveedor(Proveedor p) throws IOException {
		if(p == null) return false;
		file.setFile(new File(RUTA_ESPECIFICA, ARCHIVO_PROVEEDOR));
		return file.writerFile(p.toFile(), false);
	}

	public boolean modificarDB(List<? extends Proveedor> list) throws IOException {
		file.setFile(new File(RUTA_ESPECIFICA, ARCHIVO_PROVEEDOR));
		file.writerFile("", true);

		boolean flag = true;

		for (Proveedor c : list) {
			try {
				agregarProveedor(c);
			} catch (IOException e) {
				flag = false;
				e.printStackTrace();
			}
		}

		return flag;
	}

	public List<Proveedor> leerDB() throws IOException {
		file.setFile(new File(RUTA_ESPECIFICA, ARCHIVO_PROVEEDOR));
		file.create(1);
		List<Proveedor> list = new Vector<>();
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
