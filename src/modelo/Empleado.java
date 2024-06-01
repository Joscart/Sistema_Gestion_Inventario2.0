package modelo;

public class Empleado extends Cliente{

	public Empleado(String nombre, String direccion, String cedula, String telefono, String correo) {
		super(nombre, direccion, cedula, telefono, correo);
		// TODO Auto-generated constructor stub
	}
	
	public String information() {
		return String.format("%s;%s;%s;%s;%s;1", 
				getNombre(), getDireccion(), getCedula(), getTelefono(), getCorreo());
	}

}
