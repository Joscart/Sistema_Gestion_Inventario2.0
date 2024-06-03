package modelo;

import java.util.Date;

import libreria.Generica;


public class Usuario implements Codificador {
    
    /** Objeto de tipo Generica para almacenar los datos del usuario. */
    private Generica<String,Date> lb = new Generica<>();
    
    /** El tipo de usuario. */
    private TIPO_USUARIO tipo = TIPO_USUARIO.EMPLEADO;
    
    /** Enumeración que define los tipos de usuario posibles. */
    public static enum TIPO_USUARIO {
        ADMINISTRADOR, EMPLEADO
    }

    /** Constructor por defecto. */
    public Usuario() {
        super();
    }

    /**
     * Constructor que inicializa un Usuario con nombre de usuario y contraseña.
     *
     * @param nombre El nombre de usuario.
     * @param contrasena La contraseña del usuario.
     */
    public Usuario(String nombre, String contrasena) {
        super();
        this.lb = new Generica<>(Codificador.codificar(nombre), Codificador.codificar(contrasena), new Date());
    }

    /**
     * Constructor que inicializa un Usuario con nombre de usuario, contraseña y fecha de creación.
     *
     * @param nombre El nombre de usuario.
     * @param contrasena La contraseña del usuario.
     * @param fecha La fecha de creación del usuario.
     */
    public Usuario(String nombre, String contrasena, Date fecha) {
        super();
        this.lb = new Generica<>(Codificador.codificar(nombre), Codificador.codificar(contrasena), fecha);
    }
    
    /**
     * Constructor que inicializa un Usuario con nombre de usuario, contraseña y tipo de usuario.
     *
     * @param nombre El nombre de usuario.
     * @param contrasena La contraseña del usuario.
     * @param tipo El tipo de usuario.
     */
    public Usuario(String nombre, String contrasena, TIPO_USUARIO tipo) {
        super();
        this.lb = new Generica<>(Codificador.codificar(nombre), Codificador.codificar(contrasena), new Date());
        this.tipo = tipo;
    }
    
    /**
     * Constructor que inicializa un Usuario con nombre de usuario, contraseña, fecha de creación y tipo de usuario.
     *
     * @param nombre El nombre de usuario.
     * @param contrasena La contraseña del usuario.
     * @param fecha La fecha de creación del usuario.
     * @param tipo El tipo de usuario.
     */
    public Usuario(String nombre, String contrasena, Date fecha, TIPO_USUARIO tipo) {
        super();
        this.lb = new Generica<>(Codificador.codificar(nombre), Codificador.codificar(contrasena), fecha);
        this.tipo = tipo;
    }

    /**
     * Obtiene el nombre de usuario decodificado.
     *
     * @return El nombre de usuario decodificado.
     */
    public String getUsuario() {
        return Codificador.decodificar(lb.getAtributo1());
    }

    /**
     * Obtiene la contraseña decodificada.
     *
     * @return La contraseña decodificada.
     */
    public String getContrasena() {
        return Codificador.decodificar(lb.getAtributo2());
    }

    /**
     * Obtiene la fecha de creación del usuario.
     *
     * @return La fecha de creación del usuario.
     */
    public Date getFechaCreacion() {
        return lb.getAtributo3();
    }
    
    /**
     * Obtiene el tipo de usuario.
     *
     * @return El tipo de usuario.
     */
    public TIPO_USUARIO getTipo() {
        return tipo;
    }

    /**
     * Establece el nombre de usuario.
     *
     * @param nombre_usuario El nuevo nombre de usuario.
     */
    public void setUsuario(String nombre_usuario) {
        lb.setAtributo1(Codificador.codificar(nombre_usuario));
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasena La nueva contraseña del usuario.
     */
    public void setcontrasena(String contrasena) {
        lb.setAtributo2(Codificador.codificar(contrasena));
    }

    /**
     * Establece el tipo de usuario.
     *
     * @param tipo El nuevo tipo de usuario.
     */
    public void setTipo(TIPO_USUARIO tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Establece el tipo de usuario a partir de una cadena de texto.
     *
     * @param tipo La cadena de texto que representa el tipo de usuario.
     */
    public void setTipo(String tipo) {
        this.tipo = TIPO_USUARIO.valueOf(Codificador.decodificar(tipo));
    }
    
    /**
     * Obtiene una representación en formato de archivo de los datos del usuario.
     *
     * @return Una cadena de texto con los datos del usuario codificados.
     */
    public String toFile() {
        return Codificador.codificar(String.format("%s;%s;%s;%s", lb.getAtributo1(), lb.getAtributo2(), lb.getAtributo3().getTime(), Codificador.codificar(tipo.toString())));
    }
    
    /**
     * Establece los datos del usuario a partir de una línea de texto formateada.
     *
     * @param linea La línea de texto con los datos del usuario codificados.
     * @return true si los datos se establecieron correctamente, false en caso contrario.
     */
    public boolean fromFile(String linea) {
        String[] Datos = Codificador.decodificar(linea).split(";");
        if(Datos.length != 4) return false;
        lb.setAtributo1(Datos[0]);
        lb.setAtributo2(Datos[1]);
        lb.setAtributo3(new Date(Long.parseLong(Datos[2])));
        tipo = TIPO_USUARIO.valueOf(Codificador.decodificar(Datos[3]));
        return true;    
    }
}
