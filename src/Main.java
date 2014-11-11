public class Main {
	
	static int [][] grid = new int[][] { 
			
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}
					
			};
	
	static Option optionroot = new Option (grid,1,1,1,1,false);
	static GenericTree<Option> tree = new GenericTree<Option>();
	public static void main (String[] args) throws java.lang.Exception
	{
		
		
		
		GenericTreeNode <Option> root =  new GenericTreeNode<Option>(optionroot);
		tree.setRoot(root);
		
		
		
		
		//System.out.println(number1);
		Functions.solvecram (grid, 0, 0);
		int number = tree.getNumberOfNodes();
		System.out.println(number);
		tree.getRoot().getNumberOfChildren();
		for (int i = 0;i < number - 1;i++){
			int one = tree.getRoot().getChildAt(i).getData().getRowOne();
			int two = tree.getRoot().getChildAt(i).getData().getRowTwo();
			int three =  tree.getRoot().getChildAt(i).getData().getColOne();
			int four = tree.getRoot().getChildAt(i).getData().getColTwo();
			System.out.println("Row1:" + one + " Col1:" + three + "\nRow2:" + two + " Col2:" + four + "\n\n");
		}	
	}




}
