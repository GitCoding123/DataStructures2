
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * COP 3530: Project - Array Searches and Sorts
 * 
 * Project1 class includes methods to read in a csv file,
 * creating state objects using the data in the file to set and get attributes
 * for an object, and creating a stack and a priority queue of State objects
 * in which we can push/pop state objects from the stack and insert/remove state
 * objects from the priority queue.
 * 
 * @author Brian Gerkens
 * @version 10/8/21
 */

public class Project2 {
	
	public Project2() {
		
	}

	/**
	 * The main method includes while loops to prompt user for the file name
	 * input until the correct file name is entered. It also prints a number
	 * menu that will keep reprinting until option '7' is entered, which
	 * exits the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int size = 50;
		String line = "";
		boolean running = true;
		Scanner scan = new Scanner(System.in);
		
		
		State state; 			//states read from file
		State insertState;		//states manually inserted into queue
		State pushState;		//states manually pushed into stack
		
		Stack stack = new Stack(size);				//stack object to call methods from stack class.
		PriorityQ pq = new PriorityQ(size);			//queue object to call methods from queue class.
		
		
		printHeader();
		System.out.println("Enter the file name: ");
		
		while(running) {
			String fileName = scan.next();
			try {
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				System.out.println("\nStack created of 50 states.\nPriority Queue created of 50 states.\n ");	
				 
				String headLine = br.readLine();
				while((line = br.readLine()) != null) {
							
					String[] data = line.split(",");
					//parse data from file
					String name = data[0];
					String capitol = data[1];
					String region = data[2];
					int usHouseSeats = Integer.parseInt(data[3]);
					int population = Integer.parseInt(data[4]);
					double covidCases = Double.parseDouble(data[5]);
					double covidDeaths = Double.parseDouble(data[6]);
					int income = Integer.parseInt(data[7]);
					double crimeRate = Double.parseDouble(data[8]);
					double CFR = covidCases / covidDeaths;
					double caseRate = covidCases / population * 100000;
					double deathRate = covidDeaths / population * 100000;
					
					state = new State(name, capitol, region, usHouseSeats, population,					//Create state objects from file, line by line.
							covidCases, covidDeaths, income, crimeRate, CFR, caseRate, deathRate);
					
					stack.push(state);		//State pushed onto stack, first in last out (FILO).
					pq.insert(state);		//State inserted into priority queue and sorted by highest priority(Lowest death rate).
				}
				running = false;			//end main while loop		
			}
			catch (FileNotFoundException e) {
				System.out.println("YIKES!!! Incorrect file name. Please try again.\nEnter the file name: ");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	
		
			
		running = true;
		int menuNumber = 0;
		while(running) {
			printMenu();
			try {
				menuNumber = scan.nextInt();
			}
			catch(InputMismatchException e) {
				scan.next();
			}
			if(menuNumber == 1) {
				
				stack.printStack();
				System.out.println("\nPlease choose another option: \n");
				continue;
			}
			else if(menuNumber == 2) {
				//check if stack is empty
				if(stack.stackIsEmpty()) {
					System.out.println("Cannot pop state!\nThe stack is empty: " + stack.stackIsEmpty());
				}
				else {
					stack.pop();
					System.out.println("\nState popped from stack!\n");
					System.out.println("\nPlease choose another option: \n");
					continue;
				}
			}
			else if(menuNumber == 3) {
				if(stack.stackIsFull()) {
					System.out.println("Cannot push!\nStack is full: " + stack.stackIsFull());
				}
				else {
					System.out.println("You've chosen to push a state onto the stack.\nPlease enter name: ");
					String name = scan.next();
					System.out.println("Please enter capitol: \n");
					String capitol = scan.next();
					System.out.println("Please enter region: \n");
					String region = scan.next();
					System.out.println("Please enter number of US House Seats: \n");
					int usHouseSeats = scan.nextInt();
					System.out.println("Please enter population: \n");
					int population = scan.nextInt();
					System.out.println("Please enter number of covid cases: \n");
					double covidCases = scan.nextDouble();
					System.out.println("Please enter number of covid deaths: \n");
					double covidDeaths = scan.nextDouble();
					System.out.println("Please enter median household income: \n");
					int income = scan.nextInt();
					System.out.println("Please enter violent crime rate: \n");
					double crimeRate = scan.nextDouble();
					
					
					double CFR = covidCases / covidDeaths;
					double caseRate = covidCases / population * 100000;
					double deathRate = covidDeaths / population * 100000;
					
					
					pushState = new State(name, capitol, region, usHouseSeats, population, covidCases,
											covidDeaths, income, crimeRate, CFR, caseRate, deathRate);
					
					stack.push(pushState);
					System.out.println("\nState pushed onto stack!\n");			
					System.out.println("\nPlease choose another option: \n");
					continue;					
				}
			}
			else if(menuNumber == 4) {
				pq.printQueue();								//Printing the priority queue
				System.out.println("\nPlease choose another option: \n");
				continue;
			}
			else if(menuNumber == 5) {
				//checking to see if queue is empty
				if(pq.queueIsEmpty()) {
					System.out.println("Priority Queue is empty!");
				}
				else {
					pq.remove();
					System.out.println("\nState removed from priority queue!\n");
					System.out.println("\nPlease choose another option: \n");
					continue;
				}
			}
			else if(menuNumber == 6) {
				if(pq.queueIsFull()) {
					System.out.println("Cannot insert!\nPriority queue is full: " + pq.queueIsFull());
					continue;
				}
				else {
					System.out.println("You've chosen to insert a state into the priority queue.\nPlease enter state name: ");
					String input = scan.next();
					String name = input;
					System.out.println("Please enter capitol: \n");
					String capitol = scan.next();
					System.out.println("Please enter region: \n");
					String region = scan.next();
					System.out.println("Please enter number of US House Seats: \n");
					int usHouseSeats = scan.nextInt();
					System.out.println("Please enter population: \n");
					int population = scan.nextInt();
					System.out.println("Please enter number of covid cases: \n");
					double covidCases = scan.nextDouble();
					System.out.println("Please enter number of covid deaths: \n");
					double covidDeaths = scan.nextDouble();
					System.out.println("Please enter median household income: \n");
					int income = scan.nextInt();
					System.out.println("Please enter violent crime rate: \n");
					double crimeRate = scan.nextDouble();
					double CFR = covidCases / covidDeaths;
					double caseRate = covidCases / population * 100000;
					double deathRate = covidDeaths / population * 100000;
				
					
					insertState = new State(name, capitol, region, usHouseSeats, population, covidCases,
											covidDeaths, income, crimeRate, CFR, caseRate, deathRate);
					pq.insert(insertState);
					System.out.println("\nState inserted into priority queue!\n");
					System.out.println("\nPlease choose another option: \n");
					continue;
				}
			}
			else if(menuNumber == 7) {
				System.out.println("File closed.\nProgram terminated.\nHave a nice day!");
				scan.close();
				running = false;
			}
			else {
				System.out.println("\nYIKES!!!\nInvalid entry. Please try again: \n");
			}	
		}
	}
	
	/**
	 * The printHeader() method prints the proper header consisting of the class,
	 * instructor name, and title of project 2.
	 * 
	 */
	public static void printHeader() {
		System.out.println("COP3530 Project 2\nInstructor: Xudong Liu\n");
		System.out.println("Stacks and Priority Queues");
	}
	/**
	 * The printMenu() method prints the menu to the user with options 1-7.
	 * 
	 */
	public static void printMenu() {
		System.out.println("1.) Print stack\n2.) Pop a state object from stack\n3.) Push a state object onto stack");
		System.out.println("4.) Print priority queue\n5.) Remove a state object from priority queue");
		System.out.println("6.) Insert a state object into priority queue\n7.) Exit\n\nPlease enter your choice: ");
	}
}