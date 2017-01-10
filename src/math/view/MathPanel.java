package math.view;

import math.controller.MathController;
import math.model.MathSolver;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import math.model.*;

public class MathPanel extends JPanel
{
	private MathController baseController;
	private JComboBox<JPanel> solverSelector;
	JPanel cards;
	
	public MathPanel(MathController baseController)
	{
		super();
		setBackground(Color.BLUE);
		this.baseController = baseController;
		solverSelector = new JComboBox<JPanel>(baseController.getMathDex());
		
		
		
		
		setupPanel();
		
		setupLayout();
		setupListeners();
		setupPopupMenu();
		
		
	}
	
	private void setupPanel()
	{
		setLayout(null);
		this.add(solverSelector);
	}
	
	private void setupPopupMenu()
	{
		
	}
	
	private void setupLayout()
	{
		solverSelector.setBounds(6,6,159,27);
	}
	
	private void setupListeners()
	{
		solverSelector.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						JPanel selected = (JPanel) solverSelector.getSelectedItem();
						baseController.getAppFrame().setContentPane(selected);
						baseController.getAppFrame().validate();
						
					}
				});
	}
	
	
	
}
