package solitare;

public class Solitare {

	public static void main(String[] args) {

		Deck deck;
		Stack[] stack = new Stack[7];
		Stack[] pile = new Stack[4];
		
		/* initialize */
		
		deck = new Deck();
		for ( int i=0; i<7; i++ ) stack[i] = new Stack();
		for ( int i=0; i<4; i++ ) pile[i] = new Stack();
		
		/* shuffle the deck */
		
		deck.ShuffleDeck();
		
		/* load the 7 playing field stacks, set top card to visible */
		
		load_stacks ( deck, stack );

		for ( int i=0; i<7; i++ ) stack[i].PrintStack();
		
		/* move cards within the stacks */
		
		process_stacks ( deck , stack );
		
		/* process kings within the stacks */
		
		/* move cards from the stacks up to the piles */
		
		/* process the draw pile card */
		
		for ( int i=0; i<7; i++ ) stack[i].PrintStack();
	}

	
	/*
	 * Load the 7 playing field stacks
	 */
	
	static void load_stacks ( Deck d, Stack[] s ) {
		
		Card c = null;
			
		for ( int i=0; i<7; i++ ) {
		
			for ( int j=i; j<7; j++ ) {
				try {
					c = d.Draw();
				}
				catch ( OutOfCards ooc ) {
					System.out.println("out of cards");
				}

				s[6-i].AddCard ( c, false );
			}
			
		}
		
		for ( int i=0; i<7; i++ ) s[i].MakeTopVisible();
	}
	
	
	/*
	 * Make moves within the playing field stacks
	 */
	
	static void process_stacks ( Deck d, Stack[] s ) {
		
		Card c1 = null;
		Card c2 = null;
	
		for ( int j=0; j<7; j++ ) {
			
			c1 = s[j].GetTopCard();
			if ( c1 == null ) continue;
		
			System.out.println("Processing ");
			c1.PrintCard();
		
			for ( int i=0; i<7; i++ ) {
				if ( i == j ) continue;
				c2 = s[i].GetTopCard();
				if ( c2 == null ) continue;
				if (( c1.card_color != c2.card_color ) && ( c1.card_value == (c2.card_value-1) )) {
					System.out.println("Can move to stack "+i);
					s[i].AddCard( c1 , true );
					s[j].RemoveTopCard();
				}
			}
		}
	}
	
	
}
