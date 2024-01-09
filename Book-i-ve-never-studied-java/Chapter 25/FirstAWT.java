import java.awt.*;

class FirstAWT
{	
	public static void main(String[] args)
	{
		Frame frm=new Frame("First Swing");
		frm.setBounds(120, 120, 400, 100);
		frm.setLayout(new FlowLayout());
		
		Button btn1=new Button("My Button");
		Button btn2=new Button("Your Button");
		Button btn3=new Button("Our Button");
		
		frm.add(btn1);		
		frm.add(btn2);		
		frm.add(btn3);
		frm.setVisible(true);
	}
}