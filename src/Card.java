public class Card {
    private String cardCode;
    private String name;
    private Integer copies;

    public Card(String cardCode, Integer copies){
        this.cardCode = cardCode;
        this.copies = copies;
    }

    public String getCardCode(){
        return cardCode;
    }
    public Integer getCopies(){
        return copies;
    }
}
