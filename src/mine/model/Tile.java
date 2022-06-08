package mine.model;

public class Tile 
{
	private boolean isMine;
	private int adjMine = 0;
	private boolean isChecked = false;

	public Tile(boolean isMine)
	{
		this.setMine(isMine);
		
	}

	public void increment()
	{
		adjMine ++;
	}
	public boolean isMine() {
		return isMine;
	}

	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}

	public int getAdjMine() {
		return adjMine;
	}
	
	public String getAdjMineString() 
	{
		if (!isMine)
		{
			if (adjMine == 0) 
			{
				return "";
			} 
			else 
			{

				return Integer.toString(adjMine);
			}
		}
		else 
		{
			return "x";
		}
	}


	public void setAdjMine(int adjMine) {
		this.adjMine = adjMine;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
}
