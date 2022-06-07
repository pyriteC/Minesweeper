package mine.view;

import javax.swing.JFrame;

import mine.controller.Controller;

public class Frame extends JFrame
{
	private Controller app;
	private Panel panel;
	
	public Frame(Controller app)
	{
		super();
		this.app = app;
		this.panel = new Panel(this.app);
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(panel);
		this.setTitle("Minesweeper");
		this.setSize(800, 600);
		this.setResizable(false);
		this.setVisible(true);
	}
}
