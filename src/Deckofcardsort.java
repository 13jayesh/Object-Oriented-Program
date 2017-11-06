
public class Deckofcardsort {

		public static void main(String[] args) {
			int noOfPlayers = 4;
			int noOfCards = 9;
			String[] deckOfCards = JSONlogic.assignDeckOfCards();
			String[] deckOfShuffleCards = JSONlogic.shuffle(deckOfCards);
			String[][] playerCards = JSONlogic.distribute(noOfPlayers, noOfCards,deckOfShuffleCards);
			System.out.println("Cards before sorting...");
			System.out.println();
			JSONlogic.printDistibutedCards(playerCards, noOfPlayers, noOfCards);
			System.out.println("Cards after sorting...");
			JSONlogic.printSortedCards(playerCards,noOfPlayers,noOfCards);
		}

	}
