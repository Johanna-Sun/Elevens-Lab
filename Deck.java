import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class Deck {

	/**
	 * cards contains all the cards in the deck.
	 */
	private List<Card> cards;

	/**
	 * size is the number of not-yet-dealt cards.
	 * Cards are dealt from the top (highest index) down.
	 * The next card to be dealt is at size - 1.
	 */
	private int size;


	/**
	 * Creates a new <code>Deck</code> instance.<BR>
	 * It pairs each element of ranks with each element of suits,
	 * and produces one of the corresponding card.
	 * @param ranks is an array containing all of the card ranks.
	 * @param suits is an array containing all of the card suits.
	 * @param values is an array containing all of the card point values.
	 */


	public Deck(String[] ranks, String[] suits, int[] values) {
		cards = new ArrayList<Card>();
		for (int i = 0; i<ranks.length; i++ ) {
			for (int j = 0; j<suits.length ; j++ ) {
				cards.add(new Card(ranks[i],suits[j],values[i]));
			}
		}
		size = cards.size();
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
	}


	/**
	 * Determines if this deck is empty (no undealt cards).
	 * @return true if this deck is empty, false otherwise.
	 */
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
	}

	/**
	 * Accesses the number of undealt cards in this deck.
	 * @return the number of undealt cards in this deck.
	 */
	public int size() {
		return size;
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
	}

	/**
	 * Randomly permute the given collection of cards
	 * and reset the size to represent the entire deck.
	 */
	public void shuffle() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
		Random random = new Random();
		for (int k = (cards.size()-1); k > 0 ; k-- ) {
			int exchange = random.nextInt(k);
			Card exchangeValue = cards.get(exchange);
			cards.set(exchange,cards.get(k));
			cards.set(k,exchangeValue);
		}
		size = cards.size();
	}

	/**
	 * Deals a card from this deck.
	 * @return the card just dealt, or null if all the cards have been
	 *         previously dealt.
	 */
	public Card deal() {
		if (size == 0) {
			return null;
		} else {
			Card dealCard = new Card();
			dealCard = cards.get(size-1);
			// cards.remove(size-1);
			size -= 1;
			return dealCard;
		}
		/* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
	}

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() {
		String returnString = "size = " + size + "\nUndealt cards: \n";

		for (int k = size - 1; k >= 0; k--) {
			returnString = returnString + cards.get(k);
			if (k != 0) {
				returnString = returnString + ", ";
			}
			if ((size - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				returnString = returnString + "\n";
			}
		}

		returnString = returnString + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= size; k--) {
			returnString = returnString + cards.get(k);
			if (k != size) {
				returnString = returnString + ", ";
			}
			if ((k - cards.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				returnString = returnString + "\n";
			}
		}

		returnString = returnString + "\n";
		return returnString;
	}
}
