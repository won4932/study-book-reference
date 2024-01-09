import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

class CheckBoxHandler implements ItemListener
{
	JRadioButton btn1;
	JRadioButton btn2;
	JRadioButton btn3;
	
	public CheckBoxHandler(JRadioButton b1, JRadioButton b2, JRadioButton b3)
	{
		btn1=b1;
		btn2=b2;
		btn3=b3;
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getStateChange()==ItemEvent.SELECTED)
		{
			btn1.setEnabled(true);
			btn2.setEnabled(true);
			btn3.setEnabled(true);
		}
		else
		{
			btn1.setEnabled(false);
			btn2.setEnabled(false);
			btn3.setEnabled(false);		
		}
	}
}

class JRadioButtonBorder
{	
	public static void main(String[] args)
	{
		JFrame frm=new JFrame("Border");		
		frm.setBounds(120, 120, 200, 180);
		frm.setLayout(new FlowLayout()); 
		
		JCheckBox checkBox=new JCheckBox("Are you a programmer");
		
		JRadioButton rbtn1= new JRadioButton("I like C");
		JRadioButton rbtn2= new JRadioButton("I like C++");
		JRadioButton rbtn3= new JRadioButton("I like Java", true);
		ButtonGroup bGroup=new ButtonGroup();
		bGroup.add(rbtn1); bGroup.add(rbtn2); bGroup.add(rbtn3);
		
		Border rbtnBorder=BorderFactory.createEtchedBorder();
		rbtnBorder=BorderFactory.createTitledBorder(rbtnBorder, "Language");
		
		JPanel rbtnBorderPanel=new JPanel();
		rbtnBorderPanel.setLayout(new GridLayout(0, 1));
		rbtnBorderPanel.setBorder(rbtnBorder);
		
		rbtnBorderPanel.add(rbtn1);
		rbtnBorderPanel.add(rbtn2);
		rbtnBorderPanel.add(rbtn3);
		
		checkBox.addItemListener(new CheckBoxHandler(rbtn1, rbtn2, rbtn3));
		frm.add(checkBox); frm.add(rbtnBorderPanel);
		
		rbtn1.setEnabled(false);
		rbtn2.setEnabled(false);
		rbtn3.setEnabled(false);
		
		rbtn1.addItemListener(
			new ItemListener() { 
				public void itemStateChanged(ItemEvent e)
				{
					if(e.getStateChange()==ItemEvent.SELECTED)
						System.out.println("I like C too");
				}
			}
		);
		
		rbtn2.addItemListener(
			new ItemListener() { 
				public void itemStateChanged(ItemEvent e)
				{
					if(e.getStateChange()==ItemEvent.SELECTED)
						System.out.println("I like C++ too");
				}
			}
		);
		
		rbtn3.addItemListener(
			new ItemListener() { 
				public void itemStateChanged(ItemEvent e)
				{
					if(e.getStateChange()==ItemEvent.SELECTED)
						System.out.println("I like Java too");
				}
			}
		);
				
		frm.setVisible(true);	
		frm.setDefaultCloseOperation(
				WindowConstants.DISPOSE_ON_CLOSE);
	}
}