import java.util.ArrayList;

public abstract class Player {
  protected String _name;
  protected ArrayList<Card> _hand;
  protected ArrayList<Card> _table;
  protected int _score;
  protected int _difficulty;
  protected int _trickSuit;
  protected boolean isLeading;
  protected boolean isBroken;
  protected int _roundScore;
  

  public Player() {
    _name = "";
    _score = 0;
    _roundScore = 0;
    _hand = new ArrayList<Card>();
    _table = new ArrayList<Card>();
    isLeading = false;
    isBroken = false;
  }

  public Player(String name) {
    _name = name;
    _score = 0;
    _roundScore = 0;
    _table = new ArrayList<Card>();
    _hand = new ArrayList<Card>();
    isLeading = false;
    isBroken = false;
  }
  
  public void addTable(Card g){
    _table.add(g);
  }
  
  public void emptyTable(){
    for (int x = 0; x < _table.size() ; x++){
      _table.remove(x);
      x--;
    }
  }
  
  public void setBroken(boolean h){
    isBroken = h;
  }
  public void setDifficulty(int s){
    _difficulty = s;
  }
  public void setLeading(boolean g){
    isLeading = g;
  }
  public void setTrickSuit(int j){
    _trickSuit = j;
  }
  public int getTrick(){
    return _trickSuit;
  }
  public int getScore() { return _score; }
  public String getName() { return _name; }
  public boolean getLeading() {return isLeading;}
  public ArrayList<Card> retHand(){return _hand;}
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
  public int getRound() {return _roundScore; }

  public Card remove(int index) {
    return _hand.remove(index);
  }
  
  public void tally() {
    _score += _roundScore;
    _roundScore = 0;
  }
  
  public String getTable(){
    String d = "================================================\n||";
    for (int x = 0; x < _table.size(); x++){
      d += _table.get(x) + "\t";
    }
    d += "||\n================================================\n";
    return d;
  }
  
  public Card remove(Card c) {
    _hand.remove(c);
    return c;
  }
  public String toString() {
    String out = "Name: " + _name + "\tScore: " + _score;
    return out;
  }
  public String getHand() {
    sort();
    String out = "";
    for (int x = 0; x < _hand.size(); x++) {
      out = out + _hand.get(x) + " ";
    }
    return out;
  }
  public void sort() {
    for (int g = 0; g < _hand.size(); g++){
      for (int h = g+1; h < _hand.size(); h++){
        if ((_hand.get(g).compareTo(_hand.get(h))>0)){
          _hand.set(g, _hand.set(h, _hand.get(g)));
        }
      }
    }
  }
  public int addPoints( int n ){
    _roundScore += n;
    return _roundScore;
  }

  public String cardConvert(int g){
    if (g == 11){return "Jack";}
    if (g == 12){return "Queen";}
    if (g == 13){return "King";}
    if (g == 14){return "Ace";}
    return ""+g;
  }
  
  public boolean checkSuit(){
          for (int x = 0; x < _hand.size(); x++){
                  if (_hand.get(x).getSuit()==getTrick()){
                          return true;
                  }
          }
          
          return false;
  }
  public abstract Card playCard();
}
