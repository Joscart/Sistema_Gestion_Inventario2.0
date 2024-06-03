package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JOptionPane;

import controlador.SesionActual.VENTANA_TIPO;
import modelo.Administrador;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Producto;
import modelo.Proveedor;
import modelo.ValidarDatosCliente;
import modelo.ValidarDatosProducto;
import modelo.ValidarDatosProveedor;
import vista.Formulario;

public class logic_Formulario implements ActionListener, KeyListener{

	private Formulario lb;
	private boolean guardado = true;

	private List<Producto> tm_productos;
	private List<Proveedor> tm_proveedores;
	
	private Cliente tm_usuario;
	private Proveedor tm_proveedor;
	private Producto tm_producto;

	private VENTANA_TIPO tipo;

	public logic_Formulario(Formulario lb) {
		this.lb = lb;
		listener();
	}

	private void listener() {
		lb.btn_guardar.addActionListener(this);
	}
	
	public VENTANA_TIPO getTipo() {
		return tipo;
	}

	public boolean setTipo(VENTANA_TIPO tipo) {
		this.tipo = tipo;
		guardado = true;
		cargarFormulario();
		return true;
	}
	
	public void setProductos(List<Producto> productos) {
		this.tm_productos = productos;
	}
	
	public void setProveedores(List<Proveedor> proveedores) {
		this.tm_proveedores = proveedores;
	}
	
	public void setCliente(Cliente cliente) {
		this.tm_usuario = cliente;
	}
	
	public Cliente getCliente() {
		return tm_usuario;
	}
	
	public void setProveedor(Proveedor proveedor) {
		this.tm_proveedor = proveedor;
	}
	
	public Proveedor getProveedor() {
		return tm_proveedor;
	}
	
	public void setProducto(Producto producto) {
		this.tm_producto = producto;
	}
	
	public Producto getProducto() {
		return tm_producto;
	}
	
	public void setGuardado(boolean guardado) {
		this.guardado = guardado;
	}
	
	public boolean isGuardado() {
		return guardado;
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
			
			if (tm_proveedor != null) {
				lb.txt_entrada1.setText(tm_proveedor.getNombreCompleto());
				lb.txt_entrada2.setText(tm_proveedor.getEmail());
				lb.txt_entrada3.setText(tm_proveedor.getDni());
				lb.txt_entrada4.setText(tm_proveedor.getCodigo());
				lb.txt_entrada5.setText(tm_proveedor.getTelefono());
				lb.txt_entrada6.setText(tm_proveedor.getRazonSocial());
				if (tm_proveedor.getRazonSocial() == null) {
					lb.cbx_entrada7.setSelectedIndex(0);
				} else {
					lb.cbx_entrada7.setSelectedIndex(1);
				}
			}
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
			if (tm_proveedores != null) {
				for (Proveedor p : tm_proveedores) {
					lb.cbx_entrada7.addItem(p);
				}
			}
			lb.txt_informacion.setVisible(false);
			lb.btn_agregar.setVisible(false);
			lb.btn_guardar.setText("Guardar");
			
			if (tm_producto != null) {
				lb.txt_entrada1.setText(tm_producto.getname());
				lb.txt_entrada2.setText(tm_producto.getDesc());
				lb.txt_entrada3.setText(tm_producto.getCodigo());
				lb.txt_entrada5.setText(String.valueOf(tm_producto.getprecio()));
				lb.txt_entrada6.setText(String.valueOf(tm_producto.getstock()));
				lb.cbx_entrada7.setSelectedItem(tm_producto.getproveedor());
			}
			break;
		default:
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
			if (!ValidarDatosProveedor.validarCodigo(lb.txt_entrada4.getText(), tm_proveedores))
				validado = false;
			if (!ValidarDatosProveedor.validarTelefono(lb.txt_entrada5.getText()))
				validado = false;
			break;
		case PRODUCTO:
			if (!ValidarDatosProducto.validateNames(lb.txt_entrada1.getText()))
				validado = false;
			if (!ValidarDatosProducto.validateDesc(lb.txt_entrada2.getText()))
				validado = false;
			if (!ValidarDatosProducto.validateCode(lb.txt_entrada3.getText(), tm_productos))
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

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
}
