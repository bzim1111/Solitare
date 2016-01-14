package solitare;

public class Stack {

	int num_cards;
	Card[] stack = new Card[100];
	
	/*
	 * Constructor
	 */
	
	public void Stack() {
		num_cards=0;
	}
	
	
	public void AddCard ( Card c, boolean visible ) {
		
		stack[num_cards] = c;
		
		if ( visible ) c.MakeVisible();
		else c.MakeNotVisible();
		
		num_cards++;
	}
	
	
	public void MakeTopVisible() {
		stack[num_cards-1].MakeVisible();
	}
	
	
	public Card GetTopCard() {
		if ( num_cards == 0 ) return null;
		return stack[num_cards-1];
	}
	
	
	public Card GetLastVisibleCard() {
		int i;
		
		if ( num_cards == 0 ) return null;
		
		i = num_cards-1;
		
		while ( stack[i].visible ) {
			i--;
			if ( i < 0 ) break;
		}
		
		return stack[i+1];
	}
	
	
	public void MoveRun ( Stack s ) {
		int i;
		
		if ( num_cards == 0 ) return;
		
		i = num_cards-1;
		
		while ( stack[i].visible ) {
			i--;
			if ( i < 0 ) break;
		}
	
		if ( i >= -1 ) {
			
			i = i+1;
		
			for ( int j=i; j<num_cards; j++ ) {
				s.AddCard( stack[j], true );
			}
		
			num_cards = i;
		}
		
		if ( num_cards > 0 ) this.MakeTopVisible();
	}
	
	
	public void RemoveTopCard() {
		num_cards--;
	}
	
	
	public void PrintStack() {
		System.out.println("---Stack---");
		for ( int i=0; i<num_cards; i++ ) {
			stack[i].PrintCard();
		}
	}
}
