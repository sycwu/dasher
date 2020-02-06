package dasher;

public class HP {
	
	private int value;
	
	public HP(int temp)								//constructor intakes hp #
	{
		value = temp;
	}
	
	public void Display()
	{
		
	}
	
    public void HPMinus(int damage)
    {
    	if(Math.signum((double)value-damage)>=0)
    	value = value-damage;
    	else
    	value = 0;
    }
    
    public void HPAdd(int heal)
    {
    	value = value-heal;
    }
    
    public int getHP()
    {
    	return value;
    }
    
    public int setHP(int temp)
    {
    	value = temp;
    	return value;
    }
    
    public String toString()
    {
    	return "HP: " + Integer.toString(value);
    }

}
