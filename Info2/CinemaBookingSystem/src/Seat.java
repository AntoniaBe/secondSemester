package src;

public class Seat {
	
	private int row;
	private int column;
	

	public Seat(int row, int column){
		
		this.row = row;
		this.column = column;
	}

//@ return a row.	
	public int getRow(){
		
		return this.row;
	}
	
//@ return a column.
	public int getColumn() {
		
		return this.column;
	}
}
