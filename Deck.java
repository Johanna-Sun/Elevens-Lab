import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 * initialize, shuffle, deal, and check if empty.
 */
public class Deck {

    /**
     * cards contains all the cards in the deck.
     */
    public List<Card> cards;

    /**
     * size is the number of not-yet-dealt cards.
     * Cards are dealt from the top (highest index) down.
     * The next card to be dealt is at size - 1.
     */
    public int size;


    /**
     * Creates a new <code>Deck</code> instance.<BR>
     * It pairs each element of ranks with each element of suits,
     * and produces one of the corresponding card.
     *
     * @param ranks  is an array containing all of the card ranks.
     * @param suits  is an array containing all of the card suits.
     * @param values is an array containing all of the card point values.
     */
    public Deck(String[] ranks, String[] suits, int[] values) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
        size = ranks.length * suits.length;
        cards = new ArrayList<Card>();

        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < suits.length; j++) {
                cards.add(new Card(ranks[i], suits[j], values[i]));
            }
        }

        shuffle();

    }


    /**
     * Determines if this deck is empty (no undealt cards).
     *
     * @return true if this deck is empty, false otherwise.
     */
    public boolean isEmpty() {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
        if (size == 0) {
          return true;
        } else {
          return false;
        }
    }

    /**
     * Accesses the number of undealt cards in this deck.
     *
     * @return the number of undealt cards in this deck.
     */
    public int size() {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
        return size;
    }

    /**
     * Randomly permute the given collection of cards
     * and reset the size to represent the entire deck.
     */
    public void shuffle() {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 4 *** */
        List<Card> suf = new ArrayList<Card>();

        while (cards.size() > 0) {
            int rand = getRandomRange(0, cards.size());
            Card randCard = cards.get(rand);
            suf.add(randCard);
            cards.remove(randCard);
        }

        cards = suf;
        size = cards.size();
    }

    public int getRandomRange(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min) + min;
    }

    /**
     * Deals a card from this deck.
     *
     * @return the card just dealt, or null if all the cards have been
     * previously dealt.
     */
    public Card deal() {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 2 *** */
        if (size <= 0) {
            return null;
        }
        Card dealt = cards.get(size - 1);
        size--;
        return dealt;
    }

    /**
     * Generates and returns a string representation of this deck.
     *
     * @return a string representation of this deck.
     */
    @Override
    public String toString() {
        String rtn = "size = " + size + "\nUndealt cards: \n";

        for (int k = size - 1; k >= 0; k--) {
            rtn = rtn + cards.get(k);
            if (k != 0) {
                rtn = rtn + ", ";
            }
            if ((size - k) % 2 == 0) {
                // Insert carriage returns so entire deck is visible on console.
                rtn = rtn + "\n";
            }
        }

        rtn = rtn + "\nDealt cards: \n";
        for (int k = cards.size() - 1; k >= size; k--) {
            rtn = rtn + cards.get(k);
            if (k != size) {
                rtn = rtn + ", ";
            }
            if ((k - cards.size()) % 2 == 0) {
                // Insert carriage returns so entire deck is visible on console.
                rtn = rtn + "\n";
            }
        }

        rtn = rtn + "\n";
        return rtn;
    }
}
