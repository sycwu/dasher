package dasher;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class IntroPanel extends JPanel
{
	private long Time;

	public IntroPanel(long Time)
	{
		setLayout(null);
		setSize(800,700);
		setOpaque(true);

	}

	public void paint(Graphics g) 
	{	
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 700);
		g.setColor(Color.RED);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 80)); 
		g.drawString("GAME OVER", 100, 350);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
		System.out.println(Time);
		g.drawString("...you got a dickey :( Time = " + Long.toString(Time), 150, 400);
	}

	public void SetTime(long temp) 
	{	
		Time = temp;
	}
}