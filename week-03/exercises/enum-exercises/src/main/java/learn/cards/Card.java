package learn.cards;

public class Card {

// 1. Add a Suit and Rank field the Card class.

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }
//Rank rank;

// 2. Add a constructor that accepts a Suit and Rank and sets the appropriate fields.

    public String getName(){




        switch (suit){
            case CLUBS:
                break;
            case HEARTS:
                break;
            case SPADES:
                break;
            case DIAMONDS:
                break;
        }
        return String.format("%s of %s",rank.getName(),suit.getName());
    }

    // 3. Add getters for both suit and rank.


        // 4. Complete the getName method.
        // Given a card's suit and rank, getName returns a String in the format:
        // "[rank] of [suit]"
        //return rank.getName() + " of " + suit.getName();

        // Examples:
        // Ace of Clubs
        // 5 of Diamonds
        // King of Hearts
        // 9 of Spades



        // Note: it's unlikely you'll be able to use the enum name directly since enum naming conventions
        // don't match the required Output

    }

