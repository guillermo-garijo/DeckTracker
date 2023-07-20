import com.google.gson.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameController {

    GameState gameState;
    ArrayList<Rectangle> previousBoardState;
    ArrayList<Rectangle> currentBoardState;
    HashMap<String, String> cardNames;

    public GameController(GameState gameState){
        this.cardNames = new HashMap<>();
        this.previousBoardState=null;
        this.gameState = gameState;
    }
    public void initTracker(){
        boolean inGame=false;
        try {
            loadCardNames();
            while(!inGame){
                if(gameState.initDeck(API.makeRequest("static-decklist"), cardNames)){
                    inGame=true;
                }
            }
        } catch (IOException e) {
            //game closed
            throw new RuntimeException(e);
        }
    }
    public void updateState(){
        try {
            String s = API.makeRequest("positional-rectangles");
            this.currentBoardState=convertToRectangles(s);
            printBoard(currentBoardState);
            /*if(previousBoardState==null){

            }*/
            //do stuff

            //mirar si en bench hay algo con nab
            //mirar si en mano ya no hay hechizo con nab
            //mirar si en bench hay algo con invocar
            //mirar si en mano ya no hay hechizo con invocar
            //mirar si en field hay algo con invoca al atacar
            //
        } catch (IOException e) {
            //gameclosed
            throw new RuntimeException(e);
        }

    }
    public void start(){
        Runnable helloRunnable = new Runnable() {
            public void run() {
                try {
                    updateState();
                }catch (Exception e){
                    System.out.printf(e.toString());
                }

            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(helloRunnable, 0, 1, TimeUnit.SECONDS);
    }
    private ArrayList<Rectangle> convertToRectangles(String data){
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        JsonObject jsonDeckCode =  JsonParser.parseString(data).getAsJsonObject();
        JsonArray jsonRect = jsonDeckCode.get("Rectangles").getAsJsonArray();
        for (JsonElement element: jsonRect) {
            Rectangle rectangle = new Gson().fromJson(element, Rectangle.class);
            rectangles.add(rectangle);
        }
        return rectangles;
    }
    private void printBoard(ArrayList<Rectangle> b){
        for (Rectangle r:b) {
            if(r.isLocal()){
                System.out.println("Name: " + cardNames.get(r.getCardCode()) + ", X: " + r.getTopLeftX() + ", Y: " + r.getTopLeftY());
            }
        }
        System.out.println(" ... ");
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

}
