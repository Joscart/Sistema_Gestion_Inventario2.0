package controlador;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.LoginDAO;
import modelo.Usuario;
import modelo.Usuario.TIPO_USUARIO;
import vista.Formulario;
import vista.Gestion;
import vista.Login;
import vista.Menu;

public class logic_Menu implements ActionListener, WindowListener, Dimensiones{

	private Menu lb;
	private logic_Gestion lb_gestion = new logic_Gestion(new Gestion());
	private logic_Login lb_login;
	
	private Usuario tm_Usuario;
	
	public enum VENTANA_TIPO{
		CLIENTE,PROVEEDOR,PRODUCTO,VENTA
	};
	
	public logic_Menu(Menu lb) {
		this.lb = lb;
		login();
		lb.setBounds(POS_X,POS_Y,ANCHO,ALTO);
		lb.setDefaultCloseOperation(Menu.EXIT_ON_CLOSE);
		listener();
		cargarMenu();
	}
	
	private void listener() {
		lb.btn_boton1.addActionListener(this);
		lb.btn_boton2.addActionListener(this);
		lb.btn_boton3.addActionListener(this);
		lb.btn_boton4.addActionListener(this);
		lb.btn_salir.addActionListener(this);
		lb.addWindowListener(this);
	}
	
	private void cargarMenu() {
		lb.btn_boton1.setText("Clientes");
		lb.btn_boton2.setText("Proveedores");
		lb.btn_boton3.setText("Productos");
		lb.btn_boton4.setText("Ventas");
	}
	
	private void login() {
		lb.setVisible(false);
		lb_login = new logic_Login(new Login());
		lb_login.getLogin().addWindowListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lb.btn_boton1) {
			lb_gestion.setTipo(VENTANA_TIPO.CLIENTE);
		} else if (e.getSource() == lb.btn_boton2) {
			lb_gestion.setTipo(VENTANA_TIPO.PROVEEDOR);
		} else if (e.getSource() == lb.btn_boton3) {
			lb_gestion.setTipo(VENTANA_TIPO.PRODUCTO);
		} else if (e.getSource() == lb.btn_boton4) {
			lb_gestion.setTipo(VENTANA_TIPO.VENTA);
		} else if (e.getSource() == lb.btn_salir) {
			lb.dispatchEvent(new WindowEvent(lb, WindowEvent.WINDOW_CLOSING));
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lb_login.getLogin() && lb_login.isValido()) {
			this.tm_Usuario = lb_login.getUsuario();
			lb.setVisible(true);
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
