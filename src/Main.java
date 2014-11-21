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
		ArrayList<StringBuilder> allMasters = new ArrayList <StringBuilder>();
		Functions functionsInstance = new Functions();
		functionsInstance.setNumofcols(numofcols);
		functionsInstance.setNumofrows(numofrows);
		allMasters = functionsInstance.masterMovesString ();
		for (int i = 0; i<300;i++){
			int row = 0;
			int col = 0;
			for (int j = 1;j <= 25; j++){
				
				//temp = 5*row;
				if (allMasters.get(i).charAt(j - 1) == 'M'){
				gridInit [row][col] = 1;
				}
				col++;
				if ((j % 5) == 0){
					row++;
					col = 0;
				}
			}
			
		
		
	
		
		grid.setGrid(gridInit);
		//grid.setGrid(allMasters.get(i));
		System.out.print("THIS IS THE GRID" + grid);
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
		
		//reset grid
		System.out.println(theMove);
		for (int r = 0; r < 5; r++){
			for (int c = 0; c < 5; c++){
				gridInit [r][c] = 0;
			}
		}
		

			}
		}

}
