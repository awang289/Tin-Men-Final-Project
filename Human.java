import java.util.ArrayList;
import cs1.Keyboard;

public class Human extends Player{

  public Human() {
    _name = "";
    _score = 0;
    _roundScore = 0;
    _hand = new ArrayList<Card>();
    isLeading = false;
    isBroken = false;
  }

  public Human(String name) {
    _name = name;
    _score = 0;
    _roundScore = 0;
    _hand = new ArrayList<Card>();
    isLeading = false;
    isBroken = false;
  }
  
  public int convert(String w){
    for (int x = 0 ; x < _hand.size() ; x++){
      if (_hand.get(x).toString().equals(w)){
        return x;
      }
    }
    
    return -1;
  }
  
  public String isOkay(String e, boolean anyOfSuit){
    
    int h = convert(e);
    
    if (h < 0 || h > _hand.size()-1){return "Illegal move. Please select a card in your hand.";}
    Card d = _hand.get(h);
    
    String retStr = "";
    
    if ( isLeading == true && isBroken == false && d.getSuit() == 0) {retStr = "Illegal move. Hearts has not yet been broken, please lead a card of another suit.";}
    if (isLeading == false && _trickSuit != d.getSuit() && anyOfSuit == true){retStr = "Illegal move. You have a " + _table.get(0).getSuitName() + ", so you must play it.";} //make getSuitName
    
    return retStr;
  }

  public boolean inHand(Card d){
    for ( int x = 0; x < _hand.size() ; x++ ){
      if (_hand.get(x).equals(d)){
        return true;
        }
    }
    return false;
  }
  
  public void showHand(){
    System.out.println(getHand());
  }
  
  public Card playCard(){
    
    System.out.println("The Table: " + getTable());
    System.out.println("It's your turn, please select a card from your hand:");
    showHand();
    String h = Keyboard.readString();
    
    boolean j = checkSuit();
    
    while (isOkay(h,j)!= ""){
      System.out.println(isOkay(h,j));
      h = Keyboard.readString();
    }
    
    System.out.println(isOkay(h,j));
    Card retCard = _hand.remove(convert(h));//edit because h is a string now
    String r = cardConvert(retCard.getNumber()+2);
    System.out.println(_name + " played the " + r + " of " + retCard.getSuitName() + "s.");
    return retCard;
  }
  
}
