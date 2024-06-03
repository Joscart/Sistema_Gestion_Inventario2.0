package modelo;


public class Empleado extends Cliente{

    /**
     * Constructor por defecto que llama al constructor de la clase base Cliente.
     */
    public Empleado() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructor que inicializa un Empleado con los datos proporcionados.
     *
     * @param nombre El nombre del empleado.
     * @param direccion La dirección del empleado.
     * @param cedula La cédula del empleado.
     * @param telefono El teléfono del empleado.
     * @param correo El correo electrónico del empleado.
     */
    public Empleado(String nombre, String direccion, String cedula, String telefono, String correo) {
        super(nombre, direccion, cedula, telefono, correo);
        // TODO Auto-generated constructor stub
    }

    /**
     * Método para obtener una representación del objeto en formato de archivo.
     * 
     * @return Una cadena de texto con los datos del empleado, separados por punto y coma, con un 1 al final.
     */
    public String toFile() {
        return String.format("%s;%s;%s;%s;%s;1", 
                getNombre(), getDireccion(), getCedula(), getTelefono(), getCorreo());
    }

    /**
     * Método para establecer los datos del empleado a partir de una línea de texto formateada.
     * 
     * @param linea Una cadena de texto con los datos del empleado, separados por punto y coma.
     * @return true si los datos fueron correctamente asignados, false si hubo un error en el formato.
     */
    public boolean fromFile(String linea) {
        String[] datos = linea.split(";");
        if(datos.length != 6) return false;
        if(!datos[5].equals("1")) return false;
        setNombre(datos[0]);
        setDireccion(datos[1]);
        setCedula(datos[2]);
        setTelefono(datos[3]);
        setCorreo(datos[4]);
        return true;
    }
}
