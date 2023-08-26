import java.util.ArrayList;
import java.util.HashMap;

public class BoardState {
    private ArrayList<Rectangle> others;
    private ArrayList<Rectangle> localHand;
    private ArrayList<Rectangle> localBench;
    private ArrayList<Rectangle> localField;
    private ArrayList<Rectangle> spellStack;
    private ArrayList<Rectangle> enemyField;
    private ArrayList<Rectangle> enemyBench;
    private ArrayList<Rectangle> enemyHand;
    private HashMap<String, String> cardNames;

    public BoardState(HashMap<String,String> cardNames){
        this.enemyField=new ArrayList<>();
        this.enemyBench=new ArrayList<>();
        this.localBench=new ArrayList<>();
        this.localField=new ArrayList<>();
        this.localHand=new ArrayList<>();
        this.enemyHand=new ArrayList<>();
        this.spellStack=new ArrayList<>();
        this.cardNames=cardNames;
        this.others=new ArrayList<>();
    }
    public void addToOthers(Rectangle r){
        others.add(r);
    }
    public boolean hasOthers(){
        return !others.isEmpty();
    }
    public void addToLocalHand(Rectangle r){
        localHand.add(r);
    }
    public void addToLocalBench(Rectangle r){
        localBench.add(r);
    }
    public void addToLocalField(Rectangle r){
        localField.add(r);
    }
    public void addToEnemyHand(Rectangle r){
        enemyHand.add(r);
    }
    public void addToEnemyField(Rectangle r){
        enemyField.add(r);
    }
    public void addToEnemyBench(Rectangle r){
        enemyBench.add(r);
    }
    public void addToSpellStack(Rectangle r){
        spellStack.add(r);
    }
    //TODO: convertir en override de equals
    public boolean equalBoardStates(BoardState previousState){
        if(!this.localHand.equals(previousState.localHand)){
            return false;
        }
        if(!this.localField.equals(previousState.localField)){
            return false;
        }
        if(!this.localBench.equals(previousState.localBench)){
            return false;
        }
        if(!this.spellStack.equals(previousState.spellStack)){
            return false;
        }
        if(!this.enemyBench.equals(previousState.enemyBench)){
            return false;
        }
        if(!this.enemyField.equals(previousState.enemyField)){
            return false;
        }
        if (!this.enemyHand.equals(previousState.enemyHand)){
            return false;
        }
        return true;
    }
    public void printBoard(){
        localHand.forEach((r) -> {System.out.println("(lhand)Name:(" + r.getCardCode() + ")" + cardNames.get(r.getCardCode()) + ", X: " + r.getTopLeftX() + ", Y: " + r.getTopLeftY());});
        localBench.forEach((r) -> {System.out.println("(lbench)Name:(" + r.getCardCode() + ")" + cardNames.get(r.getCardCode()) + ", X: " + r.getTopLeftX() + ", Y: " + r.getTopLeftY());});
        localField.forEach((r) -> {System.out.println("(lfield)Name:(" + r.getCardCode() + ")"+ cardNames.get(r.getCardCode()) + ", X: " + r.getTopLeftX() + ", Y: " + r.getTopLeftY());});
        spellStack.forEach((r) -> {System.out.println("(spells)Name:(" + r.getCardCode() + ")" +cardNames.get(r.getCardCode()) + ", X: " + r.getTopLeftX() + ", Y: " + r.getTopLeftY());});
        enemyField.forEach((r) -> {System.out.println("(efield)Name:(" + r.getCardCode() + ")" +cardNames.get(r.getCardCode()) + ", X: " + r.getTopLeftX() + ", Y: " + r.getTopLeftY());});
        enemyBench.forEach((r) -> {System.out.println("(ebench)Name:(" + r.getCardCode() + ")"+ cardNames.get(r.getCardCode()) + ", X: " + r.getTopLeftX() + ", Y: " + r.getTopLeftY());});
        enemyHand.forEach((r) -> {System.out.println("(ehand)Name:(" + r.getCardCode() + ")"+ cardNames.get(r.getCardCode()) + ", X: " + r.getTopLeftX() + ", Y: " + r.getTopLeftY());});
        others.forEach((r) -> {System.out.println("(others)Name:(" + r.getCardCode() + ")"+ cardNames.get(r.getCardCode()) + ", X: " + r.getTopLeftX() + ", Y: " + r.getTopLeftY());});

        System.out.println(" ... ");
    }


    public boolean checkDraw(BoardState previousBoardState) {
        if(){
            return false;
        }

    }
}
