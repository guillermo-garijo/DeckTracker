import com.google.gson.*;

import java.util.ArrayList;
import java.util.HashMap;

public class GameState {

    private Player enemyPlayer;
    private Player localPlayer;


    public GameState(Player enemyPlayer, Player localPlayer){
        this.enemyPlayer=enemyPlayer;
        this.localPlayer=localPlayer;
    }
    public boolean initDeck(String localDeckData, HashMap<String, String> cardNames){
        ArrayList<Card> deck = generateDeck(localDeckData);
        if(deck==null){
            return false;
        }
        for (Card c:deck) {
            c.setName(cardNames.get(c.getCardCode()));
        }
        this.localPlayer.setDeck(deck);
        return true;
    }
    public GameState copy(){
        return new GameState(this.enemyPlayer.copy(), this.localPlayer.copy());
    }
    private ArrayList<Card> generateDeck(String localDeckData){
        ArrayList<Card> deck = new ArrayList<>();
        JsonObject jsonData =  JsonParser.parseString(localDeckData).getAsJsonObject();
        if(jsonData.get("CardsInDeck").isJsonNull()){
            return null;
        }
        JsonObject jsonCards = jsonData.get("CardsInDeck").getAsJsonObject();
        if(jsonCards.entrySet().isEmpty()){
            return null;
        }
        for (String key: jsonCards.keySet()) {
            deck.add(new Card(key, jsonCards.get(key).getAsInt()));
        }
        return deck;
    }


}
