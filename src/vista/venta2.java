package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.Graphics;

public class venta2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					venta2 frame = new venta2();
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
	public venta2() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][grow][grow]", "[][][grow][grow][grow]"));
		
		JLabel lblNewLabel_2 = new JLabel("Agregar ventas");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 27));
		contentPane.add(lblNewLabel_2, "cell 1 0 2 1");
		
		JLabel lblNewLabel = new JLabel("Agregar cantidad de venta");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(lblNewLabel, "cell 0 1,aligny center");
		
		JSpinner spinner = new JSpinner();
		contentPane.add(spinner, "cell 1 1,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Total:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		contentPane.add(lblNewLabel_1, "cell 0 2");
		
		JLabel lblNewLabel_4 = new JLabel("");
		contentPane.add(lblNewLabel_4, "cell 1 2");
		
		JButton btnNewButton = new JButton("Finalizar");
		contentPane.add(btnNewButton, "cell 1 4");
		
		JButton btnNewButton_1 = new JButton("Guardar");
		contentPane.add(btnNewButton_1, "cell 2 4");
	}
	private ImageIcon imagen = new ImageIcon("src/imagen/morado.jpg");

	public void paint(Graphics g) {
		g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
		contentPane.paintComponents(contentPane.getGraphics());
	}
}
