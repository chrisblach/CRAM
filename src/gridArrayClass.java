public class gridArrayClass {
  byte grid[][];
  boolean win;

  public gridArrayClass( byte b[][], boolean condition ) {
     grid = b;
     setWin(condition);
  }
  
	public boolean getWin() {
		return win;
	}


	public void setWin(boolean win) {
		this.win = win;
	}

  public int hashCode() {
    //int hash = 0;
    int hash = java.util.Arrays.deepHashCode(grid);
    //for (int i = 0; i < grid.length; i++)
    	//for (int j = 0; j < grid.length; j++)
    		//if (grid[i][j])
    			//hash += Math.pow(2, i);
    return hash;
  }

  public boolean equals( Object b ) {
     if (!(b instanceof gridArrayClass))
        return false;
     if ( grid.length != ((gridArrayClass)b).grid.length )
        return false;
     for (int k = 0; k < grid.length; k++ )
    	 if ( grid[k].length != ((gridArrayClass)b).grid[k].length )
    	        return false;
     for (int i = 0; i < grid.length; i++ )
    	 for (int j = 0; j < grid[i].length; j++ )
    		 if (grid[i][j] != ((gridArrayClass)b).grid[i][j])
    			 return false;
     return true;
  }
  
  public String toString(){
		//return Arrays.deepToString(this.grid);
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
	  returnString += win;
	  return returnString;
	}
}