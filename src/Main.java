import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {
	
	//Starting grid which can be manually set for testing
	public static byte [][] gridInit = new byte[][] { 
			
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}
					
			};
	
	//Creates a new gridArrayClass object using
	public static gridArrayClass grid = new gridArrayClass(gridInit, true, false);
	
	//Size of starting grid which can also be manually changed for testing
	public static int numofrows = 5;
	public static int numofcols = 5; 
	
	//BufferedReader to get user input
	private static BufferedReader inputLine = null;
	
	public static void main (String[] args) throws java.lang.Exception
	{
		//BufferedReader to get user input
		inputLine = new BufferedReader(new InputStreamReader(System.in));
		
		//Creating an instance of functions and passing the grid size
		Functions functionsInstance = new Functions();
		functionsInstance.setNumofcols(numofcols);
		functionsInstance.setNumofrows(numofrows);
		
		//Hash map to contain all the possible board layouts and their moves
		HashMap<gridArrayClass, LinkedList<Option>> allGrids = new HashMap<gridArrayClass, LinkedList<Option>>();

		//Hash map to contain all the possible board layouts contained in the first hash map to allow changes to the keys
		HashMap<gridArrayClass,gridArrayClass> allGridsKeys = new HashMap<gridArrayClass,gridArrayClass>();
		
		System.out.println("Starting board:\n" + grid);
		
		//First asks if we play first
		boolean boardSolved = false;
		System.out.println("Our move first? Y/N");
		String moveFirst = null;
		while(moveFirst == null){		
			moveFirst = inputLine.readLine();
		}
		//If we play first
		if (moveFirst.equals("Y")){
			String worstReturn = functionsInstance.checkForWorst(grid);
			//If it's an easier board then find the move normally
			if(worstReturn.equals("N")){
				System.out.println("Not a worst case starting grid.");
				LinkedList<Option> startGridList = new LinkedList<Option>();
				allGridsKeys.put(grid, grid);
				allGrids.put(grid, startGridList);
				functionsInstance.solve(allGrids, allGridsKeys);
				boardSolved = true;
				String theMove = functionsInstance.findMove(allGrids, allGridsKeys, grid);
				System.out.println("Our Move: " + theMove);
				functionsInstance.parseMove(theMove, grid);
			}
			//If the starting grid that was set would take a long time to calculate
			//Get a pre-calculated move
			else{
				System.out.println("Worst case starting grid.");
				System.out.println("Our Move: " + worstReturn);
				functionsInstance.parseMove(worstReturn, grid);
			}
			System.out.println("Their board:\n" + grid);
		}
		//Ask for the other player's move manually for testing
		while (true){
			System.out.println("What is their move?");
			String theirMove = null;
			while(theirMove == null){		
				theirMove = inputLine.readLine();
			}
			//If the board has been solved already, simply find the next move
			if (boardSolved){
			functionsInstance.parseMove(theirMove, grid);
			System.out.println("Our board:\n" + allGridsKeys.get(grid));
			String theMove = functionsInstance.findMove(allGrids, allGridsKeys, grid);
			System.out.println("Our Move: " + theMove);
			functionsInstance.parseMove(theMove, grid);
			System.out.println("Their board:\n" + allGridsKeys.get(grid));
			}
			//If the board hasn't been solved yet, solve it
			else{
				functionsInstance.parseMove(theirMove, grid);
				LinkedList<Option> startGridList = new LinkedList<Option>();
				allGridsKeys.put(grid, grid);
				allGrids.put(grid, startGridList);
				System.out.println("Our board:\n" + allGridsKeys.get(grid));
				functionsInstance.solve(allGrids, allGridsKeys);
				boardSolved = true;
				String theMove = functionsInstance.findMove(allGrids, allGridsKeys, grid);
				System.out.println("Our Move: " + theMove);
				functionsInstance.parseMove(theMove, grid);
				System.out.println("Their board:\n" + allGridsKeys.get(grid));
			}
		}
	}
}
