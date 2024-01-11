import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class MouseEventHandler implements MouseListener
{
	public void mouseClicked(MouseEvent e)
	{
		System.out.println("마우스 버튼 눌렸다 풀림");
	}
	
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }	
}

class JButtonMouseEvent
{	
	public static void main(String[] args)
	{
		JFrame frm=new JFrame("JButton Disable");
		frm.setBounds(120, 120, 250, 150);
		frm.setLayout(new FlowLayout());
		
		MouseListener mouseHandler=new MouseEventHandler();
	
		JButton btn1=new JButton("Button One");
		btn1.addMouseListener(mouseHandler);
		JButton btn2=new JButton("Button Two");
		btn2.addMouseListener(mouseHandler);
		
		frm.add(btn1);
		frm.add(btn2);
		btn1.setEnabled(false);
	
		frm.setVisible(true);
	}
}