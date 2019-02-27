import java.util.*;
public class KnightBoard {
  private int rows;
  private int cols;
  private int[][] board;
  private int[] moves;
  private int n;
  private int[][] optimizedBoard;
  private Node[] optimizedOptions;
  private class Node implements Comparable<Node> {
    private int row, col;
    public Node(int rowIn, int colIn) {
      row = rowIn;
      col = colIn;
    }
    public int compareTo(Node b) {
      Node a = this;
      return optimizedBoard[a.row][a.col] - optimizedBoard[b.row][b.col];
    }
    public Node move(Node b) {
      Node a = this;
      return new Node(a.row + b.row, a.col + b.col);
    }
  }
  public KnightBoard(int startingRows, int startingCols) {
    if (startingRows < 1 || startingCols < 1) {
      throw new IllegalArgumentException("Inputs must be one or greater.");
    }
    board = new int[startingRows][startingCols];
    rows = startingRows;
    cols = startingCols;
    optimizedBoard = new int[rows][cols];
    n = startingCols * startingRows;
    moves = new int[] {1, 2, 1, -2, -1, 2, -1, -2, 2, 1, 2, -1, -2, 1, -2, -1};
    optimizedOptions = new Node[] { new Node(1, 2), new Node(1, -2), new Node(-1, 2), new Node(-1, -2), new Node(2, 1), new Node(2, -1), new Node(-2, 1), new Node(-2, -1) };
  }
  public void initializeOBoard() {
    for (int i = 0; i < rows; i++) {
      for (int i2 = 0; i2 < cols; i2++) {
        if (i < rows - 2 && i2 < cols - 2 && i > 1 && i2 > 1) {
          optimizedBoard[i][i2] = 8;
        }
        else {
          for (Node inQuestion:optimizedOptions) {
            int newRow = i + inQuestion.row;
            int newCol = i2 + inQuestion.col;
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
              optimizedBoard[i][i2] += 1;
            }
          }
        }
      }
    }
  }
  public void clear() {
    board = new int[rows][cols];
  }
  public String toString() {
    String output = "";
    for (int[] elem:board) {
      for (int num:elem) {
        if (num == 0) {
          output += " _ ";
        }
        else if (num / 10 == 0) {
          output += " " + num + " ";
        }
        else {
          output += num + " ";
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
  private boolean addKnight(int r, int c, int move) {
    if (r < 0 || r >= rows || c < 0 || c >= cols) return false;
    else if (board[r][c] != 0) return false;
    board[r][c] = move;
    return true;
  }
  private boolean removeKnight(int r, int c) {
    if (r < 0 || r >= rows || c < 0 || c >= cols) return false;
    else if (board[r][c] == 0) return false;
    board[r][c] = 0;
    return true;
    }
  public boolean solve(int r, int c) {
    exception();
    return solveH(r, c, 1);
  }
  private boolean solveH(int r, int c, int move) {
    //if (r < 0 || r >= rows || c < 0 || c >= cols) return false; //If the spot is outside the board.
    //else if (board[r][c] != 0) return false; //If the spot has already been visited.
    if (move == n) return true; //If the spot hasn't been visited and is the final move.
    if (addKnight(r, c, move)) {
      for (int i = 0; i < moves.length; i += 2) {
        //System.out.println(this);
        int rInc = moves[i];
        int cInc = moves[i + 1];
        if (solveH(r + rInc, c + cInc, move + 1)) return true;
        }
        removeKnight(r, c);
      }
      //System.out.println(this);
      return false;
    }
    public int countSolutions(int startRow, int startCol) {
      return countSolutionsHelper(0, 0, 1);
    }
    private int countSolutionsHelper(int r, int c, int move) {
      int total = 0;
      if (move > n) return 1;
      if (addKnight(r, c, move)) {
        if (move == n) total++;
        else {
          for (int i = 0; i < moves.length; i += 2) {
          //System.out.println(this);
          int rInc = moves[i];
          int cInc = moves[i + 1];
          total += countSolutionsHelper(r + rInc, c + cInc, move + 1);
          }
        }
          removeKnight(r, c);
        }
        //System.out.println(this);
        return total;
      }
    private boolean solveOptim(Node curr, int move) {
      if (move > n) return true;
      return false;
    }
  }
