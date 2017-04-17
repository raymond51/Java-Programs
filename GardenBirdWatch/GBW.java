 /* ***************************************
   AUTHOR: Raymond Zhen
	Date : 14/10/16
  Description : The program asks the user what bird have they seen if the enter end the program terminates otherwise it will ask you for the number of birds you have seen
  and prints the most common bird you have inputted 
   ****************************************/
import java.util.Scanner;
//importing the scanner library
class GBW
{

    public static void main(String[] param)
    {
      //declaring variables
      Scanner sc = new Scanner(System.in);
      //delcaring scanner to get users input
      int numSeen[] = new int[10];
      //a array which stores number of birds seen as integer of ten indexes
      String birdName[] = new String[10];
      //a array used to store name of the birds as string with 10 indexes
      int incrementer =0;


       while( incrementer< 10)
       {
      print("Which bird have you seen?");
        //print out message to user
      	 	birdName[incrementer] = sc.nextLine();
          //stores the name of the bird the user has inputted into the array 
          //this array wil increment each time is looped
        	if (birdName[incrementer].contains("END"))
          {
            //check if the array contains the string END
        		break;
            //break out of the loop
        	}
         
      	print("How many were in your garden at once?");
            //print out message to user
      	numSeen[incrementer]= sc.nextInt();
        //stores the number of birds seen which corrosponds to the name of the bird
        sc.nextLine();
        //add a next line so that the reader does not consume the input
      	incrementer+=1;
        }

        int largest = numSeen[0];
        //provide the variable with the first index in array numSeen
        int storeIndex = 0;  
        //declaring the variable to store the index in array where the number of birds is at its greatest          
       for(int counter=1; counter< numSeen.length; counter++)
       {
        //loop through the array
            if(numSeen[counter] > largest)
              //if the number in array is greater than value in largets then store it 
             largest = numSeen[counter];                  
        }
        for(int counter=1; counter< numSeen.length; counter++)
        {
          //loop through the array
            if(numSeen[counter]==largest)
            {
              //checks if the value in the variable largest corrosponds to the number in numSeen array
             storeIndex = counter;    
            }                  
       }
        print("You saw "+largest+" "+birdName[storeIndex]);
        //print out the message to the user
         print("It was the most common bird seen at one time in your garden");
      		System.exit(0);// exits 
      		
    } // END main
public static void print(String message){
	System.out.println(message);
}
} // END class endangeredAnimals

