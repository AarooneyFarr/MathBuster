package math.model;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import math.controller.MathController;
import math.view.MathPanel;

public class Sphere extends JPanel
	{
		private MathController baseController;
		private JComboBox<JPanel> sphereSolverSelector;
		private JTextField radText;
		private JTextField diaText;
		private JLabel radLabel;
		private JLabel diaLabel;
//		private JLabel SALabel;
//		private JTextField SAField;
//		private JLabel volumeLabel;
//		private JTextField volumeField;
//TODO add rest of items, add listeners, and catch exceptions
		
		public Sphere(MathController baseController)
			{
				super();
				setBackground(Color.GRAY);

				this.baseController = baseController;
				sphereSolverSelector = new JComboBox<JPanel>(baseController.getMathDex());
				radText = new JTextField();
				diaText = new JTextField();
				radLabel = new JLabel("Radius: ");
				diaLabel = new JLabel("Diameter: ");

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
				this.add(radText);
				this.add(diaText);
				this.add(radLabel);
				this.add(diaLabel);

			}

		public void setupLayout()
			{
				sphereSolverSelector.setBounds(6, 6, 159, 27);
				radText.setBounds(114, 64, 78, 27);
				diaText.setBounds(306, 64, 78, 27);
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
			radText.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
						{
							
						}
				});
			diaText.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
						{
							
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
		
		
		
		
	}
