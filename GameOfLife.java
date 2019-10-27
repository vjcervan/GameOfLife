public class GameOfLife
{
    private int[][] grid;  

    public int[][] getGrid()
    {
        return this.grid;
    }
 
    public GameOfLife(int a, int b)
    {
        this.grid = new int[a][b];
    }
  
    public void nextIteration()
    {
        
        int[][] temp = copyGrid();

    int neighbors = 0;
  
    for(int i = 1; i < temp.length - 1; i++)
    {
        for(int j = 1; j < temp[i].length - 1; j++)
        {
          if (this.grid[i - 1][j] == 1)
               neighbors++;	
    	  if (this.grid[i - 1][j + 1] == 1)
            	neighbors++;
    	  if (this.grid[i][j + 1] == 1)
            	neighbors++;
          if (this.grid[i + 1][j + 1] == 1)
            	neighbors++;
    	  if (this.grid[i + 1][j] == 1)
            	neighbors++;
    	  if (this.grid[i + 1][j - 1] == 1)
            	neighbors++;
    	  if (this.grid[i][j - 1] == 1)
            	neighbors++;
    	  if (this.grid[i - 1][j - 1] == 1)
            	neighbors++;
               
            if(this.grid[i][j] == 1 && neighbors < 2)
               temp[i][j] = 0;
            else if(this.grid[i][j] == 1 && neighbors > 3)
               temp[i][j] = 0;
            else if((this.grid[i][j] == 1 && neighbors == 2) || (this.grid[i][j] == 1 && neighbors == 3))
               temp[i][j] = 1; 
            else if(this.grid[i][j] == 0 && neighbors == 3)
               temp[i][j] = 1;  
                
                

              neighbors = 0;
        }
    }
    
    this.grid = temp;
     
     
    }
    
   	public int[][] copyGrid()
    {
       int[][] temp = new int[this.grid.length][this.grid[0].length];
 
        for(int i = 0; i < this.grid.length; i++)
        {
            for(int j = 0; j < this.grid[i].length; j++)
            {
                temp[i][j] = this.grid[i][j];
            }
        }
        
        return temp;
        
    }
    
    public void oscillatePatternInitialGrid()
    {
      int[][] temp = copyGrid();
        
       temp[temp.length/2][temp[0].length/2] = 1;
       temp[temp.length/2][(temp[0].length/2) + 1] = 1;
       temp[temp.length/2][(temp[0].length/2) - 1] = 1;
       
       this.grid = temp;
    }
    
    public int[][] blockPatternInitialGrid()
    {
    		int[][] temp = copyGrid();
        
        temp[(temp.length / 2) - 1][(temp.length / 2) - 1] = 1;
        temp[(temp.length / 2) - 1][(temp.length / 2)] = 1;
        temp[(temp.length / 2)][(temp.length / 2) - 1] = 1;
        temp[temp.length / 2][temp.length / 2] = 1;
        
        this.grid = temp;
        return this.grid;
    }
    
    public int[][] randomizeInitialGrid()
    {
    	  int[][] temp = copyGrid();
        
        for(int i = 0; i < temp.length; i++)
        {
            for(int j = 0; j < temp[i].length; j++)
            {
                temp[i][j] = (int)(Math.random() * 2);
            }
        }
        
        this.grid = temp;
        return this.grid;
    }
}