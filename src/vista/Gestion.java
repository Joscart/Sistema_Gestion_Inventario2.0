package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextPane;
import java.awt.Component;

public class Gestion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField txt_busqueda;
	public JButton btn_buscar;
	public JList lst_resultados;
	public JTextPane txt_informacion;
	public JButton btn_nuevo;
	public JButton btn_editar;
	public JButton btn_eliminar;
	public JButton btn_guardar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestion frame = new Gestion();
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
	public Gestion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		txt_busqueda = new JTextField();
		contentPane.add(txt_busqueda);
		txt_busqueda.setColumns(10);
		
		btn_buscar = new JButton("New button");
		contentPane.add(btn_buscar);
		
		lst_resultados = new JList();
		contentPane.add(lst_resultados);
		
		txt_informacion = new JTextPane();
		contentPane.add(txt_informacion);
		
		btn_nuevo = new JButton("New button");
		contentPane.add(btn_nuevo);
		
		btn_editar = new JButton("New button");
		contentPane.add(btn_editar);
		
		btn_eliminar = new JButton("New button");
		contentPane.add(btn_eliminar);
		
		btn_guardar = new JButton("New button");
		contentPane.add(btn_guardar);
	}

}
