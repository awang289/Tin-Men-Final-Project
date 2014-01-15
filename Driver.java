//super preliminary; can we have other methods in the driver?


public class Driver{

	private ArrayList<Card> _deck;

	private ArrayList<Card> _onTable

	public ArrayList<Card> newDeck(){

		for (int x = 0; x < 3 ; x++){

			for (int h = 0; h < 13 ; h++){

				Card g = new Card(x,h);

				_deck.add(g);

			}

		}

	}

	public void dealHand(Player j){

		while (int x = 0; x < 12 ; x++){
			int h = (int) (Math.random()*_deck.size());
			j.add(_deck.remove(_deck.get(h)));
		}

	}

	public static void main(String [] args){

		boolean anyLosers = false;

		//instantiate players based on user input



		while ( anyLosers == false ){
			//dealHand to all players
			//playRound() -- with each play, add cards to onTable
			//add all cards in onTable back to deck, remove from onTable
			//reevaluate anyLosers
		}

	}


}
