package chat.controller;

import chat.model.Chatbot;
import chat.view.PopupDisplay;
import chat.view.ChatFrame;

public class ChatbotController
{ 
	private Chatbot chatbot;
	private PopupDisplay display;
	private ChatFrame appFrame;
	
	public ChatbotController()
	{
		chatbot = new Chatbot("jairo");
		display = new PopupDisplay();    
		appFrame = new ChatFrame(this);
	}
	
	public void start()//start program
	{
		
		display.displayText("welcome to Chatbot"); 
		
	}
	public String interactWithChatbot(String input)
	{
		String chatbotSays = "";
		
		if(chatbot.quitChecker(input))
		{
			close();
		}
		
		chatbotSays += chatbot.processConversation(input);
		
		return chatbotSays;
		
	}
	private void close()
	{
		display.displayText("Godbye");
		System.exit(0);
	}

	private String popupChat(String chat)

	{
		String chatbotSays = ""; //Assigns a valid value to a variable that will be rern for the method.
		chatbotSays += chatbot.processConversation(chat);

		return chatbotSays;
	}
	public Chatbot getChatbot()
	{
		return chatbot;
	}
	//public PopupDisplay getDisplay() 
	//{
		
	//}
	//public ChatFrame getChatFrame()
	//{
		
	//}
	
	
}
