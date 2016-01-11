package solitare;

public class Solitare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Deck deck;
		Card c;
		Stack s;
		
		deck = new Deck();
		c = null;
		s = new Stack();
		
		deck.ShuffleDeck();
		
		for ( int i=0; i<10; i++ ) {
			
			try {
				c = deck.Draw();
			}
			catch ( OutOfCards ooc ) {
				System.out.println("out of cards");
			}
		
			c.PrintCard();
		
			s.AddCard ( c , false );
		
		}
		
		s.MakeTopVisible();
		s.PrintStack();
	}

}
