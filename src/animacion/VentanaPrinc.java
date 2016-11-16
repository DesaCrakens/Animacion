package animacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaPrinc extends JFrame {

	private PanelPrinc panPrinc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrinc frame = new VentanaPrinc();
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
	public VentanaPrinc() {
		setTitle("Marcianito 100% real no fake");
		setSize(350,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panPrinc = new PanelPrinc();
		panPrinc.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panPrinc);
		panPrinc.setLayout(null);
	}
}
