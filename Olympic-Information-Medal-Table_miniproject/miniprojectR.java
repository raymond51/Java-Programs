/* ***************************************
   AUTHOR: Raymond Zhen
	Date : 01/10/16
   ****************************************/
import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;
class miniprojectR
{
 

    public static void main(String[] param)
    {

        //LEVEL 1
        /* We want to print out the message defined in method printResults
        asks the usesr if he/she wants to see the GB medals won*/

        printoutBritainScore();

      //LEVEL 2
      /*
      This program gets the users input for medals: gold,silver and bronze and adds the input to a total which is displayed
      */

       // totalMedalsWon();

             int Gold=goldWon();
       int Silver=silverWon();
       int Bronze=bronzeWon();
       int total=Gold + Silver + Bronze;
        System.out.println("Total of medals won today:" + total);

          //LEVEL 3
          /*
          asks the user what type of medal (gold,silver, bronze or all) they would only like to see, the program displays a message with the corrosponding amount of medals won according to the type of medal
          */
           Scanner sc = new Scanner(System.in);
            
            System.out.println("What medals are you interested to see? gold,silver,bronze or all");
            String medalChosen = sc.nextLine();        
          if (medalChosen.equals("gold"))
          {
            //comparison operator, this statement will be executed if the condition is met
             System.out.println("the number of old and new medals won for gold is: " + oldnewGold(Gold));
             //outputs a message and the number of medals won for a specific medal
            // the method takes a parameter, this parameter passes a value to the method which will calculate the amount of medals won
          } else if (medalChosen.equals("silver")){
             System.out.println("the number of old and new medals won for silver is: " + oldnewSilver(Silver));
          } else if (medalChosen.equals("bronze")){
            System.out.println("the number of old and new medals won for bronze is: " + oldnewBronze(Bronze));
          } else {
             System.out.println("the number of old and new medals won for all is: " + oldnewTotal(total));
          }

          
          //LEVEL 3 Almost
          /*
          Author : Raymond Zhen
          date: 01/10/16
          A new object is defined, which will hold all the information passed to it by a setter, the information stored in the record will be retrieved using a getter and displayed to the user
          */
          countryRecord cR = new countryRecord();

          //declaring new object
            cR = setcountryName(cR,"GB");
            //passing value through a setter
             cR = setGold(cR,oldnewGold(Gold));
             //the setter requires two parameter which is the object name and the name of the country
           cR = setSilver(cR,oldnewSilver(Silver));
           //passing function values to the setter
           cR = setBronze(cR,oldnewBronze(Bronze));
           System.out.println("Name: "+ getcountryName(cR)+ " Gold="+ getgold(cR)+" Silver="+getsilver(cR)+" bronze="+ getbronze(cR));
          //printing out the information using a getter, the getter requires a parameter which is the object name

          		

            //LEVEL 4 & LEVEL 5
                 /*
              Date: 05/10/16
              Author :Raymond Zhen


                */
            String confirmation;
            //required to get user input 
            int limitCounter = 0;
            //declare a counter to store the content in the correct index and also to halt program by index out of bounds
            String[][] medalStorage=new String[15][3];
            //declaring array giving the variable 3 indexes and 7 rows
              do{
                updateMedals(cR);
            //calls the method called updateMedals to get user to input amount of medals
                  System.out.println("Enter Y to add a new day");
                  confirmation = sc.nextLine();
            //pauses the program to obtain the users input 
                    medalStorage[limitCounter][0] = Integer.toString(getgold(cR));
            //stores the number of medals scored for gold in the first index of the array 
                    medalStorage[limitCounter][1] = Integer.toString(getsilver(cR));
                    medalStorage[limitCounter][2] = Integer.toString(getbronze(cR));
                  limitCounter++;
              //increment counter by 1 through each loop
            }while(confirmation.equals("Y"));
            //while condition 
            //determines if the user input is Y or if the counter has reached 6 to halt loop
             System.out.println("Storing medals in array..");
                //print a friendly message to user
             
             System.out.println("displayed as gold, silver then bronze:");
                 //prints out a friendly message
             PrintArrayMedals(medalStorage);
                 //prints out the number of medals won one by one


                //LEVEL 6
                //Creating new object methods and providing them with intial values to be used in the constructor
                // declared the object using the class not the abstract class as it not fully completed class

                  medalTable medalCountry[] = new medalTable[4];

               for(int k = 0;k<medalCountry.length;k++)
                {  
                    medalCountry[k] = new medalTable();
                }  

                  createCountryMedal(medalCountry[0],"china",41,12,4,50,15,20);
                     createCountryMedal(medalCountry[1],"Brazil",2,6,100,4,5,90);
                        createCountryMedal(medalCountry[2],"America",90,1,1,100,0,1);

           for(int i =0;i<medalCountry.length;i++){
                PrintMultipleMedalTable(medalCountry[i]);
              }

                    //LEVEL 7

                    askMedalsWonInOrder(medalCountry[0].countrymedalStorage,medalCountry[1].countrymedalStorage,medalCountry[2].countrymedalStorage);


                    //LEVEL 8

                    determineFileSave(medalStorage);
                    //pass the array which contains new user daily medal input

                    System.exit(0);
                    } // END main




                     //LEVEL 8 


                    public static void determineFileSave(String[][] medalStore)
                    {

                  
                      try{  
                          BufferedReader br = new BufferedReader(new FileReader("text.txt"));   
                          //read the file called text.txt
                        if (br.readLine() == null)
                          //check if the file is not empty
                         {
                        System.out.println("file empty, would you like to write daily medals to file? Y/N");
                            if ((JOptionPane.showInputDialog("Type Y to save your daily medals")).equalsIgnoreCase("y"))
                              //ask the user for input
                            {
                              writeText(medalStore);
                              //store the new data into file
                                System.out.println("Displaying new data");
                              readText();
                              //then after storing data show data to the user
                            }
                          
                        } else 
                        {
                           System.out.println("\nFetching data from previous input\n");
                             readText();
                             //fetching data from file from previous input 
                            System.out.println("\nDo you want to save new data? Y/N\n");
                             if ((JOptionPane.showInputDialog("Type Y to save your daily medals")).equalsIgnoreCase("y"))
                            {
                              writeText(medalStore);
                              //once user wants to update new records, it will overwrite the existing file
                              System.out.println("\nSAVING COMPLETE\n");
                            }

                        }
                    }catch (IOException e)//catches the error
                      {

                      System.out.println("error");
                      }

                    }

                  

                    public static void writeText(String[][] medalStore)
                    {
                      try{
                      FileWriter fw = new FileWriter("text.txt");
                      //declare this object to determine if the file can be written to or not
                      PrintWriter pw = new PrintWriter(fw);
                      //declare this to write formatted data to a certain file
                      int incrementer = 0;
                      
                     for (int row=0;row<medalStore.length;row++)
                      {
                          //loops through the the amount of rows in the array
                          pw.println("\tDay"+row);
                          //store the day along with the data in text file
                          for (int col=0;col<medalStore[row].length;col++)
                          {
                            //loops through the the amount of columns there is on current row
                            if ((medalStore[row][col]) != null)
                              //check if the array at this index is not empty
                            {
                             pw.println(medalStore[row][col]);
                            //otherwise write this data to the file
                            }
                          }
                            incrementer++;
                          //increment by 1 each time
                       }


                      pw.close();
                    }catch (IOException e)
                      {

                      System.out.println("error");
                      }
                    }

                    public static void readText()
                    {
                      try
                      {
                        FileReader fr = new FileReader("text.txt");
                        BufferedReader br = new BufferedReader(fr);
                        //declare this to provide efficient reading of files

                        String str;
                        while ((str= br.readLine())!= null) 
                        {
                          //check if file is not empty
                          System.out.println(str);
                        }
                        br.close();
                        //close buffered reader connection
                      }catch (IOException e)
                      {
                        System.out.println("File not found");
                      }


                    }

                    //LEVEL 7
                    public static void askMedalsWonInOrder(int[][] chinaMedals,int[][] brazilMedals,int[][] americaMedals)
                    {
                      //recieves the parameter as arrays 
                      Scanner sc = new Scanner(System.in);
                      System.out.println("Do you want to see medal table in order of medals won? Y/N");
                      String userAnswer = sc.nextLine(); 
                      //get user input
                      if (userAnswer.equalsIgnoreCase("y"))
                        //checks if the user has entered yes
                      {

                       bubbleSort(provideTotalScore(chinaMedals,brazilMedals,americaMedals));
                      //pass the array to the bubble sort method
                      }

                      return;
                    }

                    public static int[] provideTotalScore(int[][] chinaMedals,int[][] brazilMedals,int[][] americaMedals)
                    {
                      //this method adds up the number of medal in one column and continues adding until all columns completed
                      int[] total = new int[3];
                      //Create a new variable to store the total medals won by each country, has size 3 as there is only three countries
                      total[0] = addTotalMedals(chinaMedals); 
                      //adds the total amount of medals for china and store it in total
                       total[1] = addTotalMedals(brazilMedals);
                        //adds the total amount of medals for brazil and store it in total
                        total[2] = addTotalMedals(americaMedals);
                         //adds the total amount of medals for america and store it in total



                        /******************************
                          USE THIS METHOD TO CHECK THE size of medals using BUBBLE SORT
                        */

                      return total;
                    }

                    public static int addTotalMedals(int[][] countryMedals)
                    {
                      int tempTotal=0;

                        int incrementer = 0;
                  //temp storage to hold incrementation
                      for (int row=0;row<countryMedals.length;row++)
                      {
                          //loops through the the amount of rows in the array
                           
                          for (int col=0;col<countryMedals[row].length;col++)
                          {
                            //loops through the the amount of columns there is on current row
                              tempTotal = tempTotal + countryMedals[row][col];
                              //print the content in array
                        }
                            incrementer++;
                          //increment by 1
                        }

                        return tempTotal;
                    }


                      public static void bubbleSort(int[] numArray)
                     {
                      //bubble sort algorithm to sort the array in terms of size in ascending order
                      //takes the parameter, which the the array that needs to be reordered
                          int chinaScore = numArray[0];
                          int brazilScore = numArray[1];
                          int americaScore = numArray[2];
                          //set the score of each individual country in terms of the array index

                          int n = numArray.length;
                          //grabs the length of the array
                          int temp = 0;

                          for (int i = 0; i < n; i++) {
                              for (int j = 1; j < (n - i); j++) {
                                //loop through each item starting from the end

                                  if (numArray[j - 1] > numArray[j]) {
                                    //check if the previous item in array index is greater than the item in current array index
                                      temp = numArray[j - 1];
                                      //store the previous item in temp
                                      numArray[j - 1] = numArray[j];
                                      //set the previous item as current item
                                      numArray[j] = temp;
                                      //set the current item as previous item
                                  }

                              }
                          }

                          for (int j = 0; j<n;j++)
                            //for loop throught the array size
                          {
                            if (chinaScore == numArray[j])
                              //check if the if statement equals to the number in array at a certain index 

                            {
                                System.out.println("China is number "+(3-j)+" in the world with medals won: "+numArray[j]);
                            } else if(brazilScore== numArray[j])
                            {
                               System.out.println("Brazil is number "+(3-j)+" in the world with medals won: "+numArray[j]);
                            }else if (americaScore ==numArray[j])
                            {
                               System.out.println("America is number "+(3-j)+" in the world with medals won: "+numArray[j]);
                            }

                          }

                      }

                //LEVEL 6
                   public static void PrintMultipleMedalTable(medalTable t)
                      {
                             //the printMedalMedal method takes two parameters: the name of the country which is retrieved from the object class
                // and the 2D array which will hold old and new records achieved by that country
                 PrintMedalTable(getName(t),t.countrymedalStorage);
            
                   //this method will print out records about a particular country
                     
                        return;
                        }

                public static void PrintMedalTable(String nameofCountry,int[][] medalTable)
                {
                  //takes in the name and 2d array
                    System.out.println("\t"+nameofCountry);
                    //creates space and prints out the name of the country
                  int incrementer = 0;
                  //temp storage to hold incrementation
                      for (int row=0;row<medalTable.length;row++)
                      {
                          //loops through the the amount of rows in the array
                            if (incrementer ==0)
                            {
                                System.out.println("\tNew Records:");
                                //prints new records first
                             } else 
                             {
                               System.out.println("\tOld Records:");
                              //print old records after new record
                            }
                          for (int col=0;col<medalTable[row].length;col++)
                          {
                            //loops through the the amount of columns there is on current row
                              System.out.println(medalTable[row][col]);
                              //print the content in array
                        }
                            incrementer++;
                          //increment by 1
                        }
                  return;
                  }//END printMedalTable




                    public static String getName(medalTable t) 
                      {
                      return t.newcountryName;
                      //getter method which returns the data in variable
                      }


                          public static medalTable createCountryMedal(medalTable t,String name,  int newgoldIn, int newsilverIn, int newbronzeIn, int oldgoldIn, int oldsilverIn, int oldbronzeIn)
                           {
                            // using this will reference this abstract class
                            
                                 t.newcountryName = name;
                                t.countrymedalStorage[0][0] = newgoldIn;
                               t.countrymedalStorage[0][1] = newsilverIn;
                                t.countrymedalStorage[0][2] = newbronzeIn;
                                 t.countrymedalStorage[1][0] = oldgoldIn;
                                t.countrymedalStorage[1][1] = oldsilverIn;
                                t.countrymedalStorage[1][2] = oldbronzeIn;
                                System.out.println("\nIntialising "+ name);
                              //print out a message indicating successful initialisation
                                 return t;
                           }



//  LEVEL 5


                      // printing the medal storage to the user
                      public static void PrintArrayMedals(String[][] medalsWon)
                      {

                          
                          for (int row=0;row<medalsWon.length;row++)
                          {
                            //loops through the the amount of rows in the array
                            System.out.println("\tDay"+row);
                            //prints out the day which the array is on
                            for (int col=0;col<medalsWon[row].length;col++)
                            {
                              //loops through the the amount of columns there is on current row
                              if(medalsWon[row][col]!=null)
                              {
                                //checks if the array at that index is empty if not then print out the contents
                                System.out.println(medalsWon[row][col]);
                              }
                            }
                          } 

                      return;
                      }//END printArrayMedals


//LEVEL 4

                      public static void updateMedals(countryRecord cr)
                      {
                         System.out.println("enter number of medals scored today in the order of gold, silver and bronze");
                          //prints out a friendly message asking user to input some data regarding the medals

                         startLoop(cr);
                         //a method called startLoop 
                        System.out.println("Name: "+ getcountryName(cr)+ " Gold="+ getgold(cr)+" Silver="+getsilver(cr)+" bronze="+ getbronze(cr));
                        //prints out the information about medals this information was retrieved from the class called countryRecord
                        return;
                      }


                      public static void startLoop(countryRecord cr)
                      {
                          for(int counter=1;counter<=3;counter++)
                          {
                           //a for loop which will loop 3 times in total  
                             setMedal(cr,counter);
                           //calls the method called setMedal which takes a parameter counter

                          }
                      return;
                      }

                  public static void setMedal(countryRecord cr,int incremented)
                  {
                      //accepts a parameter which is used in the if statement
                     Scanner sc = new Scanner(System.in);
                     //declaring a new scanner
                     int storage = sc.nextInt();
                     //allow the user to have input and store this in a variable called storage
                          if (incremented==1)
                          {
                               cr = setGold(cr,storage);
                               //set the new value of gold medals won 
                          }else if(incremented==2)
                          {
                              cr = setSilver(cr,storage);
                        }else if(incremented==3){
                            cr = setBronze(cr,storage);
                        }
                  return;
                }

    //LEVEL 3 Almost

                  public static countryRecord setcountryName (countryRecord c, String name)
                  {
                      c.countryName = name;
                      // set the name of the country using the local variable which has the value passed to it 
                     return c;
                     //returns control back to where it was called
                  }

                    public static countryRecord setGold (countryRecord c, int medalScored)
                    {
                     c.noofGold= medalScored;

                     return c;
                  }
                    public static countryRecord setSilver (countryRecord c, int medalScored)
                    {
                       c.noofSilver= medalScored;

                       return c;
                  }
                    public static countryRecord setBronze (countryRecord c, int medalScored)
                    {
                       c.noofBronze= medalScored;

                       return c;
                  }


                    public static String getcountryName(countryRecord c)
                    {
                        return c.countryName;
                       //returns the name of the country as string, returns the name according the object name
                  }

                    public static int getgold(countryRecord c)
                    {
                         //takes the parameter of the object name
                         return c.noofGold;
                  }
                    public static int getsilver(countryRecord c)
                    {
                       return c.noofSilver;
                  }
                    public static int getbronze(countryRecord c)
                    {
                       return c.noofBronze;
                  }



    //LEVEL 3



                  public static int oldnewGold(int newGold)
                  {
                    //takes a value in as a parameter, this parameter is used in the method
                      int gold = 0;
                      //initialise the variable
                      gold = 27 + newGold;
                      return gold;
                    }
                 public static int oldnewSilver(int newSilver)
                 {
                      int silver = 0;
                      silver = 23+ newSilver;
                      return silver;
                    }
                 public static int oldnewBronze(int newBronze)
                 {
                      int bronze = 0;
                      bronze = 17 + newBronze;
                      return bronze;
                    }
                 public static int oldnewTotal(int newTotal)
                 {
                      int total = 0;
                      total = 67 + newTotal;
                      return total;
                    }

    //LEVEL 2

                public static int goldWon()
                {
                   Scanner sc = new Scanner(System.in);
                  int gold = 0;
                  System.out.println("How many people won a gold medal today?");
                  gold = sc.nextInt();
                  
                  return gold;
                }
               public static int silverWon()
               {
                     Scanner sc = new Scanner(System.in);
                    int silver = 0;
                    System.out.println("How many people won a silver medal today?");
                    silver = sc.nextInt();
                    
                    return silver;
              }

               public static int bronzeWon()
               {
                     Scanner sc = new Scanner(System.in);
                    int bronze = 0;
                    System.out.println("How many people won a bronze medal today?");
                    bronze = sc.nextInt();
                    
                    return bronze;
              }



//LEVEL 1

                public static void printoutBritainScore()
                  {
                    
                  System.out.println("Do you wanna see how many medals GB won? Press Y for yes");
                  Scanner sc = new Scanner(System.in);
                  String userInput = sc.nextLine();
                      if (userInput.equals("Y")){
                        printResults();
                      }
                        
                    return;
                  } // END printoutBritainScore

                 public static void printResults()
                  {
                    int goldwon = 27;
                    int silverwon = 23;
                    int bronzewon = 17;
                    int totalmedals = 67;
                   System.out.println("\t\tG\tS\tB\tTotal");
                    System.out.println("Great Britain\t"+goldwon+"\t"+silverwon+"\t"+bronzewon+"\t"+totalmedals);

                
                    return;
                  } // END printResults



} // END class mproject1

 class medalTable 
 {
  //creating a new abstract data type 
      public String newcountryName="empty";
         //need to initialise variable otherwise error will occur
      public int[][] countrymedalStorage=new int[2][3];
      //declaring an array with dimensions 2x3
      //first row will store new records and second row will store old records
      //first, second and third column will store the medals 

         

}

 class countryRecord 
 {
  //this is a class separate from the miniproject class
    public String countryName;
    public int noofGold;
    public int noofSilver;
    public int noofBronze;
}


