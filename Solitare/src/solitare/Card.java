package solitare;

/* card suits */

enum suit {
	hearts, spades, diamonds, clubs;
}

/* card face values */

enum face_value {
	ace, two, three, four, five, six, seven, eight, nine, ten, jack, queen, king;
}


enum color {
	red, black;
}


public class Card {
	
	suit card_suit;
	face_value card_face_value;
	int card_value;
	boolean visible;
	color card_color;
	
	/*
	 * Constructor
	 * Set the suit and face value
	 */
	
	public Card ( suit s , face_value fv )	{
		
		card_suit = s;
		card_face_value = fv;
		visible = false;
		
		if ( ( card_suit == suit.spades ) || ( card_suit == suit.clubs ) ) card_color = color.black;
		else card_color = color.red;
		
		switch ( fv ) {
		case ace:
			card_value = 11;
			break;
		case two:
			card_value = 2;
			break;
		case three:
			card_value = 3;
			break;
		case four:
			card_value = 4;
			break;
		case five:
			card_value = 5;
			break;
		case six:
			card_value = 6;
			break;
		case seven:
			card_value = 7;
			break;
		case eight:
			card_value = 8;
			break;
		case nine:
			card_value = 9;
			break;
		case ten:
		case jack:
		case queen:
		case king:
			card_value = 10;
			break;
		}
	}
	
	
	/*
	 * Mark a card as visible
	 */
	
	public void MakeVisible() {
		visible = true;
	}
	
	
	/*
	 * Mark a card as not visible
	 */
	
	public void MakeNotVisible() {
		visible = false;
	}
	
	
	/*
	 * Print out a card
	 */
	
	public void PrintCard () {
		
		switch ( this.card_face_value ) {
		case two:
			System.out.print("Two");
			break;
		case three:
			System.out.print("Three");	
			break;
		case four:
			System.out.print("Four");
			break;
		case five:
			System.out.print("Five");
			break;
		case six:
			System.out.print("Six");
			break;
		case seven:
			System.out.print("Seven");
			break;
		case eight:
			System.out.print("Eight");
			break;
		case nine:
			System.out.print("Nine");
			break;
		case ten:
			System.out.print("Ten");
			break;
		case jack:
			System.out.print("Jack");
			break;
		case queen:
			System.out.print("Queen");
			break;
		case king:
			System.out.print("King");
			break;
		case ace:
			System.out.print("Ace");
			break;
		}
		
		System.out.print(" ");
		
		switch ( this.card_suit ) {
		case diamonds:
			System.out.print("Diamonds");
			break;
		case spades:
			System.out.print("Spades");
			break;
		case clubs:
			System.out.print("Clubs");
			break;
		case hearts:
			System.out.print("Hearts");
			break;
		}
		
		if ( this.card_color == color.red ) System.out.print(", red");
		else System.out.print(", black");
		
		if (this.visible) System.out.println(", visible");
		else System.out.println(", not visible");
	}

}
