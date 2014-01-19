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
  //hand is already sorted
  public ArrayList<Card> reduce(){
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
    	
    	return toUse;
  }
  
	
  public Card playCard(){
    ArrayList<Card> n = reduce();
    //at this point we have an arraylist n of all legal cards
    //we also have _table, which contains all cards currently in play
    // as well as _difficulty, which runs 1-3 and dictates increasing difficulty level
    
    if (_difficulty == 1){
    	return easyPlay(n);
    }
    
    if (_difficulty == 2){
    	return midPlay(n);
    }
    
    if (_difficulty == 3){
    	return hardPlay(n);
    }
    
    return easyPlay();
  }
  
  public boolean anyHearts(){
  	for (int x = 0; x < _table.size(); x++){
  		if( _table.get(x).getSuit() == 0 ){
  			return true;
  		}
  	}
  	return false;
  }
  
  public Card easyPlay(ArrayList<Card> n){
  	int x = (int) (Math.random * n.size());
  	return n.get(x);
  }
  
  public Card midPlay(ArrayList<Card> n){
  	if (isLeading == false && _trickSuit != 0){
  		for (int x = 0; x < n.size(); x++){
  			if (n.get(x).getSuit() == 0){
  				return n.get(x);
  			}
  		}	
  	}
  	
  	if (isLeading == false && _trickSuit == 0){
  		for (int x = 0; x < n.size() ; x++){
  			if (n.get(x).getSuit() != 0){
  				return n.get(x);
  			}
  		}
  		return n.get(0);
  	}
  	
  	if (isLeading == false){
  		return n.get((int)(n.size()));
  	}
  	
  	if (isLeading == true){
  		return n.get(0);
  	}
  	
  	
  }
  
  public Card hardPlay(ArrayList<Card> n){////mod/enhance this(midPlay) later to get hardPlay
  	if (isLeading == false && _trickSuit != 0){
  		for (int x = 0; x < n.size(); x++){
  			if (n.get(x).getSuit() == 0){
  				return n.get(x);
  			}
  		}	
  	}
  	
  	if (isLeading == false && _trickSuit == 0){
  		for (int x = 0; x < n.size() ; x++){
  			if (n.get(x).getSuit() != 0){
  				return n.get(x);
  			}
  		}
  		return n.get(0);
  	}
  	
  	if (isLeading == false){
  		return n.get((int)(n.size()));
  	}
  	
  	if (isLeading == true){
  		return n.get(0);
  	}
  }
  
}




