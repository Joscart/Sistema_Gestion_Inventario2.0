package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Component;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel lbl_titulo;
	private JPanel panel;
	public JLabel lbl_usuario;
	public JTextField txt_usuario;
	private JPanel panel_1;
	private JPanel panel_2;
	public JButton btn_ingresar;
	public JLabel lbl_contrasenia;
	public JPasswordField txt_contrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		lbl_titulo = new JLabel("Inicio de Sesion");
		contentPane.add(lbl_titulo);
		
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		lbl_usuario = new JLabel("Usuario");
		panel.add(lbl_usuario);
		
		txt_usuario = new JTextField();
		txt_usuario.setColumns(20);
		panel.add(txt_usuario);
		
		panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_1);
		
		lbl_contrasenia = new JLabel("Contraseña");
		panel_1.add(lbl_contrasenia);
		
		txt_contrasenia = new JPasswordField();
		txt_contrasenia.setColumns(20);
		panel_1.add(txt_contrasenia);
		
		panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_2);
		
		btn_ingresar = new JButton("Ingresar");
		panel_2.add(btn_ingresar);
	}
	
}
