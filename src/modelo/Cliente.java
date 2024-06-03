package modelo;


public class Cliente {
    private String nombre;
    private String direccion;
    private String cedula;
    private String telefono;
    private String correo;

    /**
     * Constructor por defecto que inicializa un Cliente vacío.
     */
    public Cliente() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa un Cliente con los datos proporcionados.
     *
     * @param nombre El nombre del cliente.
     * @param direccion La dirección del cliente.
     * @param cedula La cédula del cliente.
     * @param telefono El teléfono del cliente.
     * @param correo El correo electrónico del cliente.
     */
    public Cliente(String nombre, String direccion, String cedula, String telefono, String correo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
    }

    /**
     * Obtiene el nombre del cliente.
     * 
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * 
     * @param nombre El nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la dirección del cliente.
     * 
     * @return La dirección del cliente.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del cliente.
     * 
     * @param direccion La dirección del cliente.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene la cédula del cliente.
     * 
     * @return La cédula del cliente.
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Establece la cédula del cliente.
     * 
     * @param cedula La cédula del cliente.
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtiene el teléfono del cliente.
     * 
     * @return El teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del cliente.
     * 
     * @param telefono El teléfono del cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     * 
     * @return El correo electrónico del cliente.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del cliente.
     * 
     * @param correo El correo electrónico del cliente.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Retorna una representación en cadena del cliente.
     * 
     * @return Una cadena que representa al cliente.
     */
    @Override
    public String toString() {
        return String.format("%s, %s, %s", nombre, cedula, correo);
    }

    /**
     * Método para obtener una representación del objeto en formato de archivo.
     * 
     * @return Una cadena de texto con los datos del cliente, separados por punto y coma, con un 0 al final.
     */
    public String toFile() {
        return String.format("%s;%s;%s;%s;%s;0", 
                nombre, direccion, cedula, telefono, correo);
    }

    /**
     * Método para establecer los datos del cliente a partir de una línea de texto formateada.
     * 
     * @param line Una cadena de texto con los datos del cliente, separados por punto y coma.
     * @return true si los datos fueron correctamente asignados, false si hubo un error en el formato.
     */
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
