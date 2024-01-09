import java.awt.*;
import javax.swing.*;

class JLabelView
{	
	public static void main(String[] args) throws Exception
	{
		//UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		//UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticLookAndFeel");
		//UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		//UIManager.setLookAndFeel("com.jgoodies.looks.plastic.PlasticXPLookAndFeel");
		UIManager.setLookAndFeel("net.sourceforge.napkinlaf.NapkinLookAndFeel");
		
		JFrame frm=new JFrame("First Swing");
		frm.setBounds(120, 120, 400, 100);
		frm.setLayout(new FlowLayout());
		
		JLabel label1=new JLabel("첫 번째 버튼 : ");
		JLabel label2=new JLabel("두 번째 버튼 : ");
		
		JButton btm1=new JButton("Button One");
		JButton btm2=new JButton("Button One");
		
		frm.add(label1);		
		frm.add(btm1);		
		frm.add(label2);		
		frm.add(btm2);		
	
		frm.setVisible(true);
	}
}