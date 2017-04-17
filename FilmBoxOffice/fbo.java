 /* ***************************************
   AUTHOR: Raymond Zhen
	Date : 11/11/16
   ****************************************/
import java.util.Scanner;
//importing the scanner library
class fbo
{

    public static void main(String[] param)
    {
      
 
		getUserInput();

		//call method 


          System.exit(0); 
          // exit out of the program
 	} // END main



	public static void getUserInput()
	 {
		//declaring variables
   

      film boxOfficeFilms[] = new film[4];
      //creatinga a new object of film so that we can store info about them
 	  Scanner sc = new Scanner(System.in);
 	  
      //delcaring scanner to get users input

		for(int k = 0;k<boxOfficeFilms.length;k++)
		{  
		    boxOfficeFilms[k] = new film();
		}  



	 	for(int i =0;i<4;i++)
	 	{
     
	 		//loop 4 times as their is only four movies

	 		System.out.println("Film for screen "+(i+1)+"?");
	 		




	 		 setfilmName(boxOfficeFilms[ i ],sc.nextLine());
	 		System.out.println("What time does it start? Hour");
			 setfilmHour(boxOfficeFilms[ i ],sc.nextInt());
			System.out.println("What time does it start? Minutes after the hour");
			 setfilmMinutes(boxOfficeFilms[ i ],sc.nextInt());
			//get users input 

			sc.nextLine();
        //add a next line so that the reader does not consume the input
	 	}


	 	for(int j=0;j<4;j++)
	 	{
	 		 printFilm( boxOfficeFilms[ j ] , j + 1 );
	 	}

	 //	boxOfficeFilms.printFilms(boxOfficeFilms);
	 	//method to print out the cinema movies
	return;
	}


   public static String calcMinutes(int minutes)
      {
      	String result = "";
      	//initialising a variable to store final resutl of minute modification to suit the output display

      	if (minutes < 10 ){
      		//when the number of minutes is less than 10 append an 0 in front and store this as string
      		result = "0"+Integer.toString(minutes);
      	}else{
      		result = Integer.toString(minutes);
      		//convert the integer to string 
      	}
      				
      return result;
      //return the value as string
     }


        public static String getFilmName(film f)
        {
           //takes a parameter, the input is recieved from user and is stored in the variable 
          String ans = f.filmName;
            return ans;
            //getter method which returns the data in variable
        }

      public static int getFilmHour(film f) 
        {
          int ans = f.filmHour;
          return ans;
          //getter method which returns the data in variable
          //returns the data as an integer
       }

       public static int getFilmMinutes(film f) 
       {
         int ans = f.filmMinutes;
          return ans;
          //getter method which returns the data in variable
          //returns the data as an integer
       }

      public static film setfilmName(film f,String name)
      {
        //takes a parameter, the input is recieved from user and is stored in the variable 
         f.filmName = name;
      
        return f;
      //does not return a value
      }

     public static film setfilmHour(film f, int hour)
     {
      //takes the index this is to store information in certain positions in the array
         f.filmHour = hour;
         //stores the data from parameter in variable called hwscore
      return f;
      }
      public static film setfilmMinutes(film f, int minutes)
      {
         f.filmMinutes = minutes;
         //stores the data from parameter in variable called hwscore
      return f;
      }

      public static void printFilm(film f, int index)
     {
      //takes the argument object which is used to reference the methods 

 
        System.out.println("Screen " + index + ":"+ getFilmName( f )+"\t\t\t"+ getFilmHour( f )+":"+ calcMinutes(getFilmMinutes( f )));
        //print out the cinama films and their time 

      } 






} // END class filmboxoffice 




class film 
 {
  	//creating a new abstract data type, this will be the framework of class film
    public String filmName="";
    public int filmHour=0;
	public int filmMinutes=0;
	// creating 3 new variables to store name, hour and minute of the movie
	//each array carry 4 indexes
}




   
