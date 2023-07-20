public class Card {
    private String cardCode;
    private String name;
    private Integer copies;

    public Card(String cardCode, Integer copies){
        this.cardCode = cardCode;
        this.copies = copies;
    }

    private Card(String cardCode, Integer copies, String name){
        this.name=name;
        this.cardCode = cardCode;
        this.copies = copies;
    }

    public String getCardCode(){
        return cardCode;
    }
    public Integer getCopies(){
        return copies;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Card copy(){
        return new Card(this.cardCode, this.copies, this.name);
    }
}
