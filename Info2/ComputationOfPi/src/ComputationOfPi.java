package src;
import java.awt.Point;


import java.util.Random;

public class ComputationOfPi {
	
	// height and length of the square
	public static int squareBound = 6;
	
	// radius of the circle inside of the square
	public static int circleRadius = squareBound/2;
	
	// midpoint of the circle 
	public static Point midPoint = new Point(circleRadius, circleRadius);

	public static void main(String[] args) {
		
//		Point p = createRandomPointInSquare();
//		isInTheCircle(p, midPoint);
		computePi(100000000);

	}
	
	public static double computePi(int numberOfRandomPoints){

		int numberOfPointsInCircle = 0;    
		Point randomPoint = null;


		for (int i = 0; i < numberOfRandomPoints; i++)
        {  
			randomPoint = createRandomPointInSquare();

			if (isInTheCircle(randomPoint, circleRadius)== true)
            	numberOfPointsInCircle++;
        }
		System.out.println((4.0 * ((double)numberOfPointsInCircle /(double)numberOfRandomPoints)));
        return (4.0 * ((double)numberOfPointsInCircle /(double)numberOfRandomPoints));
	}

	/*
	 * Creates a random point between the square bounds
	 */
	public static Point createRandomPointInSquare(){ 
		Random rand = new Random();
		
		int x = rand.nextInt(squareBound);
		int y = rand.nextInt(squareBound);
		Point randomPoint = new Point(x, y);
//		System.out.println("Coordinates of Point: x = " + randomPoint.x + " and y =" + randomPoint.y);
		
		// return point so it can be used in further methods 
		return randomPoint;
	}
	
	/*
	 * Check if random Point is inside of the circle area. 
	 * Return true, if the square of deltaX + the square of deltaY is smaller than
	 * the square of the radius of the circle
	 */
	public static boolean isInTheCircle(Point p, int circleRadius){
		int deltaX = p.x - circleRadius;
		int deltaY = p.y - circleRadius;
		
		int rpsquare = (deltaX * deltaX) + (deltaY * deltaY);
		int rcsquare = circleRadius * circleRadius;
		if(rpsquare <= rcsquare){
//			System.out.println("Point is in the circle.");
			return true;
		}
		else{
			//System.out.println("Point is not in the circle.");
			return false;
		
		}
	}
}
