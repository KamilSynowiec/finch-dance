The purpose of this program is to make a finch robot perform a dance routine. The dance is determined by the user input. 
However, I made this problem slightly more interesting by using different numeral systems. 
I used binary, decimal, octal and hexadecimal number systems. 
The program asks the user to enter a hexadecimal number of either 1 or 2 digits (e.g., F or 1F). 

Then the program converts this hexadecimal number into the octal, decimal and binary equivalents. 
For example, if the user enters 5A, the octal equivalent is 132, the decimal equivalent is 90 and the binary equivalent is 1011010. 

Once the conversion is done, these numbers are used for creating the dance routine. 

The speed of the finch is determined by the octal equivalent of the given hexadecimal number. However, if the octal number is smaller than 60 then the speed is set to that octal number + 50. If the octal number exceeds the speed limit of the wheels of the finch, the speed is set to the limit. 

The colour of the LED of the finch’s beak is created by mixing different values of red, green, and blue. The red value is a decimal equivalent of the given hexadecimal number; the green value is equal to the remainder of the decimal equivalent when divided by 80, multiplied by 3; the blue value is equal to the greater of the two (red or green) values. 

The movements of the robot (forward or backwards) are determined by the binary equivalent of the given hexadecimal number. 

Specifically, the movements are as follows: reading the binary number from right to left one digit at a time, the finch moves forward when the digit is equal to 1, and backwards when the digit is equal to zero. So, for example, 1011010 causes the robot to move backwards, forward, backwards, forward, forward, backwards and finally forward. If the hexadecimal is one digit long, the duration of each movement (forward or backward) is 1 second. If the hexadecimal is two digits long, the duration of each movement is 0.5 seconds. Before the finch starts moving, the program displays the following information:

Hexadecimal value given, the octal, decimal and binary equivalents, the speed at which the finch robot will be moving, and the red, green, and blue values that make the LED colour. Here are three examples of output: F, 17, 15, 1111, speed = 67, LED colour (red 15, green 45, blue 45). 5A, 132, 90, 1011010, speed = 132, LED colour (red 90, green 30, blue 90). C8, 310, 200, 11001000, speed = 255, LED colour (red 200, green 120, blue 200). 

The LED in the finch’s beak should be set to the right colour and the finch should start moving. When the finch completes its last move, it should switch off the LED, and ask the user if they would like to enter another hex number. If the user responds ‘NO’, the program should sort in ascending order all the hexadecimals that the user has entered so far, write the numbers to a text file, and terminate. Error checks and appropriate exception handling should be put in place to ensure that the entered number represented as a string of digits and characters is valid for the hexadecimal system and the length of the string is either 1 or 2. Invalid input should be rejected, and the program should display appropriate error messages and ask the user for new input. The program must incorporate a ‘proper’ algorithm for doing the conversion and must NOT use any Java built- in methods to do the conversion.
