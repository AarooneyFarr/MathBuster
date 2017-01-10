package math.controller;

import math.view.MathFrame;
import java.util.Vector;
import math.model.*;
import javax.swing.JPanel;

public class MathController {
	
	
	private MathFrame appFrame;
	private Vector<JPanel> mathDex;

	public MathController()
	{
		mathDex = new Vector<JPanel>();
		appFrame = new MathFrame(this);
		
		
	}
	
	public void start()
	{
		buildMathDex();
		
	}
	
	private void buildMathDex()
	{
		Quadratics quad = new Quadratics(this);
		mathDex.add(quad);
		Sphere sphere = new Sphere(this);
		mathDex.add(sphere);
		
	}
	
	public Vector<JPanel> getMathDex()
	{
		return mathDex;
	}
	
	public MathFrame getAppFrame()
	{
		return appFrame;
	}
}
