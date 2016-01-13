package solitare;

public class Solitare {

	public static void main(String[] args) {

		Deck deck;
		Stack[] stack = new Stack[7];
		Stack[] pile = new Stack[4];
		
		deck = new Deck();
		for ( int i=0; i<7; i++ ) stack[i] = new Stack();
		for ( int i=0; i<4; i++ ) pile[i] = new Stack();
		
		deck.ShuffleDeck();
		
		load_stacks ( deck, stack );
				
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
	
}
