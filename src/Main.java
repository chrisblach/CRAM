
public class Main {
	
	
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		int [][] grid = new int[][] { 
			
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,1,0,0,0},
			{0,0,0,1,0},
			{0,0,0,0,0}
					
			}; 
		Functions.solvecram (grid, 0, 0);
		System.out.println(Functions.lastoptionrow1);
		System.out.println(Functions.lastoptioncol1);
		System.out.println(Functions.lastoptionrow2);
		System.out.println(Functions.lastoptioncol2);
		
		
	}




}
