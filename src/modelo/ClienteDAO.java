package modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import controlador.SesionActual.VENTANA_TIPO;
import libreria.Files;
import modelo.Usuario.TIPO_USUARIO;

public class ClienteDAO implements Config{
	
	private Files file;
	private final String RUTA_ESPECIFICA = Config.getRutaEspecifica(VENTANA_TIPO.CLIENTE);

	public ClienteDAO() {
		super();
		// TODO Auto-generated constructor stub
		file = new Files(RUTA_ABSOLUTA);
	}
	
	public boolean agregarUsuario(Cliente c) throws IOException{
		if(c == null) return false;
		file.setFile(new File(RUTA_ESPECIFICA,ARCHIVO_USUARIO));
		return file.writerFile(c.toFile(), false);
	}
	
	public synchronized boolean modificarDB(List<? extends Cliente> list) throws IOException {	
		file.setFile(new File(RUTA_ESPECIFICA,ARCHIVO_USUARIO));
		file.writerFile("", true);
		
		boolean flag = true;
		
		for (Cliente c : list) {
			try {
				agregarUsuario(c);
			} catch (IOException e) {
				flag = false;
				e.printStackTrace();
			}
		}
		
		return flag;
	}

	public synchronized List<Cliente> leerDB() throws IOException {
		file.setFile(new File(RUTA_ESPECIFICA, ARCHIVO_USUARIO));
		file.create(1);
		List<Cliente> list = new Vector<>();
		String texto = file.readerFile();
		for (String linea : texto.split("\n")) {
			if(linea.isEmpty()) continue;
			Cliente aux = new Cliente();
			if(!aux.fromFile(linea)) {
				aux = new Empleado();
				if (!aux.fromFile(linea)) {
					aux = new Administrador();
					if (!aux.fromFile(linea)) continue;
				}
			}
			list.add(aux);
		}
		return list;
	}

}
