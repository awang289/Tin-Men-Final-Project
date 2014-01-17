//super preliminary; can we have other methods in the driver?
import cs1.Keyboard;

public class Driver{

	private static ArrayList<Card> _deck;

	private static ArrayList<Card> _table

	private static Player p1, p2, p3, p4
	
	private ArrayList<Player> players = new ArrayList<Player>();
	
	private static int trickSuit;
	
	private int first;
	
	public static String getTrick() { return trickSuit; }
	public static void newDeck(){

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
		dealHand(p1);
		dealHand(p2);
		dealHand(p3);
		dealHand(p4);
	}
	
	public static boolean anyLosers() {	
		return ( (p1.getScore() >= 100 ) || ( p2.getScore() >= 100 ) || 
			(p3.getScore() >= 100 ) || ( p4.getScore() >= 100 ) ) ;
	}
	public static void playTurn() {
		if () 
			
	public static void main(String [] args){
		String j;
		int leading;
		System.out.print("What is your name? ");
		j = Keyboard.readString();
		p1 = new Human(j);
		p2 = new Computer("West");
		p3 = new Computer("North");
		p4 = new Computer("East");
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
			for (int x = 0; x < 12; x++) {
				//cycles, tally points, set next leader
			}
		}

	}


}
