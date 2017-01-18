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
			sphereSolverSelector.setBounds(6,6,159,27);
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
		}
	}
