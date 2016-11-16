package animacion;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PanelPrinc extends JPanel {

	Image marcianitoImg;
	Marcianito miMarcianito = new Marcianito();
	
	public PanelPrinc() {
		ImageIcon marcianito_IMG_ICON = new ImageIcon("marcianito.gif");
		marcianitoImg = marcianito_IMG_ICON.getImage();
		
		prepareImage(marcianitoImg, this);
		miMarcianito.setX(10);
		miMarcianito.setY(10);
		setDoubleBuffered(true);
		new Timer(15, paintTimer).start();
	}
	
	public void paint(Graphics g) {		//este paint es el que usamos para "dibujar" la imagen
		super.paint(g);		//usa paint como JPanel (su padre)
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(marcianitoImg, miMarcianito.getX(), miMarcianito.getY(),this);	//mepa que esto es para poner la imagen en el lugar inicial
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	Action paintTimer = new AbstractAction() {
		
		int tiempocaida = 0;
		boolean creciendo = true;
		
		public void actionPerformed(ActionEvent e) {	//qué hacemos por cada corrida del thread
			if (creciendo)
				miMarcianito.setX(miMarcianito.getX() + 1);
			else
				miMarcianito.setX(miMarcianito.getX() - 1);
			if (miMarcianito.getX() <= 0 || miMarcianito.getX() >= 300)
				creciendo = !creciendo;
			miMarcianito.setY(15*tiempocaida-1*tiempocaida*tiempocaida);	//tiro vertical
			tiempocaida++;
			if(tiempocaida == 20)
				tiempocaida = 0;
			repaint();	//repaint es el que llama a paint(Graphics g) de arriba
		}
	};
}
