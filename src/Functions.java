import java.util.*;
import java.lang.*;
import java.io.*;

public class Functions {

	static int numofrows = 4;
	static int numofcols = 4;
	static int temp = 0;
	static int combinations = 0;
	static int combinationstemp = 0;
	static int col = 0;
	static int lastoptionrow1;
	static int lastoptioncol1;
	static int lastoptionrow2;
	static int lastoptioncol2;
	
	static int [][] grid = new int[][] {};
	static int [][] tempgrid = grid;
	
	public static int number = 0;
	
	public static boolean solvecram (int currentgrid [][], int row,int onCol)	{
		if (row >= numofrows){
		    removeOption (currentgrid,lastoptionrow1, lastoptioncol1, lastoptionrow2, lastoptioncol2);
		    solvecram (currentgrid,lastoptionrow1,lastoptioncol2);
			return true;
		}
		
		for (col = onCol; col < numofcols - 1; col++){
			if (canPlace(currentgrid, row, col)){
				placeOption (currentgrid,row, col, row, col + 1);
				solvecram (currentgrid, row, 0);
			}
		}
			if (solvecram (currentgrid,row +1, 0)) return true;
			
			
		
		return false;	
	}
	
	public static void placeOption (int currentgrid [][], int row1, int col1, int row2, int col2){
		currentgrid [row1][col1] = 1;
		currentgrid [row2][col2] = 1;
		lastoptionrow1 = row1;
		lastoptioncol1 = col1;
		lastoptionrow2 = row2;
		lastoptioncol2 = col2;
		combinations++;
		Option option = new Option (currentgrid, row1, row2, col1, col2);
		Option option2 = new Option (currentgrid, row1 + 1, row2 + 1, col1 + 1, col2 + 1);
		TreeNode tree = new TreeNode (option);
		TreeNode tree2 = new TreeNode (option2);
		tree.addChildNode(tree);
		tree.addChildNode(tree2);
		println(option.getRowOne(tree.getParent()))
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < numofrows; i++)
		   {
		      for(int j = 0; j < numofcols; j++)
		      {
		         System.out.printf("%5d ", currentgrid[i][j]);
		      }
		      
		      System.out.println();
		   }
	      System.out.println("\n");
	      System.out.println(combinations);
	}
	
	public static void removeOption(int currentgrid [][], int row1, int col1, int row2, int col2){
		currentgrid [row1][col1] = 0;
		currentgrid [row2][col2] = 0;
		 System.out.println("REMOVE:");
		try {
			Thread.sleep(1000);
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
	}
	
	public static boolean canPlace (int currentgrid [][], int row, int col){
		if (currentgrid [row][col] == 0 && currentgrid [row] [col + 1] == 0){
			return true;
		}
		else return false;
		
	}
}
