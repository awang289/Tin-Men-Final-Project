import java.util.ArrayList;

public class Card implements Comparable {
  /* Hearts is 0
Spades is 1
Diamonds is 2
Clubs is 3
*/
  private int _suit;
  private int _number;
  private String _name;
  private int _value;
  public Card (int suit, int number) {
    _suit = suit;
    _number = number;
    if (_suit == 0)
      _value = 1;
    else if (_suit == 1 && _number == 10)
      _value = 13;
    else
      _value = 0;
    if (_suit == 0){_name = "Heart";}
    else if (_suit == 1){_name = "Spade";}
    else if (_suit == 2){_name = "Diamond";}
    else {_name = "Club";}
  }
  public int getSuit() { return _suit; }
  public int getNumber() { return _number; }
  public int getValue() { return _value; }
  public String getSuitName(){return _name;}
  public int compareTo(Object other) {

      if (other instanceof Card){

        return (compareTo2((Card) other));

      }

      return 1;
  }

  public int compareTo2(Card other){

    return ((_suit * 13) + _number - (other.getSuit() * 13) - other.getNumber());

  }

  public String toString(){
    if (_suit == 0) {
      if (_number < 9)
        return (_number + 2) + "H";
      else if (_number == 9)
        return "J" + "H";
      else if (_number == 10)
        return "Q" + "H";
      else if (_number == 11)
        return "K" + "H";
      else
        return "A" + "H";
    }
    else if (_suit == 1) {
      if (_number < 9)
        return (_number + 2) + "S";
      else if (_number == 9)
        return "J" + "S";
      else if (_number == 10)
        return "Q" + "S";
      else if (_number == 11)
        return "K" + "S";
      else
        return "A" + "S";
    }
    else if (_suit == 2) {
      if (_number < 9)
        return (_number + 2) + "D";
      else if (_number == 9)
        return "J" + "D";
      else if (_number == 10)
        return "Q" + "D";
      else if (_number == 11)
        return "K" + "D";
      else
        return "A" + "D";
    }
    else {
      if (_number < 9)
        return (_number + 2) + "C";
      else if (_number == 9)
        return "J" + "C";
      else if (_number == 10)
        return "Q" + "C";
      else if (_number == 11)
        return "K" + "C";
      else
        return "A" + "C";
    }
  }
}
