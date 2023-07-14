import java.util.HashMap;
import java.util.Vector;

public class Player {
    private Deck deck;

    public Player(){
        this.deck = new Deck();
    }

    public Deck getDeck(){
        return deck;
    }
    public Vector<Vector<String>> getDeckData(HashMap<String, String> cardNames){
        Vector<Vector<String>> data = new Vector<>();
        for (Card c:deck.getCards()) {
            Vector<String> tmp = new Vector<>();
            tmp.add(cardNames.get(c.getCardCode()));
            tmp.add(String.valueOf(c.getCopies()));
            data.add(tmp);
        }
        return data;
    }
    public void setDeck(String deckString){
        deck.create(deckString);
    }

    public void updateDeck(String data){

    }

}
