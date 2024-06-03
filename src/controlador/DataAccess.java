package controlador;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import modelo.Administrador;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Empleado;
import modelo.LoginDAO;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.Proveedor;
import modelo.ProveedorDAO;
import modelo.Usuario;
import modelo.Usuario.TIPO_USUARIO;


public class DataAccess implements Runnable {

    private List<Usuario> tm_usuarios;
    private List<Cliente> tm_clientes;
    private List<Producto> tm_productos;
    private List<Proveedor> tm_proveedores;

    private LoginDAO dao_usuario = new LoginDAO();
    private ClienteDAO dao_cliente = new ClienteDAO();
    private ProductoDAO dao_producto = new ProductoDAO();
    private ProveedorDAO dao_proveedor = new ProveedorDAO();

    /**
     * Constructor de la clase DataAccess.
     * Llama al método cargarListas() para cargar los datos desde la base de datos.
     */
    public DataAccess() {
        super();
        // TODO Auto-generated constructor stub
        cargarListas();
    }

    /**
     * Carga los datos desde la base de datos en listas.
     * 
     * @return true si las listas se cargan correctamente, false en caso contrario
     */
    private boolean cargarListas() {
        try {
            tm_usuarios = dao_usuario.leerDB();
            tm_clientes = dao_cliente.leerDB();
            tm_productos = dao_producto.leerDB();
            tm_proveedores = dao_proveedor.leerDB();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Convierte una lista de objetos Cliente a una lista de objetos Usuario.
     * 
     * @param list la lista de objetos Cliente
     * @return la lista de objetos Usuario
     */
    private List<Usuario> clienteToUsuario(List<Cliente> list) {
        List<Usuario> list_usuarios = new Vector<>();
        list_usuarios.add(new Usuario("admin", "admin", TIPO_USUARIO.ADMINISTRADOR));
        list.forEach(e -> {
            if (e instanceof Empleado) {
                if (e instanceof Administrador) {
                    list_usuarios.add(new Usuario(e.getCorreo(), e.getCedula(), TIPO_USUARIO.ADMINISTRADOR));
                } else {
                    list_usuarios.add(new Usuario(e.getCorreo(), e.getCedula(), TIPO_USUARIO.EMPLEADO));
                }
            }
        });
        return list_usuarios;
    }

    /**
     * Agrega un objeto Usuario a la lista.
     * 
     * @param usuario el objeto Usuario a agregar
     * @return true si el objeto se agrega correctamente, false en caso contrario
     */
    public boolean add(Usuario usuario) {
        if (usuario == null) return false;
        return tm_usuarios.add(usuario);
    }

    /**
     * Agrega un objeto Cliente a la lista.
     * 
     * @param cliente el objeto Cliente a agregar
     * @return true si el objeto se agrega correctamente, false en caso contrario
     */
    public boolean add(Cliente cliente) {
        if (cliente == null) return false;
        return tm_clientes.add(cliente);
    }

    /**
     * Agrega un objeto Producto a la lista.
     * 
     * @param producto el objeto Producto a agregar
     * @return true si el objeto se agrega correctamente, false en caso contrario
     */
    public boolean add(Producto producto) {
        if (producto == null) return false;
        return tm_productos.add(producto);
    }

    /**
     * Agrega un objeto Proveedor a la lista.
     * 
     * @param proveedor el objeto Proveedor a agregar
     * @return true si el objeto se agrega correctamente, false en caso contrario
     */
    public boolean add(Proveedor proveedor) {
        if (proveedor == null) return false;
        return tm_proveedores.add(proveedor);
    }

    /**
     * Elimina un objeto Usuario de la lista.
     * 
     * @param usuario el objeto Usuario a eliminar
     * @return true si el objeto se elimina correctamente, false en caso contrario
     */
    public boolean remove(Usuario usuario) {
        return tm_usuarios.remove(usuario);
    }

    /**
     * Elimina un objeto Cliente de la lista.
     * 
     * @param cliente el objeto Cliente a eliminar
     * @return true si el objeto se elimina correctamente, false en caso contrario
     */
    public boolean remove(Cliente cliente) {
        return tm_clientes.remove(cliente);
    }

    /**
     * Elimina un objeto Producto de la lista.
     * 
     * @param producto el objeto Producto a eliminar
     * @return true si el objeto se elimina correctamente, false en caso contrario
     */
    public boolean remove(Producto producto) {
        return tm_productos.remove(producto);
    }

    /**
     * Elimina un objeto Proveedor de la lista.
     * Si el proveedor está asociado con algún Producto, esos objetos Producto 
     * también se eliminan de la lista.
     * 
     * @param proveedor el objeto Proveedor a eliminar
     * @return true si el objeto se elimina correctamente, false en caso contrario
     */
    public boolean remove(Proveedor proveedor) {
        if (proveedor == null) return false;
        List<Producto> eliminar = new Vector<>();
        for (Producto producto : tm_productos) {
            if (proveedor.getCodigo().equals(producto.getproveedor().getCodigo())) {
                eliminar.add(producto);
            }
        }
        tm_productos.removeAll(eliminar);
        return tm_proveedores.remove(proveedor);
    }

    /**
     * Recupera la lista de objetos Usuario.
     * 
     * @return la lista de objetos Usuario
     */
    public List<Usuario> getUsuarios() {
        return tm_usuarios;
    }

    /**
     * Recupera la lista de objetos Cliente.
     * 
     * @return la lista de objetos Cliente
     */
    public List<Cliente> getClientes() {
        return tm_clientes;
    }

    /**
     * Recupera la lista de objetos Producto.
     * 
     * @return la lista de objetos Producto
     */
    public List<Producto> getProductos() {
        return tm_productos;
    }

    /**
     * Recupera la lista de objetos Proveedor.
     * 
     * @return la lista de objetos Proveedor
     */
    public List<Proveedor> getProveedores() {
        return tm_proveedores;
    }

    /**
     * Guarda las listas en la base de datos.
     * 
     * @return true si las listas se guardan correctamente, false en caso contrario
     */
    private boolean guardarListas() {
        try {
            tm_usuarios = clienteToUsuario(tm_clientes);
            dao_usuario.modificarDB(tm_usuarios);
            dao_cliente.modificarDB(tm_clientes);
            dao_producto.modificarDB(tm_productos);
            dao_proveedor.modificarDB(tm_proveedores);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Implementa el método run de la interfaz Runnable.
     * Llama al método guardarListas() para guardar las listas en la base de datos.
     */
    @Override
    public void run() {
        // TODO Auto-generated method stub
        guardarListas();
    }

}
