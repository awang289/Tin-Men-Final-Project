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
  
  
  public boolean checkSuit(){
  	for (int x = 0; x < _hand.size(); x++){
  		if (_hand.get(x).getSuit()==getTrick()){
  			return true;
  		}
  	}
  	
  	return false;
  }
  
	
  public Card playCard(){//do in morning
    ArrayList<Card> toUse = _hand;
    boolean anyOfSuit = checkSuit(); 
    for (int x = 0; x < _toUse.size(); x++){
    	if (isLeading == true && isBroken == false && toUse.get(x).getSuit() == 0){
    		toUse.remove(x);
    		x--;
    	}
    	if (toUse.get(x).getSuit()!= getTrick() && anyOfSuit == true && isLeading == false){
    		toUse.remove(x);
    		x--;
    	}
    }
    //at this point we have an arraylist toUse of all legal cards
    return h; //h will be final outputted card
  	}
  
}
