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
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.BorderLayout;

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
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 349);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(128, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelbase = new JPanel();
		panelbase.setForeground(Color.WHITE);
		panelbase.setBackground(new Color(128, 0, 255));
		panelbase.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panelbase);
		panelbase.setLayout(new BoxLayout(panelbase, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panelbase.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panelbase.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(128, 0, 255));
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(new Color(128, 0, 255));
		panel_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		btn_agregar = new JButton("New button");
		btn_agregar.setForeground(Color.WHITE);
		btn_agregar.setBackground(new Color(0, 102, 255));
		panel_2.add(btn_agregar);
		
		btn_guardar = new JButton("New button");
		btn_guardar.setForeground(Color.WHITE);
		btn_guardar.setBackground(new Color(0, 102, 255));
		panel_2.add(btn_guardar);
		
		lbl_titulo = new JLabel("New label");
		lbl_titulo.setForeground(Color.WHITE);
		lbl_titulo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		panel_1.add(lbl_titulo);
		
		lbl_entrada1 = new JLabel("New label");
		lbl_entrada1.setForeground(Color.WHITE);
		panel_1.add(lbl_entrada1);
		
		txt_entrada1 = new JTextField();
		panel_1.add(txt_entrada1);
		txt_entrada1.setColumns(10);
		
		lbl_entrada2 = new JLabel("New label");
		lbl_entrada2.setForeground(Color.WHITE);
		panel_1.add(lbl_entrada2);
		
		txt_entrada2 = new JTextField();
		panel_1.add(txt_entrada2);
		txt_entrada2.setColumns(10);
		
		lbl_entrada3 = new JLabel("New label");
		lbl_entrada3.setForeground(Color.WHITE);
		panel_1.add(lbl_entrada3);
		
		txt_entrada3 = new JTextField();
		panel_1.add(txt_entrada3);
		txt_entrada3.setColumns(10);
		
		lbl_entrada4 = new JLabel("New label");
		lbl_entrada4.setForeground(Color.WHITE);
		panel_1.add(lbl_entrada4);
		
		txt_entrada4 = new JTextField();
		panel_1.add(txt_entrada4);
		txt_entrada4.setColumns(10);
		
		lbl_entrada5 = new JLabel("New label");
		lbl_entrada5.setForeground(Color.WHITE);
		panel_1.add(lbl_entrada5);
		
		txt_entrada5 = new JTextField();
		panel_1.add(txt_entrada5);
		txt_entrada5.setColumns(10);
		
		lbl_entrada6 = new JLabel("New label");
		lbl_entrada6.setForeground(Color.WHITE);
		panel_1.add(lbl_entrada6);
		
		txt_entrada6 = new JTextField();
		panel_1.add(txt_entrada6);
		txt_entrada6.setColumns(10);
		
		lbl_entrada7 = new JLabel("New label");
		lbl_entrada7.setForeground(Color.WHITE);
		panel_1.add(lbl_entrada7);
		
		cbx_entrada7 = new JComboBox();
		panel_1.add(cbx_entrada7);
		
		lbl_estatus = new JLabel("New label");
		lbl_estatus.setForeground(Color.WHITE);
		panel_1.add(lbl_estatus);
	}
	private ImageIcon imagen = new ImageIcon("src/imagen/morado.jpg");

	public void paint(Graphics g) {
		g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
		contentPane.paintComponents(contentPane.getGraphics());
	}
}
