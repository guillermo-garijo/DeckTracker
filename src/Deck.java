import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;
    private String deckCode;

    public Deck(){
        this.deck = new ArrayList<>();
    }
    public void create(String deckString){
        JsonParser parser = new JsonParser();
        JsonObject jsonDeckCode = parser.parse(deckString).getAsJsonObject();
        this.deckCode = jsonDeckCode.get("DeckCode").getAsString();
        JsonObject jsonDeck = jsonDeckCode.get("CardsInDeck").getAsJsonObject();
        for (String key : jsonDeck.keySet()) {
            deck.add(new Card(key, jsonDeck.get(key).getAsInt()));
        }

    }

    public ArrayList<Card> getCards(){
        return deck;
    }

}
