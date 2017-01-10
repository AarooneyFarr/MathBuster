package math.model;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.*;
import math.controller.MathController;
import math.view.MathPanel;

public class Quadratics extends JPanel 
{

	private MathController baseController;
	private JTextField aField;
	private JTextField bField;
	private JTextField cField;
	private JLabel aLabel;
	private JLabel bLabel;
	private JLabel cLabel;

	
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
		this.setMinimumSize(new Dimension(500,500));
		this.add(aField);
		this.add(bField);
		this.add(cField);
		this.add(aLabel);
		this.add(bLabel);
		this.add(cLabel);


		this.add(quadSolverSelector);
	}
	
	private void setupLayout()
	{
		aField.setBounds(48,64,78,27);
		bField.setBounds(180,64,78,27);
		cField.setBounds(300,64,78,27);
		quadSolverSelector.setBounds(6,6,159,27);
		aLabel.setBounds(26, 64, 30, 27);
		bLabel.setBounds(158, 64, 30, 27);
		cLabel.setBounds(278, 64, 30, 27);

		
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
	
	}
}
