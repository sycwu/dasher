package dasher;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.Timer;

public class AnimationPanel extends JPanel implements ActionListener,KeyListener
{
	private Timer t;
	int frameNum;
	int range;
	private Character player;
	private boolean game=true;
	private boolean restart=false;
	
	private NPC bug1;
	private NPC bug2;
	private NPC bug3;
	private NPC bug4;
	private NPC bug5;
	private NPC bug6;
	private NPC bug7;
	private NPC bug8;
	private NPC bug9;	
	private NPC bug10;	
	
	
	private int bugcount;


	private Background background;

	public AnimationPanel(Character temp)
	{
		setLayout(null);

		setSize(800,500);
		frameNum = 0;
		range = 50;
		
		player = new Character();
		player = temp;
		add(player);

		bug1 = new NPC(-10);
		bug2 = new NPC(-200);
		bug3 = new NPC(-600);
		bug4 = new NPC(-1000);
		bug5 = new NPC(-1500);
		bug6 = new NPC(-1800);
		bug7 = new NPC(-2000);
		bug8 = new NPC(-2500);
		bug9 = new NPC(-3100);
		bug10 = new NPC(-3500);

		
		setVisible(true);

		add(bug1);
		add(bug2);
		add(bug3);
		add(bug4);
		add(bug5);
		add(bug6);
		add(bug7);
		add(bug8);
		add(bug9);
		add(bug10);

		t = new Timer(20,this);
		t.start();

		addKeyListener(this);

		background = new Background();
		add(background);

		setVisible(true);
	}

	public void drawbg()
	{
		add(background);
	}
	
	public void drawNPC()
	{
		add(bug1);
		add(bug2);
		add(bug3);
		add(bug4);
		add(bug5);
		add(bug6);
		add(bug7);
		add(bug8);
		add(bug9);
		add(bug10);
	}
	
	public boolean BugCheck()
	{
		if (bugcount==10)
		{
			return true;
		}	
		return false;
	}
	
	public void drawPlayer()
	{
		add(player);
	}
	
	public void toggleGame()
	{
		game=!game;
	}

	
	//Modify this method as needed.
	public void actionPerformed(ActionEvent e)
	{

	}

	public void keyPressed(KeyEvent e)
	{
		System.out.println(e.getKeyCode());
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && game)
		{   
			System.out.println(background.ScrollCheckLeft() + Boolean.toString(player.MiddleCheck()));
			if(background.ScrollCheckLeft() && player.MiddleCheck())
			{
				background.ScrollLeft();

				bug1.ScrollLeft();
				bug2.ScrollLeft();
				bug3.ScrollLeft();
				bug4.ScrollLeft();
				bug5.ScrollLeft();
				bug6.ScrollLeft();
				bug7.ScrollLeft();
				bug8.ScrollLeft();
				bug9.ScrollLeft();
				bug10.ScrollLeft();
				
			}
			if(!background.ScrollCheckLeft() || !player.MiddleCheck())
			{
				player.Right();
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT&& game) 
		{
			System.out.println(background.ScrollCheckRight() + Boolean.toString(player.MiddleCheck()));
			if(background.ScrollCheckRight() && player.MiddleCheck())
			{	
				background.ScrollRight();
				bug1.ScrollRight();
				bug2.ScrollRight();
				bug3.ScrollRight();
				bug4.ScrollRight();
				bug5.ScrollRight();
				bug6.ScrollRight();
				bug7.ScrollRight();
				bug8.ScrollRight();
				bug9.ScrollRight();
				bug10.ScrollRight();
			}
			if(!background.ScrollCheckRight() || !player.MiddleCheck())
			{
				player.Left();
			}
			
			//player gets damage if it gets too close to the bug
			if (player.playerX() >= bug1.bugX() && player.playerX() <= bug1.bugX() + 90 )
			{
				player.BounceBack();
			}
			
			if (player.playerX() >= bug2.bugX() && player.playerX() <= bug2.bugX() + 90 )
			{
				player.BounceBack();
			}

			if (player.playerX() >= bug3.bugX() && player.playerX() <= bug3.bugX() + 90 )
			{
				player.BounceBack();
			}
			
			if (player.playerX() >= bug4.bugX() && player.playerX() <= bug4.bugX() + 90 )
			{
				player.BounceBack();
			}
			
			if (player.playerX() >= bug5.bugX() && player.playerX() <= bug5.bugX() + 90 )
			{
				player.BounceBack();
			}
			
			if (player.playerX() >= bug6.bugX() && player.playerX() <= bug6.bugX() + 90 )
			{
				player.BounceBack();
			}
			
			if (player.playerX() >= bug7.bugX() && player.playerX() <= bug7.bugX() + 90 )
			{
				player.BounceBack();
			}
			
			if (player.playerX() >= bug8.bugX() && player.playerX() <= bug8.bugX() + 90 )
			{
				player.BounceBack();
			}
			
			if (player.playerX() >= bug9.bugX() && player.playerX() <= bug9.bugX() + 90 )
			{
				player.BounceBack();
			}
			
			if (player.playerX() >= bug10.bugX() && player.playerX() <= bug10.bugX() + 90 )
			{
				player.BounceBack();
			}
			
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE&& game) 
		{
			player.Up();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN&& game) 
		{
			player.Down();
		}

		if (e.getKeyCode() == 0x41&& game) 
		{
			player.Hit();
			if (player.playerX() >= bug1.bugX() && player.playerX() <= bug1.bugX() + 110 || player.playerY() >= bug1.bugY() && player.playerY() <= bug1.bugY() +75)
			{
				bug1.getHit();
				if (bug1.bugHP()==0)
				{
					bug1.Die();
					bugcount++;
				}
			}
			
			if (player.playerX() >= bug2.bugX() && player.playerX() <= bug2.bugX() + 110 || player.playerY() >= bug2.bugY() && player.playerY() <= bug2.bugY() +75)
			{
				bug2.getHit();
				if (bug2.bugHP()==0)
				{
					bug2.Die();
					bugcount++;
				}
			}
			
			if (player.playerX() >= bug3.bugX() && player.playerX() <= bug3.bugX() + 110 || player.playerY() >= bug3.bugY() && player.playerY() <= bug3.bugY() +75)
			{
				bug3.getHit();
				if (bug3.bugHP()==0)
				{
					bug3.Die();
					bugcount++;
				}
			}
			
			if (player.playerX() >= bug4.bugX() && player.playerX() <= bug4.bugX() + 110 || player.playerY() >= bug4.bugY() && player.playerY() <= bug4.bugY() +75)
			{
				bug4.getHit();
				if (bug4.bugHP()==0)
				{
					bug4.Die();
					bugcount++;
				}
			}
			
			if (player.playerX() >= bug5.bugX() && player.playerX() <= bug5.bugX() + 110 || player.playerY() >= bug5.bugY() && player.playerY() <= bug5.bugY() +75)
			{
				bug5.getHit();
				if (bug5.bugHP()==0)
				{
					bug5.Die();
					bugcount++;
				}
			}
			
			if (player.playerX() >= bug6.bugX() && player.playerX() <= bug6.bugX() + 110 || player.playerY() >= bug6.bugY() && player.playerY() <= bug6.bugY() +75)
			{
				bug6.getHit();
				if (bug6.bugHP()==0)
				{
					bug6.Die();
					bugcount++;
				}
			}
			
			if (player.playerX() >= bug7.bugX() && player.playerX() <= bug7.bugX() + 110 || player.playerY() >= bug7.bugY() && player.playerY() <= bug7.bugY() +75)
			{
				bug7.getHit();
				if (bug7.bugHP()==0)
				{
					bug7.Die();
					bugcount++;
				}
			}
			
			if (player.playerX() >= bug8.bugX() && player.playerX() <= bug8.bugX() + 110 || player.playerY() >= bug8.bugY() && player.playerY() <= bug8.bugY() +75)
			{
				bug8.getHit();
				if (bug8.bugHP()==0)
				{
					bug8.Die();
					bugcount++;
				}
			}
			
			if (player.playerX() >= bug9.bugX() && player.playerX() <= bug9.bugX() + 110 || player.playerY() >= bug9.bugY() && player.playerY() <= bug9.bugY() +75)
			{
				bug9.getHit();
				if (bug9.bugHP()==0)
				{
					bug9.Die();
					bugcount++;
				}
			}
			
			if (player.playerX() >= bug10.bugX() && player.playerX() <= bug10.bugX() + 110 || player.playerY() >= bug10.bugY() && player.playerY() <= bug10.bugY() +75)
			{
				bug10.getHit();
				if (bug10.bugHP()==0)
				{
					bug10.Die();
					bugcount++;
				}
			}
		}

		if (e.getKeyCode() == 0x42&& game) 
		{
			player.BounceBack();
			if(background.ScrollCheckLeft() && player.MiddleCheck())
			{
				background.ScrollLeft();
				bug1.ScrollLeft();
				bug2.ScrollLeft();
				bug3.ScrollLeft();
				bug4.ScrollLeft();
				bug5.ScrollLeft();
				bug6.ScrollLeft();
				bug7.ScrollLeft();
				bug8.ScrollLeft();
			}

			if(!background.ScrollCheckLeft() || !player.MiddleCheck())
			{
				player.Right();
			}
		}

		if (e.getKeyCode() == 0x43&& game) 
		{
			player.Floor();
		}

		if (e.getKeyCode() == 0x44&& game) 
		{
			player.Recover();
		}
		if (e.getKeyCode() == 0x30) 
		{
			game=true;
			System.out.println("Please work.");
			restart=true;
		}
	}
	
	public boolean Restart()
	{
		return restart;
	}
	
	public void TRestart()
	{
		restart=!restart;
	}
	
	public void resetscreen()
	{
		removeAll(); 
	}
	

	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == 0x41) 
		{
			player.Idle();
		}
	}
	public void keyTyped(KeyEvent e) {}
}

