import java.util.Arrays;


public class Option {
	private gridArrayClass grid;
	private int rowOne;
	private int rowTwo;
	private int colOne;
	private int colTwo;
	
	
	
	public Option (gridArrayClass currentgrid, int row1, int col1, int row2, int col2){
		setGrid (currentgrid);
		setRowOne (row1);
		setRowTwo (row2);
		setColOne (col1);
		setColTwo (col2);
	}





	public gridArrayClass getGrid() {
		//int [][] myInt = new int[5][];
		//for(int i = 0; i < 5; i++)
		//    myInt[i] = grid[i].clone();
		//return myInt;
		return grid;
	}


	public void setGrid(gridArrayClass grid) {
		this.grid = grid;
	}


	public int getRowOne() {
		return rowOne;
	}


	public void setRowOne(int rowOne) {
		this.rowOne = rowOne;
	}


	public int getRowTwo() {
		return rowTwo;
	}


	public void setRowTwo(int rowTwo) {
		this.rowTwo = rowTwo;
	}


	public int getColOne() {
		return colOne;
	}


	public void setColOne(int colOne) {
		this.colOne = colOne;
	}


	public int getColTwo() {
		return colTwo;
	}


	public void setColTwo(int colTwo) {
		this.colTwo = colTwo;
	}
	
	public String toString(){
		return "\n" + this.grid.toString() + ", " + this.rowOne + ", " 
				+ this.rowTwo + ", " + this.colOne + ", " + this.colTwo;
	}
}
