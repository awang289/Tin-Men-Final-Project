//super preliminary; can we have other methods in the driver?


public class Driver{

	private static ArrayList<Card> _deck;

	private static ArrayList<Card> _table

	private static Player p1, p2, p3, p4
	
	private static String trickSuit;
	
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
	public static void main(String [] args){


		//instantiate players based on user input



		while ( anyLosers() == false ){
			//dealHand to all players
			//playRound() -- with each play, add cards to onTable
			//add all cards in onTable back to deck, remove from onTable
			//reevaluate anyLosers
		}

	}


}
