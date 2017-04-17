import java.util.Scanner;
/* ***************************************
   AUTHOR: Raymond Zhen
	A program that works out if your fitness age as a way of inidicating whether you are fitter than your actual age or not.
   ****************************************/

class underground
{


	


    public static void main(String[] param)
    {	

    	//Defining variables
		

		int zoneStorage = 0;

        // We want to print out the message defined in method getUndergroundZone

	System.out.println("What station do you need to know the zone of?");
	//print out a friendly message
	 String userInput= "";
	Scanner sc = new Scanner(System.in);
	userInput = sc.nextLine();
	zoneStorage = getUndergroundZone(userInput);
	
	// store the returned into zoneStorage

	if (zoneStorage!=0){
	System.out.println(userInput + " is in zone "+ zoneStorage);
}else{
System.out.println("Is "+ userInput +" a London Underground Station? Maybe check your spelling");
}
		System.exit(0);
		
    } // END main


    public static int getUndergroundZone(String userInput){

	int stationZone = 0;

	//read the string the user has inputted
	if (userInput.equals("Mile End") || userInput.equals("mile end")) {
	stationZone = 2;
}
else if(userInput.equals("Liverpool Street")  || userInput.equals("liverpool street")) {
	stationZone = 1;
}else if(userInput.equals("Woodford")  || userInput.equals("woodford")) {
	stationZone = 4;
}else if(userInput.equals("Wimbledon")  || userInput.equals("wimbledon")) {
	stationZone = 3;
}else if(userInput.equals("Cockfosters") || userInput.equals("cockfosters")) {
	stationZone = 5;
}else{
return stationZone;
}

	
	    return stationZone;
    } // END getUndergroundZone
	
} // END class underground
