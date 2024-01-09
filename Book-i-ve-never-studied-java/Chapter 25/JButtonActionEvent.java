import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ActionEventHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{		
		System.out.println(e.getActionCommand());
	}
}

class JButtonActionEvent
{	
	public static void main(String[] args)
	{
		JFrame frm=new JFrame("JButton Disable");
		frm.setBounds(120, 120, 250, 150);
		frm.setLayout(new FlowLayout());
		
		JButton btn1=new JButton("Button One");
		JButton btn2=new JButton("Button Two");
		
		ActionListener actionHandler=new ActionEventHandler();
	
		btn1.addActionListener(actionHandler);
		btn2.addActionListener(actionHandler);
		
		frm.add(btn1);
		frm.add(btn2);
		btn1.setEnabled(false);
	
		frm.setVisible(true);
	}
}