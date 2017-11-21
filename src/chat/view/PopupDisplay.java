package chat.view;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class PopupDisplay
{

	private ImageIcon icon;
	private String windowTitle;
	
	public PopupDisplay()
	{
		icon = new ImageIcon (getClass().getResource("images/huskay.png"));
		windowTitle = "Chatbot says";
	}
	
	public void displayText(String message)
	{ 
		JOptionPane.showInputDialog(null, message, windowTitle,JOptionPane.INFORMATION_MESSAGE, icon, null, "");
	}
	

	public String getResponse(String question)
	{
		String answer ="";
	
		answer += JOptionPane.showInputDialog(null, question, windowTitle, JOptionPane.PLAIN_MESSAGE, icon, null, "");
		
		return answer;
		
	} 
}
