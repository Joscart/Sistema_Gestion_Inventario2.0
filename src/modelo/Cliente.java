package modelo;

public class Cliente {
	 private String nombre;
     private String direccion;
	 private String cedula;
	 private String telefono;
	 private String correo;

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

		public String information() {
			return String.format("%s;%s;%s;%s;%s;0", 
					nombre, direccion, cedula, telefono, correo);
		}
		
    
}