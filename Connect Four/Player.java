public class Player {
    private String name;
    private State pieceColor;
    private int score;

    // constructor
    public Player(String name, State piece) {
        this.name = name;
        this.piece = piece;
        this.score = 0;
    }

    // getters
    public State getName() {
        return this.name;
    }

    public State getPiece() {
        return this.piece;
    }

    public int getScore() {
        return this.score;
    }

    // method to update score
    public void updateScore() {
        this.score++;
    }

}
