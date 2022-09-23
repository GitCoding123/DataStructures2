/**
 * The PriorityQ class initializes a priority queue with a set size and number of items
 * in which we insert from our sorted array in terms of highest priority. 
 * 
 * @author bgerk
 */
public class PriorityQ {

	private int size;
	State stateQueue[];
	private int items;
	
	/**
	 * Constructor PriorityQ constructs a priority queue based on the
	 * given size parameter.
	 * 
	 * 
	 * @param s
	 */
	public PriorityQ(int s) {			//Constructor
		size = s;
		items = 0;
		stateQueue = new State[size];
	}
	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	/**
	 * The printQueue() method prints out the priority queue in terms 
	 * of the highest priority.
	 * 
	 */
	public void printQueue() {
		System.out.printf("%-15s%-15s%-18s%-17s%-15s%-15s%-15s%-15s%-19s%-17s%-17s%-17s%n",
				"Name", "Capitol", "Region", "US House Seats", "Population", "Covid Cases",
				"Covid Deaths", "Income", "Crime Rate", "CFR", "Case Rate", "Death Rate");
		for(int j = 0; j < 190; j++) {
			System.out.print("-");
		}
		System.out.println();
		for (int i = 0; i < stateQueue.length; i++) { 
			System.out.printf("%-15s%-15s%-18s%-17s%-15s%-15s%-15s%-15s%-15s%-20s%-20s%-20s%n", stateQueue[i].getName(),
							stateQueue[i].getCapitol(), stateQueue[i].getRegion(), stateQueue[i].getUsHouseSeats(), 
							stateQueue[i].getPopulation(), stateQueue[i].getCovidCases(), stateQueue[i].getCovidDeaths(),
							stateQueue[i].getIncome(), stateQueue[i].getCrimeRate(), String.format("%.6f", stateQueue[i].getCFR()),
							String.format("%.2f", stateQueue[i].getCaseRate()), String.format("%.2f", stateQueue[i].getDeathRate()));
		}
	}
	/**
	 * The insert() method inserts a state through the parameter, in which we define
	 * in the Project2 class, by the highest priority
	 * 
	 * @param s1
	 */
	public void insert(State s1) {
		
		int w;
		
		
		if(items == 0) {							//if there are no items	
			stateQueue[items] = s1;
													//we insert the new item at 0
			items++;
		}
		else if(items >= 1 && items <= 49) {
																	// otherwise
				for(w = items - 1; w >= 0; w--) {					// if the number of items start at the end of the queue(descending order)	
					if(s1.getDeathRate() < stateQueue[w].getDeathRate()) {						// if the new item is larger, 
						stateQueue[w + 1] = stateQueue[w];			// shift upwards
					}
					else {											//otherwise
						break;										// we finish shifting
					}
				}
			stateQueue[w + 1] = s1;							//insert the item into the queue
			items++;											//increase number of items by 1
		}
		else {
			System.out.println("Cannot insert to the priority queue because it is full!");
		}
		
		
	}
	
	/**
	 * The remove() method removes a state object with the highest priority.
	 *
	 * @return stateQueue[--items]
	 */
	public State remove() {
	
		return stateQueue[--items];
	}
	
	/**
	 * The queueIsEmpty() method determines whether or not the priority queue is empty.
	 * 
	 * @return (items == 0)
	 */
	public boolean queueIsEmpty() {
		return (items == 0);
	}
	
	/**
	 * The queueIsFull() method determines whether or not the priority queue is full.
	 * 
	 * @return (items == size)
	 */
	public boolean queueIsFull() {
		return (items == size);
	}

}
