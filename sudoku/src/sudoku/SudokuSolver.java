package sudoku;

public class SudokuSolver {
    private final int MAX = 9;
    private int[][] board;

    public SudokuSolver() {
        this.board = this.generateRandomBoard();
    }

    public SudokuSolver(int[][] board) {
        this.board = board;
    }

    private int[][] generateRandomBoard() {
        return new int[][] {
                { 7, 0, 2, 0, 5, 0, 6, 0, 0 },
                { 0, 0, 0, 0, 0, 3, 0, 0, 0 },
                { 1, 0, 0, 0, 0, 9, 5, 0, 0 },
                { 8, 0, 0, 0, 0, 0, 0, 9, 0 },
                { 0, 4, 3, 0, 0, 0, 7, 5, 0 },
                { 0, 9, 0, 0, 0, 0, 0, 0, 8 },
                { 0, 0, 9, 7, 0, 0, 0, 0, 5 },
                { 0, 0, 0, 2, 0, 0, 0, 0, 0 },
                { 0, 0, 7, 0, 4, 0, 2, 0, 3 }
        };
    }

    private boolean isNumberInRow(int row, int number) {
        for (int col = 0; col < MAX; col++) {
            if (board[row][col] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumberInCol(int col, int number) {
        for (int row = 0; row < MAX; row++) {
            if (board[row][col] == number) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumberInBox(int row, int col, int number) {
        final int boxRow = row - row % 3;
        final int boxCol = col - col % 3;

        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPlaceValid(int row, int col, int number) {
        return !isNumberInRow(row, number) &&
                !isNumberInCol(col, number) &&
                !isNumberInBox(row, col, number);
    }

    public boolean solveBoard() {
        for (int row = 0; row < MAX; row++) {
            for (int col = 0; col < MAX; col++) {
                if (board[row][col] == 0) {
                    for (int numberToCheck = 0; numberToCheck <= MAX; numberToCheck++) {
                        if (isPlaceValid(row, col, numberToCheck)) {
                            board[row][col] = numberToCheck;

                            if (solveBoard()) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < MAX; row++) {
            if (row % 3 == 0 && row != 0) {
                result.append("---------------------\n");
            }
            for (int col = 0; col < MAX; col++) {
                if (col % 3 == 0 && col != 0) {
                    result.append("| ");
                }
                result.append(board[row][col]).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
