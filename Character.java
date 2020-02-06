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

public class Character extends JLabel implements KeyListener, ActionListener 
{
	private ImageIcon iconleft;
	private ImageIcon iconup;
	private ImageIcon iconslap2;
	int dx = 0;
	int dy = 0;
	double yaccel = 100;
	private HP health;
	private MP mana;
	private Timer t;
	private int time;
	boolean wait = true;
	boolean turn = false;
	boolean ground = true;

	public Character() 
	{
		health = new HP(400);
		mana = new MP(300);

		iconleft = new ImageIcon("C:/Users/Celeste/eclipse-workspace/CSC 405/src/alert_0.png");
		iconup = new ImageIcon("C:/Users/Celeste/eclipse-workspace/CSC 405/src/fly_0.png");
		iconslap2 = new ImageIcon("C:/Users/Celeste/eclipse-workspace/CSC 405/src/stabO1_0.png");

		setIcon(iconleft);
		setBounds(350,250,200,200);
		setVisible(true);

		System.out.println(health);
	}

	public int getHP()
	{
		return health.getHP();
	}

	public int getMP()
	{
		return mana.getMP();
	}

	public void Left()
	{
		if(350+dx>=0)
		{
			dx = dx - 50;
			setBounds(350+dx,250-dy,200,200);
		}

		if (350+dx <0)
			try {
				// Open an audio input stream.
				File soundFile = new File("C:/Users/Celeste/eclipse-workspace/CSC 405/src/Wall.wav");
				AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
				// Get a sound clip resource.
				Clip clip = AudioSystem.getClip();
				// Open audio clip and load samples from the audio input stream.
				clip.open(audioIn);
				clip.start();
			} catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			}
	}
	public boolean canLeft()
	{
		return(350+dx>=0); 
	}

	public void Right()
	{
		if(350+dx<=670)
		{
			dx = dx + 50;
			setBounds(350+dx,250-dy,200,200);
		}
		if(350+dx>670)
			try {
				// Open an audio input stream.
				File soundFile = new File("C:/Users/Celeste/eclipse-workspace/CSC 405/src/Wall.wav");
				AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
				// Get a sound clip resource.
				Clip clip = AudioSystem.getClip();
				// Open audio clip and load samples from the audio input stream.
				clip.open(audioIn);
				clip.start();
			} catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			}
	}

	public void Up()
	{
		ground = false;
		if (wait)														
		{
			yaccel = .005;
			setIcon(iconup);

			t = new Timer(10,this);
			t.start();   

			time=50;

			try {
				// Open an audio input stream.
				File soundFile = new File("C:/Users/Celeste/eclipse-workspace/CSC 405/src/Jump.wav");
				AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
				// Get a sound clip resource.
				Clip clip = AudioSystem.getClip();
				// Open audio clip and load samples from the audio input stream.
				clip.open(audioIn);
				clip.start();
			} catch (UnsupportedAudioFileException a) {
				a.printStackTrace();
			} catch (IOException a) {
				a.printStackTrace();
			} catch (LineUnavailableException a) {
				a.printStackTrace();
			}
		} 
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		wait=false;
		if(!turn)
		{
			time--;
			dy =  (int) (dy + 0.5*yaccel*java.lang.Math.pow(time,2));
			setBounds(350+dx,250-dy,200,200);
			System.out.println(time);
			System.out.println("BOOGERS" + (250-dy));
		}
		if(time==0)
		{
			t.stop();
			turn=!turn;
		}
		if(turn)
		{
			t.start();
			time++;
			dy =  (int) (dy + 0.5*-yaccel*java.lang.Math.pow(time,2));
			setBounds(350+dx,250-dy,200,200);
			System.out.println(time);


			if (dy<0)
			{
				ground = true;
			}
		}

		if(ground)														
		{
			t.stop();
			turn=!turn;
			wait=true;
			setIcon(iconleft);
		}    	
	}   

	public void Recover()
	{
		dx = 0;
		dy = 0;
		setBounds(350+dx,250+dy,200,200);
	}

	public void Down()
	{
		//dy = dy + 10;
		//setBounds(350+dx,250+dy,200,200);
	}

	public void Floor()
	{
		ground=true;
	}

	public void Fall()
	{
		//dy = dy + 50;
		//setBounds(350+dx,250+dy,200,200);
		setIcon(iconleft);
	}

	public void Hit()
	{
		if(getMP()-30>=0)
		{
			try {
				// Open an audio input stream.
				File soundFile = new File("C:/Users/Celeste/eclipse-workspace/CSC 405/src/pow.wav");
				AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
				// Get a sound clip resource.
				Clip clip = AudioSystem.getClip();
				// Open audio clip and load samples from the audio input stream.
				clip.open(audioIn);
				clip.start();
			} catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			}
			setIcon(iconslap2);
			mana.MPMinus(30);
		}
	}

	public void BounceBack()
	{
		setIcon(iconleft);
		health.HPMinus(30);
		try {
			// Open an audio input stream.
			File soundFile = new File("C:/Users/Celeste/eclipse-workspace/CSC 405/src/Scream.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			// Get a sound clip resource.
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void Idle()
	{
		setIcon(iconleft);
	}

	public boolean MiddleCheck()
	{
		return(350+dx==350);
	}
	
	public int playerX()
	{
		return (350+dx);
	}
	
	public int playerY()
	{
		return (250+dy);
	}

	public void Die()
	{
		health.setHP(0);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}