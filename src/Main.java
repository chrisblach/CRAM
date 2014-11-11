public class Main {
	
	private static int [][] grid = new int[][] { 
			
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}
					
			};
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		grid = new int[][] { 
				
				{1,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{1,0,0,0,0},
				{0,0,0,0,0}
						
				};		
		Functions.setGrid(grid);
		int numofrows = 2;
		int numofcols = 3; 
		Functions.setNumofcols(numofcols);
		Functions.setNumofrows(numofrows);
		Option optionroot = new Option (grid,0,0,0,0,false);
		Functions.setOptionroot(optionroot);
	 	GenericTree<Option> tree = new GenericTree<Option>();
	 	Functions.setTree(tree);
		GenericTreeNode <Option> root =  new GenericTreeNode<Option>(Functions.getOptionroot());
		Functions.getTree().setRoot(root);
		
		
		
		
		
		
		Functions.solve(0,0);
		//Functions.solvecram (0, 0);
		int number = tree.getNumberOfNodes();
		System.out.println("Number of node : " + number);
		tree.getRoot().getNumberOfChildren();
		for (int i = 0;i < tree.getRoot().getNumberOfChildren() - 1;i++){
			int one = tree.getRoot().getChildAt(i).getData().getRowOne();
			int two = tree.getRoot().getChildAt(i).getData().getRowTwo();
			int three =  tree.getRoot().getChildAt(i).getData().getColOne();
			int four = tree.getRoot().getChildAt(i).getData().getColTwo();
			System.out.println("Row1:" + one + " Col1:" + three + "\nRow2:" + two + " Col2:" + four + "\n\n");
		}	
		
		System.out.println("Grid in node: \n");
		int i = 0;
		// while(i < tree.getRoot().getNumberOfChildren()) {
    	for(int k = 0; k < Functions.getNumofrows(); k++)
		   {
		      for(int j = 0; j < Functions.getNumofcols(); j++)
		      {
		    	  
		         System.out.printf("%5d ", tree.getRoot().getChildAt(0).getData().getGrid()[k][j]);
		      }
		      
		      System.out.println();
		   }
		   
		// }


	}

}
