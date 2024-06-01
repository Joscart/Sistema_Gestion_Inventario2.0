package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import modelo.LoginDAO;
import modelo.Usuario;
import vista.Formulario;
import vista.Login;

public class logic_Login implements ActionListener, KeyListener, WindowListener, Dimensiones{

	private Login lb;
	private boolean valido = false;
	private LoginDAO dao_login = new LoginDAO();

	private List<Usuario> list_login = new Vector<>();
	private Usuario tm_Usuario;

	public logic_Login(Login lb) {
		this.lb = lb;
		lb.setBounds(dimensiones_login());
		lb.setDefaultCloseOperation(Login.EXIT_ON_CLOSE);
		listener();
		cargarLogin();
		cargarUsuarios();
		lb.setVisible(true);
	}

	private void listener() {
		lb.txt_usuario.addKeyListener(this);
		lb.txt_contrasenia.addKeyListener(this);
		lb.btn_ingresar.addActionListener(this);
		lb.addWindowListener(this);
	}

	protected ImageIcon createImageIcon(String path,
			String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	public Login getLogin() {
		return lb;
	}

	public Usuario getUsuario() {
		return tm_Usuario;
	}

	public boolean isValido() {
		return valido;
	}

	private void cargarLogin() {
		
		lb.setResizable(false);
		lb.txt_usuario.setText("");
		lb.txt_contrasenia.setText("");
		lb.lbl_titulo.setText("Iniciar sesión");
		lb.lbl_usuario.setText("Usuario");
		lb.lbl_contrasenia.setText("Contraseña");
		lb.btn_ingresar.setText("Iniciar sesión");
	}

	private void cargarUsuarios() {
		try {
			list_login = dao_login.leerDB();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean validarUsuario(String usuario, char[] contrasenia) {
		for (Usuario u : list_login) {
			if (u.getUsuario().equals(usuario) && u.getContrasena().equals(String.valueOf(contrasenia))) {
				this.tm_Usuario = u;
				return true;
			}
		}
		return false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lb.txt_usuario && e.getKeyChar() == KeyEvent.VK_ENTER) {
			lb.txt_contrasenia.requestFocus();
		} else if (e.getSource() == lb.txt_contrasenia && e.getKeyChar() == KeyEvent.VK_ENTER) {
			lb.btn_ingresar.doClick();	
		}
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
		if (e.getSource() == lb.btn_ingresar) {
			valido = validarUsuario(lb.txt_usuario.getText(), lb.txt_contrasenia.getPassword());
			if(valido) {
				JOptionPane.showMessageDialog(lb, "Bienvenido", "Ingreso exitoso", JOptionPane.INFORMATION_MESSAGE);
				lb.setDefaultCloseOperation(Login.DISPOSE_ON_CLOSE);
				lb.dispatchEvent(new WindowEvent(lb, WindowEvent.WINDOW_CLOSING));
			} else {
				JOptionPane.showMessageDialog(lb, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
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
