package dasher;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.Timer;

public class InfoPanel extends JPanel implements ActionListener {

	private Timer t;
	private Timer s;
	private int hp;
	private int mp;
	private Character player;
	private long elapsedTime;
	private boolean proceed = true;

	public InfoPanel(Character temp)						//the bar at the bottom of the screen
	{

		player = new Character();
		player = temp;
		setLayout(null);
		setSize(800,100);
		setOpaque(true);

		t = new Timer(20,this);
		t.start();

		setVisible(true); 

	}
	
	public void fproceed()
	{
		proceed=false;
	}
	
	public void tproceed()
	{
		proceed=true;
	}
	
	public void paint(Graphics g) 
	{	
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 800, 100);
		g.setColor(Color.RED);
		g.drawRect(50, 10, 400, 25); 	
		g.fillRect(50, 10, player.getHP(), 25);					//display hp
		g.drawString("HP",15,30); 
		g.setColor(Color.BLUE);
		g.drawRect(50, 35, 300, 15); 
		g.fillRect(50, 35, player.getMP(), 15);					//display mp
		g.drawString("MP",15,48); 
		g.setFont(new Font("Calibri", Font.PLAIN, 25)); 
		g.drawString("TIME: " + Long.toString((elapsedTime*20)), 600, 50);      //display time
		
		if (!proceed)
		{
			g.setColor(Color.BLACK);
			g.setFont(new Font("Calibri", Font.PLAIN, 12)); 
			g.drawString("CANNOT PROCEED TILL ALL BUGS ARE KILLED :(", 500, 20);
		}
	}

	public void StopTimer() 
	{	
		t.stop();
	}

	public long GetTime() 
	{	
		return elapsedTime;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		repaint();
		elapsedTime++;
	}

}
