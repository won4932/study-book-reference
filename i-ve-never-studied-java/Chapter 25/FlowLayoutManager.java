import java.awt.*;
import javax.swing.*;

class FlowLayoutManager
{
	public static void main(String[] args)
	{
		JFrame frm=new JFrame("FlowLayout Test");
		frm.setBounds(120, 120, 400, 200);
		frm.setLayout(new FlowLayout());
		
		frm.add(new JButton("Hi!"));
		frm.add(new JButton("I like Swing"));
		frm.add(new JButton("I am a button"));
		
		frm.add(new LargeButton("Hi!"));
		frm.add(new LargeButton("I like Swing"));
		frm.add(new LargeButton("I am a button"));
			
		frm.setVisible(true);
	}
}

class LargeButton extends JButton
{
	public LargeButton(String str)
	{
		super(str);
	}
	
	public Dimension getPreferredSize()
	{
		Dimension largeBtmSz
		    =new Dimension(
		    		super.getPreferredSize().width+30, 
		    		super.getPreferredSize().height+15
		    	);
		
		return largeBtmSz;
	}
}