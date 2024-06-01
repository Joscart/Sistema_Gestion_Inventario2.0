package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.logic_Menu;

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
					//frame.setVisible(true);
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
		contentPane.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		lblNewLabel = new JLabel("BIENVENIDOS");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 37));
		contentPane.add(lblNewLabel, "cell 3 0,alignx center,aligny center");
		
		btn_boton1 = new JButton("Cliente");
		contentPane.add(btn_boton1, "cell 0 2,grow");
		
		btn_boton2 = new JButton("Proveedor");
		contentPane.add(btn_boton2, "cell 2 2,grow");
		
		btn_boton3 = new JButton("Productos");
		contentPane.add(btn_boton3, "cell 4 2,grow");
		
		btn_boton4 = new JButton("Ventas");
		contentPane.add(btn_boton4, "cell 6 2,grow");
		
		btn_salir = new JButton("Salir");
		contentPane.add(btn_salir, "cell 6 7,alignx right,aligny bottom");
		
		logic_Menu logica = new logic_Menu(this);
	}
	private ImageIcon imagen = new ImageIcon("Datos/Recursos/floppa.gif");

	public void paint(Graphics g) {
		g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
		contentPane.paintComponents(contentPane.getGraphics());
	}

}
