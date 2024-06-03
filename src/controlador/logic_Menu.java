package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import controlador.SesionActual.VENTANA_TIPO;
import modelo.Usuario.TIPO_USUARIO;
import vista.Menu;


public class logic_Menu implements ActionListener, Dimensiones{
	
	private Menu lb;
	
	VENTANA_TIPO tipo;
	
	TIPO_USUARIO permisos;
	
	/**
	 * Constructor de la clase.
	 * @param lb Objeto de la clase Menu.
	 */
	public logic_Menu(Menu lb) {
		this.lb = lb;
		lb.setBounds(POS_X,POS_Y,ANCHO,ALTO);
		listener();
	}
	
	private void listener() {
		lb.btn_boton1.addActionListener(this);
		lb.btn_boton2.addActionListener(this);
		lb.btn_boton3.addActionListener(this);
		lb.btn_boton4.addActionListener(this);
		lb.btn_salir.addActionListener(this);
	}
	
	/**
	 * Método para obtener el tipo de ventana.
	 * @return Tipo de ventana.
	 */
	public VENTANA_TIPO getTipo() {
		return tipo;
	}
	
	/**
	 * Método para obtener los permisos del usuario.
	 * @return Permisos del usuario.
	 */
	public TIPO_USUARIO getPermisos() {
		return permisos;
	}
	
	/**
	 * Método para establecer los permisos del usuario.
	 * @param permisos Permisos del usuario.
	 */
	public void setPermisos(TIPO_USUARIO permisos) {
		this.permisos = permisos;
		
		switch (permisos) {
		case ADMINISTRADOR:
			lb.btn_boton1.setEnabled(true);
			lb.btn_boton2.setEnabled(true);
			lb.btn_boton3.setEnabled(true);
			lb.btn_boton4.setEnabled(true);
			break;
		case EMPLEADO:
			lb.btn_boton1.setEnabled(false);
			lb.btn_boton2.setEnabled(false);
			lb.btn_boton3.setEnabled(true);
			lb.btn_boton4.setEnabled(true);
			break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lb.btn_boton1) {
			tipo = VENTANA_TIPO.CLIENTE;
			lb.setDefaultCloseOperation(Menu.HIDE_ON_CLOSE);
			lb.dispatchEvent(new WindowEvent(lb, java.awt.event.WindowEvent.WINDOW_CLOSING));
		} else if (e.getSource() == lb.btn_boton2) {
			tipo = VENTANA_TIPO.PROVEEDOR;
			lb.setDefaultCloseOperation(Menu.HIDE_ON_CLOSE);
			lb.dispatchEvent(new WindowEvent(lb, java.awt.event.WindowEvent.WINDOW_CLOSING));
		} else if (e.getSource() == lb.btn_boton3) {
			tipo = VENTANA_TIPO.PRODUCTO;
			lb.setDefaultCloseOperation(Menu.HIDE_ON_CLOSE);
			lb.dispatchEvent(new WindowEvent(lb, java.awt.event.WindowEvent.WINDOW_CLOSING));
		} else if (e.getSource() == lb.btn_boton4) {
			tipo = VENTANA_TIPO.VENTA;
			lb.setDefaultCloseOperation(Menu.HIDE_ON_CLOSE);
			lb.dispatchEvent(new WindowEvent(lb, java.awt.event.WindowEvent.WINDOW_CLOSING));
		} else if (e.getSource() == lb.btn_salir) {
			lb.setDefaultCloseOperation(Menu.EXIT_ON_CLOSE);
			lb.dispatchEvent(new WindowEvent(lb, java.awt.event.WindowEvent.WINDOW_CLOSING));
		}
	}

}
