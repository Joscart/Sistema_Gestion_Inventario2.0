package modelo;

public class Cliente {
	private String nombre;
	private String direccion;
	private String cedula;
	private String telefono;
	private String correo;



	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nombre, String direccion, String cedula, String telefono, String correo) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.cedula = cedula;
		this.telefono = telefono;
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s", nombre, cedula, correo);
	}

	public String toFile() {
		return String.format("%s;%s;%s;%s;%s;0", 
				nombre, direccion, cedula, telefono, correo);
	}

	public boolean fromFile(String line) {
		String[] datos = line.split(";");
		if(datos.length != 6) return false;
		if(!datos[5].equals("0")) return false;
		setNombre(datos[0]);
		setDireccion(datos[1]);
		setCedula(datos[2]);
		setTelefono(datos[3]);
		setCorreo(datos[4]);
		return true;
	}


}
