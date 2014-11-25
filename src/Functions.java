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

	public  int number = 0;
	
	private int doneCount = 0;
	private int gridArrayLength = 1;
	
	private LinkedList<gridArrayClass> worstCases = new LinkedList<gridArrayClass>();
	private LinkedList<String> worstCaseMoves = new LinkedList<String>();
	
	private byte [][] TLHI = new byte[][] { 
			
			{1,1,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}
					
			};
		
	private  gridArrayClass TLHG = new gridArrayClass(TLHI, true, false);
		
	String TLHS = "C3D3";
	
private byte [][] TLVI = new byte[][] { 
			
			{1,0,0,0,0},
			{1,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}
					
			};
		
	private  gridArrayClass TLVG = new gridArrayClass(TLVI, true, false);
		
	String TLVS = "C3C4";
	
private byte [][] BLHI = new byte[][] { 
			
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{1,1,0,0,0}
					
			};
		
	private  gridArrayClass BLHG = new gridArrayClass(BLHI, true, false);
		
	String BLHS = "C3D3";
	
private byte [][] BLVI = new byte[][] { 
			
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{1,0,0,0,0},
			{1,0,0,0,0}
					
			};
		
	private  gridArrayClass BLVG = new gridArrayClass(BLVI, true, false);
		
	String BLVS = "C2C3";
	
private byte [][] TRHI = new byte[][] { 
			
			{0,0,0,1,1},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}
					
			};
		
	private  gridArrayClass TRHG = new gridArrayClass(TRHI, true, false);
		
	String TRHS = "B3C3";
	
private byte [][] TRVI = new byte[][] { 
			
			{0,0,0,0,1},
			{0,0,0,0,1},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}
					
			};
		
	private  gridArrayClass TRVG = new gridArrayClass(TRVI, true, false);
		
	String TRVS = "C3C4";
	
private byte [][] BRHI = new byte[][] { 
			
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,1,1}
					
			};
		
	private  gridArrayClass BRHG = new gridArrayClass(BRHI, true, false);
		
	String BRHS = "B3C3";
	
private byte [][] BRVI = new byte[][] { 
			
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,1},
			{0,0,0,0,1}
					
			};
		
	private  gridArrayClass BRVG = new gridArrayClass(BRVI, true, false);
		
	String BRVS = "C2C3";
	
private byte [][] TLI = new byte[][] { 
			
			{0,1,1,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}
					
			};
		
	private  gridArrayClass TLG = new gridArrayClass(TLI, true, false);
		
	String TLS = "D2D3";

private byte [][] TRI = new byte[][] { 
			
			{0,0,1,1,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}
					
			};
		
	private  gridArrayClass TRG = new gridArrayClass(TRI, true, false);
		
	String TRS = "B2B3";

private byte [][] RUI = new byte[][] { 
			
			{0,0,0,0,0},
			{0,0,0,0,1},
			{0,0,0,0,1},
			{0,0,0,0,0},
			{0,0,0,0,0}
					
			};
		
	private  gridArrayClass RUG = new gridArrayClass(RUI, true, false);
		
	String RUS = "C4D4";
	
private byte [][] RDI = new byte[][] { 
			
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,1},
			{0,0,0,0,1},
			{0,0,0,0,0}
					
			};
		
	private  gridArrayClass RDG = new gridArrayClass(RDI, true, false);
		
	String RDS = "C2D2";
	
private byte [][] BLI = new byte[][] { 
			
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,1,1,0,0}
					
			};
		
	private  gridArrayClass BLG = new gridArrayClass(BLI, true, false);
		
	String BLS = "D3D4";

private byte [][] BRI = new byte[][] { 
			
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0},
			{0,0,1,1,0}
					
			};
		
	private  gridArrayClass BRG = new gridArrayClass(BRI, true, false);
		
	String BRS = "B3B4";
	
private byte [][] LUI = new byte[][] { 
			
			{0,0,0,0,0},
			{1,0,0,0,0},
			{1,0,0,0,0},
			{0,0,0,0,0},
			{0,0,0,0,0}
					
			};
		
	private  gridArrayClass LUG = new gridArrayClass(LUI, true, false);
		
	String LUS = "B4C4";
	
private byte [][] LDI = new byte[][] { 
			
			{0,0,0,0,0},
			{0,0,0,0,0},
			{1,0,0,0,0},
			{1,0,0,0,0},
			{0,0,0,0,0}
					
			};
		
	private  gridArrayClass LDG = new gridArrayClass(LDI, true, false);
		
	String LDS = "B2C2";
	
	public String checkForWorst(gridArrayClass passedGrid){
		worstCases.add(TLHG);
		worstCases.add(TLVG);
		worstCases.add(BLHG);
		worstCases.add(BLVG);
		worstCases.add(TRHG);
		worstCases.add(TRVG);
		worstCases.add(BRHG);
		worstCases.add(BRVG);
		worstCases.add(TLG);
		worstCases.add(TRG);
		worstCases.add(RUG);
		worstCases.add(RDG);
		worstCases.add(BLG);
		worstCases.add(BRG);
		worstCases.add(LUG);
		worstCases.add(LDG);
		worstCaseMoves.add(TLHS);
		worstCaseMoves.add(TLVS);
		worstCaseMoves.add(BLHS);
		worstCaseMoves.add(BLVS);
		worstCaseMoves.add(TRHS);
		worstCaseMoves.add(TRVS);
		worstCaseMoves.add(BRHS);
		worstCaseMoves.add(BRVS);
		worstCaseMoves.add(TLS);
		worstCaseMoves.add(TRS);
		worstCaseMoves.add(RUS);
		worstCaseMoves.add(RDS);
		worstCaseMoves.add(BLS);
		worstCaseMoves.add(BRS);
		worstCaseMoves.add(LUS);
		worstCaseMoves.add(LDS);
		String returnString = "N";
		for (int worst = 0; worst < 16; worst++){
			if (passedGrid.equals(worstCases.get(worst))){
				System.out.println("Starting grid is a worst case");
				returnString = worstCaseMoves.get(worst);
				break;
			}
		}
		return returnString;
	}
	
	public void solve (HashMap<gridArrayClass, LinkedList<Option>> allGrids, HashMap<gridArrayClass,gridArrayClass> allGridsKeys){
	boolean hi = false;
	
	
	buildHash(allGrids, allGridsKeys);
	hi = true;
	if (hi){
		System.out.println("Done");
	}
}
	
	public void buildHash (HashMap<gridArrayClass, LinkedList<Option>> allGrids, HashMap<gridArrayClass,gridArrayClass> allGridsKeys){
        	for (int r = 0;r <= this.getNumofrows() - 1;r++){
    			for (int col = 0; col <= this.getNumofcols() - 1;col++){
    				if (this.canPlaceHor (Main.grid,r,col)){
        					if (col == this.getNumofcols() - 1){
        						
        					}
        					else this.placeOption(Main.grid,r,col,r,col + 1, allGrids, allGridsKeys);
    				}
    				if (this.canPlaceVer (Main.grid,r,col)){
    					if (r == this.getNumofrows() - 1){
    						
    					}
    					else this.placeOption(Main.grid,r,col,r + 1,col, allGrids, allGridsKeys);
    				}
    			}
    		}
        		fillHash(allGrids, allGridsKeys);
    	}
	
	@SuppressWarnings("unchecked")
	public void fillHash (HashMap<gridArrayClass, LinkedList<Option>> allGrids, HashMap<gridArrayClass,gridArrayClass> allGridsKeys){         
		while (this.doneCount < this.gridArrayLength){
			System.out.println(this.doneCount + " is less than " + this.gridArrayLength);
			Object[] gridArray = allGrids.keySet().toArray();
			this.gridArrayLength = gridArray.length;
			this.doneCount = 0;
			for(int i = 0; i < this.gridArrayLength; i++) {
			
				if (allGrids.get(gridArray[i]).peekFirst() == null)
				{
				
					boolean placed = false;
					for (int r = 0;r <= this.getNumofrows() - 1;r++){
						for (int col = 0; col <= this.getNumofcols() - 1;col++){
							if (this.canPlaceHor ((gridArrayClass)gridArray[i],r,col)){
								if (col == this.getNumofcols() - 1){
								
								}
								else
									{
									placed = true;
									this.placeOption((gridArrayClass)gridArray[i],r,col,r,col + 1, allGrids, allGridsKeys);
									}
							}
							if (this.canPlaceVer ((gridArrayClass)gridArray[i],r,col)){
								if (r == this.getNumofrows() - 1){
						
								}
								else
								{
									placed = true;
									this.placeOption((gridArrayClass)gridArray[i],r,col,r + 1,col, allGrids, allGridsKeys);
								}
							}
						}
					}
					if (!placed)
					{
						
						Option option = new Option((gridArrayClass)gridArray[i],0,0,0,0);
						allGrids.get(gridArray[i]).add(option);
						((gridArrayClass) gridArray[i]).setWin(false);
						((gridArrayClass) gridArray[i]).setProcessed(true);
						
					}
				}
				else
				{
					//System.out.println(i + " is not null");
					this.doneCount++;
				}
			}
		}
		processHash(allGrids, allGridsKeys);
	}
	
	public void processHash (HashMap<gridArrayClass, LinkedList<Option>> allGrids, HashMap<gridArrayClass,gridArrayClass> allGridsKeys){
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
				if (!allGridsKeys.get(((gridArrayClass) gridArray[i])).getProcessed()){
					LinkedList<Option> keyGridList = allGrids.get(gridArray[i]);
					int winCount = 0;
					int processedCount = 0;
					long childrenCount = 0;
					for (int j = 0; j < keyGridList.size(); j++)
					{
						if(allGridsKeys.get(keyGridList.get(j).getGrid()).getProcessed()){
							keyGridList.get(j).getGrid().setProcessed(true);
							processedCount++;
							if(keyGridList.get(j).getGrid().getWin() != allGridsKeys.get(keyGridList.get(j).getGrid()).getWin()){
								keyGridList.get(j).getGrid().setWin(allGridsKeys.get(keyGridList.get(j).getGrid()).getWin());
							}
							if(keyGridList.get(j).getGrid().getWinningRatio() != allGridsKeys.get(keyGridList.get(j).getGrid()).getWinningRatio()){
								keyGridList.get(j).getGrid().setWinningRatio(allGridsKeys.get(keyGridList.get(j).getGrid()).getWinningRatio());
							}
							if(keyGridList.get(j).getGrid().getTotalChildren() != allGridsKeys.get(keyGridList.get(j).getGrid()).getTotalChildren()){
								keyGridList.get(j).getGrid().setTotalChildren(allGridsKeys.get(keyGridList.get(j).getGrid()).getTotalChildren());
							}
							if (keyGridList.get(j).getGrid().getWin()){
								winCount++;
							}
							childrenCount += allGridsKeys.get(keyGridList.get(j).getGrid()).getTotalChildren() + 1;
						}
					}
					if (processedCount == keyGridList.size()){
						if (winCount == keyGridList.size()){
							allGridsKeys.get(((gridArrayClass) gridArray[i])).setWin(false);
						}
						else{
							allGridsKeys.get(((gridArrayClass) gridArray[i])).setWin(true);
						}
						allGridsKeys.get(((gridArrayClass) gridArray[i])).setProcessed(true);
						allGridsKeys.get(((gridArrayClass) gridArray[i])).setWinningRatio((float)winCount/(float)keyGridList.size());
						allGridsKeys.get(((gridArrayClass) gridArray[i])).setTotalChildren(childrenCount);
					}
					else{
						allGridsKeys.get(((gridArrayClass) gridArray[i])).setProcessed(false);
					}
				}
				else{
					totalProcessed++;
				}
			}
			System.out.println("Total processed: " + totalProcessed + ", Size: " + gridArray.length);
		}
	}
	
	public String findMove (HashMap<gridArrayClass, LinkedList<Option>> allGrids, HashMap<gridArrayClass,gridArrayClass> allGridsKeys, gridArrayClass currentBoard){
		String theMove = "";
		byte moveRow1 = 1;
		byte moveRow2 = 1;
		byte moveCol1 = 1;
		byte moveCol2 = 1;
		boolean canWin = allGridsKeys.get(currentBoard).getWin();
		
		if(canWin){
			//Search for L with least children
			LinkedList<Option> keyGridList = allGrids.get(currentBoard);
			long leastChildren = Long.MAX_VALUE;
			int leastChildrenIndex = 0;
			for (int i = 0; i < keyGridList.size(); i++){
				if(!keyGridList.get(i).getGrid().getWin()){
					if (keyGridList.get(i).getGrid().getTotalChildren() < leastChildren){
						leastChildren = keyGridList.get(i).getGrid().getTotalChildren();
						leastChildrenIndex = i;
					}
				}
			}
			moveRow1 += (keyGridList.get(leastChildrenIndex).getRowOne());
			moveRow2 += (keyGridList.get(leastChildrenIndex).getRowTwo());
			moveCol1 += (keyGridList.get(leastChildrenIndex).getColOne());
			moveCol2 += (keyGridList.get(leastChildrenIndex).getColTwo());
		}
		else{
			//Search for W with highest ratio then most children
			LinkedList<Option> keyGridList = allGrids.get(currentBoard);
			float highestRatio = 0;
			long mostChildren = 0;
			int mostChildrenIndex = 0;
			for (int i = 0; i < keyGridList.size(); i++){
				if (keyGridList.get(i).getGrid().getWinningRatio() > highestRatio){
					highestRatio = keyGridList.get(i).getGrid().getWinningRatio();
					mostChildren = keyGridList.get(i).getGrid().getTotalChildren();
					mostChildrenIndex = i;
				}
				else if(keyGridList.get(i).getGrid().getWinningRatio() == highestRatio){
					if (keyGridList.get(i).getGrid().getTotalChildren() > mostChildren){
						highestRatio = keyGridList.get(i).getGrid().getWinningRatio();
						mostChildren = keyGridList.get(i).getGrid().getTotalChildren();
						mostChildrenIndex = i;
					}
				}
			}
			moveRow1 += (keyGridList.get(mostChildrenIndex).getRowOne());
			moveRow2 += (keyGridList.get(mostChildrenIndex).getRowTwo());
			moveCol1 += (keyGridList.get(mostChildrenIndex).getColOne());
			moveCol2 += (keyGridList.get(mostChildrenIndex).getColTwo());
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
	
	public void parseMove (String theMove, gridArrayClass theGrid){
		byte moveRow1 = 1;
		byte moveRow2 = 1;
		byte moveCol1 = 1;
		byte moveCol2 = 1;

		switch (theMove.charAt(0)) {
		case 'A':
			moveCol1 = 0;
			break;
		case 'B':
			moveCol1 = 1;
			break;
		case 'C':
			moveCol1 = 2;
			break;
		case 'D':
			moveCol1 = 3;
			break;
		case 'E':
			moveCol1 = 4;
			break;
		}
		
		switch (theMove.charAt(1)) {
		case '1':
			moveRow1 = 0;
			break;
		case '2':
			moveRow1 = 1;
			break;
		case '3':
			moveRow1 = 2;
			break;
		case '4':
			moveRow1 = 3;
			break;
		case '5':
			moveRow1 = 4;
			break;
		}
		
		switch (theMove.charAt(2)) {
		case 'A':
			moveCol2 = 0;
			break;
		case 'B':
			moveCol2 = 1;
			break;
		case 'C':
			moveCol2 = 2;
			break;
		case 'D':
			moveCol2 = 3;
			break;
		case 'E':
			moveCol2 = 4;
			break;
		}
		
		switch (theMove.charAt(3)) {
		case '1':
			moveRow2 = 0;
			break;
		case '2':
			moveRow2 = 1;
			break;
		case '3':
			moveRow2 = 2;
			break;
		case '4':
			moveRow2 = 3;
			break;
		case '5':
			moveRow2 = 4;
			break;
		}
		
		theGrid.grid[moveRow1][moveCol1] = 1;
		theGrid.grid[moveRow2][moveCol2] = 1;
	}

	public  void placeOption (gridArrayClass currentgrid, int row1, int col1, int row2, int col2, HashMap<gridArrayClass, LinkedList<Option>> allGrids, HashMap<gridArrayClass,gridArrayClass> allGridsKeys){
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
			allGridsKeys.put(myInt, myInt);
			allGrids.put(myInt, newGrid);
		}
		setLastoptionrow1(row1);
		setLastoptioncol1(col1);
		setLastoptionrow2(row2);
		setLastoptioncol2(col2);
		combinations++;
	}
	
	public  void removeOption (byte currentgrid [][], int row1, int col1, int row2, int col2){
		currentgrid [row1][col1] = 0;
		currentgrid [row2][col2] = 0;
		 System.out.println("REMOVE:");
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
}
