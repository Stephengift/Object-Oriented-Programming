public class Game {
    private Grid grid;
    private int connectN;
    private Player[] players;
    private int targetScore;

    //constructor
    public Game(Grid grid, int connectN, int targetScore){
        this.grid = grid;
        this.connectN = connectN;
        this.targetScore = targetScore;
    }
}
