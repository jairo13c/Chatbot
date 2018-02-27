package chat.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import chat.controller.ChatbotController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;


public class ChatPanel extends JPanel
{
	private ChatbotController appController;
	private JButton chatButton;
	private JTextField inputField;
	private JTextArea chatArea;
	private SpringLayout appLayout;
	private JButton checkerButton;
	private JLabel infoLabel;
	private JScrollPane chatScrollPane;
	
	public ChatPanel(ChatbotController appController)
	{
		super();
		this.appController = appController;
		chatButton = new JButton("chat");
		chatArea = new JTextArea(10,25);
		inputField = new JTextField(20);
		infoLabel = new JLabel("type to chat ith the chatbot");
		appLayout = new SpringLayout();
		chatScrollPane = new JScrollPane();
		checkerButton = new JButton("check contains");
		
		
		seetupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void seetupScrollPane()
	{
		chatScrollPane.setViewportView(chatArea);
		chatScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		chatArea.setLineWrap(true);;
		chatArea.setWrapStyleWord(true); 
	}
	private void setupPanel()
	{
		this.setBackground(Color.blue);
		this.setLayout(appLayout);
		this.add(chatButton);
		this.add(inputField);
		this.add(chatScrollPane);
		this.add(infoLabel);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
	}
	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.NORTH, inputField, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, inputField, 29, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, -27, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, -38, SpringLayout.EAST, this);
		
	}
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String displayText = appController.interactWithChatbot(userText);
				chatArea.append(displayText);
				inputField.setText("");
			}
		});
		
		checkerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userText = inputField.getText();
				String dispayText = appController.useCheckers(userText);
				chatArea.append(dispayText);
				inputField.setText("");
			}
			});
		
	}
}
