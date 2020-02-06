package dasher;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;

public class Background extends JLabel

{
	private ImageIcon bg;
	private int dx = 0;
	private boolean canscrollL = true;
	private boolean canscrollR = true;
	private int x = -4000;
	private int y = -100;
	private int width = 5060;
	private int height = 600;

	public Background()
	{	
		bg = new ImageIcon("C:/Users/Celeste/eclipse-workspace/CSC 405/src/background.png");
		setBounds(x,y,width,height); 
		setIcon(bg);
		setVisible(true);
	}
	
	public void ScrollLeft()							//scroll background
	{
		System.out.println(dx);
		if(canscrollL)
		{
			dx = dx - 50;
			setBounds(x+dx,y,width,height);
		}
    }

	public void ScrollRight()							
	{
		System.out.println(dx);
        if(canscrollR)
		{
        	dx = dx + 50;
			setBounds(x+dx,y,width,height);
		}
    }
	
	public boolean ScrollCheckLeft()						//check whether at the end; disables scrolling if so
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
        
}
