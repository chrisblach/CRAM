import java.util.*;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main (String[] args) throws java.lang.Exception
	{
		int [][] startGrid = new int[][]
				{ 
				{0,0},
				{0,0}
				};

		HashMap<int[][], LinkedList<Option>> allGrids = new HashMap<int[][], LinkedList<Option>>();

		LinkedList<Option> startGridList = new LinkedList<Option>();
		allGrids.put(startGrid, startGridList);

		int[][] nextGrid = new int[][]
				{
				{1,1},
				{0,0}
				};

		Option newMove = new Option(nextGrid, 0, 0, 0, 1);

		if (allGrids.containsKey(nextGrid))
		{
			allGrids.get(startGrid).add(newMove);
		}
		else
		{
			allGrids.get(startGrid).add(newMove);
			LinkedList<Option> newGrid = new LinkedList<Option>();
			allGrids.put(nextGrid, newGrid);
		}

		int[][] nextGrid2 = new int[][]
				{
				{0,0},
				{1,1}
				};

		Option newMove2 = new Option(nextGrid2, 1, 1, 0, 1);

		if (allGrids.containsKey(nextGrid2))
		{
			allGrids.get(startGrid).add(newMove);
		}
		else
		{
			allGrids.get(startGrid).add(newMove2);
			LinkedList<Option> newGrid = new LinkedList<Option>();
			allGrids.put(nextGrid2, newGrid);
		}

		// Get a set of the entries
		Set<?> set = allGrids.entrySet();
		// Get an iterator
		Iterator<?> i = set.iterator();
		// Display elements
		while(i.hasNext()) {
			Map.Entry<int[][], LinkedList<Option>> me = (Map.Entry<int[][], LinkedList<Option>>)i.next();
			System.out.print(Arrays.deepToString(me.getKey()) + ": ");
			System.out.println(me.getValue());
		}
	}
}
