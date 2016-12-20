package math.model;

import javax.swing.*;
import math.controller.MathController;

public class Quadratics extends JPanel 
{

	private MathController baseController;
	
	
	 public Quadratics(MathController baseController)
	 {
		super();
		this.baseController = baseController;
		
	 }
	
	
	public String toString()
	{
		return "Quadratics";
	}
	
	
}
