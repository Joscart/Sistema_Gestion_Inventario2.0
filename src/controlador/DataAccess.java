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

public class DataAccess implements Runnable{

	private List<Usuario> tm_usuarios;
	private List<Cliente> tm_clientes;
	private List<Producto> tm_productos;
	private List<Proveedor> tm_proveedores;

	private LoginDAO dao_usuario = new LoginDAO();
	private ClienteDAO dao_cliente = new ClienteDAO();
	private ProductoDAO dao_producto = new ProductoDAO();
	private ProveedorDAO dao_proveedor = new ProveedorDAO();

	public DataAccess() {
		super();
		// TODO Auto-generated constructor stub
		cargarListas();
	}

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

	private List<Usuario> clienteToUsuario(List<Cliente> list){
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

	public boolean add(Usuario usuario) {
		if(usuario == null) return false;
		return tm_usuarios.add(usuario);
	}

	public boolean add(Cliente cliente) {
		if(cliente == null) return false;
		return tm_clientes.add(cliente);
	}

	public boolean add(Producto producto) {
		if(producto == null) return false;
		return tm_productos.add(producto);
	}

	public boolean add(Proveedor proveedor) {
		if(proveedor == null) return false;
		return tm_proveedores.add(proveedor);
	}

	public boolean remove(Usuario usuario) {
		return tm_usuarios.remove(usuario);
	}

	public boolean remove(Cliente cliente) {
		return tm_clientes.remove(cliente);
	}

	public boolean remove(Producto producto) {
		return tm_productos.remove(producto);
	}

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
	
	public List<Usuario> getUsuarios() {
		return tm_usuarios;
	}
	
	public List<Cliente> getClientes() {
		return tm_clientes;
	}
	
	public List<Producto> getProductos() {
		return tm_productos;
	}
	
	public List<Proveedor> getProveedores() {
		return tm_proveedores;
	}	

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

	@Override
	public void run() {
		// TODO Auto-generated method stub
		guardarListas();
	}



}
