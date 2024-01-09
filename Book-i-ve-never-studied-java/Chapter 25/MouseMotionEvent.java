import javax.swing.*;
import java.awt.event.*;

class MouseMotionHandler implements MouseMotionListener
{
	public void mouseDragged(MouseEvent e)
	{
		System.out.printf("Drag [%d %d] \n", e.getX(), e.getY());
	}
	
	public void mouseMoved(MouseEvent e)
	{
		System.out.printf("Move [%d %d] \n", e.getX(), e.getY());
	}
}

class MouseMotionEvent
{	
	public static void main(String[] args) throws Exception
	{
		JFrame frm=new JFrame("Mouse Motion");		
		frm.setBounds(120, 120, 250, 150);		
		frm.addMouseMotionListener(new MouseMotionHandler());
		
		frm.setVisible(true);	
		frm.setDefaultCloseOperation(
				WindowConstants.DISPOSE_ON_CLOSE);
	}
}