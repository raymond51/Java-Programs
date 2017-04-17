/* ***************************************
   AUTHOR: Raymond Zhen
	Date : 13/10/16
   ****************************************/
import java.util.Scanner;
//importing the scanner library
class endangeredAnimals
{
  public static void main(String[] param)
    {
      Scanner sc = new Scanner(System.in);
      //declaring a new scanner 

      String animals[]= {"Komodo Dragon","Manatee","Kakapo","Florida panther","White rhino"};
      //store the names of the animals in array
      int animalCount[] = new int[5];
      //declaring a variable called animalCount as int which holds 5 indexes
      for (int counter=0;counter<=4;counter++)
      {
        	//leeop through the index of the array and record the input in the array
      	 System.out.println(animals[counter] +":\nHow many are left in the wild?");
      	 //prints out a message to the user
      	 animalCount[counter] = sc.nextInt();
      	//stores the user input in the array according to that index
      }

       int minIndex = 0;  // start with 0th element as min
       minIndex = getIndex(animals,animalCount);
   
        printAnimal(animals,animalCount,minIndex);
	     	System.exit(0);// exits 
		
    } // END main

     public static int getIndex(String[] name,int[] count)
     {
          //takes a value in as a parameter, this parameter is used in the method
          int value = 0;
             for (int i=1; i<name.length; i++)
              {
                  //loop through the array until index completed
                  if (count[i] < count[value])
                   {
                    //check if the condition is correct
                    //only when the value in minIndex is smaller than one in array
                    value = i;
                    //stores the index where the value is lowest
                   }
              }
        return value;
      }

     public static void printAnimal(String[] name,int[] count,int index)
     {
          //takes a value in as a parameter, this parameter is used in the method
        System.out.println("The most endangered animal is the "+ name[index]);
        //print out a message to the user about the animal
        System.out.println("There are only "+count[index]+" left in the wild.\n");
        //print out the number of animals left
        for (int counter=0;counter<=4;counter++)
        {
          //loop through the array and print all the animals and there population
          System.out.println(count[counter] + ","+ name[counter]);
    

     
       }
     }

} // END class endangeredAnimals

