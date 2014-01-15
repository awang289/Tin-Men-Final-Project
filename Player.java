public abstract class Player {
  protected String _name;
  protected ArrayList<Card> _hand;
  protected int _score;
  public Player(String name) { 
    _name = name;
    _score = 0;
    _hand = new ArrayList<Card>();
  }
  public int getScore() { return score; }
  public String getName() { return name; }
  public boolean add (Card c) {
    _hand.add(c);
    return true;
  }
  public void add (int index, Card c) {
    _hand.add(index, c);
  }
  public Card set (int index, Card c) {
    _hand.set(index, c);
    return c;
  }
  public Card remove(int index) {
    return _hand.remove(index);
  }
  public Card remove(Card c) {
    _hand.remove(c);
    return c;
  }
  public String toString() { 
    String out = "Name: " + _name + "\nScore: " + _score;
    return out;
  }
  public String getHand() {
    sort();
    String out = "";
    for (int x = 0; x < _hand.size(); x++) {
      out = out + _hand.get(x); + "  ";
    }
    return out;
  }
  public void sort() {
    for (int g = 0; g < _hand.size(); g++){
      for (int h = g+1; h < _hand.size(); h++){
        if ((_hand.get(g).compareTo(hand.get(h))>0)){
          _hand.set(g, _hand.set(h, _hand.get(g)));
        }
      }
    }
  }
}
