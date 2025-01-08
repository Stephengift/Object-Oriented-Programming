import java.util.Scanner;

public class Game {
    static Scanner input = new Scanner(System.in);
    private Grid grid;
    private int connectN;
    private Player[] players;
    private int targetScore;

    // constructor
    public Game(Grid grid, int connectN, int targetScore) {
        this.grid = grid;
        this.connectN = connectN;
        this.targetScore = targetScore;

        this.players = new Player[] {
                new Player("Player 1", State.YELLOW),
                new Player("Player 2", State.RED)
        };
    }

    private void printBoard() {
        int[][] grid = this.grid.getGrid();
        for (int i = 0; i < grid.length; i++) {
            String row = "";
            for (int piece : grid[i]) {
                if (piece == State.EMPTY.ordinal()) {
                    row += "0";
                } else if (piece == State.YELLOW.ordinal()) {
                    row += "Y";
                } else if (piece == State.RED.ordinal()) {
                    row += "R";
                }

            }
            System.out.println(row);
        }
        System.out.println();
    }

    private int[] playMove(Player player) {
        printBoard();
        System.out.println(player.getName() + " turn");
        int columnCount = this.grid.getColumnCount();

        System.out.print("Enter column between 0 and " + (columnCount - 1) + " ");
        int moveColumn = input.nextInt();
        int moveRow = this.grid.placePiece(moveColumn, player.getPiece());
        return new int[] { moveRow, moveColumn };
    }

    private Player playRound() {
        while (true) {
            for (Player player : this.players) {
                int[] pos = playMove(player);
                int row = pos[0];
                int column = pos[1];
                State pieceColour = player.getPiece();
                if (this.grid.checkWin(this.connectN, row, column, pieceColour)) {
                    player.updateScore();
                    return player;
                }
            }
        }
    }

    public void play() {
        int maxScore = 0;
        Player winner = null;
        while (maxScore < this.targetScore) {
            winner = playRound();
            System.out.println(winner.getName() + " won the round");
            maxScore = Math.max(winner.getScore(), maxScore);

            this.grid.initGrid();
        }
        System.out.println(winner.getName() + " won the game");
    }
}
