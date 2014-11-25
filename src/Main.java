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
	
	public static byte [][] gridInit = new byte[][] { 
			
			{0,1,1,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}
					
			};
	
	public static gridArrayClass grid = new gridArrayClass(gridInit, true, false);
	public static int numofrows = 5;
	public static int numofcols = 5; 
	
	private static BufferedReader inputLine = null;
	
	@SuppressWarnings("unchecked")
	public static void main (String[] args) throws java.lang.Exception
	{
		
		inputLine = new BufferedReader(new InputStreamReader(System.in));
		
		Functions functionsInstance = new Functions();
		
		functionsInstance.setNumofcols(numofcols);
		functionsInstance.setNumofrows(numofrows);
		
		
		HashMap<gridArrayClass, LinkedList<Option>> allGrids = new HashMap<gridArrayClass, LinkedList<Option>>();

		HashMap<gridArrayClass,gridArrayClass> allGridsKeys = new HashMap<gridArrayClass,gridArrayClass>();
		
		System.out.println("Starting board:\n" + grid);
		
		boolean boardSolved = false;
		System.out.println("Our move first? Y/N");
		String moveFirst = null;
		while(moveFirst == null){		
			moveFirst = inputLine.readLine();
		}
		if (moveFirst.equals("Y")){
			String worstReturn = functionsInstance.checkForWorst(grid);
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
			else{
				System.out.println("Worst case starting grid.");
				System.out.println("Our Move: " + worstReturn);
				functionsInstance.parseMove(worstReturn, grid);
			}
			System.out.println("Their board:\n" + grid);
		}
		while (true){
			System.out.println("What is their move?");
			String theirMove = null;
			while(theirMove == null){		
				theirMove = inputLine.readLine();
			}
			if (boardSolved){
			functionsInstance.parseMove(theirMove, grid);
			System.out.println("Our board:\n" + allGridsKeys.get(grid));
			String theMove = functionsInstance.findMove(allGrids, allGridsKeys, grid);
			System.out.println("Our Move: " + theMove);
			functionsInstance.parseMove(theMove, grid);
			System.out.println("Their board:\n" + allGridsKeys.get(grid));
			}
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
