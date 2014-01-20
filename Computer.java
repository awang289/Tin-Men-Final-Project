import java.util.ArrayList;

public class Computer extends Player{

  public Computer() {
    _name = "";
    _score = 0;
    _roundScore = 0;
    _hand = new ArrayList<Card>();
    isLeading = false;
    isBroken = false;
    _table = new ArrayList<Card>();
  }

  public Computer(String name) {
    _name = name;
    _score = 0;
    _roundScore = 0;
    _hand = new ArrayList<Card>();
    _table = new ArrayList<Card>();
    isLeading = false;
    isBroken = false;
  }
  //hand is already sorted
  public ArrayList<Card> reduce(){
      	ArrayList<Card> toUse = _hand;
    	boolean anyOfSuit = checkSuit(); 
    	for (int x = 0; x < toUse.size(); x++){
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
    
    return easyPlay(n);
  }
  
  public boolean anyHearts(){
  	for (int x = 0; x < _table.size(); x++){
  		if( _table.get(x).getSuit() == 0 ){
  			return true;
  		}
  	}
  	return false;
  }
  
  public int handSuit(int n, ArrayList<Card> g){
  	for (int x = g.size() -1; x < 0; x--){
  		if (g.get(x).getSuit() == n){
  			return x;
  		}
  	}
  	return -1;
  }
  
  public int otherSuit(int n, ArrayList<Card> g){
  	for (int x = g.size() -1; x < 0; x--){
  		if (g.get(x).getSuit() != n){
  			return x;
  		}
  	}
  	return -1;
  }
  
  public Card easyPlay(ArrayList<Card> n){
      int x = (int) (Math.random() * n.size());
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
  	
  		return n.get(0);
  	
  	
  	
  }
  
  public Card hardPlay(ArrayList<Card> n){
  	if (_table.size() == 3 && anyHearts() == false){
  		if (handSuit(0,n) != -1){
  			return n.get(handSuit(0,n));
  		}
  		else {
  			return n.get(n.size()-1);
  			}
  	}
  	
  	if (_table.size() == 3 && anyHearts()==true && _trickSuit == 0){
  		if (otherSuit(0,n) != -1){
  			return n.get(otherSuit(0,n));
  			}
  		else {
  			return n.get(0);
  		}
  	}
  	
  	if (_table.size() ==3 && anyHearts()==true && _trickSuit != 0){
  		if (otherSuit(_trickSuit,n) != -1){
  			return n.get(otherSuit(_trickSuit,n));
  			}
  		else {
  			return n.get(0); 
  		}	
  	}
  	
  	if (isLeading == true && _hand.size()> 8){
  		//assume everyone will follow your lead
  		if (otherSuit(0,n) != -1){
  			return (n.get(otherSuit(0,n)));
  		}
  		else {
  			return n.get(0);
  		}
  	}
  	
  	if (isLeading == true && _hand.size() <= 8){
  		//assume someone won't, play conservatively
  		for (int x= 0; x< n.size(); x++){
  			if ( n.get(x).getSuit() != 0 ){
  				return n.get(x);
  			}
  			return n.get(0);
  		}
  	}
  	
  	if (_trickSuit == 0 && _table.size() == 1){
  		for (int x = 0 ; x < n.size(); x++){
  			if (n.get(x).compareTo(_table.get(0)) < 0){
  				return n.get(x);
  			}
  		}
  		
  	}
  	
  	if (_trickSuit ==0 && _table.size() == 2){
  		for (int x = 0; x < n.size(); x++){
  			if (n.get(x).compareTo(_table.get(0))< 0|| n.get(x).compareTo(_table.get(1))> 0){
  				return n.get(x);
  			}
  		}
  	}
  	
  	if ( anyHearts() == false ){
  		return n.get((int)n.size()/2);
  	}
  	
 
  		return n.get(0);
  	
  
  }
  
}




