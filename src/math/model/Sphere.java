package math.model;

import javax.swing.*;
import math.controller.MathController;
import math.view.MathPanel;

public class Sphere extends JPanel
	{
		private MathController baseController;
		
		
		 public Sphere(MathController baseController)
		 {
			
			this.baseController = baseController;
			
		 }
		
		
		public String toString()
		{
			return "Sphere";
		}
		
		
	}
