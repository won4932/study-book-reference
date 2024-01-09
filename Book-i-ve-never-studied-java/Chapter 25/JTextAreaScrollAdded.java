import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ButtonTextHandler implements ActionListener
{
	JTextArea textArea;
	
	public ButtonTextHandler(JTextArea area)
	{
		textArea=area;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		textArea.setText("모두 지웠습니다. \n");
		textArea.append("원하는 내용 입력하세요. \n");
	}
}

class JTextAreaScrollAdded
{	
	public static void main(String[] args)
	{
		JFrame frm=new JFrame("JTextArea");		
		frm.setBounds(120, 120, 250, 270);
		frm.setLayout(new FlowLayout());
	
		JTextArea textArea=new JTextArea(10, 20);
		textArea.append("원하는 내용 입력하세요. \n");
		textArea.setCaretPosition(textArea.getText().length());
		
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JButton btn=new JButton("Clear");
		btn.addActionListener(new ButtonTextHandler(textArea));

		JScrollPane simpleScroll=new JScrollPane(textArea);
		frm.add(simpleScroll); frm.add(btn);
		
		frm.setVisible(true);	
		frm.setDefaultCloseOperation(
				WindowConstants.DISPOSE_ON_CLOSE);
	}
}