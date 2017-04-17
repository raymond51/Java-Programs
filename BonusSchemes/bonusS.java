 /* ***************************************
   AUTHOR: Raymond Zhen
	Date : 15/10/16
   ****************************************/
import java.util.Scanner;
//importing the scanner library
class bonusS
{

    public static void main(String[] param)
    {
        employee e1 = createEmployee(0, 0,0);
        //creatinga a new object of employee so that we can store info about them

        askEmployeeScore(e1);
 
          System.exit(0); // exit out of the program
 } // END main
//**************************************************
        public static void askEmployeeScore(employee e1)
        {
                //declaring variables
      Scanner sc = new Scanner(System.in);
      //delcaring scanner to get users inpuT
        System.out.println("Profit Score?");
      //prints out a message to the user
       e1 = setprofitScore(e1, sc.nextInt());
        //the input is read from the user as int and stored passed to the setter method to be stored in the object
      System.out.println("Hard work Score");
     e1 = sethardworkScore(e1, sc.nextInt());
     int finalscore = calculateFinalScore(calculateProfitScore(getprofitScore(e1)),calculateHardWorkScore(gethardworkScore(e1)));

        printScore(finalscore,calculateBonusPay(finalscore));

        return;
        }
//**************************************************
        public static void printScore(int performanceScore, int bonus)
        {
            System.out.println( performanceScore +"out of 10\n Your bonus is "+ bonus +" pounds.");

 // prints out the performance to the user
      //The calculateFinalScore takes two parameters the profit score value (out 20) and hard work score value (out of 50) and produces an overall score
      // this uses the newly defined object method to determine its score
      //calls the method from the class called calculateBonusScheme, this method takes a parameter which is the final score the employee has recieved

          return;
        }
//**************************************************
         public static employee createEmployee (int profitScore, int hardworkScore,int finalEmployeeScore)
         {
          employee e = new employee();

           e.profitScore = profitScore;
           e.hardworkScore = hardworkScore;
           e.finalEmployeeScore = finalEmployeeScore;
          
           return e;
         }
         //**************************************************
      public static int getprofitScore(employee e) {
          return e.profitScore;
          //getter method which returns the data in variable
       }
//**************************************************
      public static int gethardworkScore(employee e) {
          return e.hardworkScore;
          //getter method which returns the data in variable
          //returns the data as an integer
       }

//**************************************************
      public static employee setprofitScore(employee e, int pscore){
        //takes a parameter, the input is recieved from user and is stored in the variable called profitScore
         e.profitScore = pscore;
         //profitScore gets value from pscore
      return e;
      }
//**************************************************
     public static employee sethardworkScore(employee e, int hwscore){
         e.hardworkScore = hwscore;
         //stores the data from parameter in variable called hwscore
      return e;
      }
//**************************************************
      public static int calculateProfitScore(int psScore){
      //takes parameter 
      int tempScore = 0;
       tempScore = 2 * psScore;
      //maths operation calculated here
      return tempScore;
    //returns the data as integer to where it was called from
     }
//**************************************************
      public static int calculateHardWorkScore(int hwScore){
      int tempScore = 0;
      //temporary storage for score which is destroyed after the method is complete
        tempScore = 5 * hwScore;
         //maths operation calculated here
       return tempScore;
     }
//**************************************************
      public static int calculateFinalScore(int psScore, int hwscore){
      int finalScore = 0;
        finalScore = hwscore + psScore;
        finalScore = finalScore/7;
    
      return finalScore;
     }
//**************************************************
      public static int calculateBonusPay(int finalScore){
      int bonusPay = 0;
      //temporary storage which gets destroyed
        bonusPay=finalScore * 5000;
        //multiplys the final score to calculate the employee bonus pay
      return bonusPay;
      //returns the bonus pay as int
    }
} // END class bonusScheme

//**************************************************
class employee {
  //creating a new abstract data type, this will be the framework of class employee
    public int profitScore;
    public int hardworkScore;
        public int finalEmployeeScore;
    //declare this variable to hold the final score for the user
       //need to initialise variable otherwise error will occur
    //these variables are required to hold values by user

}


     
