package math.model;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.*;
import math.controller.MathController;
import math.view.MathPanel;
import java.util.Vector;
import java.math.*;
import java.awt.*;

// Naming convention: should probably be named QuadraticsPanel or something like that.
// Also this should be in the view package not the model.
public class Quadratics extends JPanel
	{

		private MathController baseController;
		private JTextField aField;
		private JTextField bField;
		private JTextField cField;
		private JLabel aLabel;
		private JLabel bLabel;
		private JLabel cLabel;
		private JLabel xIntLabel;
		private JLabel disLabel;
		private JButton enterButton;
		private JPanel quad;
		double A, B, C, x, Y;

		private JComboBox<JPanel> quadSolverSelector;

		public Quadratics(MathController baseController)
			{
				super();
				setBackground(Color.GRAY);

				this.baseController = baseController;
				quadSolverSelector = new JComboBox<JPanel>(baseController.getMathDex());

				aField = new JTextField();
				bField = new JTextField();
				cField = new JTextField();
				aLabel = new JLabel("A: ");
				bLabel = new JLabel("B: ");
				cLabel = new JLabel("C: ");
				xIntLabel = new JLabel("The X-Intercepts are: ");
				disLabel = new JLabel("The Discriminant is: ");
				enterButton = new JButton("Enter");
				quad = this;

				A = 0;
				B = 0;
				C = 0;
				x = 0;
				Y = 0;
				
				
				setupPanel();

				setupLayout();
				setupListeners();

			}
		
		

 		public String toString()
			{
				return "Quadratics";
			}

		private void setupPanel()
			{
				setLayout(null);
				this.setMinimumSize(new Dimension(500, 500));
				this.add(aField);
				this.add(bField);
				this.add(cField);
				this.add(aLabel);
				this.add(bLabel);
				this.add(cLabel);
				this.add(xIntLabel);
				this.add(disLabel);
				this.add(enterButton);
				this.add(quadSolverSelector);
			}

		private void setupLayout()
			{
				aField.setBounds(66, 64, 78, 27);
				bField.setBounds(210, 64, 78, 27);
				cField.setBounds(354, 64, 78, 27);
				quadSolverSelector.setBounds(6, 6, 159, 27);
				aLabel.setBounds(46, 64, 30, 27);
				bLabel.setBounds(190, 64, 30, 27);
				cLabel.setBounds(334, 64, 30, 27);
				xIntLabel.setBounds(6, 103, 488, 27);
				disLabel.setBounds(6, 133, 488, 27);
				enterButton.setBounds(211, 455, 78, 27);
				

			}

		private void setupListeners()
			{
				quadSolverSelector.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
							{
								JPanel selected = (JPanel) quadSolverSelector.getSelectedItem();
								baseController.getAppFrame().setContentPane(selected);
								baseController.getAppFrame().validate();

							}

					});

				aField.addActionListener(new ActionListener()
					{

						public void actionPerformed(ActionEvent e)
							{
								if (isDouble(aField.getText()) && Double.parseDouble(aField.getText()) != 0)
									{
										bField.requestFocus();

									}
								else if (isDouble(aField.getText()))
									{
										JOptionPane.showMessageDialog(quad, "0 is not a valid A value");
									}
							}
					});

				bField.addActionListener(new ActionListener()
					{

						public void actionPerformed(ActionEvent e)
							{
								if (isDouble(bField.getText()))
									{
										cField.requestFocus();

									}
							}
					});

				cField.addActionListener(new ActionListener()
					{

						public void actionPerformed(ActionEvent e)
							{
								if (isDouble(cField.getText()))
									{
										try
										{
											
										    	 A = Double.parseDouble(aField.getText());
										    	 B = Double.parseDouble(bField.getText());
										    	 C = Double.parseDouble(cField.getText());
										    	
											
										xIntLabel.setText("The X-Intercepts are: "
												+ round(getXIntercepts(Integer.parseInt(aField.getText()), Integer.parseInt(bField.getText()), Integer.parseInt(cField.getText())).get(0), 4) + ", "
												+ round(getXIntercepts(Integer.parseInt(aField.getText()), Integer.parseInt(bField.getText()), Integer.parseInt(cField.getText())).get(1), 4));
										disLabel.setText("The Discriminant is: " + round(getDiscriminant(Integer.parseInt(aField.getText()), Integer.parseInt(bField.getText()), Integer.parseInt(cField.getText())), 4));
										}
										catch(NumberFormatException error)
										{
											JOptionPane.showMessageDialog(quad, "The X-intercepts are not real.");	
										}
										
										repaint();
									}
							}
					});

				enterButton.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							if (isDouble(aField.getText()) && Double.parseDouble(aField.getText()) != 0 && isDouble(bField.getText()) && isDouble(cField.getText()))
								{
									xIntLabel.setText("The X-Intercepts are: "
											+ round(getXIntercepts(Integer.parseInt(aField.getText()), Integer.parseInt(bField.getText()), Integer.parseInt(cField.getText())).get(0), 4) + ", "
											+ round(getXIntercepts(Integer.parseInt(aField.getText()), Integer.parseInt(bField.getText()), Integer.parseInt(cField.getText())).get(1), 4));
									disLabel.setText("The Discriminant is: " + round(getDiscriminant(Integer.parseInt(aField.getText()), Integer.parseInt(bField.getText()), Integer.parseInt(cField.getText())), 4));
									repaint();
								}
							else if (isDouble(aField.getText()))
								{
									JOptionPane.showMessageDialog(quad, "0 is not a valid A value");
								}
						}
					});

			}

		
		public Vector<Double> getXIntercepts(double a, double b, double c)
			{
				Vector<Double> xInt = new Vector<Double>();

				double xIntOne = (-b + Math.sqrt((Math.pow(b, 2)) - ((4) * (a) * (c)))) / (2 * a);
				double xIntTwo = (-b + Math.sqrt((Math.pow(b, 2)) - ((4) * (a) * (c)))) / (2 * a);

				// if (xIntOne == Double.NaN)

				xInt.add(xIntOne);
				xInt.add(xIntTwo);
				return xInt;
			}
		
		
		public double getDiscriminant(double a, double b, double c)
			{
				double dis = Math.pow(b, 2) - (4 * a * c);

				return dis;
			}

		private boolean isDouble(String input)
			{
				Boolean isDouble = false;
				try
					{
						Double.parseDouble(input);
						isDouble = true;
					}
				catch (NumberFormatException error)
					{
						JOptionPane.showMessageDialog(this, "Please type in a valid number.");
					}
				return isDouble;
			}

		public static double round(double value, int places)
			{
				if (places < 0)
					throw new IllegalArgumentException();

				BigDecimal bd = new BigDecimal(value);
				bd = bd.setScale(places, RoundingMode.HALF_UP);
				return bd.doubleValue();
			}
		
		private double getYValue(double a, double b, double c, double x)
		{
			double yValue = (a * Math.pow(x, 2)) + b*x + c;
			return yValue;
		}
		
		public void paintComponent(Graphics page)
			   {  

			     super.paintComponent (page);

			     for ( x=-50; x <= 50; x+= 0.1 )
			     {
			    	
			    	 
			    	 
			         Y = (A*(Math.pow(x,2)))+(B*x)+(C);
			         int g = (int)Math.round(x);
			         int h = (int)Math.round(Y);
			         page.setColor (Color.black);
			          page.fillOval (g + 250, h + 250, 4, 4);
			      }


			    }
	}
