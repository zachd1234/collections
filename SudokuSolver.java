import java.util.*;

public class SudokuSolver {
    private String[][] board = new String[9][9];
    private MyGraphMap graph;

    public SudokuSolver() {
        generateBoard();
        createGraph();
    }

    // Generate a full valid board using backtracking
    private boolean fillBoard(int row, int col) {
        if (row == 9) return true;
        if (col == 9) return fillBoard(row + 1, 0);

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 9; i++) nums.add(i);
        Collections.shuffle(nums);

        for (int num : nums) {
            if (isValidPlacement(row, col, String.valueOf(num))) {
                board[row][col] = String.valueOf(num);
                if (fillBoard(row, col + 1)) return true;
                board[row][col] = "0";
            }
        }
        return false;
    }

    private void generateBoard() {
        // Initialize the board with "0" (blanks)
        for (int i = 0; i < 9; i++) {
            Arrays.fill(board[i], "0");
        }
        fillBoard(0, 0);
    }

    private boolean isValidPlacement(int row, int col, String num) {
        // Check row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i].equals(num) || board[i][col].equals(num)) return false;
        }

        // Check 3x3 box
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;
        for (int r = boxRow; r < boxRow + 3; r++) {
            for (int c = boxCol; c < boxCol + 3; c++) {
                if (board[r][c].equals(num)) return false;
            }
        }
        return true;
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

        // Add all vertices with their current board values
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                String label = "R" + row + "C" + col;
                String value = board[row][col];
                graph.addVertex(label, value);
            }
        }

        // Add edges based on Sudoku constraints
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

                if (val.equals("0")) continue; // skip blank cells

                Set<String> neighbors = graph.getAdjacency(label);
                for (String neighbor : neighbors) {
                    int nRow = Integer.parseInt(neighbor.substring(1, 2));
                    int nCol = Integer.parseInt(neighbor.substring(3, 4));
                    String neighborVal = board[nRow][nCol];
                    if (val.equals(neighborVal)) return false;
                }
            }
        }
        return true;
    }
}

