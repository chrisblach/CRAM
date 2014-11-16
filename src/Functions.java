import java.util.*;
import java.lang.*;
import java.io.*;

public class Functions {

	private static int numofrows = 2;
	private static int numofcols = 3;
	private static int temp = 0;
	static int combinations = 0;
	private static int combinationstemp = 0;

	private static int lastoptionrow1;
	private static int lastoptioncol1;
	private static int lastoptionrow2;
	private static int lastoptioncol2;
	
	private static int [][] grid = new int[][] {};
	private static Option optionroot = new Option (grid,0,0,0,0,false);
	
	private static GenericTree<Option> tree = new GenericTree<Option>();

	private static int [][] tempgrid = new int[][] {};

	public static int number = 0;
	public static void solve (int row, int onCol){
	boolean hi;
	hi = tree.buildTree(getTree().getRoot(),row,onCol);
	if (hi){
		System.out.println("Done");
	}
}
	public static boolean solvecram (int row, int onCol){
		return Functions.solvecram (grid, 0, 0);
	}
	private static boolean solvecram (int currentgrid [][], int row,int onCol)	{
		for (int r = row;r <= numofrows - 1;r++){
			for (int col = onCol; col < numofcols - 1;col++){
				if (canPlaceHor (currentgrid,r,col)){
					//placeOption(currentgrid,r,col,r,col + 1);
					removeOption (currentgrid,lastoptionrow1,lastoptioncol1,lastoptionrow2,lastoptioncol2);
				}
			}
		}
		for (int col = onCol; col <= numofcols - 1; col++){
			for (int r = row; r < numofrows - 1; r++){
				if (canPlaceVer (currentgrid,r,col)){
					//placeOption(currentgrid,r,col,r + 1,col);
					removeOption (currentgrid,lastoptionrow1,lastoptioncol1,lastoptionrow2,lastoptioncol2);
				}
			}
		}
		
		return false;	
	}

	public static void placeOption (int currentgrid [][], int row1, int col1, int row2, int col2, GenericTreeNode <Option> optionNode){
		int [][] myInt = new int[5][];
		for(int i = 0; i < 5; i++)
		    myInt[i] = currentgrid[i].clone();
		myInt [row1][col1] = 1;
		myInt [row2][col2] = 1;
		Option option = new Option(myInt,row1,col1,row2,col2,false);
		GenericTreeNode <Option> optionnode =  new GenericTreeNode<Option>(option);
		optionNode.addChild(optionnode);
		setLastoptionrow1(row1);
		setLastoptioncol1(col1);
		setLastoptionrow2(row2);
		setLastoptioncol2(col2);
		combinations++;
		/*try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < numofrows; i++)
		   {
		      for(int j = 0; j < numofcols; j++)
		      {
		         System.out.printf("%5d ", myInt[i][j]);
		      }
		      
		      System.out.println();
		   }
	      System.out.println("\n");
	     System.out.println(combinations);*/
	}
	
	public static void removeOption (int currentgrid [][], int row1, int col1, int row2, int col2){
		currentgrid [row1][col1] = 0;
		currentgrid [row2][col2] = 0;
		 System.out.println("REMOVE:");
		 /*try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n");
		for(int i = 0; i < numofrows; i++)
		   {
		      for(int j = 0; j < numofcols; j++)
		      {
		         System.out.printf("%5d ", currentgrid[i][j]);
		      }
		      
		      System.out.println();
		   }
		 System.out.println("\n");*/
	}
	
	public static boolean canPlaceHor (int currentgrid [][], int row, int col){
		if (row > 4 || col >= 4){
			
		}
		else{
		if (currentgrid [row][col] == 0 && currentgrid [row] [col + 1] == 0){
			return true;
		}
		}
		 return false;
		
		
	}
	
	public static boolean canPlaceVer (int currentgrid [][], int row, int col){
		if (row >= 4 || col >4){
			
		}
		else {
		if (currentgrid [row][col] == 0 && currentgrid [row + 1] [col] == 0){
			return true;
		}
		}
	 return false;
		
	}
	
	public static int getNumofrows() {
		return numofrows;
	}
	public static void setNumofrows(int numofrows) {
		Functions.numofrows = numofrows;
	}
	public static int getNumofcols() {
		return numofcols;
	}
	public static void setNumofcols(int numofcols) {
		Functions.numofcols = numofcols;
	}
	public static int getLastoptionrow1() {
		return lastoptionrow1;
	}
	public static void setLastoptionrow1(int lastoptionrow1) {
		Functions.lastoptionrow1 = lastoptionrow1;
	}
	public static int getLastoptioncol1() {
		return lastoptioncol1;
	}
	public static void setLastoptioncol1(int lastoptioncol1) {
		Functions.lastoptioncol1 = lastoptioncol1;
	}
	public static int getLastoptionrow2() {
		return lastoptionrow2;
	}
	public static void setLastoptionrow2(int lastoptionrow2) {
		Functions.lastoptionrow2 = lastoptionrow2;
	}
	public static int getLastoptioncol2() {
		return lastoptioncol2;
	}
	public static void setLastoptioncol2(int lastoptioncol2) {
		Functions.lastoptioncol2 = lastoptioncol2;
	}
	
	public static Option getOptionroot() {
		return optionroot;
	}
	public static void setOptionroot(Option optionroot) {
		Functions.optionroot = optionroot;
	}
	public static GenericTree<Option> getTree() {
		return tree;
	}
	public static void setTree(GenericTree<Option> tree) {
		Functions.tree = tree;
	}
	
	public static int[][] getGrid() {
		return grid;
	}
	
	public static void setGrid(int[][] grid) {
		Functions.grid = grid;
		setTempgrid(grid);
	}
	
	public static int[][] getTempgrid() {
		return tempgrid;
	}
	public static void setTempgrid(int[][] tempgrid) {
		Functions.tempgrid = tempgrid;
	}
}
