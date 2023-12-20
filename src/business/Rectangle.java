package business;

public class Rectangle {

    private int CardID;
    private String  CardCode;
    private int TopLeftX;
    private int TopLeftY;
    private int Width;
    private int Height;
    private boolean LocalPlayer;

    public Boolean isLocal(){
        return LocalPlayer;
    }

    public String getCardCode(){
        return CardCode;
    }

    public Integer getTopLeftX(){
        return TopLeftX;
    }
    public Integer getTopLeftY(){
        return TopLeftY;
    }

    public boolean isLocalHand(){
        return (TopLeftY<=86 && TopLeftY>=67) || (TopLeftY<=313 && TopLeftY>=247);
    }
    public boolean isLocalBench(){
        return TopLeftY==260;
    }
    public boolean isLocalField(){
        return TopLeftY==450;
    }
    //TODO: buscar la posicion
    public boolean isEnemyHand(){
        return false; //TopLeftY<=85 && TopLeftY>=67;
    }
    public boolean isEnemyBench(){
        return TopLeftY==980;
    }
    public boolean isEnemyField(){
        return TopLeftY==790;
    }
    public boolean isSpellStack(){
        return TopLeftY==598;
    }
    @Override
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(!(o instanceof Rectangle)){
            return false;
        }
        Rectangle r = (Rectangle) o;
        return this.CardID == r.CardID &&
                this.CardCode.equals(r.CardCode);// &&
                //this.TopLeftX == r.TopLeftX &&
                //this.TopLeftY == r.TopLeftY; // &&
                //this.Width == r.Width &&
                //this.Height == r.Height;

    }

    public boolean isFace() {
        return this.getCardCode().equals("face");
    }
}
