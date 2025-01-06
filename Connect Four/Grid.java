//Grid class that represents the 2D Matrix the game is played on
public class Grid {
    private int rows;
    private int columns;
    private int[][] grid;

    //constructor
    public Grid(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        initGrid();
    }
    //initialize initGrid()
    public void initGrid(){
        this.grid = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j<columns; j++){
                grid[i][j] = State.EMPTY.ordinal();
            }
        }
    }
    
    //getters
    public int getGrid(){
        return this.grid;
    }

    //player places piece according to the column
    public int placePiece(int column, State piece){
        //if a player places a token into a negative index or a index greater than 7 X 6
        if(column < 0 || column >= this.columns){
            throw new Error("Invalid column");
        }
        //if a player playes a token that is not red or yellow
        if(piece == State.EMPTY){
            throw new Error("Invalid piece");
        }
        //Place the piece in the lowest empty row
        for(int row = this.rows -1; row >=0; row--){
            if(this.grid[row][column] == State.EMPTY.ordinal()){
                this.grid[row][column] = piece.ordinal();
                return row;
            }
        }
        return -1;
    }

    //check if a player currently has 4 pieces - horizontally, vertically, or diagonally
    public boolean checkWin (int connectN, int row, int column, State piece){
        //check horizontal
        int count = 0;
        for(int c = 0; c< this.columns; c++){
            if(this.grid[row][c] == piece.ordinal()){
                count++;
            }else{
                count = 0;
            }
            if(count == connectN){
                return true;
            }
        }
        //check vertical
        count = 0;
        for(int r = 0; r < this.rows, r++){
            if(this.grid[r][column] == piece.ordinal()){
                count++;
            }else{
                count = 0;
            }
            if(count == connectN){
                return true;
            }
        }

    }
    
}
