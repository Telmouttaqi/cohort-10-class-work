package learn.gomoku;
import learn.gomoku.game.Gomoku;
import learn.gomoku.game.Result;
import learn.gomoku.game.Stone;
import learn.gomoku.players.HumanPlayer;
import learn.gomoku.players.Player;
import learn.gomoku.players.RandomPlayer;



import java.util.Locale;
import java.util.Scanner;

public class UiGomoku {

    // Welcome message method
    public static void welcomeMessage() {
        System.out.println("Welcome to Gomoku");
        System.out.println(("=").repeat(17));

    }



    // create game object from Gomoku
    // using two players as arguments
    // display randomizing
    // display who's going to start first
    public static Gomoku startGame() {

        Gomoku game = new Gomoku(playerSelected(1), playerSelected(2));
        System.out.println("\n");
        System.out.println("Randomizing\n");
        System.out.print(game.getCurrent().getName() + " goes first");
        return game;
    }



    // this method return the user input
    // choices between human or random player 1-2
    // ask for the userName
    public static Player playerSelected(int playerNumber) {

        Scanner console = new Scanner(System.in);
        System.out.println("Player " + playerNumber + " is: ");
        System.out.println("1. Human");
        System.out.println("2. Random Player");
        System.out.print("Select [1-2]: ");

        int playerChoice = Integer.parseInt(console.nextLine());

        Player player = null;

        if (playerChoice == 1) {
            System.out.print("Player," + playerNumber + " enter your name: ");
            player = new HumanPlayer(console.nextLine());

        } else if (playerChoice == 2) {
            player = new RandomPlayer();
            System.out.print("Player, " + playerNumber + " name is " + player.getName());

        } else {
            System.out.println(" Out of range [1 - 2]");
        }
        return player;

    }



    // Using Gomoku game to fill the baord char[][]
    // Display the board
    public static void displayBoard(Gomoku game) {
        gameBoard board = new gameBoard(game.getStones());
        String cellsSpaces = "%3s";
        System.out.println("");
        for (int row = 0; row <= Gomoku.WIDTH; row++) {
            for (int column = 0; column <= Gomoku.WIDTH; column++) {
                if (row == 0) {
                    System.out.printf(cellsSpaces, column);
                } else if (column == 0) {
                    System.out.print("");
                    System.out.printf("%n%s", String.format(cellsSpaces, row));
                } else {
                    char symbol = board.getCell(row - 1 , column - 1   );
                    System.out.printf(cellsSpaces, symbol == 0 ? '_' : symbol);
                }
            }
        }
        System.out.println();
    }


    public static void playerTurn(Gomoku game, Player currentPlayer) {
        Scanner console = new Scanner(System.in);
        System.out.println(currentPlayer.getName() + "'s Turn");

        Stone stone = currentPlayer.generateMove(game.getStones());
        int row;
        int column;
        boolean human = stone == null;


        if (human) {
            System.out.println("Enter Row: ");
            row = console.nextInt() - 1;
            System.out.println("Enter Column: ");
            column = console.nextInt() - 1;
            stone = new Stone(row,column, game.isBlacksTurn());
        }

        Result result;
        result = game.place(stone);
        System.out.println(result);
    }

    // void method display exit game.
    public static void endGame() {
        System.out.println("Exiting..");
    }

    // boolean method playAgain method
    // ask if the user want to play again
    public static boolean playAgain() {
        Scanner console = new Scanner(System.in);
        System.out.println("");
        System.out.println("Play Again [Y/N]?: ");
        String playAgainInput = console.nextLine().toLowerCase(Locale.ROOT);
        if (playAgainInput.equals("y")) {
            return true;
        } else {
            return false;
        }
    }
}