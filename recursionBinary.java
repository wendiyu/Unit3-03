/****************************************************************************
 *
 * Created by: Wendi Yu
 * Created on: Apr 23 2018
 * Created for: ICS4U
 * This program generates a list of 250 random values and sorts them. It then
 * 		allows the user to input a number and searches for that number in the
 * 		list
 *
 ****************************************************************************/

import java.util.Random;
import java.util.Scanner;

public class recursionBinary {
	public static void main(String[] args) { 
		
		Scanner userInput = new Scanner(System.in);
		Random range = new Random();
		// generate 250 random numbers in a list
		int[] values = new int[250]; 
		
		System.out.print("Generated values:\n");
		
		int randomNumber;
		
		// generate random numbers between 0 and 550
		for(int counter = 0; counter < values.length; counter++) {
			randomNumber = range.nextInt(550) + 1;
			values[counter] = randomNumber;
			System.out.println(randomNumber);
			
		}
		
		System.out.println("\nSorted values: ");
		NumberSort(values);
		
		// Display text
		do {
			System.out.println("Enter a number from 1 to 550 to search in values (Enter -1 to exit the program): ");
			int userNumber = userInput.nextInt();
			
			// conditional for run the program
			if(userNumber < -1 || userNumber > 550) {
				System.out.print("\nInvalid.");
				System.exit(0);
			}
			else if(userNumber == -1) {
				System.out.print("Thank You For Using!");
				System.exit(0);
			} 
			else {
				String search = NumSearch(values, userNumber, 0, values.length - 1);
				System.out.print("\n" + search);
			}
		} while(true);
	}
	
	public static void NumberSort(int array[]) {
		
		// sorts elements in array in numerical order 
		int arrLen = array.length;
		
		for(int nextNum = 0; nextNum < arrLen; nextNum ++) {
			for(int prevNum = 0; prevNum < arrLen; prevNum++) {
				if(array[nextNum] < array[prevNum]) {
					int sub = array[nextNum];
					array[nextNum] = array[prevNum];
					array[prevNum] = sub;
				}
			}
		}
		for(int counter = 0; counter < arrLen; counter++) {
			System.out.println(array[counter]);
		}
	} 
	
	public static String NumSearch(int array[], int srchNum, int lowIndex, int highIndex) {
		// searches for user number and returns whether or not the number is found
		
		if (lowIndex <= highIndex) {
			
			//finds the middle value
			int midIndex = (lowIndex + highIndex)/2;
			
			//if number equal to the middle value
			if(srchNum == array[midIndex]) {
				return "Found at " + (midIndex+1) + "\n";
			}
			
			//Changing lowIndex, if number is greater than the middle value then shorten the range
			else if(srchNum > array[midIndex]) {
				lowIndex = midIndex + 1;
			}
			
			//Changing highIndex, if number is less than the middle value then shorten the range
			else if(srchNum < array[midIndex]) {
				highIndex = midIndex - 1;
			}
		}
			
		else {
			return "Not found.\n";
		}
		
		return NumSearch(array, srchNum, lowIndex, highIndex);
	}
}
