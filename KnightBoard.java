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
}
