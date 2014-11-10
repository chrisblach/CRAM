import java.util.HashMap;


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
		Tree tree = new Tree();
		HashMap<Option, Node> nodes1;
		Option option1 = new Option (grid, 1,1,8,2);
		Option option2 = new Option (grid, 3,3,9,2);
		Option option3 = new Option (grid, 4,3,7,2);
		tree.addNode(option1);
		tree.addNode(option2, option1);
		tree.addNode(option3, option2);
        tree.display(option2);
        int test = tree.option.getColOne();
        System.out.println(test);
		Functions.solvecramHor (grid, 0, 0);
		System.out.println(Functions.lastoptionrow1);
		System.out.println(Functions.lastoptioncol1);
		System.out.println(Functions.lastoptionrow2);
		System.out.println(Functions.lastoptioncol2);
		
		
		
	}




}
