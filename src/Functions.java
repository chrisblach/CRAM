import java.util.*;
import java.util.Map.Entry;
import java.lang.*;
import java.io.*;

public class Functions {

	private  int numofrows = 2;
	private  int numofcols = 3;
	private  int temp = 0;
	 int combinations = 0;
	private  int combinationstemp = 0;

	private  int lastoptionrow1;
	private  int lastoptioncol1;
	private  int lastoptionrow2;
	private  int lastoptioncol2;
	
	private byte [][] gridInit = new byte[][] { 
		
		{0,0,0,0,0},
		{0,0,0,0,0},
		{0,0,0,0,0},
		{0,0,0,0,0},
		{0,0,0,0,0}
				
		};
	
	private  gridArrayClass grid = new gridArrayClass(gridInit);
	private  Option optionroot = new Option (grid,0,0,0,0,false);
	
	private  GenericTree<Option> tree = new GenericTree<Option>();

	private  gridArrayClass tempgrid = new gridArrayClass(gridInit);

	public  int number = 0;
	
	private int doneCount = 0;
	private int gridArrayLength = 1;
	
	public void solve (HashMap<gridArrayClass, LinkedList<Option>> allGrids){
		boolean done = false;	
		buildHash(allGrids);
		done = true;
		if (done){
			System.out.println("Done Making Hash Map... Now Making Tree...");
		}
		
		this.setOptionroot(allGrids.get(grid).get(0));
	 	GenericTree<Option> tree = new GenericTree<Option>();
	 	this.setTree(tree);
		GenericTreeNode <Option> root =  new GenericTreeNode<Option>(this.getOptionroot());
		this.getTree().setRoot(root);
		GenericTreeNode <Option> currentNode =  new GenericTreeNode<Option>(this.getOptionroot());
		currentNode = tree.getRoot();
		//solveTree(allGrids, currentNode);
		System.out.println("Done Tree... Now Solving...");
		System.out.println(allGrids.size());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*List<GenericTreeNode<Option>> result;
		GenericTree gTree = new GenericTree();
		result = gTree.build(tree.getRoot(), GenericTreeTraversalOrderEnum.PRE_ORDER);
		System.out.println(result);*/
	}
	
	private void solveTree(HashMap<gridArrayClass, LinkedList<Option>> allGrids, GenericTreeNode<Option> currentNode){
		int i3 = 0;
		gridArrayClass tempGA = new gridArrayClass (tree.getRoot().getData().getGrid().grid);
		/*int test = tree.getRoot().getNumberOfChildren();
		System.out.println(test);*/
		
		if (!tree.getRoot().hasChildren()){
			for (int i = 0 ; i < allGrids.get(tree.getRoot().getData().getGrid()).size() ; i++){
				//currentNode.setData(allGrids.get();
				/*System.out.println("Test");*/
				GenericTreeNode <Option> rootNodes =  new GenericTreeNode<Option>(allGrids.get(this.optionroot.getGrid()).get(i));
				currentNode.addChild(rootNodes);
			}
		
		}
		Option breakCondition = new Option((gridArrayClass)currentNode.getData().getGrid(),0,0,0,0,true);
		if (currentNode.getData().getWin()){
			/*System.out.println("Did i get in here?");*/
		}
		else{
		i3 = 0;
		if (currentNode.hasChildren()) {
			while (i3 < currentNode.getNumberOfChildren()){
				
				
            	
			/*	System.out.println("i is " + i3);*/
				for (int j = 0 ; j < allGrids.get(currentNode.getChildAt(i3).getData().getGrid()).size() ; j++){
				/*	System.out.println("Size " + allGrids.get(currentNode.getChildAt(i3).getData().getGrid()).size() + " j is " + j);*/
					GenericTreeNode <Option> nodes =  new GenericTreeNode<Option>(allGrids.get(currentNode.getChildAt(i3).getData().getGrid()).get(j));
					currentNode.getChildAt(i3).addChild(nodes);
					
				}
				
				
				solveTree (allGrids, currentNode.getChildAt(i3));
				i3++;
					
				
			}
			
		}
			
		}	
}

	public void buildHash (HashMap<gridArrayClass, LinkedList<Option>> allGrids){
        	for (int r = 0;r <= this.getNumofrows() - 1;r++){
    			for (int col = 0; col <= this.getNumofcols() - 1;col++){
    				if (this.canPlaceHor (grid,r,col)){
        					if (col == this.getNumofcols() - 1){
        						
        					}
        					else this.placeOption(grid,r,col,r,col + 1, allGrids);
    				}
    				if (this.canPlaceVer (grid,r,col)){
    					if (r == this.getNumofrows() - 1){
    						
    					}
    					else this.placeOption(grid,r,col,r + 1,col, allGrids);
    				}
    			}
    		}
        		fillHash(allGrids);
    	}
	
	@SuppressWarnings("unchecked")
	public void fillHash (HashMap<gridArrayClass, LinkedList<Option>> allGrids){         
		while (this.doneCount < this.gridArrayLength){
			System.out.println(this.doneCount + " is less than " + this.gridArrayLength);
			Object[] gridArray = allGrids.keySet().toArray();
			this.gridArrayLength = gridArray.length;
			this.doneCount = 0;
			for(int i = 0; i < this.gridArrayLength; i++) {
				//System.out.println("i is" + i);
				if (allGrids.get(gridArray[i]).peekFirst() == null)
				{
					//System.out.println(i + " is null ");
					boolean placed = false;
					for (int r = 0;r <= this.getNumofrows() - 1;r++){
						for (int col = 0; col <= this.getNumofcols() - 1;col++){
							if (this.canPlaceHor ((gridArrayClass)gridArray[i],r,col)){
								if (col == this.getNumofcols() - 1){
									//System.out.println("Not placing");
								}
								else
									{
									placed = true;
									this.placeOption((gridArrayClass)gridArray[i],r,col,r,col + 1, allGrids);
									}
							}
							if (this.canPlaceVer ((gridArrayClass)gridArray[i],r,col)){
								if (r == this.getNumofrows() - 1){
									//System.out.println("Not placing 2");
								}
								else
								{
									placed = true;
									this.placeOption((gridArrayClass)gridArray[i],r,col,r + 1,col, allGrids);
								}
							}
						}
					}
					if (!placed)
					{
						Option option = new Option((gridArrayClass)gridArray[i],0,0,0,0,true);
						allGrids.get(gridArray[i]).add(option);
					}
				}
				else
				{
					//System.out.println(i + " is not null");
					this.doneCount++;
				}
			}
		}
	}
	
	
	/*public  boolean solvecram (int row, int onCol){
		return this.solvecram (grid, 0, 0);
	}
	private  boolean solvecram (int currentgrid [][], int row,int onCol)	{
		for (int r = row;r <= numofrows - 1;r++){
			for (int col = onCol; col < numofcols - 1;col++){
				if (canPlaceHor (currentgrid,r,col)){
					//placeOption(currentgrid,r,col,r,col + 1);
					removeOption (currentgrid,lastoptionrow1,lastoptioncol1,lastoptionrow2,lastoptioncol2);
				}
			}
		}
		for (int col = onCol; col <= numofcols - 1; col++){
			for (int r = row; r < numofrows - 1; r++){
				if (canPlaceVer (currentgrid,r,col)){
					//placeOption(currentgrid,r,col,r + 1,col);
					removeOption (currentgrid,lastoptionrow1,lastoptioncol1,lastoptionrow2,lastoptioncol2);
				}
			}
		}
		
		return false;	
	}*/

	public  void placeOption (gridArrayClass currentgrid, int row1, int col1, int row2, int col2, HashMap<gridArrayClass, LinkedList<Option>> allGrids){
		byte [][] myIntInit = new byte[][]
				{ 
				
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0}
						
				};
		gridArrayClass myInt = new gridArrayClass(myIntInit);
		for(int i = 0; i < 5; i++)
		    myInt.grid[i] = currentgrid.grid[i].clone();
		myInt.grid [row1][col1] = 1;
		myInt.grid [row2][col2] = 1;
		Option option = new Option(myInt,row1,col1,row2,col2,false);
		if (allGrids.get(myInt) != null)
		{
			allGrids.get(currentgrid).add(option);
		}
		else
		{
			allGrids.get(currentgrid).add(option);
			LinkedList<Option> newGrid = new LinkedList<Option>();
			allGrids.put(myInt, newGrid);
		}
		setLastoptionrow1(row1);
		setLastoptioncol1(col1);
		setLastoptionrow2(row2);
		setLastoptioncol2(col2);
		combinations++;
		/*try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < numofrows; i++)
		   {
		      for(int j = 0; j < numofcols; j++)
		      {
		         System.out.printf("%5d ", myInt[i][j]);
		      }
		      
		      System.out.println();
		   }
	      System.out.println("\n");
	     System.out.println(combinations);*/
	}
	
	public  void removeOption (byte currentgrid [][], int row1, int col1, int row2, int col2){
		currentgrid [row1][col1] = 0;
		currentgrid [row2][col2] = 0;
		 System.out.println("REMOVE:");
		 /*try {
			Thread.sleep(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n");
		for(int i = 0; i < numofrows; i++)
		   {
		      for(int j = 0; j < numofcols; j++)
		      {
		         System.out.printf("%5d ", currentgrid[i][j]);
		      }
		      
		      System.out.println();
		   }
		 System.out.println("\n");*/
	}
	
	public  boolean canPlaceHor (gridArrayClass currentgrid, int row, int col){
		if (row > 4 || col >= 4){
			   
		 }
		else{
		if (currentgrid.grid [row][col] == 0 && currentgrid.grid [row] [col + 1] == 0){
			return true;
		}
		}
		return false;
		
	}
	
	public  boolean canPlaceVer (gridArrayClass currentgrid, int row, int col){
		if (row >= 4 || col >4){
			   
		  }
		else{
		if (currentgrid.grid [row][col] == 0 && currentgrid.grid [row + 1] [col] == 0){
			return true;
		}
		}
		return false;
		
	}
	
	public  int getNumofrows() {
		return numofrows;
	}
	public  void setNumofrows(int numofrows) {
		this.numofrows = numofrows;
	}
	public  int getNumofcols() {
		return numofcols;
	}
	public  void setNumofcols(int numofcols) {
		this.numofcols = numofcols;
	}
	public  int getLastoptionrow1() {
		return lastoptionrow1;
	}
	public  void setLastoptionrow1(int lastoptionrow1) {
		this.lastoptionrow1 = lastoptionrow1;
	}
	public  int getLastoptioncol1() {
		return lastoptioncol1;
	}
	public  void setLastoptioncol1(int lastoptioncol1) {
		this.lastoptioncol1 = lastoptioncol1;
	}
	public  int getLastoptionrow2() {
		return lastoptionrow2;
	}
	public  void setLastoptionrow2(int lastoptionrow2) {
		this.lastoptionrow2 = lastoptionrow2;
	}
	public  int getLastoptioncol2() {
		return lastoptioncol2;
	}
	public  void setLastoptioncol2(int lastoptioncol2) {
		this.lastoptioncol2 = lastoptioncol2;
	}
	
	public  Option getOptionroot() {
		return optionroot;
	}
	public  void setOptionroot(Option optionroot) {
		this.optionroot = optionroot;
	}
	public  GenericTree<Option> getTree() {
		return tree;
	}
	public  void setTree(GenericTree<Option> tree) {
		this.tree = tree;
	}
	
	public  gridArrayClass getGrid() {
		return grid;
	}
	
	public  void setGrid(gridArrayClass grid) {
		this.grid = grid;
		setTempgrid(grid);
	}
	
	public  gridArrayClass getTempgrid() {
		return tempgrid;
	}
	public  void setTempgrid(gridArrayClass tempgrid) {
		this.tempgrid = tempgrid;
	}
}
