package dasher;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameClearPanel extends JPanel implements ActionListener 
{
	private long Time;
	private JButton b1;

	public GameClearPanel (long Time)
	{
		setLayout(null);
		setSize(800,700);
		setOpaque(true);
		setVisible(true);
		
		b1 = new JButton("Click to play again!");

		b1.addActionListener(this);//assign the action to this button
		b1.setBounds(100,100,100,100);//set x,y,width,height of button
	}

	public void paint(Graphics g) 
	{	
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 800, 700);
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 80)); 
		g.drawString("GAME CLEAR!", 100, 350);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30)); 
		System.out.println(Time);
		g.drawString("Nice! You got those pesky bugs :) Time = " + Long.toString(Time*20), 150, 400);
		g.drawString("Press 0 to restart." , 150, 500);
	}

	public void SetTime(long temp) 
	{	
		Time = temp;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}	
}