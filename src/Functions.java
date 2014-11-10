import java.util.*;
import java.lang.*;
import java.io.*;

public class Functions {

	static int numofrows = 3;
	static int numofcols = 3;
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
	
	public static boolean solvecramHor (int currentgrid [][], int row,int onCol)	{
		System.out.println("Col " + onCol + " row " + row + "\n");
		if (row >= numofrows){
			return true;
		}
		
		for (col = onCol; col < numofcols - 1; col++){
			if (canPlace(currentgrid, row, col)){
				placeOptionHor (currentgrid,row, col, row, col + 1);
				 removeOption (currentgrid,lastoptionrow1, lastoptioncol1, lastoptionrow2, lastoptioncol2);
				solvecramHor (currentgrid, row, col + 1);
			}
		}
			if (solvecramHor (currentgrid,row +1, 0)) return true;
			
			
		
		return false;	
	}
	
	public static void placeOptionHor (int currentgrid [][], int row1, int col1, int row2, int col2){
		currentgrid [row1][col1] = 1;
		currentgrid [row2][col2] = 1;
		lastoptionrow1 = row1;
		lastoptioncol1 = col1;
		lastoptionrow2 = row2;
		lastoptioncol2 = col2;
		combinations++;
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
		 System.out.println("\n");
	}
	
	public static boolean canPlace (int currentgrid [][], int row, int col){
		if (currentgrid [row][col] == 0 && currentgrid [row] [col + 1] == 0){
			return true;
		}
		else return false;
		
	}
}
