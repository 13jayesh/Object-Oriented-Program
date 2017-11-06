public class DeckOfCards 
{
		static JSONlogic object = new JSONlogic();
		public static void main(String[] args) {
			int noOfPlayers = 4;
			int noOfCards = 9;
		    String[] deckOfCards = object.assignDeckOfCards();
		    String[] deckOfShuffledCards = object.shuffle(deckOfCards);
		    String[][] playerCards = object.distribute(noOfPlayers,noOfCards,deckOfShuffledCards);
		    JSONlogic.printDistibutedCards(playerCards,noOfPlayers,noOfCards);
	}
	}

