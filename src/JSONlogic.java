import javax.rmi.CORBA.Util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONlogic 
{
	static QueueLinkedList queue = new QueueLinkedList();
	/*
	 * assigning cards
	 */
	public static  String[] assignDeckOfCards() {
		
		String[] suit = { "Club", "Diamond", "Heart", "Spade" };
		String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		String[] deckOfCards = new String[52];
		int position = 0;
		for (int i = 0; i < suit.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				deckOfCards[position++] = suit[i] + " " + rank[j];
			}
		}
		return deckOfCards;	
	}

	
	/*
	 * shuffling cards
	 */
	public static String[] shuffle(String[] deckOfCards) {
		int length = deckOfCards.length;
		for (int i = 0; i < length; i++) {
			int random = (int) (Math.random() * (52));
			String temp = deckOfCards[i];
			deckOfCards[i] = deckOfCards[random];
			deckOfCards[random] = temp;
		}	
		return deckOfCards;
	}
	
	/*
	 * this method is for distributing cards to the players
	 */
	public static String[][] distribute(int noOfPlayers, int noOfCards,String[] deckOfShuffleCards) {
		int position = 0;
		String[][] distributedCards = new String[noOfPlayers][noOfCards];
		for (int i = 0; i < noOfPlayers; i++) {
			for (int j = 0; j < noOfCards; j++) {
				distributedCards[i][j] = deckOfShuffleCards[position++];
			}
		}
		return distributedCards;
	}

	
	/*
	 * method for printing distributed cards
	 */
	public static void printDistibutedCards(String[][] cardsOfPlayers, int noOfPlayers, int noOfCards) {
		for (int i = 0; i < noOfPlayers; i++) {
			System.out.println("Cards of player " + (i + 1) + " are");
			for (int j = 0; j < noOfCards; j++) {
				System.out.println(cardsOfPlayers[i][j]);
			}
			System.out.println();
		}
	}

	/*
	 * 
	 */
	public static void printSortedCards(String[][] playerCards, int noOfPlayers, int noOfCards) {
		String[] cards = new String[noOfCards];
		for (int i = 0; i < noOfPlayers; i++) {
			for (int j = 0; j < noOfCards; j++) {
				cards[j] = playerCards[i][j];
			}
			queue.enQueue("Cards Of Player " + (i + 1) + " are as follows..");
			sort(cards);
		}
		printSortedCardQueue();
	}
	
	/*
	 * method for sorting cards on the basis of ranks
	 */
	private static <queue> void sort(String[] cards) {
		char[] rank = { 'A', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'J', 'Q', 'K' };
		for (int i = 0; i < rank.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				String card = cards[j];
				char cardRank = card.charAt(card.length() - 1);
				if (cardRank == rank[i])
					queue.enQueue(card);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * method for printing sorted card queue
	 */
	private static void printSortedCardQueue() {
		for (int i = 0; i < queue.size(); i++) {
			if (i % 10 == 0)
				System.out.println();
			System.out.println(queue.deQueue());

		}
}

}
