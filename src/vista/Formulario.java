package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Font;

public class Formulario extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField txt_entrada1;
	public JTextField txt_entrada2;
	public JTextField txt_entrada3;
	public JTextField txt_entrada4;
	public JTextField txt_entrada5;
	public JTextField txt_entrada6;
	public JLabel lbl_entrada1;
	public JLabel lbl_entrada2;
	public JLabel lbl_entrada3;
	public JLabel lbl_entrada4;
	public JLabel lbl_entrada5;
	public JLabel lbl_entrada6;
	public JLabel lbl_entrada7;
	public JComboBox cbx_entrada7;
	public JTextArea txt_informacion;
	public JLabel lbl_estatus;
	public JButton btn_agregar;
	public JButton btn_guardar;
	public JLabel lbl_titulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
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
	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[57.00][172.00][grow][131.00,grow][65.00,grow]", "[][grow][grow][grow][grow][grow][grow][grow][grow][][grow][grow][grow]"));
		
		lbl_titulo = new JLabel("New label");
		lbl_titulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		contentPane.add(lbl_titulo, "cell 1 0");
		
		lbl_entrada1 = new JLabel("New label");
		contentPane.add(lbl_entrada1, "flowx,cell 0 2,alignx leading");
		
		txt_entrada1 = new JTextField();
		contentPane.add(txt_entrada1, "cell 1 2,growx");
		txt_entrada1.setColumns(10);
		
		txt_informacion = new JTextArea();
		contentPane.add(txt_informacion, "cell 3 2 2 7,grow");
		
		lbl_entrada2 = new JLabel("New label");
		contentPane.add(lbl_entrada2, "cell 0 3,alignx leading");
		
		txt_entrada2 = new JTextField();
		contentPane.add(txt_entrada2, "cell 1 3,growx");
		txt_entrada2.setColumns(10);
		
		lbl_entrada3 = new JLabel("New label");
		contentPane.add(lbl_entrada3, "cell 0 4,alignx leading");
		
		txt_entrada3 = new JTextField();
		contentPane.add(txt_entrada3, "cell 1 4,growx");
		txt_entrada3.setColumns(10);
		
		lbl_entrada4 = new JLabel("New label");
		contentPane.add(lbl_entrada4, "cell 0 5,alignx leading");
		
		txt_entrada4 = new JTextField();
		contentPane.add(txt_entrada4, "cell 1 5,growx");
		txt_entrada4.setColumns(10);
		
		lbl_entrada5 = new JLabel("New label");
		contentPane.add(lbl_entrada5, "cell 0 6,alignx leading");
		
		txt_entrada5 = new JTextField();
		contentPane.add(txt_entrada5, "cell 1 6,growx");
		txt_entrada5.setColumns(10);
		
		lbl_entrada6 = new JLabel("New label");
		contentPane.add(lbl_entrada6, "cell 0 7");
		
		txt_entrada6 = new JTextField();
		contentPane.add(txt_entrada6, "cell 1 7,growx");
		txt_entrada6.setColumns(10);
		
		lbl_entrada7 = new JLabel("New label");
		contentPane.add(lbl_entrada7, "cell 0 8");
		
		lbl_estatus = new JLabel("New label");
		contentPane.add(lbl_estatus, "cell 0 10,alignx leading");
		
		cbx_entrada7 = new JComboBox();
		contentPane.add(cbx_entrada7, "cell 1 10,growx,aligny baseline");
		
		btn_agregar = new JButton("New button");
		contentPane.add(btn_agregar, "cell 3 10,alignx leading");
		
		btn_guardar = new JButton("New button");
		contentPane.add(btn_guardar, "cell 4 10,alignx trailing");
		
		
		
	}
}
