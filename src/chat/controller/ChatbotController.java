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
		
		String results = IOController.loadFromFile(this, "commonWords.txt");
		IOController.saveToFile(this, results,  "save results.txt");
		
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
	
	public String useCheckers(String text)
	{
		String response = "";
		
		if(chatbot.contentChecker(text))
		{
			response += "this text matches the special content\n";
		}
		if(chatbot.cuteAnimalMemeChecker(text))
		{
			response +="";
			//continue with all checkers except length and quit checker
			
		}
		return response;
	}
	private void close()
	{
		display.displayText("Godbye");
		System.exit(0);
	}

	private String popupChat(String chat)

	{
		String chatbotSays = ""; //Assigns a valid value to a variable that will be return for the method.
		chatbotSays += chatbot.processConversation(chat);

		return chatbotSays;
	}
	public Chatbot getChatbot()
	{
		return chatbot;
	}
	public PopupDisplay getDisplay() 
	{
		return display;
	}
	public ChatFrame getChatFrame()
	{
		return appFrame;
	}
	public void handleErrors(Exception error)
	{
		display.displayText(error.getMessage());
	}
	
	
}
