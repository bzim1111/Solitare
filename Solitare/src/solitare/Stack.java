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
