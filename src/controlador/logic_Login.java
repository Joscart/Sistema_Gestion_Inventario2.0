package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JOptionPane;

import vista.Login;
import modelo.Usuario;

public class logic_Login implements ActionListener, KeyListener, Dimensiones{

	private Login lb;
	private List<Usuario> list_Usuarios = null;
	private Usuario tm_Usuario = null;

	boolean valido = false;

	public logic_Login(Login lb) {
		this.lb = lb;
		lb.setBounds(dimensiones_login());
		listener();
	}
	
	private void listener() {
		lb.txt_usuario.addKeyListener(this);
		lb.txt_contrasenia.addKeyListener(this);
		lb.btn_ingresar.addActionListener(this);
	}	

	public boolean isValido() {
		return valido;
	}

	public Usuario getUsuario() {
		return tm_Usuario;
	}

	public void setUsuarios(List<Usuario> listaUsuarios) {
		this.list_Usuarios = listaUsuarios;
	}

	public boolean validar(String usuario, char[] contrasenia) {
		if (list_Usuarios != null) {
			for (Usuario u : list_Usuarios) {
				if (u == null) continue;
				if (u.getUsuario().equals(usuario) && u.getContrasena().equals(String.valueOf(contrasenia))) {
					tm_Usuario = u;
					valido = true;
					JOptionPane.showMessageDialog(null, "Bienvenido " + tm_Usuario.getUsuario());
					return valido;
				}
			}
		}
		valido = false;
		tm_Usuario = null;
		JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
		return valido;
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lb.txt_usuario && e.getKeyChar() == KeyEvent.VK_ENTER) {
			lb.txt_contrasenia.requestFocus();
		} else if (e.getSource() == lb.txt_contrasenia && e.getKeyChar() == KeyEvent.VK_ENTER) {
			lb.btn_ingresar.doClick();
		}	
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == lb.btn_ingresar) {
			if (validar(lb.txt_usuario.getText(), lb.txt_contrasenia.getPassword())) {
				lb.setDefaultCloseOperation(Login.DISPOSE_ON_CLOSE);
				lb.dispatchEvent(new WindowEvent(lb, WindowEvent.WINDOW_CLOSING));
			}
		}
	}

}
