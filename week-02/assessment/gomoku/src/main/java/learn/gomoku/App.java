package learn.gomoku;
import learn.gomoku.game.Gomoku;
import learn.gomoku.players.Player;


public class App {

    public static void main(String[] args) {
        UiGomoku.welcomeMessage();
        do {
            Gomoku game = UiGomoku.startGame();

            Player currentPlayer;

            while (!game.isOver()){

                currentPlayer = game.getCurrent();
                UiGomoku.displayBoard(game);
                UiGomoku.playerTurn(game, currentPlayer);
            }
            UiGomoku.displayBoard(game);

        }while (UiGomoku.playAgain());

        UiGomoku.endGame();
    }
}