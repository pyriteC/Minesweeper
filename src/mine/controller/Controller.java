package mine.controller;

import mine.model.Tile;

public class Controller 
{
	private int rows = 9;
	private int cols = 9;
	private int mines = 10;
	private Tile [][] grid = new Tile [rows][cols]; 
	public Controller()
	{
		for (int index = 0; index < grid.length; index++)
		{
			for (int inIndex = 0; inIndex < grid[0].length; inIndex++)
			{
				Tile temp = new Tile(false);
				grid[index][inIndex] = temp;
			}
		}
		placeMines();
	}
	
	public void start ()
	{
		
	}
	
	private void placeMines()
	{
		int randRow = (int) (Math.random() * rows);
		int randCol = (int) (Math.random() * cols);
		for (int index = 0; index < mines; index++)
		{
			while(grid[randCol][randRow].isMine());
			{
				randRow = (int) (Math.random() * rows);
				randCol = (int) (Math.random() * cols);
			}
			grid[randRow][randCol].setMine(true);
			
			
			if (randRow > 0)
			{
				grid[randRow-1][randCol].increment();//top
			}
			if (randRow > 0 && randCol <cols -1)
			{
				grid[randRow-1][randCol +1].increment();//topRight
			}
			if (randCol < cols -1)
			{
				grid[randRow][randCol +1].increment();//right
			}
			if (randCol < cols -1 && randRow < rows -1)
			{
				grid[randRow+1][randCol +1].increment();//bottomRight
			}
			if (randRow < rows -1)
			{
				grid[randRow+1][randCol].increment();//bottom
			}
			if (randRow < rows -1 && randCol >0)
			{
				grid[randRow+1][randCol-1].increment();//bottomLeft
			}
			if (randCol > 0)
			{
				grid[randRow][randCol-1].increment();//left
			}
			if (randCol > 0 && randRow > 0)
			{
				grid[randRow-1][randCol -1].increment();//topLeft
			}
				
		}
	}
}