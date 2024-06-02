package controlador;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.Cliente;
import modelo.Producto;
import modelo.Proveedor;
import modelo.Usuario;
import vista.Formulario;
import vista.Gestion;
import vista.Menu;
import vista.Login;

public class SesionActual implements Runnable, WindowListener, Dimensiones{

	private DataAccess tm_datos = new DataAccess();
	private Usuario tm_usuario;

	protected Login lb_login;
	protected Menu lb_menu;
	protected Gestion lb_gestion;
	protected Formulario lb_formulario;

	protected logic_Login tm_login;
	protected logic_Menu tm_menu;
	protected logic_Gestion tm_gestion;
	protected logic_Formulario tm_formulario;

	public enum VENTANA_TIPO{
		CLIENTE,PROVEEDOR,PRODUCTO,VENTA
	};

	public static void main(String[] args) {
		EventQueue.invokeLater(new SesionActual());
	}

	public SesionActual() {
		super();
		// TODO Auto-generated constructor stub
	}


	private void iniciarLogin() {
		lb_login = new Login();
		lb_login.setDefaultCloseOperation(Login.EXIT_ON_CLOSE);
		lb_login.addWindowListener(this);
		lb_login.setVisible(true);
		tm_login = new logic_Login(lb_login);
		tm_login.setUsuarios(tm_datos.getUsuarios());
	}

	private void iniciarMenu() {
		lb_menu = new Menu();
		lb_menu.setDefaultCloseOperation(Menu.EXIT_ON_CLOSE);
		lb_menu.addWindowListener(this);
		lb_menu.setVisible(true);
		tm_menu = new logic_Menu(lb_menu);
	}

	private void iniciarGestion() {
		lb_gestion = new Gestion();
		tm_gestion = new logic_Gestion(lb_gestion);
		lb_gestion.setDefaultCloseOperation(Gestion.EXIT_ON_CLOSE);
		lb_gestion.addWindowListener(this);
		lb_gestion.setVisible(true);
	}

	private void iniciarFormulario() {
		lb_formulario = new Formulario();
		tm_formulario = new logic_Formulario(lb_formulario);
		lb_formulario.setDefaultCloseOperation(Formulario.HIDE_ON_CLOSE);
		lb_formulario.addWindowListener(this);
		lb_formulario.setVisible(true);	
	}

	private boolean confirmarSalida(JFrame lb) {
		if (JOptionPane.showConfirmDialog(lb, "¿Desea salir sin guardar?", "Confirmar Salida",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lb_login) {
			if (tm_login.isValido()) {
				tm_usuario = tm_login.getUsuario();
				lb_login.setDefaultCloseOperation(Login.DISPOSE_ON_CLOSE);
			}
		} else if (e.getSource() == lb_menu) {
			if (lb_menu.getDefaultCloseOperation() == Menu.HIDE_ON_CLOSE) {
				switch (tm_menu.getTipo()) {
				case VENTA:
					//ventana de venta
					lb_menu.setDefaultCloseOperation(Menu.EXIT_ON_CLOSE);
					break;
				default:
					iniciarGestion();
					tm_gestion.setDatos(tm_datos);
					tm_gestion.setTipo(tm_menu.getTipo());
					break;
				}
			}
		} else if (e.getSource() == lb_gestion) {
			if (tm_gestion.isActivo()) {
				lb_gestion.setDefaultCloseOperation(Gestion.HIDE_ON_CLOSE);
				iniciarFormulario();
				lb_formulario.setBounds(dimensiones_formulario(tm_gestion.getTipo(), tm_gestion.getBotonActivo()));
				tm_formulario.setProductos(tm_datos.getProductos());
				tm_formulario.setProveedores(tm_datos.getProveedores());
				tm_formulario.setCliente(tm_gestion.getCliente());
				tm_formulario.setProducto(tm_gestion.getProducto());
				tm_formulario.setProveedor(tm_gestion.getProveedor());
				tm_formulario.setTipo(tm_gestion.getTipo());
				switch (tm_gestion.getTipo()) {
				case CLIENTE:
					tm_formulario.setCliente(tm_gestion.getCliente());
					break;
				case PROVEEDOR:
					tm_formulario.setProveedor(tm_gestion.getProveedor());
					break;
				case PRODUCTO:
					tm_formulario.setProducto(tm_gestion.getProducto());
					break;
				default:
					break;
				}
			} else if (tm_gestion.isGuardado()) {
				lb_gestion.setDefaultCloseOperation(Gestion.DISPOSE_ON_CLOSE);
				lb_menu.setDefaultCloseOperation(Menu.EXIT_ON_CLOSE);
				if(tm_datos.getProveedores().isEmpty()) {
					lb_menu.btn_boton3.setEnabled(false);
				} else {
					lb_menu.btn_boton3.setEnabled(true);
				}
				if (tm_datos.getProductos().isEmpty()) {
					lb_menu.btn_boton4.setEnabled(false);
				} else {
					lb_menu.btn_boton4.setEnabled(true);
				}
				lb_menu.setVisible(true);
			} else {
				if (confirmarSalida(lb_gestion)) {
					lb_gestion.setDefaultCloseOperation(Gestion.DISPOSE_ON_CLOSE);
					tm_gestion.setGuardado(true);
					lb_menu.setDefaultCloseOperation(Menu.EXIT_ON_CLOSE);
					if(tm_datos.getProveedores().isEmpty()) {
						lb_menu.btn_boton3.setEnabled(false);
					} else {
						lb_menu.btn_boton3.setEnabled(true);
					}
					if (tm_datos.getProductos().isEmpty()) {
						lb_menu.btn_boton4.setEnabled(false);
					} else {
						lb_menu.btn_boton4.setEnabled(true);
					}
					lb_menu.setVisible(true);
				} else {
					lb_gestion.setDefaultCloseOperation(Gestion.DO_NOTHING_ON_CLOSE);
				}
			}

		} else if (e.getSource() == lb_formulario) {
			if (tm_formulario.isGuardado()) {
				lb_formulario.setDefaultCloseOperation(Formulario.DISPOSE_ON_CLOSE);
				tm_gestion.setActivo(false);
				if (tm_gestion.getBotonActivo() == lb_gestion.btn_nuevo) {
					switch (tm_gestion.getTipo()) {
					case CLIENTE: tm_datos.getClientes().add(tm_formulario.getCliente()); break;
					case PROVEEDOR: tm_datos.getProveedores().add(tm_formulario.getProveedor()); break;
					case PRODUCTO: tm_datos.getProductos().add(tm_formulario.getProducto()); break;
					default: break;
					}
				} else if (tm_gestion.getBotonActivo() == lb_gestion.btn_editar){
					switch (tm_gestion.getTipo()) {
					case CLIENTE:
						tm_datos.getClientes().set(tm_datos.getClientes().indexOf(tm_gestion.getCliente()),
								tm_formulario.getCliente());
						break;
					case PROVEEDOR:
						tm_datos.getProveedores().set(tm_datos.getProveedores().indexOf(tm_gestion.getProveedor()),
								tm_formulario.getProveedor());
						break;
					case PRODUCTO:
						tm_datos.getProductos().set(tm_datos.getProductos().indexOf(tm_gestion.getProducto()),
								tm_formulario.getProducto());
						break;
					default:
						break;
					}
				}
				tm_gestion.actualizarListas();
				tm_gestion.actualizarInformacion();
				lb_gestion.setVisible(true);
			} else {
				if (confirmarSalida(lb_formulario)) {
					lb_formulario.setDefaultCloseOperation(Formulario.DISPOSE_ON_CLOSE);
					tm_formulario.setGuardado(true);
					tm_gestion.setActivo(false);
					lb_gestion.setVisible(true);
				} else {
					lb_formulario.setDefaultCloseOperation(Formulario.DO_NOTHING_ON_CLOSE);
				}
			}
		}

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lb_login) {
			if (tm_login.isValido()) {
				iniciarMenu();
				tm_menu.setPermisos(tm_usuario.getTipo());
				if(tm_datos.getProveedores().isEmpty()) {
					lb_menu.btn_boton3.setEnabled(false);
				} else {
					lb_menu.btn_boton3.setEnabled(true);
				}
				if (tm_datos.getProductos().isEmpty()) {
					lb_menu.btn_boton4.setEnabled(false);
				} else {
					lb_menu.btn_boton4.setEnabled(true);
				}
			}
		}
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			iniciarLogin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
