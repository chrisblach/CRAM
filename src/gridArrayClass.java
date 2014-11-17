import java.util.Arrays;

public class gridArrayClass {
  byte grid[][];

  public gridArrayClass( byte b[][] ) {
     grid = b;
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
		return Arrays.deepToString(this.grid);
	}
}