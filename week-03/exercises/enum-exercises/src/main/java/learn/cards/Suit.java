package learn.cards;

public enum Suit {

    // they don't change same as a const

    SPADES("spades"),
    HEARTS("hearts"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs");


    //  how to define Enum

    private final String name;

    Suit(String name){
        this.name = name;
    }
}


