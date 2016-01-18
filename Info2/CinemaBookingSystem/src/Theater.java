package src;

import java.util.*;

public class Theater {
	

	private int theaterNumber;
	private String description;
	private final char FREE = '_';   // free seats.
	private final char BOOKED = 'X'; //booked seats.
	private final char BLOCKED = 'B'; // special seats like priority seats or defect seats.
	static ArrayList<Theater> theaterList = new ArrayList<Theater>();
	
	
//Creates an ArrayList of type char
//Holds several theater halls, their rows and columns.
	

	char[][][] plans = {
			{ 
			 //  COLUMNS     1         2	        3	     4       5       6      7          8    
						{  FREE   ,  FREE   ,  FREE  ,  FREE  , FREE , FREE ,  FREE   ,  FREE   }, //1
						{  FREE   ,  FREE   ,  FREE  ,  FREE  , FREE , FREE ,  FREE   ,  FREE   }, //2
						{  FREE  ,   FREE  ,   FREE ,   FREE ,  FREE , FREE ,  FREE   ,   FREE  }, //3
						{ BLOCKED , BLOCKED ,  FREE  ,  FREE  , FREE , FREE , BLOCKED , BLOCKED }, //4
																								   //ROWS
		} ,
		{ 
						 // 1         2	        3	     4       5       6      7          8
						{  FREE   ,  FREE   ,  FREE  ,  FREE  , FREE , FREE ,  FREE   ,  FREE   }, //1
						{  FREE   ,  FREE   ,  FREE  ,  FREE  , FREE , FREE ,  FREE   ,  FREE   }, //2
						{  FREE  ,   FREE  ,   FREE ,   FREE ,  FREE , FREE ,  FREE   ,   FREE  }, //3
						{ BLOCKED , BLOCKED ,  FREE  ,  FREE  , FREE , FREE , BLOCKED , BLOCKED }, //4
		} ,
		
		{ 
						 // 1         2	        3	     4       5       6      7          8
						{  FREE   ,  FREE   ,  FREE  ,  FREE  , FREE , FREE ,  FREE   ,  FREE   }, //1
						{  FREE   ,  FREE   ,  FREE  ,  FREE  , FREE , FREE ,  FREE   ,  FREE   }, //2
						{  FREE  ,   FREE  ,   FREE ,   FREE ,  FREE , FREE ,  FREE   ,   FREE  }, //3
						{ BLOCKED , BLOCKED ,  FREE  ,  FREE  , FREE , FREE , BLOCKED , BLOCKED }, //4
		} ,

		{ 
						 // 1         2	        3	     4       5       6      7          8
						{  FREE   ,  FREE   ,  FREE  ,  FREE  , FREE , FREE ,  FREE   ,  FREE   }, //1
						{  FREE   ,  FREE   ,  FREE  ,  FREE  , FREE , FREE ,  FREE   ,  FREE   }, //2
						{  FREE  ,   FREE  ,   FREE ,   FREE ,  FREE , FREE ,  FREE   ,   FREE  }, //3
						{ BLOCKED , BLOCKED ,  FREE  ,  FREE  , FREE , FREE , BLOCKED , BLOCKED }, //4
		} ,
			
		{ 
						 // 1         2	        3	     4       5       6      7          8
						{  FREE   ,  FREE   ,  FREE  ,  FREE  , FREE , FREE ,  FREE   ,  FREE   }, //1
						{  FREE   ,  FREE   ,  FREE  ,  FREE  , FREE , FREE ,  FREE   ,  FREE   }, //2
						{  FREE  ,   FREE  ,   FREE ,   FREE ,  FREE , FREE ,  FREE   ,   FREE  }, //3
						{ BLOCKED , BLOCKED ,  FREE  ,  FREE  , FREE , FREE , BLOCKED , BLOCKED }, //4
		} ,
	        
		{ 
						 // 1         2	        3	     4       5       6      7          8
						{  FREE   ,  FREE   ,  FREE  ,  FREE  , FREE , FREE ,  FREE   ,  FREE   }, //1
						{  FREE   ,  FREE   ,  FREE  ,  FREE  , FREE , FREE ,  FREE   ,  FREE   }, //2
						{  FREE  ,   FREE  ,   FREE ,   FREE ,  FREE , FREE ,  FREE   ,   FREE  }, //3
						{ BLOCKED , BLOCKED ,  FREE  ,  FREE  , FREE , FREE , BLOCKED , BLOCKED }, //4
		} ,
		};
	
	
			
	public Theater (int theaterNumber, String description)
	{
		this.description = description;
		this.theaterNumber = theaterNumber;
	}

//Defines the seats of a theater as FREE, which is not marked as BOOKED/BLOCKED.
  public boolean isFree(char[][] structure, int row, int column )
	{
	  return structure[row-1][column-1]  == FREE ;
	}
	
//Prints out a seating plan of a selected theater.
	public void printSeatingPlan()
	{
	 char [][]structure = plans[this.theaterNumber-1];
	 int columnSize = structure[0].length;  //L�nge der Spalten des char Arrays
	 System.out.printf( "  ");
	 
	 for ( int i = 0 ; i < columnSize; i++ )
	 {
	  System.out.printf((i + 1  )  + " "); //Hier wird jede Spalte durchnummeriert, bei uns also von 1 bis 8.
	 }
	 System.out.println();
	 
	 for ( int row = 0; row < structure.length ; row++)  
	 {
		System.out.printf((row + 1) + " " ); //Hier wrd jede Reihe durchnummeriert, bei uns also von 1 bis 4.
		
		for (int column =0; column < structure[row].length ; column++  )
		  {
			 System.out.printf(structure[row][column] + " ");
          }
				
			System.out.println();
	  }
	}
	
//@ return The theater's number.
	public int getTheaterNumber() 
	{
	  return this.theaterNumber;
	}
	
	
//Booking a seat and marking it as BOOKED If a seat is not already marked as BLOCKED or BOOKED. 
//If a seat is already taken or blocked, an error message should be printed out.
	public void bookSeat(int row, int column)
	{
		char [][]structure = plans[this.theaterNumber-1];
		boolean checkedSeat = isFree(structure, row, column);
		if(checkedSeat)
		{
			
			structure[row-1][column-1] = BOOKED;
		}
		
		else 
		{
		  System.out.println("Sorry, the Seat is already taken!");
		}
	}
	
//Unbooking a BOOKED seat and marking it back to FREE.	
	public void unbookSeat(int row, int column) 
	{
	  char [][]structure = plans[this.theaterNumber-1];
	  structure[row-1][column-1] = FREE;
			
	}

}