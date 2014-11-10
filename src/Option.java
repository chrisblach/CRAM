
public class Option {
	private int [][] grid = new int[][] {};
	private int rowOne;
	private int rowTwo;
	private int colOne;
	private int colTwo;
	
	
	public Option (int currentgrid [][], int row1, int row2, int col1, int col2){
		setGrid (currentgrid);
		setRowOne (row1);
		setRowTwo (row2);
		setColOne (col1);
		setColTwo (col2);
	}


	public int[][] getGrid() {
		return grid;
	}


	public void setGrid(int[][] grid) {
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
}
