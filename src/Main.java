import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Main {
	
	private static byte [][] gridInit = new byte[][] { 
			
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,1,0,0}
					
			};
	
	private static gridArrayClass grid = new gridArrayClass(gridInit);
	
	
	@SuppressWarnings("unchecked")
	public static void main (String[] args) throws java.lang.Exception
	{
		
		Functions functionsInstance = new Functions();
		functionsInstance.setGrid(grid);
		int numofrows = 5;
		int numofcols = 5; 
		functionsInstance.setNumofcols(numofcols);
		functionsInstance.setNumofrows(numofrows);
		
		
		HashMap<gridArrayClass, LinkedList<Option>> allGrids = new HashMap<gridArrayClass, LinkedList<Option>>();

		LinkedList<Option> startGridList = new LinkedList<Option>();
		allGrids.put(grid, startGridList);
		
		
		
		
		functionsInstance.solve(allGrids);
		
		
		//Option optionroot = new Option (grid,0,0,0,0,false);
		
		
		
		
		/*int number = tree.getNumberOfNodes();
		System.out.println("Number of node : " + number);
		tree.getRoot().getNumberOfChildren();*/
		/*for (int i = 0;i < tree.getRoot().getNumberOfChildren() - 1;i++){
			int one = tree.getRoot().getChildAt(i).getData().getRowOne();
			int two = tree.getRoot().getChildAt(i).getData().getRowTwo();
			int three =  tree.getRoot().getChildAt(i).getData().getColOne();
			int four = tree.getRoot().getChildAt(i).getData().getColTwo();
			System.out.println("Row1:" + one + " Col1:" + three + "\nRow2:" + two + " Col2:" + four + "\n\n");
		}*/	
		System.out.println(functionsInstance.combinations);
		System.out.println("Grid in node: \n");
		
		//int l = 0;
		//while(l < tree.getRoot().getNumberOfChildren()) {
	
    	for(int k = 0; k < functionsInstance.getNumofrows(); k++)
		   {
		      for(int j = 0; j < functionsInstance.getNumofcols(); j++)
		      {
		    	  
		         System.out.printf("%5d ", functionsInstance.getTree().getRoot().getData().getGrid().grid [k][j]);
		      }
		      
		      System.out.println();
		     
		   }
    	 System.out.println("\n");
		  // l++;
		// }
    	 
    	int l = 0;
 		while(l <  functionsInstance.getTree().getRoot().getNumberOfChildren()) {
 	
     	for(int k = 0; k < functionsInstance.getNumofrows(); k++)
 		   {
 		      for(int j = 0; j < functionsInstance.getNumofcols(); j++)
 		      {
 		    	  
 		         System.out.printf("%5d ",  functionsInstance.getTree().getRoot().getChildAt(l).getData().getGrid().grid [k][j]);
 		      }
 		      
 		      System.out.println();
 		     
 		   }
     	 System.out.println("\n");
 		   l++;
 		 }
 	int s = 0;
 		while(s<  functionsInstance.getTree().getRoot().getNumberOfChildren()) {
 		 System.out.println("THIS IS THE GRID: \n");
		for(int k = 0; k < functionsInstance.getNumofrows(); k++)
		   {
		      for(int a= 0; a < functionsInstance.getNumofcols(); a++)
		      {
		    	  
		         System.out.printf("%5d ", functionsInstance.getTree().getRoot().getChildAt(s).getChildAt(0).getData().getGrid().grid [k][a]);
		      }
		      
		      System.out.println();
		     
		   }
	s++;
 	}
		// Get a set of the entries
		Set<?> set = allGrids.entrySet();
		// Get an iterator
		Iterator<?> i = set.iterator();
		// Display elements
		while(i.hasNext()) {
			Map.Entry<gridArrayClass, LinkedList<Option>> me = (Map.Entry<gridArrayClass, LinkedList<Option>>)i.next();
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		System.out.println(allGrids.size());

	}

}
