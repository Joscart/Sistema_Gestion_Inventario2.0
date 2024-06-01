package modelo;

public class Proveedor {
    private String nombreCompleto;
    private String email;
    private String dni;
    private String codigo;
    private String telefono;
    private String razonSocial;
    
    public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Constructor
    public Proveedor(String nombreCompleto, String email, String dni, String codigo, String telefono, String razonSocial) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.dni = dni;
        this.codigo = codigo;
        this.telefono = telefono;
        this.razonSocial = razonSocial;
    }

    // Getters and Setters
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

	@Override
	public String toString() {
		return String.format("%s, %s, %s",
				nombreCompleto, email, dni);
	}
    
	public String toFile() {
		return String.format("%s;%s;%s;%s;%s;%s",
				nombreCompleto, email, dni, codigo, telefono, razonSocial);
	}
	
	public boolean fromFile(String linea) {
		String[] datos = linea.split(";");
		if (datos.length != 6) return false;
		setNombreCompleto(datos[0]);
		setEmail(datos[1]);
		setDni(datos[2]);
		setCodigo(datos[3]);
		setTelefono(datos[4]);
		setRazonSocial(datos[5]);
		return true;
	}
}
