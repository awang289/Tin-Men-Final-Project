//All we need is methods to print the score and the winner at the end of the game and the driver is DONE!
import cs1.Keyboard;

public class Driver{

	private static ArrayList<Card> _deck;

	private static ArrayList<Card> _table
	
	private static int leading;
	
	private static ArrayList<Player> players = new ArrayList<Player>();
	
	private static int trickSuit;
	
	
	public static String getTrick() { return trickSuit; }
	public static void newDeck(){
		_deck = new ArrayList<Card>();
		for (int x = 0; x < 4 ; x++){

			for (int h = 0; h < 13 ; h++){

				Card g = new Card(x,h);

				_deck.add(g);

			}

		}

	}

	public static void dealHand(Player j){
		
		while (int x = 0; x < 13 ; x++){
			int h = (int) (Math.random()*_deck.size());
			j.add(_deck.remove(_deck.get(h)));
		}

	}
	
	public static void startRound() {
		newDeck();
		for (int x = 0; x < 4; x++) {
			dealHand(players.get(x))
			players.get(x).sort();
		}
	}
	
	public static boolean anyLosers() {	
		return ( (p1.getScore() >= 100 ) || ( p2.getScore() >= 100 ) || 
			(p3.getScore() >= 100 ) || ( p4.getScore() >= 100 ) ) ;
	}
	public static boolean checkStart( Player p ) {
		Card C3 = new Card(3,1)
		for (int x = 0; x < 13; x++) {
			if (p.get(x).compareTo( C3) == 0)
				return true;
		}
		return false;	
		
	}
	public static void setLeading (int n) {
		for (int x = 0; x < 4; x++)
			players.get(x).setLeading(false);
		players.get(n).setLeading(true);
	}
	public static void setTrick (Card c) {
		for (int x = 0; x < 4; x++)
			players.get(x).setTrickSuit(c.getSuit());
		trickSuit = c.getSuit();
	}
	public static void tallyTrick(Card c1, Card c2, Card c3, Card c4) {
		Card max = c1;
		if (c2.getSuit == trickSuit && c2.compareTo(c1) > 0)
			max = c2;
		if (c3.getSuit == trickSuit && c3.compareTo(c1) > 0)
			max = c3;
		if (c4.getSuit == trickSuit && c4.compareTo(c1) > 0)
			max = c4;
		int total = c1.getValue() + c2.getValue() + c3.getValue() + c4.getValue();
		if (max.equals(c1))
			players.get(leading).addPoints(total);
		else if (max.equals(c2))
			players.get( (leading + 1) % 4).addPoints(total);
			leading = (leading + 1) % 4;
		else if (max.equals(c3))
			players.get( (leading + 2) % 4).addPoints(total);
			leading = (leading + 2) % 4;
		else
			players.get( (leading + 3) % 4).addPoints(total);
		leading = (leading + 1) % 4;
		if (total > 0) {
			for (int x = 0; x < 4; x++) 
				players.get(x).setBroken(true);
		}
	}
	public static Card playTurn( Player m ) {
		return m.playCard();
	}		
	public static void main(String [] args){
		String j;
		int s;
		Card c1, c2, c3, c4;
		System.out.print("What is your name? ");
		j = Keyboard.readString();
		Player p1 = new Human(j);
		Player p2 = new Computer("West");
		Player p3 = new Computer("North");
		Player p4 = new Computer("East");
		System.out.print("1. Easy \n2. Medium \n3. Hard \nChoose your difficulty level: ");
		s = Keyboard.readInt();
		p2.setDifficulty(s);
		p3.setDifficulty(s);
		p4.setDifficulty(s);
		if (checkStart(p1))
			leading = 0;
		else if (checkStart(p2))
			leading = 1;
		else if (checkStart(p3))
			leading = 2;
		else 
			leading = 3;
		players.add(p1);
		players.add(p2);
		players.add(p3);
		players.add(p4);
		


		while ( anyLosers() == false ){
			//dealHand to all players
			//playRound() -- with each play, add cards to onTable
			//add all cards in onTable back to deck, remove from onTable
			//reevaluate anyLosers
			startRound();
			//set first person
			for (int x = 0; x < 13; x++) {
				setLeading(leading);
				c1 = playTurn(players.get( leading ));
				setTrick(c1);
				c2 = playTurn(players.get( (leading + 1) % 4);
				c3 = playTurn(players.get( (leading + 2) % 4);
				c4 = playTurn(players.get( (leading + 3) % 4);
				tallyTrick(c1, c2, c3, c4);

			}
			printScore();
		}
		printWinner();

	}


}
