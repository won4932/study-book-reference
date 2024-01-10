package Chapter25;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MouseEventHandler implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		JButton button = (JButton)e.getComponent();
		button.setText("Clicked");
		System.out.println("Clicked Button"+e.getButton());
		System.out.println("마우스 버튼 눌렸다 풀림");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	
}
class MyJFrame extends JFrame implements MouseListener{

	public MyJFrame(String str) {
		super(str);
		setBounds(120, 120, 400, 100);
		setLayout(new FlowLayout());
		addMouseListener(this);
		JButton btn1 = new JButton("My Button");
		
		MouseListener listener = new MouseEventHandler();
		btn1.addMouseListener(listener);
		JButton btn2 = new JButton("Your Button");
		btn2.addMouseListener(listener);
		
		JButton btn3 = new JButton("Our Button");
		btn3.addMouseListener(listener);
		add(btn1);
		add(btn2);
		add(btn3);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("JFame에서 마우스 버튼 눌렸다 풀림");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
public class Que25_1 {

	public static void main(String[] args) {
		JFrame frm = new MyJFrame("Swing Question");
		frm.setVisible(true);
	}

}
