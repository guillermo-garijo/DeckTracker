public class Rectangle {

    private Integer CardID;
    private String  CardCode;
    private Integer TopLeftX;
    private Integer TopLeftY;
    private Integer Width;
    private Integer Height;
    private Boolean LocalPlayer;

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

    public Boolean isHand(){
        return TopLeftY<=85 && TopLeftY>=67;
    }

    public Boolean isBench(){
        return TopLeftY==260 || TopLeftY==980;
    }

    public Boolean isField(){
        return TopLeftY==790 || TopLeftY==480;
    }

}
