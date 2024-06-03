package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.ComponentOrientation;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.UIManager;

public class Gestion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btn_nuevo;
	public JButton btn_eliminar;
	public JTextField txt_busqueda;
	public JButton btn_editar;
	public JButton btn_guardar;
	public JTextPane txt_informacion;
	public JList lst_resultados;
	public JLabel lbl_titulo;
	public JButton btn_buscar;
	
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
		setBounds(new Rectangle(31, 0, 0, 0));
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 831, 447);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(128, 0, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[136.00px,grow][109.00,grow][85.00][][grow][-9.00]", "[58px][grow][grow,baseline][grow,baseline][grow][grow][grow][grow][grow][grow]"));
		
		lbl_titulo = new JLabel("New label");
		lbl_titulo.setForeground(Color.WHITE);
		lbl_titulo.setFont(new Font("Tahoma", Font.PLAIN, 48));
		contentPane.add(lbl_titulo, "cell 1 0 2 1,growx,aligny top");
		
		txt_busqueda = new JTextField();
		txt_busqueda.setBorder(null);
		contentPane.add(txt_busqueda, "cell 0 1 2 1,growx");
		txt_busqueda.setColumns(10);
		
		btn_buscar = new JButton("Buscar");
		btn_buscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_buscar.setBackground(new Color(138, 148, 213));
		btn_buscar.setForeground(Color.WHITE);
		contentPane.add(btn_buscar, "flowy,cell 2 1,alignx left,aligny center");
		
		txt_informacion = new JTextPane();
		contentPane.add(txt_informacion, "cell 3 1 2 4,grow");
		
		lst_resultados = new JList();
		lst_resultados.setBorder(UIManager.getBorder("Button.border"));
		contentPane.add(lst_resultados, "flowx,cell 0 2 2 8,grow");
		
		btn_nuevo = new JButton("Nuevo");
		btn_nuevo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_nuevo.setBackground(new Color(138, 148, 213));
		btn_nuevo.setForeground(Color.WHITE);
		contentPane.add(btn_nuevo, "cell 2 6 2 1,growx");
		
		btn_editar = new JButton("Editar");
		btn_editar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_editar.setBackground(new Color(138, 148, 213));
		btn_editar.setForeground(Color.WHITE);
		contentPane.add(btn_editar, "cell 2 7 2 1,growx");
		
		btn_eliminar = new JButton("Eliminar");
		btn_eliminar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_eliminar.setBackground(new Color(138, 148, 213));
		btn_eliminar.setForeground(Color.WHITE);
		contentPane.add(btn_eliminar, "cell 2 8 2 1,growx");
		
		btn_guardar = new JButton("guardar");
		btn_guardar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_guardar.setBackground(new Color(138, 148, 213));
		btn_guardar.setForeground(Color.WHITE);
		contentPane.add(btn_guardar, "cell 2 9 2 1,growx");
	}
	private ImageIcon imagen = new ImageIcon("src/imagen/morado.jpg");

	public void paint(Graphics g) {
		g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
		contentPane.paintComponents(contentPane.getGraphics());
	}
}
