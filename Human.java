import cs1.Keyboard;

public class Human extends Player{
  
  public String isOkay(int d){
    
    if (d < 1 || d > _hand.size()){return "Illegal move. Please select a card in your hand.";}
    Card d = _hand.get(d-1);
    
    String retStr = "";
    
    if ( isLeading == true && isBroken == false && d.getSuit() == 0) {retStr = "Illegal move. Hearts has not yet been broken, please lead a card of another suit.";}
    if (isLeading == false && _trickSuit != d.getSuit()){retStr = "Illegal move. Please play a " + d.getSuitName() + ".";} //make getSuitName
    
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
    showHand();
    //include catchException in case doubles/floats/non-numbers are inputted
    System.out.println("It's your turn, please select a card using an integer from 1 to " + _hand.size()+ ".");
    int h = Keyboard.getInt();
    
    while (isOkay(h)!= ""){
      System.out.println(isOkay(h));
      retCard = findCard(Keyboard.getString());
    }
    
    System.out.println(isOkay(h));
    return retCard
  }
  
}
