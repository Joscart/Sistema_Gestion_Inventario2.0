package controlador;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controlador.SesionActual.VENTANA_TIPO;
import modelo.Administrador;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Producto;
import modelo.Proveedor;
import vista.Gestion;

public class logic_Gestion implements ActionListener, KeyListener, ListSelectionListener, Dimensiones{
	
	private Gestion lb;
	private DataAccess tm_datos;
	private boolean guardado = true;
	private boolean activo = false;
	private JButton btn_activo  = null;
	
	private Cliente tm_usuario;
	private Proveedor tm_proveedor;
	private Producto tm_producto;
	
	private VENTANA_TIPO tipo;
	
	public logic_Gestion(Gestion lb) {
		this.lb = lb;
		listener();
	}
	
	private void listener() {
		lb.txt_busqueda.addKeyListener(this);
		lb.lst_resultados.addListSelectionListener(this);
		lb.btn_buscar.addActionListener(this);
		lb.btn_editar.addActionListener(this);
		lb.btn_eliminar.addActionListener(this);
		lb.btn_guardar.addActionListener(this);
		lb.btn_nuevo.addActionListener(this);
	}
	
	public void setDatos(DataAccess datos) {
		this.tm_datos = datos;
	}
	
	public VENTANA_TIPO getTipo() {
		return tipo;
	}

	public boolean setTipo(VENTANA_TIPO tipo) {
		this.tipo = tipo;
		guardado = true;
		cargarGestion();
		return true;
	}
	
	public boolean isGuardado() {
		return guardado;
	}
	
	public void setGuardado(boolean guardado) {
		this.guardado = guardado;
	}
	
	public boolean isActivo() {
		return activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public void setBotonActivo(JButton btn) {
		this.btn_activo = btn;
	}
	
	public Cliente getCliente() {
		return tm_usuario;
	}
	
	public Proveedor getProveedor() {
		return tm_proveedor;
	}
	
	public Producto getProducto() {
		return tm_producto;
	}
	
	public JButton getBotonActivo() {
		return btn_activo;
	}
	
	private void reset() {
		lb.btn_buscar.setText("");
		lb.btn_editar.setText("");
		lb.btn_eliminar.setText("");
		lb.btn_guardar.setText("");
		lb.btn_nuevo.setText("");
		lb.lst_resultados.removeAll();
		lb.txt_busqueda.setText("");
		lb.txt_informacion.setText("");
		lb.btn_buscar.setVisible(true);
		lb.btn_editar.setVisible(true);
		lb.btn_eliminar.setVisible(true);
		lb.btn_guardar.setVisible(true);
		lb.btn_nuevo.setVisible(true);
		lb.lst_resultados.setVisible(true);
		lb.txt_busqueda.setVisible(true);
		lb.txt_informacion.setVisible(true);
		lb.btn_buscar.setEnabled(true);
		lb.btn_editar.setEnabled(false);
		lb.btn_eliminar.setEnabled(false);
		lb.btn_guardar.setEnabled(true);
		lb.btn_nuevo.setEnabled(true);
		lb.lst_resultados.setEnabled(true);
		lb.txt_busqueda.setEnabled(true);
		lb.txt_informacion.setEditable(false);
	}

	
	public void cargarGestion() {
		reset();
		lb.setBounds(dimensiones_gestion(tipo));

		switch (tipo) {
		case CLIENTE:
			lb.setTitle("Usuarios");
			lb.btn_buscar.setText("Buscar Usuario");
			lb.btn_editar.setText("Editar Usuario");
			lb.btn_eliminar.setText("Eliminar Usuario");
			lb.btn_guardar.setText("Guardar Usuarios");
			lb.btn_nuevo.setText("Nuevo Usuario");
			lb.lst_resultados.setListData(tm_datos.getClientes().toArray());
			break;
		case PROVEEDOR:
			lb.setTitle("Proveedores");
			lb.btn_buscar.setText("Buscar Proveedor");
			lb.btn_editar.setText("Editar Proveedor");
			lb.btn_eliminar.setText("Eliminar Proveedor");
			lb.btn_guardar.setText("Guardar Proveedor");
			lb.btn_nuevo.setText("Nuevo Proveedor");
			lb.lst_resultados.setListData(tm_datos.getProveedores().toArray());
			break;
		case PRODUCTO:
			lb.setTitle("Productos");
			lb.btn_buscar.setText("Buscar Producto");
			lb.btn_editar.setText("Editar Producto");
			lb.btn_eliminar.setText("Eliminar Producto");
			lb.btn_guardar.setText("Guardar Producto");
			lb.btn_nuevo.setText("Nuevo Producto");
			lb.lst_resultados.setListData(tm_datos.getProductos().toArray());
			break;
		default:
			break;
		}
	}
	
	public void actualizarListas() {
		switch (tipo) {
		case CLIENTE:
			lb.lst_resultados.setListData(tm_datos.getClientes().toArray());
			break;
		case PROVEEDOR:
			lb.lst_resultados.setListData(tm_datos.getProveedores().toArray());
			break;
		case PRODUCTO:
			lb.lst_resultados.setListData(tm_datos.getProductos().toArray());
			break;
		default:
			break;
		}
	}
	
	public void actualizarInformacion() {
		if (lb.lst_resultados.getSelectedValue() == null) {
			lb.txt_informacion.setText("");
			return;
		}

		switch (tipo) {
		case CLIENTE:
			if(tm_usuario == null) return;
			lb.txt_informacion
			.setText(String.format("Nombre: %s\nDireccion: %s\nCedula: %s\nTelefono: %s\nCorreo: %s\nTipo: %s",
					tm_usuario.getNombre(), tm_usuario.getDireccion(), tm_usuario.getCedula(), tm_usuario.getTelefono(),
					tm_usuario.getCorreo(), tm_usuario instanceof Administrador ? "Administrador" : tm_usuario instanceof Empleado ? "Empleado" : "Cliente"));
			break;
		case PROVEEDOR:
			if(tm_proveedor == null) return;
			lb.txt_informacion
			.setText(String.format("Nombre: %s\nCorreo: %s\nCedula: %s\nCodigo: %s\nTelefono: %s\nRazon Social: %s",
					tm_proveedor.getNombreCompleto(), tm_proveedor.getEmail(), tm_proveedor.getDni(), tm_proveedor.getCodigo(),
					tm_proveedor.getTelefono(), tm_proveedor.getRazonSocial()));
			break;
		case PRODUCTO:
			if(tm_producto == null) return;
			lb.txt_informacion
			.setText(String.format("Nombre: %s\nDescripcion: %s\nCodigo: %s\nPrecio: %.2f\nStock: %d\nProveedor: %s",
					tm_producto.getname(), tm_producto.getDesc(), tm_producto.getCodigo(), tm_producto.getprecio(),
					tm_producto.getstock(), tm_producto.getproveedor().getNombreCompleto()));
			break;
		default:
			break;
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lb.lst_resultados) {
			if(lb.lst_resultados.getSelectedValue() != null){
			switch (tipo) {
			case CLIENTE:
				tm_usuario =  tm_datos.getClientes().get(tm_datos.getClientes().indexOf(lb.lst_resultados.getSelectedValue()));
				break;
			case PROVEEDOR:
				tm_proveedor = tm_datos.getProveedores().get(tm_datos.getProveedores().indexOf(lb.lst_resultados.getSelectedValue()));
				break;
			case PRODUCTO:
				tm_producto = tm_datos.getProductos().get(tm_datos.getProductos().indexOf(lb.lst_resultados.getSelectedValue()));
				break;
			default:
				break;
			}
			actualizarInformacion();
			lb.btn_editar.setEnabled(true);
			lb.btn_eliminar.setEnabled(true);
			} else {
				tm_usuario = null;
				tm_proveedor = null;
				tm_producto = null;
				actualizarInformacion();
				lb.btn_editar.setEnabled(false);
				lb.btn_eliminar.setEnabled(false);
			}
		}
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
		if (e.getSource() == lb.btn_buscar) {
			switch (tipo) {
			case CLIENTE:
				lb.lst_resultados.setListData(tm_datos.getClientes().stream()
						.filter(c -> c.getNombre().toLowerCase().contains(lb.txt_busqueda.getText().toLowerCase()))
						.toArray());
				break;
			case PROVEEDOR:
				lb.lst_resultados.setListData(tm_datos.getProveedores().stream().filter(
						p -> p.getNombreCompleto().toLowerCase().contains(lb.txt_busqueda.getText().toLowerCase()))
						.toArray());
				break;
			case PRODUCTO:
				lb.lst_resultados.setListData(tm_datos.getProductos().stream()
						.filter(p -> p.getname().toLowerCase().contains(lb.txt_busqueda.getText().toLowerCase()))
						.toArray());
				break;
			default:
				break;
			}
		} else if (e.getSource() == lb.btn_editar) {
			activo = true;
			guardado = false;
			btn_activo = lb.btn_editar;
			lb.dispatchEvent(new WindowEvent(lb, WindowEvent.WINDOW_CLOSING));
		} else if (e.getSource() == lb.btn_eliminar) {
			guardado = false;
			if (JOptionPane.showConfirmDialog(lb, "¿Desea eliminar el elemento seleccionado?", "Confirmar Eliminacion",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				switch (tipo) {
				case CLIENTE:
					tm_datos.remove(tm_datos.getClientes().get(lb.lst_resultados.getSelectedIndex()));
					break;
				case PROVEEDOR:
					tm_datos.remove(tm_datos.getProveedores().get(lb.lst_resultados.getSelectedIndex()));
					break;
				case PRODUCTO:
					tm_datos.remove(tm_datos.getProductos().get(lb.lst_resultados.getSelectedIndex()));
					break;
				default:
					break;
				}
				actualizarListas();
				actualizarInformacion();
			}
		} else if (e.getSource() == lb.btn_guardar) {
			Thread guardar = new Thread(tm_datos);
			guardar.start();
			guardado = true;
			JOptionPane.showMessageDialog(lb, "Guardado con exito", "Guardado", JOptionPane.INFORMATION_MESSAGE);
		} else if (e.getSource() == lb.btn_nuevo) {
			activo = true;
			guardado = false;
			btn_activo = lb.btn_nuevo;
			tm_usuario = null;
			tm_proveedor = null;
			tm_producto = null;
			lb.dispatchEvent(new WindowEvent(lb, WindowEvent.WINDOW_CLOSING));
		}
	}
}
