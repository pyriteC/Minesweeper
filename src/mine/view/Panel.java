package mine.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import mine.controller.Controller;

public class Panel extends JPanel
{
private Controller app;
private SpringLayout layout;
private JButton [][] buttonGrid ;
private JPanel buttonPanel;
	
	public Panel(Controller app)
	{
		super();
		this.app = app;
		layout = new SpringLayout();
		buttonGrid = new JButton [app.getRows()][app.getCols()];
		buttonPanel = new JPanel( new GridLayout(app.getCols(),app.getRows()));
		setUpButtonGrid();
		setUpButtonPanel();
		setupPanel();
		setupListeners();
//		setupLayout();
		
	}

	private void setUpButtonGrid() 
	{
		for (int index = 0; index < buttonGrid.length; index++)
		{
			for (int inIndex = 0; inIndex < buttonGrid[0].length; inIndex++)
			{
				JButton temp = new JButton();
				temp.setSize(new Dimension(5000,5000));
				buttonGrid[index][inIndex] = temp;
			}
		}
	}
	private void setUpButtonPanel()
	{
		for (int index = 0; index < buttonGrid.length; index++)
		{
			for (int inIndex = 0; inIndex < buttonGrid[0].length; inIndex++)
			{
				buttonPanel.add(buttonGrid[index][inIndex]);
			}
		}
	}
	
	private void setupPanel()
	{
		this.setLayout(layout);
		this.setBackground(new Color(10, 100, 10 ));
		this.add(buttonPanel);
	}
	
	private void setupListeners()
	{
		for ( int row = 0; row < buttonGrid.length; row ++)
		{
			final int rowIndex = row;
			for ( int col = 0; col < buttonGrid[0].length; col++)
			{
				final int colIndex = col;
				buttonGrid[row][col].addActionListener(click ->   onPress(rowIndex,colIndex));
				buttonGrid[row][col].addMouseListener (new MouseAdapter()
				{
				    public void mouseClicked(MouseEvent e)
				    {
				         if (e.getButton() == 3 )//right click
				         {
				        	 flag(rowIndex,colIndex);
				         }
				        
				    }
				    
				});
			}
		}
	}
	
	private void setupLayout()
	{
	
	}
	
	private void onPress(int row, int col)
	{
		if (app.grid[row][col].isMine())
		{
			gameOver();
		}

		buttonGrid[row][col].setText(app.grid[row][col].getAdjMineString());
		buttonGrid[row][col].setEnabled(false);
		if (app.grid[row][col].getAdjMine() == 0)
		{
			if (row > 0)//top
			{
				buttonGrid[row-1][col].setText(app.grid[row-1][col].getAdjMineString());
				buttonGrid[row-1][col].setEnabled(false);
			}
			if ( row > 0 && col < app.getCols()-1 ) // top right 
			{
				buttonGrid[row-1][col+1].setText(app.grid[row-1][col+1].getAdjMineString());
				buttonGrid[row-1][col+1].setEnabled(false);
			}
			if ( col < app.getCols() -1) //right
			{
				buttonGrid[row][col+1].setText(app.grid[row][col+1].getAdjMineString());
				buttonGrid[row][col+1].setEnabled(false);
			}
			if ( col < app.getCols() -1 && row < app.getRows() -1)// bottom right 
			{
				buttonGrid[row+1][col+1].setText(app.grid[row+1][col+1].getAdjMineString());
				buttonGrid[row+1][col+1].setEnabled(false);
			}
			if (row < app.getRows() -1)// bottom  
			{
				buttonGrid[row+1][col].setText(app.grid[row+1][col].getAdjMineString());
				buttonGrid[row+1][col].setEnabled(false);
			}
			if ( col > 0 && row < app.getRows() -1)// bottom Left 
			{
				buttonGrid[row+1][col-1].setText(app.grid[row+1][col-1].getAdjMineString());
				buttonGrid[row+1][col-1].setEnabled(false);
			}
			if ( col > 0)//  Left 
			{
				buttonGrid[row][col-1].setText(app.grid[row][col-1].getAdjMineString());
				buttonGrid[row][col-1].setEnabled(false);
			}
			if ( col > 0 && row > 0)// top Left 
			{
				buttonGrid[row-1][col-1].setText(app.grid[row-1][col-1].getAdjMineString());
				buttonGrid[row-1][col-1].setEnabled(false);
			}
		}
	}

	

	private void flag(int row, int col) 
	{
		buttonGrid[row][col].setText("F");
	}
	
	private void gameOver() 
	{
		for ( int row = 0; row < buttonGrid.length; row ++)
		{
			for ( int col = 0; col < buttonGrid[0].length; col++)
			{
				buttonGrid[row][col].setEnabled(false);
			}
		}
	}
}
