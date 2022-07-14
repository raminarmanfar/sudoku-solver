import sudoku.SudokuSolver;

public class Main {
    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        System.out.println("Initial board: ");
        System.out.println(sudokuSolver);

        if (sudokuSolver.solveBoard()) {
            System.out.println("Board Solved: ");
            System.out.println(sudokuSolver);
        } else {
            System.out.println("Board is not valid!");
        }

    }
}
