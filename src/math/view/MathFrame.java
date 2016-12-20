package math.view;

import javax.swing.JFrame;
import math.controller.MathController;

import java.awt.Color;
import java.awt.Dimension;


public class MathFrame extends JFrame
{

	private MathController baseController;
	private MathPanel appPanel;
	
	public MathFrame(MathController baseController)
	{
		super();
		this.baseController =  baseController;
		appPanel = new MathPanel(baseController);
		
		setupPanel(500,500);
		setupListeners();
		
		
	}
	
	private void setupPanel(int width, int height)
	{
		this.setContentPane(appPanel);
		this.setTitle("Math Buster");
		this.setSize(new Dimension(width, height));
		this.setVisible(true);
		this.setBackground(Color.BLUE);
		
	}
	
	private void setupListeners()
	{
		this.addWindowListener(new java.awt.event.WindowAdapter()
		{
			
		@Override
		public void windowClosing(java.awt.event.WindowEvent windowEvent)
		{
			System.exit(0);
		}
				
			
				
		});
	}
	
}
