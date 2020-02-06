package dasher;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawingFrame extends JFrame implements ActionListener
{
	private AnimationPanel panel;
	private InfoPanel info;
	private GameOverPanel GG;
	private GameClearPanel FM;
	private Character player;

	//private boolean gameover = false;
	private Timer t;

	public DrawingFrame()
	{
		try 
		{
			// Open an audio input stream.
			File soundFile = new File("C:/Users/Celeste/eclipse-workspace/CSC 405/src/wii.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			// Get a sound clip resource.
			Clip clip = AudioSystem.getClip();
			// Open audio clip and load samples from the audio input stream.
			clip.open(audioIn);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} 
		catch (UnsupportedAudioFileException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (LineUnavailableException e) 
		{
			e.printStackTrace();
		}

		setLayout(null);
		setSize(800,600);
		setLocationRelativeTo(null);
	
		player = new Character();
		panel = new AnimationPanel(player);
		add(panel);

		info = new InfoPanel(player);
		add(info);
		info.setBounds(0, 500, 800, 100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		panel.requestFocus(true);
		panel.setFocusable(true);
		
		GG = new GameOverPanel(info.GetTime());
		GG.setVisible(false);
		add(GG);
		
		FM = new GameClearPanel(info.GetTime());
		FM.setVisible(false);
		add(FM);

		t = new Timer(20,this);
		t.start(); 

		setVisible(true);
	
	}

	private void Maingame() {
		// TODO Auto-generated method stub
		
	}

	public void GameOver()
	{
		panel.setOpaque(false);
		panel.resetscreen();
		remove(info);

		GG.SetTime(info.GetTime());
		GG.setVisible(true);
	}

	public void GameClear()
	{
		panel.setOpaque(false);
		panel.resetscreen();
		remove(info);

		FM.SetTime(info.GetTime());
		FM.setVisible(true);
	}

	public static void main(String[]args)
	{
		new DrawingFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//Game Clear: player reaches the end
		if(player.canLeft()==false && panel.BugCheck() )
		{
			GameClear();
			//t.stop();
			info.tproceed();
			info.StopTimer();
			panel.toggleGame();
			if(panel.Restart())
			{
				remove(panel);
				FM.setVisible(false);
				panel.TRestart();
				panel.toggleGame();
				player = new Character();
				panel = new AnimationPanel(player);
				add(panel);

				info = new InfoPanel(player);
				info.setBounds(0, 500, 800, 100);
				add(info);
				panel.requestFocus(true);
				panel.setFocusable(true);
				setVisible(true);
			}
		}
		
		if(player.canLeft()==false && !panel.BugCheck() )
		{
			info.fproceed();
		}
		//Game Over: player dies
		if(player.getHP()==0)
		{
			GameOver();   
			//t.stop();
			info.StopTimer();
			System.out.println("OVER");
			panel.toggleGame();
			if(panel.Restart())
			{
				remove(panel);
				GG.setVisible(false);
				panel.TRestart();
				panel.toggleGame();
				player = new Character();
				panel = new AnimationPanel(player);
				add(panel);

				info = new InfoPanel(player);
				info.setBounds(0, 500, 800, 100);
				add(info);
				panel.requestFocus(true);
				panel.setFocusable(true);
				setVisible(true);
			}
		}
	}


}

