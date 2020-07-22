package assingment2;
import java.util.ArrayList;

import edu.cmu.ri.createlab.terk.robot.finch.Finch; 

public class dance 
{
	int t=0, speed=0;//time of move, speed
	int red=0,green=0,blue=0; //colours of led
	
	ArrayList<Integer> bin=new ArrayList<Integer>(); //array list storying binary number, to easily get its digits
	int dec=0,oct=0;
	String hex="";  
	
	public static Finch myfinch=new Finch(); //creating finch object
	
	
	public dance(String hexadec, ArrayList<Integer> binary,int decimal, int octal) //this is constructor of a class dance
	{
		hex=hexadec;
		bin=binary;
		dec=decimal;
		oct=octal;
	}
	
	public void dancing()  //this method is responsible for movements of finch
	{
		int i=bin.size()-1;
		myfinch.setLED(red,green,blue);
		
		  
			while(i>=0&&myfinch.isObstacle()==false)   
			{
				if(bin.get(i)==0)
				{
					myfinch.setWheelVelocities(-speed,-speed,t);
				}
				else
				{
					myfinch.setWheelVelocities(speed,speed,t);
				}
				i--;
			}
			if(myfinch.isObstacle()==true)
			{
				System.out.println("Finch found obstacle and had to stop dancing");
			}
			myfinch.setLED(0,0,0);
			myfinch.quit();
	}
	
	public void preparation()  //method setting finch's speed(speed), time of movement(t) and 3 values creating LED colour
	{
		System.out.println(hex.length());
		if(hex.length()==1)
		{
			t=1000;
		}
		else
			t=500;
		if(oct<60)
		{
			speed=oct+50;
		}
		else if(oct<255)
		{
			speed=oct;
		}
		else if(oct>255)
		{
			speed=255;
		}
		red=dec;
		green=(dec%80)*3;
		if(red>green)
		{
			blue=red;
		}
		else
		{
			blue=green;
		}	
	}
	
	
	public void display()  //displays all converted numbers, finch's speed and values of LED
	{
		System.out.println("hex value given: "+ hex);
		System.out.println("octal equivalent: "+ oct);
		System.out.println("decimal equivalent: "+ dec);
		System.out.println("binary equivalent: "+ bin);
		System.out.println("speed: "+ speed);
		System.out.println("time of each movement: "+t);
		System.out.println("red: "+red+" green: "+green+" blue: "+blue);
	}
}