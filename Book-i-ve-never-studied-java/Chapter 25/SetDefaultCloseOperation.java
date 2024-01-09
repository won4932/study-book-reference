import javax.swing.*;

class SetDefaultCloseOperation
{	
	public static void main(String[] args) throws Exception
	{
		JFrame frmOne=new JFrame("Frame One");
		JFrame frmTwo=new JFrame("Frame Two");
		
		frmOne.setBounds(120, 120, 250, 150);		
		frmTwo.setBounds(380, 120, 250, 150);
	
		frmOne.add(new JButton("Button One"));
		frmTwo.add(new JButton("Button Two"));
	
		frmOne.setDefaultCloseOperation(
				WindowConstants.DISPOSE_ON_CLOSE);
		frmTwo.setDefaultCloseOperation(
				WindowConstants.DISPOSE_ON_CLOSE);

		frmOne.setVisible(true);
		frmTwo.setVisible(true);
	}
}