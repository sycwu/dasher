package dasher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Monster extends JLabel implements ActionListener 
{
	private ImageIcon BugRest;
	private ImageIcon BugHit;
	private HP health;

	int dx = 0;
	int dy = 0;
	boolean wait = true;
	boolean turn = false;

	public Monster() 
	{
		health = new HP(200);

		BugRest = new ImageIcon("BugRest.png");
		BugHit = new ImageIcon("BugHit.png");

		setIcon(BugRest);
		setBounds(350,250,200,200);
		setVisible(true);
	}

	public int getHP()
	{
		return health.getHP();
	}

	public void BounceBack()
	{
		setIcon(BugRest);
		health.HPMinus(30);
	}

	public void Idle()
	{
		setIcon(BugRest);
	}

	public void Die()
	{
		health.setHP(0);
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
	
	public static void main (String args[]) 
	{
		Monster run = new Monster();
	}
}