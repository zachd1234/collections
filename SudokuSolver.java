import java.util.*;

public class SudokuSolver {
    private String[][] board = new String[9][9];
    private MyGraphMap graph;

    public SudokuSolver() {
        generateBoard();
        createGraph();
        fillBoard(0,0);
    }

    // Generate a full valid board using backtracking
    private boolean fillBoard(int row, int col) {
        if (row == 9) {
            return true;
        }
        
        if (col == 9) {
            return fillBoard(row + 1, 0);
        }

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            nums.add(i);
        }
        Collections.shuffle(nums);

          for (int num : nums) {  
            System.out.println("Trying number " + String.valueOf(num) + " at position (" + row + ", " + col + ")");  
            board[row][col] = String.valueOf(num); // Place the number  
            if (validateBoard() && fillBoard(row, col + 1)) {  
                return true; // Proceed if valid  
            }  
            board[row][col] = "0"; //Otherwise, backtrack 
        }  
        return false;  
    }

    private void generateBoard() {
        for (int i = 0; i < 9; i++) {
            Arrays.fill(board[i], "0");
        }
    }


    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) System.out.println("------+-------+------");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) System.out.print("| ");
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void createGraph() {
        graph = new MyGraphMap();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                String label = "R" + row + "C" + col;
                String value = board[row][col];
                graph.addVertex(label, value);
            }
        }

        for (int row1 = 0; row1 < 9; row1++) {
            for (int col1 = 0; col1 < 9; col1++) {
                String label1 = "R" + row1 + "C" + col1;
                for (int row2 = 0; row2 < 9; row2++) {
                    for (int col2 = 0; col2 < 9; col2++) {
                        if (row1 == row2 && col1 == col2) continue;
                        boolean sameRow = row1 == row2;
                        boolean sameCol = col1 == col2;
                        boolean sameBox = (row1 / 3 == row2 / 3) && (col1 / 3 == col2 / 3);
                        if (sameRow || sameCol || sameBox) {
                            String label2 = "R" + row2 + "C" + col2;
                            graph.addEdge(label1, label2);
                        }
                    }
                }
            }
        }
    }
    
   public boolean validateBoard() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                String label = "R" + row + "C" + col;
                String val = board[row][col];

                if (val.equals("0")) continue;
               
                if (graph.noAdjDups(label)) {
                    return false; //there is a duplicate
                }
            }
        }
        return true;
    }

    // Optional: Main method for quick testing
    public static void main(String[] args) {
        SudokuSolver solver = new SudokuSolver();
        solver.printBoard();
    }
}

