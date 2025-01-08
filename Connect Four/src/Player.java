public class Player {
    private String name;
    private State pieceColor;
    private int score;

    // constructor
    public Player(String name, State piece) {
        this.name = name;
        this.pieceColor = piece;
        this.score = 0;
    }

    // getters
    public String getName() {
        return this.name;
    }

    public State getPiece() {
        return this.pieceColor;
    }

    public int getScore() {
        return this.score;
    }

    // method to update score
    public void updateScore() {
        this.score++;
    }

}
