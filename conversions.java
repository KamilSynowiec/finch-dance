package assingment2;

import java.util.ArrayList;
import java.util.Collections;

public class conversions
{
	
	int dec=0,T=0;  //T-storing equivalent of decimal letter
	int i=0;
	char[]a=new char[2];  //stores 2 digits of the provided hex number
	

	public int convertToDec(String hex)  //converts hex number to decimal
	{
		i=hex.length()-1;
		
		if(i==1)
		{
			a[0]=hex.charAt(0);    //passing first digit of entered hex number into char[0]
			a[1]=hex.charAt(1);
		}
		else
		{
			a[0]=hex.charAt(0);
		}
		
		while(i>=0)  //goes through all 2 characters of entered hex number from right to left
		{
			if(a[i]>=48&&a[i]<=57) //0-9 in ASCII code
			{
				T=Integer.parseInt(String.valueOf(a[i]));  //because char passed to int gives its ascii code 
			}	
			else
			{
				switch(a[i])   //check equivalent of decimal letter
				{
				case 'A':
					T=10;
					break;
				case 'B':
					T=11;
					break;
				case 'C':
					T=12;
					break;
				case 'D':
					T=13;
					break;
				case 'E':
					T=14;
					break;
				case 'F':
					T=15;
					break;
				}
			}
			if(hex.length()==2)
			{
				if(i==1)  //if currently right letter is checking then 
				{
					dec=T;  //it's assigning it to the decimal number (16^0 * character)
					i--;
				}
				else   //if the letter is left then
				{
					dec=dec+T*16;  //it's adding the letter multiplied by 16 to the decimal number (16^1 * character)  
					i--;
				}
			}
			else
			{
				dec=T;
				i--;
			}
		}
		return dec;
	}
	
	
	public ArrayList<Integer> convertToBin(int dec)  //method converting decimal to binary
	{
	    ArrayList<Integer> bin=new ArrayList<Integer>();
		
		while(dec>0)
		{
			bin.add(dec%2);	
			dec=dec/2;
		}
		Collections.reverse(bin);   //method reversing backward-read binary number (this is 
		
		return bin;
	}
	
	public int convertToOct(int dec)  //converts decimal number to octal
	{
		int octal;
		String str="";
		int rem; //reminder
		
		while(dec>0)
		{
			rem=dec%8;
			dec=dec/8;
			str=Integer.toString(rem)+str;
		}
	    octal=Integer.parseInt(str);  //converting string to int
		return octal;
	}
}