/* ***************************************
   AUTHOR: Raymond Zhen
	Date : 07/10/16
   ****************************************/
import java.util.Scanner;
class artGallery
{

//create a new instance of an object called pS
    public static void main(String[] param)
    {
        // We want to print out the message defined in method printResults
      paintingStorage pS = new paintingStorage();
            paintingStorage pS1 = new paintingStorage();
                  paintingStorage pS2 = new paintingStorage();
                        paintingStorage pS3 = new paintingStorage();

      System.out.println("Hello, tell me what room you are in?");
        //asks a friendly question to stranger
      initialisePaintingRecord(pS,"ahead of you"," marty cassatt","Women with a Pearl Necklace in a lodge","1879","81.3cm","59.7cm");
         initialisePaintingRecord(pS1,"ahead of you","Rembrandt","self-potrait with Beret and Turned-up collar","1659","84.5cm","66.0cm");
            initialisePaintingRecord(pS2,"on the left","Olga Boznanska","girl with Chrysanthemums","1894","88.5cm","69.0cm");
               initialisePaintingRecord(pS3,"on your right","claude Monet","Impression, Sunrise","1872","48.0cm","63.0cm");


      //set default info on the room records
      Scanner sc = new Scanner(System.in);
      //declaring a new scanner 
      int userInput = sc.nextInt();
      //storing the users input and quering the construct

if (userInput==1){
	//if statement to determine if input matches
 System.out.println(getRoomPainting(pS));
} else if (userInput==2){
 System.out.println(getRoomPainting(pS1));
}else if (userInput==3){
 System.out.println(getRoomPainting(pS2));
}else if (userInput==4){
 System.out.println(getRoomPainting(pS3));
} else {
 System.out.println("The room: "+userInput+" dosent seem to be a valid room.");
 //prints out another statement which tells the user a room does not exist
}

		System.exit(0);// exits 
		
    } // END main

public static void initialisePaintingRecord(paintingStorage pS,String direction,String artist,String title,String year,String height,String width){
//this method provides information the the record called PaintingStorage so that it can be accessed by a getter by the main program
	pS = setdirection(pS,direction);
	pS = setartist(pS,artist);
	pS = settitle(pS,title);
	pS = setyear(pS,year);
	pS = setheight(pS,height);
	pS = setwidth(pS,width);
return;
}

public static paintingStorage setdirection (paintingStorage c, String info){
	//takes the record as first paramenter and the information about room in second parameter
  c.direction = info;
  //sets the info in the record
  return c;
}
public static paintingStorage setartist (paintingStorage c, String info){
  c.artist = info;
  return c;
}
public static paintingStorage settitle (paintingStorage c, String info){
  c.title = info;
  return c;
}
public static paintingStorage setyear (paintingStorage c, String info){
  c.year = info;
// passes info to the record called paintingStorage
  return c;
  //returns control back to where it was called
}
public static paintingStorage setheight (paintingStorage c, String info){
  c.hieght = info;
// passes info to the record called paintingStorage
  return c;
  //returns control back to where it was called
}


public static paintingStorage setwidth (paintingStorage c, String info){
  c.width = info;
// passes info to the record called paintingStorage
  return c;
  //returns control back to where it was called
}





 public static String getRoomPainting(paintingStorage c){
 	String info ="The painting "+ c.direction+" is by "+c.artist+". It was painted in "+c.year+" and is called "+c.title+". It is "+c.hieght+" by "+c.width;
  return info;
  //returns the info about rooms as string, returns the name according the object name
}
	

} // END class artGallery

 class paintingStorage {
 	//this is a record which will hold all the information about paintings, each variable holds different information about the room
 public String direction;
 public String artist;
 public String title;
  public String year;
    public String hieght;
      public String width;

}