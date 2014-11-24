import java.io.BufferedReader;
import java.io.InputStreamReader;
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
			{0,0,0,0,0}
					
			};
	
	private static gridArrayClass grid = new gridArrayClass(gridInit, true, false);
	static int numofrows = 3;
	static int numofcols = 3; 
	
	private static BufferedReader inputLine = null;
	
	@SuppressWarnings("unchecked")
	public static void main (String[] args) throws java.lang.Exception
	{
		
		inputLine = new BufferedReader(new InputStreamReader(System.in));
		
		Functions functionsInstance = new Functions();
		functionsInstance.setGrid(grid);
		//static int numofrows = 2;
		//static int numofcols = 2; 
		functionsInstance.setNumofcols(numofcols);
		functionsInstance.setNumofrows(numofrows);
		/*Option optionroot = new Option (grid,0,0,0,0,false);
		Functions.setOptionroot(optionroot);
	 	GenericTree<Option> tree = new GenericTree<Option>();
	 	Functions.setTree(tree);
		GenericTreeNode <Option> root =  new GenericTreeNode<Option>(Functions.getOptionroot());
		Functions.getTree().setRoot(root);*/
		
		HashMap<gridArrayClass, LinkedList<Option>> allGrids = new HashMap<gridArrayClass, LinkedList<Option>>();

		HashMap<gridArrayClass,gridArrayClass> allGridsKeys = new HashMap<gridArrayClass,gridArrayClass>();
		
		LinkedList<Option> startGridList = new LinkedList<Option>();
		allGridsKeys.put(grid, grid);
		allGrids.put(grid, startGridList);
		
		
		
		
		functionsInstance.solve(allGrids, allGridsKeys);
		System.out.println("Done");
		//Functions.solvecram (0, 0);
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
		System.out.println("Possible Moves: " + functionsInstance.combinations);
		
		/*int i = 0;
		while(i < tree.getRoot().getNumberOfChildren()) {
	
    	for(int k = 0; k < Functions.getNumofrows(); k++)
		   {
		      for(int j = 0; j < Functions.getNumofcols(); j++)
		      {
		    	  
		         System.out.printf("%5d ", tree.getRoot().getChildAt(i).getData().getGrid()[k][j]);
		      }
		      
		      System.out.println();
		     
		   }
    	 System.out.println("\n");
		   i++;
		 }*/

		System.out.println("Unique Boards: " + allGrids.size());

		System.out.println("Starting board:\n" + allGridsKeys.get(grid));
		
		// Get a set of the entries
		Set<?> set = allGrids.entrySet();
		// Get an iterator
		Iterator<?> i = set.iterator();
		// Display elements
		while(i.hasNext()) {
			Map.Entry<gridArrayClass, LinkedList<Option>> me = (Map.Entry<gridArrayClass, LinkedList<Option>>)i.next();
			System.out.print("\n\n" + me.getKey() + ": ");
			System.out.print(me.getValue());
		}
		
		System.out.println("Our move first? Y/N");
		String moveFirst = null;
		while(moveFirst == null){		
			moveFirst = inputLine.readLine();
		}
		if (moveFirst.equals("Y")){
			String theMove = functionsInstance.findMove(allGrids, allGridsKeys, grid);
			System.out.println("Our Move: " + theMove);
			functionsInstance.parseMove(theMove, grid);
			System.out.println("Their board:\n" + allGridsKeys.get(grid));
		}
		while (true){
			System.out.println("What is their move?");
			String theirMove = null;
			while(theirMove == null){		
				theirMove = inputLine.readLine();
			}
			functionsInstance.parseMove(theirMove, grid);
			System.out.println("Our board:\n" + allGridsKeys.get(grid));
			String theMove = functionsInstance.findMove(allGrids, allGridsKeys, grid);
			System.out.println("Our Move: " + theMove);
			functionsInstance.parseMove(theMove, grid);
			System.out.println("Their board:\n" + allGridsKeys.get(grid));
		}
	}
}
