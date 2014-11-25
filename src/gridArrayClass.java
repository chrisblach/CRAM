public class gridArrayClass {
  byte grid[][];
  boolean win;
  boolean processed;
  float winningRatio;
  long totalChildren;

  public gridArrayClass( byte b[][], boolean condition, boolean processed ) {
     grid = b;
     setWin(condition);
     setProcessed(processed);
     setWinningRatio(0);
     setTotalChildren(0);
  }
  
	public boolean getWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}
	
	public boolean getProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}
	
	public float getWinningRatio() {
		return winningRatio;
	}

	public void setWinningRatio(float winningRatio) {
		this.winningRatio = winningRatio;
	}
	
	public long getTotalChildren() {
		return totalChildren;
	}

	public void setTotalChildren(long totalChildren) {
		this.totalChildren = totalChildren;
	}

	@Override
  public int hashCode() {
    int hash = java.util.Arrays.deepHashCode(grid);
    return hash;
  }

  @Override
  public boolean equals( Object b ) {
     if (!(b instanceof gridArrayClass)){
        return false;
     }
     if ( grid.length != ((gridArrayClass)b).grid.length ){
        return false;
     }
     for (int k = 0; k < grid.length; k++ ){
    	 if ( grid[k].length != ((gridArrayClass)b).grid[k].length ){
    	        return false;
    	 }
     }
     for (int i = 0; i < grid.length; i++ ){
    	 for (int j = 0; j < grid[i].length; j++ ){
    		 if (grid[i][j] != ((gridArrayClass)b).grid[i][j]){
    			 return false;
    		 }
    	 }
     }
     return true;
  }
  
  public String toString(){
	  String returnString = "";
	  for (int i = 0; i < Main.numofrows; i++){
		  returnString += "[";
		  for (int j = 0; j < Main.numofcols; j++){
			  returnString += grid[i][j];
			  if (j != Main.numofcols - 1){
				  returnString += ", ";
			  }
		  }
		  if (i != Main.numofrows - 1){
			  returnString += "]\n";
		  }
	  }
	  returnString += "]";
	  returnString += "W: " + win;
	  returnString += ", P: " + processed;
	  returnString += ", R: " + winningRatio;
	  returnString += ", C: " + totalChildren;
	  return returnString;
	}
}