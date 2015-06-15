package guessing_game_flipped;

import java.util.Scanner;

public class guessing_game_flipped {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args){
		/*
		 * Setup:
		 * Set minimum and maximum possible values
		 * guess middle value
		 * based on if it's lower or higher, update min and max values.
		 * 
		 */
		
		//Minimum and maximum of range, program's guess, round of game we're on
		int min, max, guess, round;
		
		//checks if the game is over at the moment
		boolean gameOver = false;
		
		/*
		 * used to print a warning about invalid inputs for the response
		 * of the user when asked if guess is correct, low, or high.
		 * Used for if statement line 42
		 * Changed to false after first round through do/while loop line 50.
		 */
		boolean firstTime = true;
		
		//user's response. Used in line 49
		int response = -1;
		
		//Possible to add a "play again" do while loop option here.
		
		
		introduction();
		
		
		//functions used to allow user to choose min and max
		min = getMin();
		max = getMax();
		
		round = 1;
		
		do{
			
			guess = guess(min, max);
			
			do{
				if(!firstTime)
				{
					System.out.println("That is not a valid response. Please try again.");
				}
				
				response = dialogBox(guess, round);
				firstTime = false;
				
			}while(response != 1 && response != 2 && response != 3);
			
			//resets firstTime for next round.
			firstTime = true;
			
			if(response == 1)
			{
				System.out.println("Your number is "+ guess + ".");
				System.out.println("I win! Good game! \n"
						+ "It took me " + round + " rounds to win!");
				gameOver = true;
			}
			if(response == 2)
			{
				//Plus 1 because guessing function is inclusive of min and max
				max = guess - 1;
			}
			
			if(response == 3)
			{
				//Minus 1 because guessing is inclusive of min and max
				min = guess + 1;
			}
			
			round += 1;
		}while(gameOver != true);
		
		input.close();

	}

	private static void introduction() {
		String s;
		
		System.out.println("Welcome to the guessing game!");
		System.out.println("I am a program that will try to guess your number!");
		System.out.println("Think of a range of integers, and decide on an integer within it.");
		System.out.println("Press enter to begin!");
		
		//input used to make program wait before continuing.
		s = input.nextLine();
	}

	/*
	 * A function that prompts the user to enter a max value for the range.
	 * @return max of range
	 */
	private static int getMax() {
		int response;
		
		System.out.println(" ");
		System.out.println("Please enter the maximum value of the range");
		response = input.nextInt();
				
		return response;
	}

	/*
	 * A function that prompts the user to enter a min value for the range.
	 * @return min of range
	 */
	private static int getMin() {
		int response;
		
		System.out.println("Please enter the minimum value of the range: ");
		response = input.nextInt();
		
				
		return response;
	}

	/*
	 * A function that prints the options for the user. Records and returns response.
	 * Response can be 1 of three things: guess is correct, guess is too low,
	 * guess is too high.
	 * 
	 * @return response in form of int
	 */
	private static int dialogBox(int guess, int round) {
		int response;
		
		System.out.println(" ");
		System.out.println("Round " + round + ": My guess is " + guess + ".");
		System.out.println("(1) That is correct!");
		System.out.println("(2) My number is lower.");
		System.out.println("(3) My number is higher.");
		
		response = input.nextInt();
		
		return response;
	}

	/*
	 * Function used to calculate guess for program.
	 * Using int caster to turn .5 results into rounded up values.
	 * guess is halfway between min and max rounded up to nearest int
	 * 
	 * @return int guess
	 */
	private static int guess(int min, int max) {
		if(min == max){
			return min;
		}
		if(min > max){
			System.out.println("you fucked up.");
			return -1;
		}
		
		int guess = (int) ( (max + min) /2 );
		return guess;
	}

}
