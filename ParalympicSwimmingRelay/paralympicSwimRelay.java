/* ***************************************
   AUTHOR: Raymond Zhen
	Date : 07/10/16
   ****************************************/
import java.util.Scanner;
//importing the scanner library
class paralympicSwimRelay
{

    public static void main(String[] param)
    {
		Scanner sc = new Scanner(System.in);
		//declaring a new scanner 

		int total=0;

		for (int counter=1;counter<=4;counter++){
			//this will start from the first counter and loop up until 4
			System.out.println("What is the disability class of Runner "+counter+"?");
			//print out friendly message
			int userInput = sc.nextInt();
			//storing the users input and quering the construct
			total+=userInput;
		//stores the running total inputted by the user
	}

		isValid(total);

		
			System.exit(0);// exits 
		
 } // END main

 public static void isValid(int result)
 {
    //takes a value in as a parameter, this parameter is used in the method
  		if (checkValid(result) == true)
  		{
			//uses a boolean comparison to determine if the score is legal
			System.out.println("That team has "+ result +" so is legal");
		}
		else 

		{
			System.out.println("That team has "+result+" so is NOT legal");
	}
 			
}

 public static boolean checkValid(int number){
          //takes a value in as a parameter, this parameter is used in the method
  
 			 if (number >= 33) {
  				//checks if the running total is greater than 33 if so it is not valid and return false
  			return false;
  			}

 			 return true;
}

	

} // END class paralympicSwimRelay

