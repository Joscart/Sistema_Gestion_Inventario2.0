package modelo;


public class Proveedor {
    private String nombreCompleto;
    private String email;
    private String dni;
    private String codigo;
    private String telefono;
    private String razonSocial;
    
    /**
     * Constructor por defecto de la clase Proveedor.
     * Inicializa todos los atributos en nulo.
     */
    public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
     * Constructor de la clase Proveedor.
     * 
     * @param nombreCompleto El nombre completo del proveedor
     * @param email El correo electrónico del proveedor
     * @param dni El número de identificación del proveedor
     * @param codigo El código del proveedor
     * @param telefono El número de teléfono del proveedor
     * @param razonSocial La razón social del proveedor
     */
    public Proveedor(String nombreCompleto, String email, String dni, String codigo, String telefono, String razonSocial) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.dni = dni;
        this.codigo = codigo;
        this.telefono = telefono;
        this.razonSocial = razonSocial;
    }

    // Getters and Setters
    
    /**
     * Obtiene el nombre completo del proveedor.
     * 
     * @return El nombre completo del proveedor
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del proveedor.
     * 
     * @param nombreCompleto El nombre completo del proveedor a establecer
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Obtiene el correo electrónico del proveedor.
     * 
     * @return El correo electrónico del proveedor
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del proveedor.
     * 
     * @param email El correo electrónico del proveedor a establecer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el número de identificación del proveedor.
     * 
     * @return El número de identificación del proveedor
     */
    public String getDni() {
        return dni;
    }

    /**
     * Establece el número de identificación del proveedor.
     * 
     * @param dni El número de identificación del proveedor a establecer
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obtiene el código del proveedor.
     * 
     * @return El código del proveedor
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código del proveedor.
     * 
     * @param codigo El código del proveedor a establecer
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene el número de teléfono del proveedor.
     * 
     * @return El número de teléfono del proveedor
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del proveedor.
     * 
     * @param telefono El número de teléfono del proveedor a establecer
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la razón social del proveedor.
     * 
     * @return La razón social del proveedor
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * Establece la razón social del proveedor.
     * 
     * @param razonSocial La razón social del proveedor a establecer
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

	/**
	 * Convierte el proveedor a una representación en cadena.
	 * 
	 * @return Una cadena que representa al proveedor
	 */
	@Override
	public String toString() {
		return String.format("%s, %s, %s",
				nombreCompleto, email, dni);
	}
    
	/**
	 * Convierte el proveedor a una cadena con formato de archivo.
	 * 
	 * @return Una cadena con formato de archivo que representa al proveedor
	 */
	public String toFile() {
		return String.format("%s;%s;%s;%s;%s;%s",
				nombreCompleto, email, dni, codigo, telefono, razonSocial);
	}
	
	/**
	 * Inicializa los atributos del proveedor a partir de una cadena con formato de archivo.
	 * 
	 * @param linea La cadena con formato de archivo que contiene los datos del proveedor
	 * @return true si la inicialización fue exitosa, false si no
	 */
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
