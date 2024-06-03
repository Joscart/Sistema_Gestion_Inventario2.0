package modelo;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import libreria.Files;
import modelo.Usuario.TIPO_USUARIO;


public class LoginDAO implements Config{
    
    private Files file;
    private final String RUTA_ESPECIFICA = Config.getRutaEspecifica();

    /**
     * Constructor por defecto que inicializa el objeto Files con la ruta absoluta.
     */
    public LoginDAO() {
        super();
        // TODO Auto-generated constructor stub
        file = new Files(RUTA_ABSOLUTA);
    }

    /**
     * Agrega un nuevo usuario al archivo de login.
     *
     * @param u El usuario a agregar.
     * @return true si el usuario se agregó correctamente, false en caso contrario.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public boolean agregarUsuario(Usuario u) throws IOException {
        if(u == null) return false;
        file.setFile(new File(RUTA_ESPECIFICA, ARCHIVO_LOGIN));
        return file.writerFile(u.toFile(), false);
    }

    /**
     * Modifica la base de datos con una lista de usuarios.
     *
     * @param list La lista de usuarios a escribir en el archivo.
     * @return true si la operación se realizó correctamente, false en caso contrario.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public boolean modificarDB(List<? extends Usuario> list) throws IOException {
        file.setFile(new File(RUTA_ESPECIFICA, ARCHIVO_LOGIN));
        file.writerFile("", true);

        boolean flag = true;

        for (Usuario u : list) {
            try {
                agregarUsuario(u);
            } catch (IOException e) {
                flag = false;
                e.printStackTrace();
            }
        }

        return flag;
    }

    /**
     * Lee la base de datos y retorna una lista de usuarios.
     *
     * @return Una lista de objetos Usuario leídos del archivo.
     * @throws IOException Si ocurre un error de entrada/salida.
     */
    public List<Usuario> leerDB() throws IOException {
        file.setFile(new File(RUTA_ESPECIFICA, ARCHIVO_LOGIN));
        List<Usuario> list = new Vector<>();
        if(!file.getFile().exists())
            agregarUsuario(new Usuario("admin", "admin", TIPO_USUARIO.valueOf("ADMINISTRADOR")));
        file.create(1);
        String texto = file.readerFile();
        for (String linea : texto.split("\n")) {
            if(linea.isEmpty()) continue;
            Usuario aux = new Usuario();
            if(!aux.fromFile(linea)) continue;
            list.add(aux);
        }
        return list;
    }
}
