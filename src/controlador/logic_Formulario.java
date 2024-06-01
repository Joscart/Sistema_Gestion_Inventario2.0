package controlador;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JOptionPane;

import controlador.logic_Menu.VENTANA_TIPO;
import modelo.Administrador;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Producto;
import modelo.Proveedor;
import modelo.ValidarDatosCliente;
import modelo.ValidarDatosProveedor;
import modelo.ValidarDatosProducto;
import vista.Formulario;

public class logic_Formulario implements ActionListener, KeyListener, WindowListener{

	private Formulario lb;
	private boolean guardado = true;

	private List<Proveedor> proveedores;


	private Cliente tm_usuario;
	private Proveedor tm_proveedor;
	private Producto tm_producto;

	VENTANA_TIPO tipo;

	public logic_Formulario(Formulario lb) {
		this.lb = lb;
		lb.setVisible(true);
		lb.setDefaultCloseOperation(Formulario.HIDE_ON_CLOSE);
		lb.setVisible(false);
		listener();
	}

	public VENTANA_TIPO getTipo() {
		return tipo;
	}

	public boolean setTipo(VENTANA_TIPO tipo, Rectangle... btn) {
		if (!guardado) {
			if (!confirmarSalida()) {
				lb.setVisible(true);				
				return false;
			} else {
			}
		}

		this.tipo = tipo;
		guardado = true;
		if (btn.length > 0)
			lb.setBounds(btn[0]);
		cargarFormulario();
		lb.setVisible(true);
		return true;
	}

	private void listener() {
		lb.txt_entrada1.addKeyListener(this);
		lb.txt_entrada2.addKeyListener(this);
		lb.txt_entrada3.addKeyListener(this);
		lb.txt_entrada4.addKeyListener(this);
		lb.txt_entrada5.addKeyListener(this);
		lb.txt_entrada6.addKeyListener(this);
		lb.cbx_entrada7.addActionListener(this);
		lb.btn_agregar.addActionListener(this);
		lb.btn_guardar.addActionListener(this);
		lb.addWindowListener(this);
	}

	private void reset() {
		lb.setTitle("");
		lb.lbl_estatus.setText("");
		lb.btn_agregar.setText("");
		lb.btn_guardar.setText("");
		lb.txt_informacion.setText("");
		lb.lbl_entrada1.setText("");
		lb.lbl_entrada2.setText("");
		lb.lbl_entrada3.setText("");
		lb.lbl_entrada4.setText("");
		lb.lbl_entrada5.setText("");
		lb.lbl_entrada6.setText("");
		lb.lbl_entrada7.setText("");
		lb.txt_entrada1.setText("");
		lb.txt_entrada2.setText("");
		lb.txt_entrada3.setText("");
		lb.txt_entrada4.setText("");
		lb.txt_entrada5.setText("");
		lb.txt_entrada6.setText("");
		lb.cbx_entrada7.removeAllItems();
		lb.lbl_entrada1.setVisible(true);
		lb.lbl_entrada2.setVisible(true);
		lb.lbl_entrada3.setVisible(true);
		lb.lbl_entrada4.setVisible(true);
		lb.lbl_entrada5.setVisible(true);
		lb.lbl_entrada6.setVisible(true);
		lb.lbl_entrada7.setVisible(true);
		lb.txt_entrada1.setVisible(true);
		lb.txt_entrada2.setVisible(true);
		lb.txt_entrada3.setVisible(true);
		lb.txt_entrada4.setVisible(true);
		lb.txt_entrada5.setVisible(true);
		lb.txt_entrada6.setVisible(true);
		lb.cbx_entrada7.setVisible(true);
		lb.txt_informacion.setVisible(true);
		lb.lbl_estatus.setVisible(true);
		lb.btn_agregar.setVisible(true);
		lb.btn_guardar.setVisible(true);
		lb.txt_entrada1.setEnabled(true);
		lb.txt_entrada2.setEnabled(true);
		lb.txt_entrada3.setEnabled(true);
		lb.txt_entrada4.setEnabled(true);
		lb.txt_entrada5.setEnabled(true);
		lb.txt_entrada6.setEnabled(true);
		lb.cbx_entrada7.setEnabled(true);
		lb.txt_informacion.setEditable(false);
	}

	private boolean confirmarSalida() {
		if (JOptionPane.showConfirmDialog(lb, "¿Desea salir sin guardar?", "Confirmar Salida",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}

	public void cargarFormulario() {
		reset();
		switch (tipo) {
		case CLIENTE:
			lb.setTitle("Registro de Usuario");
			lb.lbl_titulo.setText("Registro de Usuario");
			lb.lbl_entrada1.setText("Nombres");
			lb.lbl_entrada2.setText("Direccion");
			lb.lbl_entrada3.setText("Cedula");
			lb.lbl_entrada4.setText("Telefono");
			lb.lbl_entrada5.setText("Correo");
			lb.lbl_entrada6.setVisible(false);
			lb.txt_entrada6.setVisible(false);
			lb.lbl_entrada7.setText("Tipo");
			lb.cbx_entrada7.addItem("Cliente");
			lb.cbx_entrada7.addItem("Empleado");
			lb.cbx_entrada7.addItem("Administrador");
			lb.txt_informacion.setVisible(false);
			lb.btn_agregar.setVisible(false);
			lb.btn_guardar.setText("Guardar");

			if (tm_usuario != null) {
				lb.txt_entrada1.setText(tm_usuario.getNombre());
				lb.txt_entrada2.setText(tm_usuario.getDireccion());
				lb.txt_entrada3.setText(tm_usuario.getCedula());
				lb.txt_entrada4.setText(tm_usuario.getTelefono());
				lb.txt_entrada5.setText(tm_usuario.getCorreo());
				if (tm_usuario instanceof Administrador) {
					lb.cbx_entrada7.setSelectedIndex(2);
				} else if (tm_usuario instanceof Empleado) {
					lb.cbx_entrada7.setSelectedIndex(1);
				} else {
					lb.cbx_entrada7.setSelectedIndex(0);
				}
			}
			break;
		case PROVEEDOR:
			lb.setTitle("Registro de Proveedor");
			lb.lbl_titulo.setText("Registro de Proveedor");
			lb.lbl_entrada1.setText("Nombres Completos");
			lb.lbl_entrada2.setText("Email");
			lb.lbl_entrada3.setText("Cedula");
			lb.lbl_entrada4.setText("Codigo");
			lb.lbl_entrada5.setText("Telefono");
			lb.lbl_entrada6.setText("Razon Social");
			lb.cbx_entrada7.addItem("Persona Fisica");
			lb.cbx_entrada7.addItem("Persona Moral");
			lb.txt_informacion.setVisible(false);
			lb.btn_agregar.setVisible(false);
			lb.btn_guardar.setText("Guardar");
			break;
		case PRODUCTO:
			lb.setTitle("Registro de Producto");
			lb.lbl_titulo.setText("Registro de Producto");
			lb.lbl_entrada1.setText("Nombre");
			lb.lbl_entrada2.setText("Descripcion");
			lb.lbl_entrada3.setText("Codigo");
			lb.lbl_entrada4.setVisible(false);
			lb.txt_entrada4.setVisible(false);
			lb.lbl_entrada5.setText("Precio");
			lb.lbl_entrada6.setText("Existencias");
			lb.lbl_entrada7.setText("Proveedor");
			//rellenar proveedores
			if (proveedores != null) {
				for (Proveedor p : proveedores) {
					lb.cbx_entrada7.addItem(p);
				}
			}
			lb.txt_informacion.setVisible(false);
			lb.btn_agregar.setVisible(false);
			lb.btn_guardar.setText("Guardar");
			break;
		case VENTA:
			lb.setTitle("Registro de Venta");
			lb.lbl_titulo.setText("Registro de Venta");
			lb.lbl_entrada1.setText("Codigo Producto");
			lb.lbl_entrada2.setText("nombre");
			lb.txt_entrada2.setEnabled(false);
			lb.lbl_entrada3.setText("Cantidad");
			lb.lbl_entrada4.setVisible(false);
			lb.txt_entrada4.setVisible(false);
			lb.lbl_entrada5.setVisible(false);
			lb.txt_entrada5.setVisible(false);
			lb.lbl_entrada6.setText("Cliente");
			lb.txt_entrada6.setEnabled(false);
			lb.lbl_entrada7.setText("Facturacion");
			lb.cbx_entrada7.addItem("Consumidor Final");
			lb.cbx_entrada7.addItem("Datos Facturacion");
			lb.btn_agregar.setText("Agregar Producto");
			lb.btn_guardar.setText("Finalizar Venta");
			break;
		}
	}

	private boolean validar() {
		boolean validado = true;
		switch (tipo) {
		case CLIENTE:
			if(!ValidarDatosCliente.validarNombre(lb.txt_entrada1.getText()))
				validado = false;
			if(!ValidarDatosCliente.validarDireccion(lb.txt_entrada2.getText()))
				validado = false;
			if(!ValidarDatosCliente.validarDNI(lb.txt_entrada3.getText()))
				validado = false;
			if(!ValidarDatosCliente.ValidarTelefono(lb.txt_entrada4.getText()))
				validado = false;
			if(!ValidarDatosCliente.ValidarEmail(lb.txt_entrada5.getText()))
				validado = false;
			break;
		case PROVEEDOR:
			if (!ValidarDatosProveedor.validarRazonSocial(lb.txt_entrada1.getText(),
					lb.cbx_entrada7.getSelectedIndex() == 0))
				validado = false;
			if (!ValidarDatosProveedor.validarEmail(lb.txt_entrada2.getText()))
				validado = false;
			if (!ValidarDatosProveedor.validarDni(lb.txt_entrada3.getText()))
				validado = false;
			if (!ValidarDatosProveedor.validarCodigo(lb.txt_entrada4.getText()))
				validado = false;
			if (!ValidarDatosProveedor.validarTelefono(lb.txt_entrada5.getText()))
				validado = false;
			break;
		case PRODUCTO:
			if (!ValidarDatosProducto.validateNames(lb.txt_entrada1.getText()))
				validado = false;
			if (!ValidarDatosProducto.validateDesc(lb.txt_entrada2.getText()))
				validado = false;
			if (!ValidarDatosProducto.validateCode(lb.txt_entrada3.getText()))
				validado = false;
			if (!ValidarDatosProducto.validateprice(lb.txt_entrada5.getText()))
				validado = false;
			if (!ValidarDatosProducto.validatestock(lb.txt_entrada6.getText()))
				validado = false;
			break;
		default:
			break;
		}
		return validado;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public Cliente getUsuario() {
		return tm_usuario;
	}

	public void setUsuario(Cliente tm_usuario) {
		this.tm_usuario = tm_usuario;
	}

	public Proveedor getProveedor() {
		return tm_proveedor;
	}

	public void setProveedor(Proveedor tm_proveedor) {
		this.tm_proveedor = tm_proveedor;
	}

	public Producto getProducto() {
		return tm_producto;
	}

	public void setProducto(Producto tm_producto) {
		this.tm_producto = tm_producto;
	}

	public boolean isGuardado() {
		return guardado;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		guardado = false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lb.btn_guardar) {
			System.out.println("Guardar");
			if (validar()) {
				switch (tipo) {
				case CLIENTE:

					if (lb.cbx_entrada7.getSelectedIndex() == 0) {

						tm_usuario = new Cliente(lb.txt_entrada1.getText(), lb.txt_entrada2.getText(),
								lb.txt_entrada3.getText(), lb.txt_entrada4.getText(), lb.txt_entrada5.getText());

					} else if (lb.cbx_entrada7.getSelectedIndex() == 1) {

						tm_usuario = new Empleado(lb.txt_entrada1.getText(), lb.txt_entrada2.getText(),
								lb.txt_entrada3.getText(), lb.txt_entrada4.getText(), lb.txt_entrada5.getText());

					} else {
						tm_usuario = new Administrador(lb.txt_entrada1.getText(), lb.txt_entrada2.getText(),
								lb.txt_entrada3.getText(), lb.txt_entrada4.getText(), lb.txt_entrada5.getText());
					}

					break;
				case PROVEEDOR:
					if (tm_proveedor == null) {
						tm_proveedor = new Proveedor(lb.txt_entrada1.getText(), lb.txt_entrada2.getText(),
								lb.txt_entrada3.getText(), lb.txt_entrada4.getText(), lb.txt_entrada5.getText(), lb.txt_entrada6.getText());
					} else {
						tm_proveedor.setNombreCompleto(lb.txt_entrada1.getText());
						tm_proveedor.setEmail(lb.txt_entrada2.getText());
						tm_proveedor.setDni(lb.txt_entrada3.getText());
						tm_proveedor.setCodigo(lb.txt_entrada4.getText());
						tm_proveedor.setTelefono(lb.txt_entrada5.getText());
						tm_proveedor.setRazonSocial(lb.txt_entrada6.getText());
					}
					break;
				case PRODUCTO:
					if (tm_producto == null) {
						tm_producto = new Producto(lb.txt_entrada1.getText(), lb.txt_entrada2.getText(),
								lb.txt_entrada3.getText(), Double.parseDouble(lb.txt_entrada5.getText()),
								Integer.parseInt(lb.txt_entrada6.getText()), (Proveedor) lb.cbx_entrada7.getSelectedItem());
					} else {
						tm_producto.setname(lb.txt_entrada1.getText());
						tm_producto.setdesc(lb.txt_entrada2.getText());
						tm_producto.setCodigo(lb.txt_entrada3.getText());
						tm_producto.setprecio(Double.parseDouble(lb.txt_entrada5.getText()));
						tm_producto.setstock(Integer.parseInt(lb.txt_entrada6.getText()));
						tm_producto.setproveedor((Proveedor) lb.cbx_entrada7.getSelectedItem());
					}
					break;
				case VENTA:
					break;
				}
				guardado = true;
				JOptionPane.showMessageDialog(lb, "Guardado exitoso", "Exito", JOptionPane.INFORMATION_MESSAGE);
				lb.dispatchEvent(new WindowEvent(lb, WindowEvent.WINDOW_CLOSING));
			} else {
				guardado = false;
				JOptionPane.showMessageDialog(lb, "Datos invalidos", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		if (!guardado) {
			guardado = confirmarSalida();
			if (!guardado) {
				lb.setDefaultCloseOperation(Formulario.DO_NOTHING_ON_CLOSE);
			} else {
				lb.setDefaultCloseOperation(Formulario.HIDE_ON_CLOSE);
			}
		}

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
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

}
