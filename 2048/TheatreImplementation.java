import java.io.Console;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
*This is a simple implementation of theatre ticket booking model where user is asked to select the seats and get it booked.
*Initially the user will be shown an array of seats, there are 100 seats here. The number in a position indicates the price of the seat.
*The user has to first select the row in which he wants the seat.Then the user will be asked to provide the list of seat numbers.
*The user has to input numbers in this fashion '4 5 6 7' that is seats 4,5,6 and 7 should be booked. When the seats are booked
*The numbers at that place will be replaced by zero which means that those seats are booked.
*Run this program from console not from any IDE because the java.io.Console object will not be created.
*/
public class TheatreImplementation {

	
	public static void main(String[] args) {
		Console console	= System.console();
		if(console!=null)
			startTicketBooking(console);
		else {
			System.err.println("Restart the application and try again \n");
		    System.err.println("Make sure your running this program from the command line");
		}
	}

	/**
	* Starts the ticket booking console
	*/
	private static void startTicketBooking(Console console){
		int [][] screenSeats = new int[10][10];
		int seats_booked = 0;
		int row = 0;
		boolean seatsSelected = false;
		screenSeats = initializeArray(screenSeats); //Initialize the array with seat prices
		while(seats_booked!=100) {
			seatsSelected = false;
			console.printf("Seats with \"0\" in their place are booked!! \n");
		
			console.printf("Total Seats available: "+(100-seats_booked)+"\n");
			printSeats(screenSeats,console);
			console.printf("\n");
			//Take input from the user for the row number
			//The isValidNumber function validates the user input
			//If a wrong input is given then the user is prompted again the while loop is used for this purpose
			String row_no =  console.readLine("Please enter the row you want to book: \n");
			while(!isValidNumber(row_no,console)){ 
				row_no =  console.readLine("Please enter the row you want to book: \n");
			}
			 try{
			 	row = Integer.parseInt(row_no);
			 	row =  new Integer(2);
			 }catch(Exception e){
			 	console.printf("Ooppss!! there was some error please Restart the application!");
			 	System.exit(1);
			 }
			//After the user selects the row number that particular row gets printed
			printSpecificRow(row,screenSeats,console);
			//Now the logic for selecting seats starts from here.
			//The isValidInput function validates the list of inputs from the user
			//The user is prompted for an input until the user specifies a proper input
			seatsLoop: 
			while(!seatsSelected) {
				String seats_total = console.readLine("Please enter the seat numbers you want to book: \n");
				 while(!isValidInput(seats_total.trim(),console)){
				 	seats_total = console.readLine("Please enter the seat numbers you want to book: \n");
				 }
				int[] no_of_seats = convertStringArrayToIntArray(seats_total.trim().split("\\s"));
			//First the seats selected by the user is checked whether they are available or not
				 if (checkIfSeatsAreAvailable(screenSeats[row-1],no_of_seats)) {
			//If the seats are available then the user is prompted with the grand total and a confirmation
			// to book the tickets
				 	console.printf("Your grand Total will be : "+calculateTotal(row,no_of_seats.length)+"\n");
				 	String confirm = console.readLine("Do you want to book the tickets?: Enter yes or no \n");
				 	if(confirm.toLowerCase().equals("yes")) {
			// the positions where the user selected gets replaced by 0
			//The bookConfirmedTickets function does this
				 		screenSeats = bookConfirmedTickets(screenSeats,row-1,no_of_seats);
				 		printSeats(screenSeats,console);
				 		console.printf("Ok! Tickets are booked \n\n");
				 		seatsSelected = true;
				 		seats_booked+=no_of_seats.length;
				 	}
				 	else {
			//If the user selects 'no' on confirmation then the user is redirected to the
			//Initial Prompt
				 		console.printf("Backing out!! \n\n");
				 		break seatsLoop;
				 	}
				 }else{
			//If the selected seats are not available then the user is redirected to the
			//Initial Prompt
				 	seatsSelected = false;
				 	console.printf("Sorry! Selected seats are not available! \n\n\n");
				 	break seatsLoop;
				 }
			}	 	
		}
			console.printf("If that is the main purpose of the ticket then")
			console.printf("It's HouseFull!!!!!!");
			console.printf("Sorry All the Tickets are booked!");
	}

	/**
	*This method initializes the array for consumption
	* the array is placed with the seats prices in the cells with their position wise
	*/
	private static int[][] initializeArray(int[][] seatsArray){
		for(int i=0;i<10;i++){
			for (int j=0;j<10;j++) {
				if (i<5) 
					seatsArray[i][j]=10;	
				else if(i<8)
  					seatsArray[i][j]=20;
  				else
					seatsArray[i][j]=30;
			}
		}
		return seatsArray;
	}
	
	/**
	* This method counts the total number of tickets booked up till now
	* just return the total calculated value of tickets booked
	*/
	private static int getBookedSeatCount(int [][] seatsArray){
		int bookedSeatCount = 0;
		for (int i=0;i<10;i++) {
			for (int j=0;j<10;j++) {
				if(seatsArray[i][j]==0)
					bookedSeatCount++;
			}
		}
		return bookedSeatCount;
	} 

	/**
	* This method prints the array of seats in tabular format
	*/
	private static void printSeats(int[][] seatsArray,Console console){
		console.printf("\n");
		StringBuffer printBuffer = null;
		printBuffer= new StringBuffer();
		printBuffer.append("       1  ");
		for (int k=2;k<=10;k++) {
			printBuffer.append(+k+"  ");
		}
		console.printf(printBuffer.toString()+"\n");
		console.printf("------------------------------------- \n");
		for(int i=1;i<=10;i++){
			printBuffer = new StringBuffer();
			printBuffer.append("Row "+(i)+":  ");
			for(int j=0;j<10;j++){
				printBuffer.append(seatsArray[i-1][j]+" ");
			}
			console.printf(printBuffer.toString()+"\n");
		}
	}

	/**
	* prints the specific row of the array
	*/
	private static void printSpecificRow(int row,int[][] seatsArray,Console console){
		console.printf("\n");
		StringBuffer printBuffer = null;
		printBuffer= new StringBuffer();
		printBuffer.append("       1  ");
		for (int k=2;k<=10;k++) {
			printBuffer.append(k+"  ");
		}
		console.printf(printBuffer.toString()+"\n");
		console.printf("------------------------------------- \n");
		printBuffer = new StringBuffer();
			printBuffer.append("Row "+(row)+":  ");
			for(int j=0;j<10;j++){
				printBuffer.append(seatsArray[row-1][j]+" ");
			}
		console.printf(printBuffer.toString()+"\n");
	}

	/**
	* Checks if the value provided for the row number is valid or not
	*/
	private static boolean isValidNumber(String row_no,Console console){
		int row = 0;
				try{
					row = Integer.parseInt(row_no);
				}catch(NumberFormatException nfe){
					console.printf("Please enter a valid number!!! \n");
					return false;
				}
		if(row<1 || row>10){
			console.printf("Please enter a number between 1 and 10! \n\n");
			return false;
		}
		return true;
	}

	/**
	* Checks if the seats inputted by the user are available or not
	*/
	private static boolean checkIfSeatsAreAvailable(int[] seatsRow,int[] no_of_seats){
		boolean available = false;
		int seat_number = 0;
		for (int i=0;i<no_of_seats.length;i++) {
			if(seatsRow[(no_of_seats[i]-1)]==0){
				return false;
			}
		}
		return true;
		
	}

	/**
	* Replaces the elements selected by the user with zero to signify that the seat is booked.
	*/
	private static int[][] bookConfirmedTickets(int[][] seatsArray,int row,int[] no_of_seats){
		for (int i=0;i<no_of_seats.length;i++) {
				if(seatsArray[row][(no_of_seats[i]-1)]>0){
					seatsArray[row][(no_of_seats[i]-1)]=0;
				}
		}
		return seatsArray;
	}	

	/**
	* Calculates the amount specific to the user selection
	*/
	private static int calculateTotal(int row,int no_of_seats){
		if(row < 6)
			return 10*no_of_seats;
		else if (row < 9)
		    return 20*no_of_seats; 
		else
			return 30*no_of_seats;
	}

	/**
	* Checks if the input provided by the user for seats are valid or not 
	* Uses a regex to check that. The console is delegated to the each method
	* that needs to print on the console
	*/
	private static boolean isValidInput(String input,Console console){
		Pattern pattern = Pattern.compile("\\A(\\d{1,2}\\s)*\\d{1,2}\\Z");
		Matcher matcher = pattern.matcher(input);
		if(!matcher.find()){
			console.printf("Please enter seats numbers in the following format: \n");
			console.printf("4 5 6 7 \n");
			return false;
		}
		String[] array = input.split("\\s");
		int num = 0;
		for(int i=0;i<array.length;i++){
			try{
				num = Integer.parseInt(array[i]);
			}catch(Exception e){
				console.printf("Ooppss!! There was some error please Restart the application! \n");
				System.exit(1);
			}
			if(num<1 || num >10){
				console.printf("Please enter seats between 1 and 10 \n");
				return false;
			}

		}
		if(hasMoreOccurences(array)){
			console.printf("Please give unique numbers! no two numbers should be same \n");
			return false;
		}
		return true;
	}

	/**
	* Checks if an element has more occurences in the list of seats provided by the user
	*/
	private static boolean hasMoreOccurences(String [] arrayToSearch){
		int count=0;
		for(int i=0;i<arrayToSearch.length;i++) {
			count=0;
			String element = arrayToSearch[i];
			for (int j=0;j<arrayToSearch.length;j++){
				if(element.equals(arrayToSearch[j]))
					count++;
			}
			if (count>1) 
				return true;
		}
		return false;
	} 

	/**
	* This method converts the string array inputed by the user for seat selection into integer array.
	* This method has very narrow area of execution as it can only convert the String array of numbers 
	* As the Array Class has not utility method to reverse an array
	*/
	private static int[] convertStringArrayToIntArray(String[] seatsArray) {
		int[] returnArray = new int[seatsArray.length];
		int element = 0;
		for(int i=0;i<seatsArray.length;i++){
			try{
				element=Integer.parseInt(seatsArray[i]);
			}catch(Exception e){
				System.exit(1);
			}
			returnArray[i]=element;
		}
		return returnArray;
    }


}