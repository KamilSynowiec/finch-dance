package assingment2;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;                         
import java.util.Scanner;

public class main 
{
	public static ArrayList<String>hexnum=new ArrayList<String>(); //storing entered hexadecimal numbers
	public static void main(String[] args)
	{
		
		String hextemp = "";  //storing entered hex number
		char a = 0,b = 0;
		int playagain=0; 
		int l=0;   //store length of entered hex number
		int j=0;   //let us know if provided number contains symbols reserved only for hex numbers
		int first;   //variable/ first time entering/ wrong hex humber
		int dec; //storing decimal number
		ArrayList<Integer> backbin=new ArrayList<Integer>();  //storing bin number read backward
		int oct; //storing octal number
		
		Scanner keyboard=new Scanner(System.in);
		
		System.out.println("Welcome to finch's dancing game");
		
		
		dance.myfinch.setLED(0,255,0);
		dance.myfinch.buzz(4000,2000);
		dance.myfinch.setLED(0,0,0);
		
		
		do 
		{		
			first=0;
			j=0;
			
			while(j==0)  // to be hex numb must have length 1 or 2 and consist only of valid hex symbols
			{	
				
				if(first==0)
				{
					System.out.println("Please provide 1 or 2 digits hexadecimal number");
					first++;   //if first>0 then next attempt of entering number
				}
				else
				{
					dance.myfinch.buzz(440,1000);   //annoying buzz to inform user about code rejection
					System.out.println("Entered number is not correct 1 or 2 digits hexadecimal number");
					System.out.println("Please provide correct nubmer");
				}
					
				hextemp=keyboard.nextLine().toUpperCase();  //makes all entered letters capital 
				
			
			
				if(hextemp.length()==2)
				{
					a=hextemp.charAt(0);  //passing first digit of entered hex number into char a
					b=hextemp.charAt(1);
					if(((b>='A'&&b<='F')||(b>=48&&b<=57))&&((a>='A'&&a<='F')||(a>=48&&a<=57))) //checking if hex number's characters are valid for hex numbers     
					{
						j++;
					}
				}
				else if(hextemp.length()==1)
				{
					a=hextemp.charAt(0);
					if((a>='A'&&a<='F')||(a>=48&&a<=57))   //checking if hex number's character is valid for hex numbers
					{
						j++;
					}
				}
				else
				{
					j=0;
				}
			}
			
			System.out.println("You've entered correct hex number");
			hexnum.add(hextemp);	//saving provided number into array
			
			conversions convert=new conversions();
			dec=convert.convertToDec(hextemp);  
			backbin=convert.convertToBin(dec);
			oct=convert.convertToOct(dec);
			dance dancing=new dance(hextemp, backbin, dec,oct); //passing values through constructor
			dancing.preparation();
			dancing.display();
			dancing.dancing();
			
			System.out.println("Would you like to play again?");
			System.out.println("Enter 1 if yes or 2 if no");
			playagain=Integer.parseInt(String.valueOf(keyboard.nextLine()));
			
		}while(playagain==1);	
		
		sortAndSave();
		keyboard.close();
		
		
		
			
	}	
	
	
	static void sortAndSave() 
	{
		   Collections.sort(hexnum);
		  
		   try
		   {
			   FileWriter writehandle = new FileWriter("C:\\temp\\hexnums.txt");  //open a file for writing
			   BufferedWriter bw = new BufferedWriter(writehandle);
			   String temp="";
			   for(int i=0;i<hexnum.size();i++)  
			   {
				   temp=hexnum.get(i);
				   bw.write(temp);
				   bw.newLine();
			   }
			   bw.close();
			   writehandle.close();
			   System.out.println("Program sorter entered hex numbers and saved them to file");
		   }
		   catch(Exception e)  
		   {
			   dance.myfinch.buzz(440,1000);
			   System.out.println("The program couldn't find the text file to save entered hex numbers.");    
		   }
	}
}






