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
	
	private  gridArrayClass grid = new gridArrayClass(gridInit, true, false);
	private  Option optionroot = new Option (grid,0,0,0,0);
	
	private  GenericTree<Option> tree = new GenericTree<Option>();

	private  gridArrayClass tempgrid = new gridArrayClass(gridInit, true, false);

	public  int number = 0;
	
	private int doneCount = 0;
	private int gridArrayLength = 1;
	
	public void solve (HashMap<gridArrayClass, LinkedList<Option>> allGrids){
	boolean hi = false;
	//hi = tree.buildTree(getTree().getRoot(),row,onCol);
	
	buildHash(allGrids);
	hi = true;
	if (hi){
		System.out.println("Done");
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
						//System.out.println("Not placed");
						Option option = new Option((gridArrayClass)gridArray[i],0,0,0,0);
						allGrids.get(gridArray[i]).add(option);
						((gridArrayClass) gridArray[i]).setWin(false);
						((gridArrayClass) gridArray[i]).setProcessed(true);
						//this.placeOption((gridArrayClass)gridArray[i],0,0,0,0, allGrids);
						//allGrids.get(gridArray[i]).get(0).setWin(true);
					}
				}
				else
				{
					//System.out.println(i + " is not null");
					this.doneCount++;
				}
			}
		}
		processHash(allGrids);
	}
	
	public void processHash (HashMap<gridArrayClass, LinkedList<Option>> allGrids){
		System.out.println("Processing Hashes");
		Object[] gridArray = allGrids.keySet().toArray();
		this.gridArrayLength = gridArray.length;
		int totalProcessed = 0;
		while (totalProcessed < gridArray.length){
			totalProcessed = 0;
			for(int i = 0; i < this.gridArrayLength; i++) {
				if (i % 10000 == 0){
					System.out.println("Processing " + (i + 1) + " of " + gridArray.length + " keys/grids.");
				}
				if (!Main.allGridsKeys.get(((gridArrayClass) gridArray[i])).getProcessed()){
					LinkedList<Option> keyGridList = allGrids.get(gridArray[i]);
					int winCount = 0;
					int processedCount = 0;
					for (int j = 0; j < keyGridList.size(); j++)
					{
						if(Main.allGridsKeys.get(keyGridList.get(j).getGrid()).getProcessed()){
							keyGridList.get(j).getGrid().setProcessed(true);
							processedCount++;
							if(keyGridList.get(j).getGrid().getWin() != Main.allGridsKeys.get(keyGridList.get(j).getGrid()).getWin()){
								keyGridList.get(j).getGrid().setWin(Main.allGridsKeys.get(keyGridList.get(j).getGrid()).getWin());
							}
							if (keyGridList.get(j).getGrid().getWin()){
								winCount++;
							}
						}
					}
					if (processedCount == keyGridList.size()){
						if (winCount == keyGridList.size()){
							Main.allGridsKeys.get(((gridArrayClass) gridArray[i])).setWin(false);
						}
						else{
							Main.allGridsKeys.get(((gridArrayClass) gridArray[i])).setWin(true);
						}
						Main.allGridsKeys.get(((gridArrayClass) gridArray[i])).setProcessed(true);
					}
					else{
						Main.allGridsKeys.get(((gridArrayClass) gridArray[i])).setProcessed(false);
					}
				}
				else{
					totalProcessed++;
				}
			}
			System.out.println("Total processed: " + totalProcessed + ", Size: " + gridArray.length);
		}
	}
	
	public String findMove (HashMap<gridArrayClass, LinkedList<Option>> allGrids, gridArrayClass currentBoard){
		String theMove = "";
		int moveRow1 = 1;
		int moveRow2 = 1;
		int moveCol1 = 1;
		int moveCol2 = 1;
		boolean canWin = Main.allGridsKeys.get(currentBoard).getWin();
		
		if(canWin){
			//Search for L's
			LinkedList<Option> keyGridList = allGrids.get(currentBoard);
			for (int i = 0; i < keyGridList.size(); i++){
				if(!keyGridList.get(i).getGrid().getWin()){
					moveRow1 += (keyGridList.get(i).getRowOne());
					moveRow2 += (keyGridList.get(i).getRowTwo());
					moveCol1 += (keyGridList.get(i).getColOne());
					moveCol2 += (keyGridList.get(i).getColTwo());
					break;
				}
			}
		}
		else{
			//Pick any child
			moveRow1 += (allGrids.get(currentBoard).get(0).getRowOne());
			moveRow2 += (allGrids.get(currentBoard).get(0).getRowTwo());
			moveCol1 += (allGrids.get(currentBoard).get(0).getColOne());
			moveCol2 += (allGrids.get(currentBoard).get(0).getColTwo());
		}
	
		 switch (moveCol1) {
		  	case 1:
		  		theMove = "A" + moveRow1;
		  		break;
		  	case 2:
		  		theMove = "B" + moveRow1;
		  		break;
		 	case 3:
		 		theMove = "C" + moveRow1;
		 		break;
		 	case 4:
		 		theMove = "D" + moveRow1;
		 		break;
		 	case 5:
		 		theMove = "E" + moveRow1;
		 		break;
		}
		 
		switch (moveCol2) {
		  	case 1:
		  		theMove += "A" + moveRow2;
		  		break;
		  	case 2:
		  		theMove += "B" + moveRow2;
		  		break;
		 	case 3:
		 		theMove += "C" + moveRow2;
		 		break;
		 	case 4:
		 		theMove += "D" + moveRow2;
		 		break;
		 	case 5:
		 		theMove += "E" + moveRow2;
		 		break;
		}
		
		return theMove;
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
		gridArrayClass myInt = new gridArrayClass(myIntInit, true, false);
		for(int i = 0; i < 5; i++)
		    myInt.grid[i] = currentgrid.grid[i].clone();
		myInt.grid [row1][col1] = 1;
		myInt.grid [row2][col2] = 1;
		Option option = new Option(myInt,row1,col1,row2,col2);
		if (allGrids.get(myInt) != null)
		{
			allGrids.get(currentgrid).add(option);
		}
		else
		{
			allGrids.get(currentgrid).add(option);
			LinkedList<Option> newGrid = new LinkedList<Option>();
			Main.allGridsKeys.put(myInt, myInt);
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
	public ArrayList<gridArrayClass> masterMoves (){
	 byte [][] gridTest = new byte[][] { 
				
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0}
						
				};
	
		int keyrow = 0;
		int keycol= 0;
		int mastercomb = 0;
		int start = 0;
		int doneRow = 0;
		ArrayList<gridArrayClass> allMasters = new ArrayList <gridArrayClass>();
	for (int g = 1 ;g < (this.numofrows*this.numofcols) ;g++){
		gridTest [keyrow][keycol] = 1;
		for (int i = doneRow; i < this.numofrows ; i++){
			if (i == doneRow + 1){
				start = 0;
			}
			for (int j = start; j < this.numofcols ;j++){
				if (keyrow == i && keycol == j){
				//don't compute this one
				}
				else{
					gridTest [i][j] = 1;
					allMasters.add(new gridArrayClass (gridTest,true,false));
					System.out.println(allMasters.get(0));
					 gridTest [i][j] = 0; 
					 mastercomb ++;
				}
			}
		}
		gridTest [keyrow][keycol] = 0;
		if (g % this.numofcols == 0){
			keyrow++;
			keycol = 0;
			doneRow ++;
		}
		else{
			keycol++;
		}
		if (start % this.numofcols + 1 == 0){
		start += 2;
		}
		
		start = start + (g % this.numofcols);
		if (start == 6){
			start -= 2;
		}
		
	}
	return allMasters;
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
