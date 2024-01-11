import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MouseEventHandler implements MouseListener
{
	/* 마우스 버튼이 클릭되었을 때(눌렸다 풀렸을 때) 호출됩니다.  */
	public void mouseClicked(MouseEvent e)
	{
		JButton button=(JButton)e.getComponent();
		button.setText("Clicked");
		System.out.println("Clicked Button"+e.getButton());
		System.out.println("마우스 버튼 눌렸다 풀림");
	}
	
	/* 마우스 커서가 버튼 위에 올라가면 호출됩니다. */
	public void mouseEntered(MouseEvent e) 
	{ 
		System.out.println("커서 버튼 위 진입");
	}
	
	/* 마우스 커서가 버튼을 빠져나가면 호출됩니다. */
	public void mouseExited(MouseEvent e) 
	{
		System.out.println("커서 버튼 위 탈출");
	}
	
	/* 마우스 버튼이 눌리는 순간 호출됩니다. */
	public void mousePressed(MouseEvent e) 
	{ 
		System.out.println("마우스 버튼 눌림");		
	}
	
	/* 마우스 버튼이 풀리는 순간 호출됩니다. */
	public void mouseReleased(MouseEvent e) 
	{
		System.out.println("마우스 버튼 풀림");	
	}	
}

class EventHandler
{	
	public static void main(String[] args)
	{
		JFrame frm=new JFrame("First Swing");
		frm.setBounds(120, 120, 400, 100);
		frm.setLayout(new FlowLayout());
		
		JButton btn1=new JButton("My Button");
		MouseListener listener=new MouseEventHandler();
		btn1.addMouseListener(listener);
		
		JButton btn2=new JButton("Your Button");
		btn2.addMouseListener(listener);
		
		JButton btn3=new JButton("Our Button");
		btn3.addMouseListener(listener);		
		
		frm.add(btn1);		
		frm.add(btn2);		
		frm.add(btn3);
		frm.setVisible(true);
	}
}