
/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 1 *** */
		Card first = new Card("1","diamonds",1);
		Card second = new Card("2","heart",2);
		///test all the methods
		System.out.println(first.rank());
		System.out.println(first.suit());
		System.out.println(first.pointValue());
		//
		System.out.println(second.rank());
		System.out.println(second.suit());
		System.out.println(second.pointValue());
		///
		System.out.println(first.matches(second));
		///
		System.out.println(first.toString());
		System.out.println(second.toString());

	}
}
