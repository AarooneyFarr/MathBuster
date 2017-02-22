package math.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import math.controller.MathController;
import math.view.MathPanel;

public class Sphere extends JPanel
	{
		private MathController baseController;
		private JComboBox<JPanel> sphereSolverSelector;
		private JTextField radField;
		private JTextField diaField;
		private JLabel radLabel;
		private JLabel diaLabel;
		private JPanel sphere;
//		private JLabel SALabel;
//		private JTextField SAField;
//		private JLabel volumeLabel;
//		private JTextField volumeField;
//TODO add rest of items, add listeners, and catch exceptions
		double diameter, radius;
		
		public Sphere(MathController baseController)
			{
				super();
				setBackground(Color.GRAY);

				this.baseController = baseController;
				sphereSolverSelector = new JComboBox<JPanel>(baseController.getMathDex());
				radField = new JTextField();
				diaField = new JTextField();
				radLabel = new JLabel("Radius: ");
				diaLabel = new JLabel("Diameter: ");
				sphere = this;
				diameter = 0;
				radius = 0;
				
				setupPanel();
				setupLayout();
				setupListeners();

			}

		public String toString()
			{
				return "Sphere";
			}

		public void setupPanel()
			{
				setLayout(null);
				this.add(sphereSolverSelector);
				this.add(radField);
				this.add(diaField);
				this.add(radLabel);
				this.add(diaLabel);

			}

		public void setupLayout()
			{
				sphereSolverSelector.setBounds(6, 6, 159, 27);
				radField.setBounds(114, 64, 78, 27);
				diaField.setBounds(306, 64, 78, 27);
				radLabel.setBounds(46, 64, 56, 27);
				diaLabel.setBounds(235, 64, 65, 27);
			}

		public void setupListeners()
		{
			sphereSolverSelector.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
						{
							JPanel selected = (JPanel) sphereSolverSelector.getSelectedItem();
							baseController.getAppFrame().setContentPane(selected);
							baseController.getAppFrame().validate();
							
						}

				});
			//TODO fix listeners
			/*radField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
						{
							if (isDouble(radField.getText()) && Double.parseDouble(radField.getText()) != 0)
								{
									diaField.requestFocus();

								}
							else if (isDouble(aField.getText()))
								{
									JOptionPane.showMessageDialog(sphere, "0 is not a valid A value");
								}
						}
				});
			diaField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
						{
							
						}
				}); */
			
		}
		
		private double get2DArea(double radius)
		{
			double answer = Math.PI * Math.pow(radius, 2);
			return answer;
		}
		
		private double getVolume(double radius)
		{
			double answer = (4/3) * Math.PI * Math.pow(radius,  3);
			return answer;
		}
		
		private double getSurfaceArea(double radius)
		{
			double answer = 4 * Math.PI * Math.pow(radius, 2);
			return answer;
		}
		
		private double getRadius(double surfaceArea)
		{
			double answer = (1/2) * Math.sqrt(surfaceArea/Math.PI);
			return answer;
		}
		
		private double getCircumference(double radius)
		{
			double answer = 2 * Math.PI * radius;
			return answer;
		}
		
		private double getRadiusWithVolume(double volume)
		{
			double answer = Math.pow(((volume/Math.PI)* (3/4)), (1/3));
			return answer;
		}
		
		//TODO change algorithm to match
		/*
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
		*/
		
	}
