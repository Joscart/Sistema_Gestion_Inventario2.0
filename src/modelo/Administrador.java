package modelo;

public class Administrador extends Empleado{

	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	public Administrador(String nombre, String direccion, String cedula, String telefono, String correo) {
		super(nombre, direccion, cedula, telefono, correo);
		// TODO Auto-generated constructor stub
	}

	public String toFile() {
		return String.format("%s;%s;%s;%s;%s;2", 
				getNombre(), getDireccion(), getCedula(), getTelefono(), getCorreo());
	}
	
	public boolean fromFile(String linea) {
		String[] datos = linea.split(";");
		if (datos.length != 6) return false;
		if (!datos[5].equals("2")) return false;
		setNombre(datos[0]);
		setDireccion(datos[1]);
		setCedula(datos[2]);
		setTelefono(datos[3]);
		setCorreo(datos[4]);
		return true;
	}
}
