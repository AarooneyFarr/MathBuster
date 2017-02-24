package math.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BasicStroke;
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
		private JLabel radiusNumberLabel;
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
				radiusNumberLabel = new JLabel("");
				
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
				this.add(radiusNumberLabel);
				
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
			
			radField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
						{
							if (isDouble(radField.getText()) && Double.parseDouble(radField.getText()) != 0)
								{
									radius = Integer.parseInt(radField.getText());
									diaField.setText((int) getCircumference(Double.parseDouble(radField.getText())) + "");
									radiusNumberLabel.setBounds((250 + ((int) Double.parseDouble(radField.getText()))/2)-15, 195, 27, 92);
									radiusNumberLabel.setText((int) Double.parseDouble(radField.getText()) + "");
									repaint();

								}
							else if (isDouble(radField.getText()))
								{
									JOptionPane.showMessageDialog(sphere, "0 is not a valid radius");
								}
						}
				});
			diaField.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
						{
							if (isDouble(diaField.getText()) && Double.parseDouble(diaField.getText()) != 0)
								{
									radius = getRadiusWithCircumference(Double.parseDouble(diaField.getText()));
									radField.setText((int) getRadiusWithCircumference(Double.parseDouble(diaField.getText())) + "");
									radiusNumberLabel.setBounds((250 + ((int) radius/2))-15, 195, 27, 92);
									radiusNumberLabel.setText((int) radius + "");
									repaint();

								}
							else if (isDouble(diaField.getText()))
								{
									JOptionPane.showMessageDialog(sphere, "0 is not a valid radius");
								}
						}
				}); 
			
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
		
		private double getRadiusWithCircumference(double circumference)
		{
			double answer = circumference/(2*Math.PI);
			return answer;
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
		
		
		
		public void paintComponent(Graphics page)
			   {  
				   Graphics2D g2 = (Graphics2D) page;
			     super.paintComponent (page);

			     	BasicStroke dashed = new BasicStroke(3);
			    	 
			    	 
			         
			        
			         page.setColor (Color.black);
			         g2.setStroke(dashed);
			         page.drawOval(250 - (int)radius , 250 - (int) radius ,(int) radius * 2, (int) radius * 2);
			         page.drawLine(250,250,249 + (int) radius, 250);

			    }
		
		
	}
