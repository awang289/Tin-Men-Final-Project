public class Human extends Player{
  
  public String isOkay(Card d){
    
    String retStr = "";
    //add isBroken, isLeading, _getSuitName
    if ( isLeading == true && isBroken == false) {retStr = "Illegal move. Hearts has not yet been broken, please lead a card or another suit.";}
    if (isLeading == false && _trickSuit != d._getSuit()){retStr = "Illegal move. Please play a " + d._getSuitName + ".";} //make getSuitName
    if (inHand(d) == false){retStr = "Illegal move. Please select a card in your hand.";}
    
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
  
  //playCard() method
  
}
