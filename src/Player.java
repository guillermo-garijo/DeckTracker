import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Vector;

public class Player extends Observable {
    private ArrayList<Card> hand;
    private ArrayList<Card> bench;
    private ArrayList<Card> field;
    private ArrayList<Card> deck;

    public Player(){
        this.deck = new ArrayList<>();
        this.bench = new ArrayList<>();
        this.field = new ArrayList<>();
        this.hand = new ArrayList<>();
    }
    private Player(ArrayList<Card> deck, ArrayList<Card> hand, ArrayList<Card> bench, ArrayList<Card> field){
        this.deck=deck;
        this.hand=hand;
        this.bench=bench;
        this.field=field;
    }
    public ArrayList<Card> getDeck(){
        return deck;
    }
    public void setDeck(ArrayList<Card> deck){
        this.deck=deck;
        setChanged();
        notifyObservers(getDeckData());
    }
    public Player copy(){
        ArrayList<Card> deck = new ArrayList<>();
        ArrayList<Card> bench = new ArrayList<>();
        ArrayList<Card> field = new ArrayList<>();
        ArrayList<Card> hand = new ArrayList<>();
        for (Card c:this.hand) {
            hand.add(c.copy());
        }
        for (Card c:this.bench) {
            bench.add(c.copy());
        }
        for (Card c:this.field) {
            field.add(c.copy());
        }
        for (Card c:this.deck) {
            deck.add(c.copy());
        }
        return new Player(deck, bench, field, hand);
    }

    private Vector<Vector<String>> getDeckData(){
        Vector<Vector<String>> data = new Vector<>();
        for (Card c:deck) {
            Vector<String> tmp = new Vector<>();
            tmp.add(c.getName());
            tmp.add(String.valueOf(c.getCopies()));
            data.add(tmp);
        }
        return data;
    }

}
