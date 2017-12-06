package chat.model;

import java.util.List;
import java.time.LocalTime;
import java.util.ArrayList;

public class Chatbot
{
	private ArrayList<Movie> movieList;
	private List<String> shoppingList;
	private List<String> cuteAnimalMemes;
	private String [] verbs;
	private String [] topics;
	private String [] followUps;
	private String [] questions;
	private String username;
	private String content;
	private String intro;
	private LocalTime currentTime;
	
	public Chatbot(String username)
	{
		this.movieList = new ArrayList<Movie>();
		this.shoppingList = new ArrayList<String>(); 
		this.cuteAnimalMemes = new ArrayList<String>(); 
		this.username = username;
		this.content = content;
		this.intro = "intro";
		this.currentTime = LocalTime.now();
		this.topics = new String [7];
		this.verbs = new String [3];
		this.followUps = new String [5];
		this.questions = new String [10];

		buildShoppingList();
		buildMovieList();
		buildQuestions();
		buildCuteAnimals();
		topics();
		followUps();
		buildVerbs();
		getIntro();
		getCurrentTime();
		getUsername();
		getContent();
		
	}
	private void buildVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "run";
		
	}

	private void buildMovieList()
	{
		
	}
	private void topics()
	{
		topics[0] = "food";
		topics[1] = "sports";
		topics[2] = "movies";
		topics[3] = "tv series";
		topics[4] = "cars";
		topics[5] = "phones";
		topics[6] = "music";
		
		
	}
	private void followUps()
	{
		
	}

	private void buildShoppingList()
	{
		shoppingList.add("snacks");
		shoppingList.add("veggies");
		shoppingList.add("protein");
		shoppingList.add("frut");
		shoppingList.add("gross things");
	}
	
	private void buildCuteAnimals()
	{
		cuteAnimalMemes.add("cat");
		cuteAnimalMemes.add("dog");
		cuteAnimalMemes.add("bird");
	}
	
	private void buildQuestions()
	{
		questions[0] = "whats your name?";
		questions[1] = "how are you?";
		questions[2] = "what is your favorite movie?";
		questions[3] = "where do you live?";
		questions[4] = "how old are you?";
		questions[5] = "what music do you listen to?";
		questions[6] = "what is your favorite color?";
		questions[7] = "	what is your favorite food?";
		questions[8] = "what are your hobbies?";
		questions[9] = "what are your interests?";
		
	}
	/**
	 * build a response a based on the users input and the reated chatbot response.
	 * @param input the users text as a String.
	 * @return the chatbot. 
	 */

	
	public String processConversation(String input)
	{
		String chatbotResponse = "";
		currentTime = LocalTime.now();
		chatbotResponse += currentTime.getHour() + ":" + currentTime.getMinute() + "";
		chatbotResponse += "you said:" + "\n" + input + "\n";
		
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	
	public boolean lengthChecker(String input)
	{
		boolean validLength = false;
		
		if(input != null && input.length() > 2)
		{
			validLength = true;
		}
			
		return validLength;
	}
	
	public boolean inputHTMLChecker(String input) 
	{
		boolean containsHTML = false;
		if(input == null || !input.contains("<"))
		{
			return containsHTML;
		}
		int firstOpen = input.indexOf("<");
		int firstClose = input.indexOf(">",firstOpen);
		int secondOpen = -9;
		int secondClos = -9;
		String tagText = "" ;
	 
		//check bad tags
		if(input.contains("<>") || input.indexOf("<>") > -1)
		{
			containsHTML = false;
		}
		//check singleton
		if(input.toUpperCase().contains("<P>") || input.toLowerCase().contains("<br"))
		{
			containsHTML = true;
		}
		//check others
		else  if(firstClose > firstOpen)
		{
			//others
			tagText = input.substring(firstOpen + 1, firstClose).toLowerCase();
			secondOpen = input.toLowerCase().indexOf("</" + tagText, firstClose);
			
		}
		return containsHTML;
	}
		 
	
	
	public boolean userNameChecker(String input)
	{
		return false;
	}
	
	public boolean contentChecker(String contentCheck)
	{
		return false;
	}
	
	public boolean cuteAnimalMemeChecker(String input)
	{
		return false;
	}
	
	public boolean shoppingListChecker(String shoppingItem)
	{
		return false;
	}
	
	public boolean movieTitleChecker(String title)
	{
		return false;
	}
	
	public boolean movieGenreChecker(String genre)
	{
		return false;
	}

	public boolean quitChecker(String exitString)
	{
		if (exitString.equalsIgnoreCase("quit"))
		{
			return true;
		}
	
	
		return false;
	}

	public boolean keyboardMashChecker(String sample)
	{
		return false;
	}
	
	public List<Movie> getMovieList()
	{
		return movieList;
	}
	
	public List<String> getShoppingList()
	{
		return shoppingList;
	}
	
	public List<String> getCuteAnimalMemes()
	{
		return cuteAnimalMemes;
	}

	public String [] getQuestions()
	{
		this.questions[0] = "where is the best place to go?";	
		this.questions[1] = "whats your name?";
		this.questions[2] = "how are you?";
		this.questions[3] = "what is your favorite movie?";
		this.questions[4] = "where do you live?";
		this.questions[5] = "how old are you?";
		this.questions[6] = "what is your favorite color?";
		this.questions[7] = "what is your favorite food?";
		this.questions[8] = "what are your hobbies?";
		this.questions[9] = "what are your interests?";
		
		
		return questions;
	}
	
	/**
	 *  get a response base on input.
	 * @param colects user a set input
	 * @return come or go back to a chatbot or user
	 */
	public String prossesConversation(String input)
	{
		String chatbotResponse = "";
		chatbotResponse += "you said " + "\n" + input +" \n";
			
		chatbotResponse += buildChatbotResponse();
		
		return chatbotResponse;
	}
	/**
	 * random selects to put a answer
	 * @return return the answer random selected
	 */
	private String buildChatbotResponse()
	{
		String response = " I";
		int random = (int) (Math.random() * verbs.length);
		
		response += verbs [random];
		
		random = (int) (Math.random() * topics.length);
		response += "" + topics [random] + ".\n";
		
		random = (int) (Math.random() * questions.length);
		response += questions[random];
		random= (int) (Math.random() * 2);
		
		if(random % 2 == 0)
		{
			random = (int) ( Math.random() * movieList.size());
			response += "/n" + movieList.get(random).getTitle() + " is a great movie! " ;
		}
			int  followUp = (int) (Math.random() * 5);
			
			switch (followUp)
			{
			case 0:
				response += followUps[0] + "\n";
				break;
			case 3:
				response += followUps[1] +  "\n";
			case 1:
				response += followUps[2] +  "\n";
				break;
			default:
				response += followUps[4] + "\n";
				response += followUps[3] + "\n";
				break;
			}
		
		return response;
	}
	
	public String[] getVerbs()
	{
		verbs[0] = "like";
		verbs[1] = "dislike";
		verbs[2] = "run";
		
		
		return verbs;
	}

	public String[] getTopics()
	{
		topics[0] = "food";
		topics[1] = "sports";
		topics[2] = "movies";
		topics[3] = "tv series";
		topics[4] = "cars";
		topics[5] = "phones";
		topics[6] = "music";
		
		
		return topics;
	}

	public String[] getFollowUps()
	{
		return followUps;
	}

	public String getUsername()
	{
		return username;
	}
	
	public String getContent()
	{
		return content;
	}

	public String getIntro()
	{
		return getIntro();
	}
	
	public LocalTime getCurrentTime()
	{
		return getCurrentTime();
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setContent(String content)
	{
		this.content = content;
	}
}
