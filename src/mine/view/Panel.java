package mine.view;

import java.awt.Color;
import java.awt.GridLayout;

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
		setupLayout();
		
	}

	private void setUpButtonGrid() 
	{
		for (int index = 0; index < buttonGrid.length; index++)
		{
			for (int inIndex = 0; inIndex < buttonGrid[0].length; inIndex++)
			{
				JButton temp = new JButton(app.grid[index][inIndex].getAdjMineString());
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
		
	}
	
	private void setupLayout()
	{
	
	}
}
