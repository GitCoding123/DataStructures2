

/**
 * This class Stack initializes a stack with a set size and a 'top' counter, which informs
 *  us whether or not the stack is full/empty. Whenever we push() a state, we increment top + 1.
 *  Whenever we pop() a state, we decrement top - 1. 
 * 
 * @author bgerk
 */
public class Stack {
	private int size;
	State stateStack[];
	private int top;
	
	/**
	 * The Stack constructor constructs a new stack based on the given size parameter.
	 * 
	 * @param s
	 */
	public Stack(int s) {								//constructor
		
		size = s;									//set size of the stack array		
		top = -1;									//no items yet, start at -1.
		stateStack = new State[s];					//create a new stack array.
	}
	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	/**
	 * The printStack() method prints the stack in terms of 'first in last out' based
	 * on the reversed array of state objects in Project2 class.
	 * 
	 */
	public void printStack() {
		
		System.out.printf("%-15s%-15s%-18s%-17s%-15s%-15s%-15s%-15s%-19s%-17s%-17s%-17s%n",
				"Name", "Capitol", "Region", "US House Seats", "Population", "Covid Cases",
				"Covid Deaths", "Income", "Crime Rate", "CFR", "Case Rate", "Death Rate");
		for(int j = 0; j < 190; j++) {
			System.out.print("-");
		}
		System.out.println();
		for (int i = stateStack.length - 1; i > 0; i--) { 
			System.out.printf("%-15s%-15s%-18s%-17s%-15s%-15s%-15s%-15s%-15s%-20s%-20s%-20s%n", stateStack[i].getName(),
							stateStack[i].getCapitol(), stateStack[i].getRegion(), stateStack[i].getUsHouseSeats(), 
							stateStack[i].getPopulation(), stateStack[i].getCovidCases(), stateStack[i].getCovidDeaths(),
							stateStack[i].getIncome(), stateStack[i].getCrimeRate(), String.format("%.6f", stateStack[i].getCFR()), String.format("%.2f", stateStack[i].getCaseRate()),
							String.format("%.2f", stateStack[i].getDeathRate()));
		}
	}
	
	/**
	 * The pop() method pops a state object out of the top of the stack
	 * 
	 * @return stateStack[top--] if stack is not empty
	 */
	public State pop() {
		State[] s = new State[--size];
		s = stateStack;
		return s[top--];
	}
	/**
	 * The push() method pushes a state object onto the top of the stack.
	 * 
	 * @param State state
	 */
	public void push(State state) {	
			stateStack[++top] = state;
	}
	/**
	 * The stackIsEmpty() method determines whether the stack is empty.
	 * 
	 * @return(top == -1) will return true if true
	 */
	public boolean stackIsEmpty() {
		return (top == -1);
	}
	/**
	 * The stackIsFull() method determines whether the stack is full.
	 * 
	 * @return (top == size) will return true if true
	 */
	public boolean stackIsFull() {
		return (top == size - 1);
	}
}
