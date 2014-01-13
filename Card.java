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
  public String toString()
}
