public class KnightBoard {
  private int rows;
  private int cols;
  private int[][] board;
  private int[][] moves;
  private int n;
  public KnightBoard(int startingRows, int startingCols) {
    if (startingRows < 1 || startingCols < 1) {
      throw new IllegalArgumentException("Inputs must be one or greater.");
    }
    board = new int[startingRows][startingCols];
    rows = startingRows;
    cols = startingCols;
    n = startingCols * startingRows;
  }
  public void clear() {
    board = new int[rows][cols];
  }
  public String toString() {
    String output = "";
    for (int[] elem:board) {
      for (int num:elem) {
        if (num == 0) {
          output += "_ ";
        }
        else if (num / 10 == 0) {
          output += " " + num + " ";
        }
        else {
          output += num;
        }
      }
      output += "\n";
    }
    return output;
  }
  public void exception() {
    for (int[] elem:board) {
      for (int num:elem) {
        if (num != 0) throw new IllegalStateException("Board must be filled with zeros.");
      }
    }
  }
  private boolean addKnight(int r, int c, int x, int y, int move) {
    try {
      if (board[r+x][c+y] == 0) {
        board[r+x][c+y] = move;
        return true;
      }
      else {
        return false;
      }
    }
    catch (Exception e) {
      return false;
    }
  }
  public boolean solve(int r, int c) {
    exception();
    return solveH(r, c, 0);
  }
  private boolean solveH(int r, int c, int move) {
    if (r < 0 || r >= rows || c < 0 || c >= cols) return false; //If the spot is outside the board.
    else if (board[r][c] != 0) return false; //If the spot has already been visited.
    else if (move == n) return true; //If the spot hasn't been visited and is the final move.
    else {
      return true;
    }
  }
}
