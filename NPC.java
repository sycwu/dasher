package dasher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

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

public class NPC extends JLabel implements ActionListener 
{
	private Timer t;
	int frameNum;
	private ImageIcon bugsRest;
	private ImageIcon bugsHit;
	int dx = 0;
	int dy = 0;
	private int health;
	private boolean canscrollL = true;
	private boolean canscrollR = true;
	private int x;
	private int y = 300;
	private int width = 125;
	private int height = 95;
	private Character player;
	
	public NPC (int startX)
	{
		x = startX;
		health = 100;
		player = new Character();

		frameNum = 0;				//

		t = new Timer(20,this);		//
		t.start();					//

		bugsRest = new ImageIcon("C:/Users/Celeste/eclipse-workspace/CSC 405/src/BugRest.png");
		setBounds(x,y,width,height);

		bugsHit = new ImageIcon("C:/Users/Celeste/eclipse-workspace/CSC 405/src/BugHit.png");
		setBounds(x,y,width,height);

		setIcon(bugsHit);
		setIcon(bugsRest);
		setVisible(true);  
		
	}
	
	public int bugX()
	{
		return (x+dx);
	}
	
	public int bugY()
	{
		return (y);
	}
	
	public boolean bugRange()
	{
		if(player.playerX()>=x-25 && player.playerX()<=x+150)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
	public void ScrollLeft()
	{
		
		if(canscrollL)
		{
			System.out.println("BUGS SCROLLING LEFT" + x);
			x = x - 50;
			setBounds(x+dx,y,width,height);
		}
	}

	public void ScrollRight()
	{		
		
		if(canscrollR)
		{
			System.out.println("BUGS SCROLLING RIGHT" + x);
			x = x + 50;
			setBounds(x+dx,y,width,height);
		}
	}

	public boolean ScrollCheckLeft()
	{

		if(x+dx-10>=x)
		{
			canscrollL = true;
		}
		else
		{
			canscrollL = false;
		}
		return canscrollL;
	}

	public boolean ScrollCheckRight()
	{
		if(x+dx+10<=0)
		{
			canscrollR = true;
		}
		else
		{
			canscrollR = false;
		}
		return canscrollR;
	}
	
	public void Idle()
	{
		setIcon(bugsRest);
	}
	
	public int bugHP()
	{
		return health;
	}
	
	public void getHit()
	{		
		setIcon(bugsHit);
		try {
			// Open an audio input stream.
			File soundFile = new File("C:/Users/Celeste/eclipse-workspace/CSC 405/src/Aw.wav");
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
		health = health - 50;
	}
	
	public void attackPlayer()
	{
		player.BounceBack();
	}
	
	public void Die()
	{
		dx = -100000;
		setBounds(x+dx,y,width,height);
		setVisible(false);
	}

	private void remove(ImageIcon bugsRest2) {
		// TODO Auto-generated method stub
		
	}

	public NPC() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main (String args[]) 
	{
		NPC run = new NPC();
	}
}

