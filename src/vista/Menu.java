package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	public JButton btn_boton1;
	public JButton btn_boton2;
	public JButton btn_boton3;
	public JButton btn_boton4;
	public JButton btn_salir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[43.00][grow][grow][grow][grow][][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel lblNewLabel = new JLabel("BIENVENIDOS");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 37));
		contentPane.add(lblNewLabel, "cell 4 0,alignx center,aligny center");
		
		JButton btn_boton1 = new JButton("Cliente");
		btn_boton1.setBackground(Color.WHITE);
		btn_boton1.setForeground(new Color(0, 0, 128));
		btn_boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formulario newframe=new Formulario();
				newframe.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/imagen/icon.png")));
		contentPane.add(lblNewLabel_1, "cell 0 2");
		contentPane.add(btn_boton1, "cell 1 2,grow");
		
		JButton btn_boton2 = new JButton("Proveedor");
		btn_boton2.setBackground(Color.WHITE);
		btn_boton2.setForeground(new Color(0, 0, 128));
		btn_boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formulario newframe=new Formulario();
				newframe.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Menu.class.getResource("/imagen/proveedor.png")));
		contentPane.add(lblNewLabel_2, "cell 2 2,alignx right");
		contentPane.add(btn_boton2, "cell 3 2,grow");
		
		JButton btn_boton3 = new JButton("Productos");
		btn_boton3.setBackground(Color.WHITE);
		btn_boton3.setForeground(new Color(0, 0, 128));
		btn_boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formulario newframe=new Formulario();
				newframe.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Menu.class.getResource("/imagen/productos.png")));
		contentPane.add(lblNewLabel_3, "cell 5 2,alignx right");
		contentPane.add(btn_boton3, "cell 6 2,grow");
		
		JButton btn_boton4 = new JButton("Ventas");
		btn_boton4.setBackground(Color.WHITE);
		btn_boton4.setForeground(new Color(0, 0, 128));
		btn_boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Formulario newframe=new Formulario();
				newframe.setVisible(true);
			}
		});
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Menu.class.getResource("/imagen/ventas.png")));
		contentPane.add(lblNewLabel_4, "cell 7 2,alignx right");
		contentPane.add(btn_boton4, "cell 8 2,grow");
		
		JButton btn_boton5 = new JButton("Salir");
		btn_boton5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_boton5.setBackground(Color.WHITE);
		btn_boton5.setForeground(new Color(0, 0, 128));
		btn_boton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(WIDTH);
			}
		});
		contentPane.add(btn_boton5, "cell 8 7,growx");
	}
	private ImageIcon imagen = new ImageIcon("src/imagen/dark-blue-stripes-geometric-overlapping-background-free-vector.jpg");

	public void paint(Graphics g) {
		g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
		contentPane.paintComponents(contentPane.getGraphics());
	}

}
