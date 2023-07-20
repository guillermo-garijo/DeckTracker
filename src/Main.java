public class Main {
    public static void main(String[] args) {
        Player local = new Player();
        Player enemy = new Player();
        LocalUI uiManager = new LocalUI();
        local.addObserver(uiManager);
        GameState gameState = new GameState(enemy, local);
        GameController gameController = new GameController(gameState);
        uiManager.start();
        gameController.initTracker();
        gameController.start();
    }
}