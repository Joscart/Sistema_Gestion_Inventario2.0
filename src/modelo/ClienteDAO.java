package modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import controlador.logic_Menu.VENTANA_TIPO;
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
		file.setFile(new File(RUTA_ESPECIFICA,ARCHIVO_USUARIO));
		return file.writerFile(c.information(), false);
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
			String[] datos = linea.split(";");
			Cliente aux = switch (datos[5]) {
			case "0" -> new Cliente(datos[0], datos[1], datos[2], datos[3], datos[4]);
			case "1" -> new Empleado(datos[0], datos[1], datos[2], datos[3], datos[4]);
			case "2" -> new Administrador(datos[0], datos[1], datos[2], datos[3], datos[4]);
			default -> throw new IllegalArgumentException("Unexpected value: " + datos[5]);
			};
			list.add(aux);
		}
		return list;
	}

}
