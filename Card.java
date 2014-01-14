public class Card implements Comparable {
  /* Hearts is 0
     Spades is 1
     Diamonds is 2
     Clubs is 3
  */
  private int _suit;
  private int _number;
  private int _value;
  public Card (int suit, int number) {
    _suit = suit;
    _number = number;
    if (_suit == 0)
      _value = 1;
    else if (_suit == 1 && _number == 10)
      _value = 13;
    else 
      value = 0;
  }
  public int getSuit() { return _suit; }
  public int getNumber() { return _number; }
  public int getValue() { return _value; }
  public int compareTo(Card other) {
    return ((_suit * 13) + _number - (other.getSuit() * 13) - other.getNumber()); 
  }
  public String toString(){
    if (_suit == 0) {
      if (_number < 9) 
        return  (_number + 2) + "\u2665";
      else if (_number == 9)
        return "J" + "\u2665";
      else if (_number == 10)
        return "Q" + "\u2665";
      else if (_number == 11)
        return "K" + "\u2665";
      else 
        return "A" + "\u2665";
    }
    else if (_suit == 1) {
      if (_number < 9) 
        return  (_number + 2) + "\u2660";
      else if (_number == 9)
        return "J" + "\u2660";
      else if (_number == 10)
        return "Q" + "\u2660";
      else if (_number == 11)
        return "K" + "\u2660";
      else
        return "A" + "\u2660";
    }
    else if (_suit == 2) {
      if (_number < 9) 
        return  (_number + 2) + "\u2666";
      else if (_number == 9)
        return "J" + "\u2666";
      else if (_number == 10)
        return "Q" + "\u2666";
      else if (_number == 11)
        return "K" + "\u2666";
      else 
        return "A" + "\u2666";
    }
    else {
      if (_number < 9) 
        return  (_number + 2) + "\u2663";
      else if (_number == 9)
        return "J" + "\u2663";
      else if (_number == 10)
        return "Q" + "\u2663";
      else if (_number == 11)
        return "K" + "\u2663";
      else 
        return "A" + "\u2663";
    }
  }
}
