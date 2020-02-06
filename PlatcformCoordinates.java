//PLATFORM COORDS TEST CLASS
//attach platforms[] to background - make platforms[] an instance variable of background
//add scroll methods to platform

package dasher;


import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlatcformCoordinates extends JLabel{
	
	ImageIcon img;
	ImageIcon gif;
	
	public PlatcformCoordinates()
	{
		img = new ImageIcon("ExieBackground.jpg");	
		gif = new ImageIcon("Fire-Free-PNG-Image.gif");//if you can get the gif working, it can be put at t he bottom of the display
	}
	public void paint(Graphics g) {
		g.drawImage(img.getImage(), 0, 0, this );
		//g.drawImage(gif.getImage(),1024,0 this );
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		g.drawString("Tutorial", 450, 50);
		g.fillRect(10, 200, 75, 10);
		g.fillRect(120, 180, 75, 10);
		g.fillRect(250, 325, 75, 10);
		g.fillRect(310, 300, 75, 10);
		g.fillRect(370, 275, 75, 10);
		g.fillRect(430, 250, 75, 10);
		g.fillRect(490, 225, 534, 10);
	}
	public static void main(String[]args)
	{
		PlatcformCoordinates p = new PlatcformCoordinates(); 
		JFrame f = new JFrame();
		f.setSize(1024, 500);
		f.add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}

