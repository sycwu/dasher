package dasher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class MP implements ActionListener{			
	
	private int value;
	private Timer t;
	
	public MP(int temp)								//create mp with integer input
	{
		value = temp;
        t = new Timer(20,this);
        t.start();
	}
	
	public void Display()
	{
		
	}
	
    public void MPMinus(int damage)
    {
    	value = value-damage;
    }
    
    public void MPAdd(int heal)
    {
    	value = value-heal;
    }
    
    public int getMP()
    {
    	return value;
    }
    
    public String toString()
    {
    	return "MP: " + Integer.toString(value);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(value<300)
		{value++;}
		
	}

}
