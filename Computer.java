import java.util.ArrayList;

public class Computer extends Player{

	public Computer() {
    _name = "";
    _score = 0;
    _roundScore = 0;
    _hand = new ArrayList<Card>();
    isLeading = false;
    isBroken = false;
  }

  public Computer(String name) {
    _name = name;
    _score = 0;
    _roundScore = 0;
    _hand = new ArrayList<Card>();
    isLeading = false;
    isBroken = false;
  }
	
	public Card playCard(){//do in morning
		Card h = new Card(3,1);
		return h;
  	}
  
}
