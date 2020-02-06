package dasher;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameOverPanel extends JPanel
{
	private long Time;

	public GameOverPanel(long Time)
	{
		setLayout(null);
		setSize(800,700);
		setOpaque(true);		
		setVisible(true);
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
		g.drawString("...your com sci project is full of bugs :( Time = " + Long.toString(Time*20), 150, 400);
		g.drawString("Press 0 to restart." , 150, 500);
	}

	public void SetTime(long temp) 
	{	
		Time = temp;
	}


}