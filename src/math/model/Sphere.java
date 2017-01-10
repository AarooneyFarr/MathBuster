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

		
		 public Sphere(MathController baseController)
		 {
			super();
			setBackground(Color.GRAY);

			this.baseController = baseController;
			sphereSolverSelector = new JComboBox<JPanel>(baseController.getMathDex());

			
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

		}
		
		public void setupLayout()
		{
			sphereSolverSelector.setBounds(6,6,159,27);

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
