import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Main {
	
	private static byte [][] gridInit = new byte[][] { 
			
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}
					
			};
	
	private static gridArrayClass grid = new gridArrayClass(gridInit, true, false);
	static int numofrows = 5;
	static int numofcols = 5; 
	
	static HashMap<gridArrayClass,gridArrayClass> allGridsKeys = new HashMap<gridArrayClass,gridArrayClass>();
	
	@SuppressWarnings("unchecked")
	public static void main (String[] args) throws java.lang.Exception
	{		
		ArrayList<gridArrayClass> allMasters = new ArrayList <gridArrayClass>();
		Functions functionsInstance = new Functions();
		functionsInstance.setNumofcols(numofcols);
		functionsInstance.setNumofrows(numofrows);
		allMasters = functionsInstance.masterMoves();
		System.out.println(allMasters.get(299));
		/*for(int k = 0; k < numofrows; k++)
		   {
		      for(int L = 0; L < numofcols; L++)
		      {
		         System.out.printf("%5d ", allMasters.get(1)[k][L]);
		      }
		      
		      System.out.println();
		   }*/
	int i = 301;
	while (i < allMasters.size()){
		
		
		//grid.setGrid(allMasters.get(i));
		System.out.print("THIS IS THE GRID" + allMasters.get(i));
		functionsInstance.setGrid(grid);
		
		//static int numofrows = 2;
		//static int numofcols = 2; 
		
		/*Option optionroot = new Option (grid,0,0,0,0,false);
		Functions.setOptionroot(optionroot);
	 	GenericTree<Option> tree = new GenericTree<Option>();
	 	Functions.setTree(tree);
		GenericTreeNode <Option> root =  new GenericTreeNode<Option>(Functions.getOptionroot());
		Functions.getTree().setRoot(root);*/
		
		HashMap<gridArrayClass, LinkedList<Option>> allGrids = new HashMap<gridArrayClass, LinkedList<Option>>();

		LinkedList<Option> startGridList = new LinkedList<Option>();
		allGridsKeys.put(grid, grid);
		allGrids.put(grid, startGridList);
		
		
		
		
		functionsInstance.solve(allGrids);
		System.out.println("Done");
		
		System.out.println("Possible Moves: " + functionsInstance.combinations);

		System.out.println(allGridsKeys.get(grid));
		
		/*// Get a set of the entries
		Set<?> set = allGrids.entrySet();
		// Get an iterator
		Iterator<?> i = set.iterator();
		// Display elements
		while(i.hasNext()) {
			Map.Entry<gridArrayClass, LinkedList<Option>> me = (Map.Entry<gridArrayClass, LinkedList<Option>>)i.next();
			System.out.print("\n\n" + me.getKey() + ": ");
			System.out.print(me.getValue());
		}*/
		
		System.out.println("Unique Boards: " + allGrids.size());
		
		String theMove = functionsInstance.findMove(allGrids, grid);
		
		System.out.println(theMove);
		
		}

	}

}
