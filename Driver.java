import cs1.Keyboard;
import java.util.ArrayList;

public class Driver{

    private static ArrayList<Card> _deck;

    private static ArrayList<Card> _table;
        
    private static int leading;
        
    private static ArrayList<Player> players = new ArrayList<Player>();
        
    private static int trickSuit;
        
    public static int getTrick() { return trickSuit; }

    public static void printScore(){
	String printStr = "==================================";
	printStr = printStr +  "SCORES:";
	for (int x = 0; x < players.size(); x++){
	    printStr = printStr + players.get(x);
	}
	printStr = printStr +  "==================================";
	System.out.println(printStr);
    }

    public static void printWinner(){
	String printStr = "==================================";
	printStr += "WINNER(S):";
	int lowest = 100;
	String g = "";
	for (int x = 0; x < players.size(); x++){
	    if (players.get(x).getScore() < lowest){
		g = players.get(x).getName();
	    }
	    if (players.get(x).getScore() == lowest){
		g += ", " + players.get(x).getName();
	    }
	}
	printStr += "==================================";
	System.out.println(printStr);
    }

    public static void newDeck(){

	_deck = new ArrayList<Card>();
	for (int x = 0; x < 4 ; x++){

	    for (int h = 0; h < 13 ; h++){

		Card g = new Card(x,h);

		_deck.add(g);

	    }

	}

    }

    public static void dealHand(Player j){
                
	for (int s = 0; s < 13 ; s++){
	    int h = (int) (Math.random()*_deck.size());

	    Card d = _deck.get(h);
	    _deck.remove(d);
	    j.add(0, d);
	}

    }
        
    public static void startRound() {
	newDeck();
	for (int x = 0; x < 4; x++) {
	    dealHand(players.get(x));
	    players.get(x).sort();
	}
	if (checkStart(players.get(0)))
	    setLeading (0);
	else if (checkStart(players.get(1)))
	    setLeading(1);
	else if (checkStart(players.get(2)))
	    setLeading(2);
	else
	    setLeading(3);
    }
        
    public static boolean anyLosers(Player p1, Player p2, Player p3, Player p4) {        
	return ( (p1.getScore() >= 100 ) || ( p2.getScore() >= 100 ) ||
		 (p3.getScore() >= 100 ) || ( p4.getScore() >= 100 ));
    }
    public static boolean checkStart( Player p ) {
	Card C3 = new Card(3,1);
	for (int x = 0; x < p.retHand().size(); x++) {
	    if (p.retHand().get(x).compareTo(C3) == 0)
		return true;
	}
	return false;        
                
    }
    public static void setLeading (int n) {
	for (int x = 0; x < 4; x++)
	    players.get(x).setLeading(false);
	players.get(n).setLeading(true);
	leading = n;
    }
    public static void setTrick (Card c) {
	for (int x = 0; x < 4; x++)
	    players.get(x).setTrickSuit(c.getSuit());
	trickSuit = c.getSuit();
    }
    public static void tallyTrick(Card c1, Card c2, Card c3, Card c4) {
	//redo this later, use no inputs and a for loop referencing the ArrayList players
	Card max = c1;
	if (c2.getSuit() == trickSuit && c2.compareTo(c1) > 0)
	    max = c2;
	if (c3.getSuit() == trickSuit && c3.compareTo(c1) > 0)
	    max = c3;
	if (c4.getSuit() == trickSuit && c4.compareTo(c1) > 0)
	    max = c4;
	int total = c1.getValue() + c2.getValue() + c3.getValue() + c4.getValue();
	if (max.equals(c1))
	    {players.get(leading).addPoints(total);}
	else if (max.equals(c2)) {
	    players.get( (leading + 1) % 4).addPoints(total);
	    setLeading((leading + 1) % 4);}
	else if (max.equals(c3)) {
	    players.get( (leading + 2) % 4).addPoints(total);
	    setLeading((leading + 2) % 4);}
	else {
	    players.get( (leading + 3) % 4).addPoints(total);
	    setLeading((leading + 3) % 4); }
	if (total > 0) {
	    for (int x = 0; x < 4; x++)
		players.get(x).setBroken(true);
	}
    }

    public static void tallyRound(){
	if (players.get(0).getRound() == 26 || players.get(1).getRound() == 26 ||
	    players.get(2).getRound() == 26 || players.get(3).getRound() == 26) {
	    for (int x = 0; x < 4; x++) {
		if (players.get(x).getRound() != 26)
		    players.get(x).addPoints(26);
		else
		    players.get(x).addPoints(-26);
	    }
	}
	players.get(0).tally();
	players.get(1).tally();
	players.get(2).tally();
	players.get(3).tally();
    }

    public static Card playTurn( Player m ) {
    	for (int x = 0; x< 800000000; x++){}/// wanted to find a way to have each turn take a little longer, this is all i could think of
	if (m.getLeading() == true){
	    for (int x = 0; x < players.size(); x++){
		players.get(x).emptyTable();
	    }     
	}
                
	Card d = m.playCard();
	for (int x = 0; x < players.size(); x++){
	    players.get(x).addTable(d);
	}
	System.out.println("");
	return d;
                
    }        
        
    public static void main(String [] args){
	String mom = "Welcome to Hearts! \nCards in this game are represented by their number and the first letter of their suit. \nex. The five of hearts is written as 5H, the queen of spades is written as QS\n\nTo play a card, type the card you wish to play in this format.";
	System.out.println(mom);
	int s;
	Card c1, c2, c3, c4;
	System.out.print("What is your name? ");
	String j = Keyboard.readString();
	Player p1 = new Human(j);
	Player p2 = new Computer("West");
	Player p3 = new Computer("North");
	Player p4 = new Computer("East");
	System.out.print("1. Easy \n2. Medium \n3. Hard \nChoose your difficulty level: ");
	s = Keyboard.readInt();
	p2.setDifficulty(s);
	p3.setDifficulty(s);
	p4.setDifficulty(s);
	
	players.add(p1);
	players.add(p2);
	players.add(p3);
	players.add(p4);
            
	
	
	while ( anyLosers(p1,p2,p3,p4) == false ){
	    //dealHand to all players
	    //playRound() -- with each play, add cards to onTable
	    //add all cards in onTable back to deck, remove from onTable
	    //reevaluate anyLosers
	    startRound();
	    for (int x = 0; x < 13; x++) {
		System.out.println("" + players.get(leading).getName() 
				   + " is leading this trick.");
		
		c1 = playTurn( (Player) players.get( leading ));
		setTrick(c1);
		c2 = playTurn((Player)players.get( (leading + 1) % 4));
		c3 = playTurn((Player)players.get( (leading + 2) % 4));
		c4 = playTurn((Player)players.get( (leading + 3) % 4));
		tallyTrick(c1, c2, c3, c4);
		System.out.println("" + players.get(leading).getName() 
				   + " won this trick. \n");
		
	    }
	    tallyRound();
	    printScore();
	}
	printWinner();
	
    }
    
    
}
