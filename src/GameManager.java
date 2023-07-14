import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameManager extends Observable {

    Player local;
    HashMap<String, String> cardNames;
    public GameManager(){
        this.local = new Player();
        this.cardNames = new HashMap<>();
    }

    private void loadCardNames() throws FileNotFoundException {
        File directoryPath = new File("assets");
        File[] filesList = directoryPath.listFiles();
        Scanner sc = null;
        for(File file : filesList) {
            sc= new Scanner(file);
            String input;
            StringBuffer sb = new StringBuffer();
            while (sc.hasNextLine()) {
                input = sc.nextLine();
                sb.append(input);
            }
            String data = sb.toString();
            JsonArray gsonArr = JsonParser.parseString(data).getAsJsonArray();
            for (JsonElement obj : gsonArr) {
                JsonObject gsonObj = obj.getAsJsonObject();
                cardNames.put(gsonObj.get("cardCode").getAsString(), gsonObj.get("name").getAsString());
            }
        }
    }
    public void initTracker(){
        try {
            loadCardNames();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void updateState(){
        String response;
        try {
            response = API.makeRequest("positional-rectangles");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        local.updateDeck(response);
    }
    public void start(){

        String response;
        try {
            loadCardNames();
            response = API.makeRequest("static-decklist");
            local.setDeck(response);
            setChanged();
            Vector<Vector<String>> deckData = local.getDeckData(cardNames);
            notifyObservers(deckData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        /*
        Runnable runnable = new Runnable() {
            public void run() {
                //updateState();
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);*/
    }

}
