public class KnightBoard {
  private int rows;
  private int cols;
  private int[][] board;
  private int[][] moves;
  public KnightBoard(int startingRows, int startingCols) {
    if (startingRows < 1 || startingCols < 1) {
      throw new IllegalArgumentException("Inputs must be one or greater.");
    }
    board = new int[startingRows][startingCols];
    rows = startingRows;
    cols = startingCols;
  }
  public void clear() {
    board = new int[rows][cols];
  }
  public String toString() {
    String output = "";
    for (int[] elem:board) {
      for (int num: elem) {
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
}
