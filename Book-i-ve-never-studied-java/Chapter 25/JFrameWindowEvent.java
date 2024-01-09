import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class WindowEventHandler implements WindowListener
{
	String frameInfo;
	
	public WindowEventHandler(String info)
	{
		frameInfo=info;
	}	
	public void windowActivated(WindowEvent e)
	{
		System.out.println(frameInfo+" windowActivated");
	}	
	public void windowClosed(WindowEvent e)
	{
		System.out.println(frameInfo+" windowClosed");
	}	
	public void windowClosing(WindowEvent e)
	{
		JFrame frm=(JFrame)e.getWindow();
		frm.dispose();
		System.out.println(frameInfo+" windowClosing");
	}	
	public void windowDeactivated(WindowEvent e)
	{
		System.out.println(frameInfo+" windowDeactivated");	
	}	
	public void windowDeiconified(WindowEvent e)
	{
		System.out.println(frameInfo+" windowDeiconified");		
	}	
	public void windowIconified(WindowEvent e)
	{
		System.out.println(frameInfo+" windowIconified");		
	}	
	public void windowOpened(WindowEvent e)
	{
		System.out.println(frameInfo+" windowOpened");		
	} 
}

class JFrameWindowEvent
{	
	public static void main(String[] args)
	{
		JFrame frmOne=new JFrame("Frame One");
		JFrame frmTwo=new JFrame("Frame Two");
		
		frmOne.setBounds(120, 120, 250, 150);		
		frmTwo.setBounds(380, 120, 250, 150);
	
		frmOne.addWindowListener(new WindowEventHandler("Frame One"));
		frmTwo.addWindowListener(new WindowEventHandler("Frame Two"));
	
		frmOne.add(new JButton("Button One"));
		frmTwo.add(new JButton("Button Two"));
	
		frmOne.setVisible(true);
		frmTwo.setVisible(true);
	}
}