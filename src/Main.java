import java.util.HashMap;


public class Main {
	
	
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		int [][] grid = new int[][] { 
			
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}
					
			}; 
		Functions.solvecramHor (grid, 0, 0);
		System.out.println(Functions.lastoptionrow1);
		System.out.println(Functions.lastoptioncol1);
		System.out.println(Functions.lastoptionrow2);
		System.out.println(Functions.lastoptioncol2);
		
		
		
	}




}
