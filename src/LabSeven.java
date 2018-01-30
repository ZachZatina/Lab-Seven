import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Zachariah Zatina
 * 
 * A program that return information based on what the user wants to find out.
 */
public class LabSeven {

	public static void main(String[] args) {
		// Variable list
		Scanner scnr = new Scanner(System.in);
		String cont1 = "y";
		String cont2;
		int i;
		String userInput;
		String[] name = { "Kevin Costner", "Natalie Portman", "Hilary Swank", "Cristopher Walken", "Zach Zatina" };
		String[] favColor = { "Citrus Zest", "Desert Moss", "Fervent Brass", "Hawaiian Passion", "Blue" };
		String[] favCar = { "Yugo", "Audi R8", "Lamborghini Aventador", "Smart Car", "BMW 7-series" };
		String[] favFood = { "Pecan Pie", "Filet Mignon", "Applesauce", "Cobb Salad", "Chocolate Chip Cookies" };
		String[] firstName;
		boolean innerLoopRun = true;
		boolean smallestLoopRun = true;
		
		// loop to keep the program going (loop to change students chosen)
		while (cont1.equalsIgnoreCase("y")) {
			// try catch statement for array out of bounds and type mismatch exception
			try {
				// reset of boolean so loop further down can run
				innerLoopRun = true;
				
				// lists the students
				System.out.println("Welcome to our Java class."); 
				System.out.println("1) " + name[0]);
				System.out.println("2) " + name[1]);
				System.out.println("3) " + name[2]);
				System.out.println("4) " + name[3]);
				System.out.println("5) " + name[4]);
				
				// takes the student the user wants to learn about
				System.out.print("Which student would you like to learn more about? (enter a number 1-5): ");
				i = scnr.nextInt();
				// to allow the correct part of the array to be called.
				i = i - 1;
				scnr.nextLine();
				
				// gets the first name of the student chosen
				firstName = name[i].split(" ");
				
				// prompts user to find out the information they want to hear
				System.out.print("Student " + (i + 1) + " is " + name[i]
						+ ". What would you like to know about " + firstName[0]
						+ "? (Enter 'favorite car', 'favorite color', or 'favorite food'): ");
				
				// loop to allow the user to learn more than just the first thing they choose about the student they chose
				while (innerLoopRun == true) {
						userInput = scnr.nextLine();
						// resets a boolean loop below
						smallestLoopRun = true;
						
						// if-else statement depending on what the user wants to know about.
						if (userInput.equalsIgnoreCase("favorite car")) {
							System.out.print(firstName[0] + "'s favorite car is a " + favCar[i] + ". ");
						}
						else if (userInput.equalsIgnoreCase("favorite color")) {
							System.out.print(firstName[0] + "'s favorite color is " + favColor[i] + ". ");
						}
						else if (userInput.equalsIgnoreCase("favorite food")) {
							System.out.print(firstName[0] + "'s favorite food is " + favFood[i] + ". ");
						}
						else {
							System.out.print("That data does not exist. Please try again. (Enter 'favorite car', 'favorite color', or 'favorite food'): ");
							continue;
						}
						
						// loop to find out more information about the student the user chose
						System.out.print("Would you like to know more about " + firstName[0] + "? (y/n): ");
						while (smallestLoopRun == true) {
							cont2 = scnr.nextLine();
							
							if (cont2.equalsIgnoreCase("y")) {
								smallestLoopRun = false;
								System.out.print("What would you like to know about " + firstName[0] + "? (Enter 'favorite car', 'favorite color', or 'favorite food'): ");
								continue;
							} else if (cont2.equalsIgnoreCase("n")) {
								smallestLoopRun = false;
								innerLoopRun = false;
							} else {
								System.out.print("That is not a valid response. Continue? (y/n): ");
							}
						}

				}
				
				// prompt to see if the user wants to pick another student
				System.out.print("Would you like to pick another student? (y/n): ");
				cont1 = scnr.nextLine();
				
				// catch for inputs that are outside of the array size
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Enter a valid integer (1-5)!");
				continue;
				// catch to validate that the input is not a letter
			} catch (InputMismatchException e) {
				System.out.println("Enter a valid integer (1-5)!");
				scnr.nextLine();
				continue;
			}

		}
		
		// ending statement.
		System.out.println("Goodbye!");
	}

}
