//import scanner to get user input
import java.util.Scanner;

public class deliverable1 {
	
	//check to see if the two given integers have their digits add up to the same numbers
	public static boolean addDigits(String int1, String int2) {
		int i = 0;
		int totalValue = 0;
		int digit1 = 0;
		int digit2 = 0;
		boolean digitsAddUp = true;
		
		
		//get initial value to compare added values to
		digit1 = int1.charAt(0) -'0';
		digit2 = int2.charAt(0) -'0';
		totalValue = digit1 + digit2;
		
		//check the value of each digit in the two integers against the sum
		//if they don't equal, the function will return false
		while (i < int1.length()) {
			digit1 = int1.charAt(i) - '0';
			digit2 = int2.charAt(i) - '0';
			if (digit1 + digit2 != totalValue) {
				digitsAddUp = false;
			}
			i++;
		}
		
		//if all digits add up to the same number, return true
		//otherwise, return false
		if (digitsAddUp == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//check a string to see if it is an integer that can be converted to a real integer
	//returns true if the string contains only digits and false if it contains other character types
	public static boolean checkDigits(String str) {
		//declare boolean that is used to pass at the end and counter for digits 
		boolean isInt = true;
		int i = 0;
		
		//check each character of the input to confirm that the input is only digits
		while (i < str.length()) {
			if (Character.isDigit(str.charAt(i)) == false) {
				isInt = false;
			}
			i++;
		}
		
		//return true if the input is an integer, otherwise return false
		if (isInt == true){
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static void main(String [] args ) {
		//declare scanner object
		Scanner sc = new Scanner(System.in);
		
		//declare variables to loop while input isn't good
		boolean input1IsGood = false;
		boolean input2IsGood = false;
		String userInput1 = "";
		String userInput2 = "";
		
		//get the first integer after confirming that the user's input is actually a valid integer
		//once a valid integer has been entered, move on to getting the second integer
		while (input1IsGood == false) {
			System.out.println("Please enter your first integer: ");
			userInput1 = sc.next();
			if (checkDigits(userInput1) == false) {
				System.out.println("Input is not an integer, please try again.");
			}
			else {
				input1IsGood = true;
			}
		}
		
		//get the second integer
		//check validity and that supplied integers are the same length
		int i = 0;
		while (input2IsGood == false) {
			input2IsGood = true;
			System.out.println("Please enter your second integer: ");
			userInput2 = sc.next();
			if (checkDigits(userInput2) == false) {
				System.out.println("Input is not an integer, please try again.");
				input2IsGood = false;
			}
			else if (userInput1.length() != userInput2.length()) {
				System.out.println("Integer 2 is not the same length as integer 1, please try again.");
				input2IsGood = false;
			}
		}
		
		//compare the digits in each integer and see if the add up to the same number
		//print the result so the user can see it
		if (addDigits(userInput1, userInput2) == false) {
			System.out.println("False, the digits do not add up to the same number.");
		}
		else {
			System.out.println("True, the digits add up to the same number.");
		}
		
	}

}