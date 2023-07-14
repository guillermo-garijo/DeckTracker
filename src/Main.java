public class Main {
    public static void main(String[] args) {
        UI uiManager = new UI();
        GameManager gameManager = new GameManager();
        gameManager.addObserver(uiManager);
        uiManager.start();
        gameManager.initTracker();
        gameManager.start();
    }
}