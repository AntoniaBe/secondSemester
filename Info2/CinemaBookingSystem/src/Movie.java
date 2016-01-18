package src;

public class Movie {
	
	private String movieName;
	private int price;
	private String time;
	
	
	
	public Movie(String movieName, String time,  int price)
	{
		
		this.movieName = movieName;
		this.time = time;
		this.price = price;
	}
	
//@ return The movie's time.
	public String getMovieTime()
	{
		return this.time;
	}
//@return The movie's name.
	public String getName() 
	{
		return this.movieName;
	}
	
//@return The movie's price.	
	public int getPrice()
	{
		return this.price;
	}
	
	
}	   
