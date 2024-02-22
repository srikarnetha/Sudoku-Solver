public class SudokuSolver {
    
        public boolean isSafe(char[][] board, int row, int col, int num) {
            // Check column
            for(int i = 0; i < board.length; i++) {
                if(board[i][col] == (char)(num + '0')) {
                    return false;
                }
            }
           
            // Check row
            for(int j = 0; j < board.length; j++) {
                if(board[row][j] == (char)(num + '0')) {
                    return false;
                }
            }
           
            // Check grid
            int startRow = 3 * (row / 3);
            int startCol = 3 * (col / 3);
           
            for(int i = startRow; i < startRow + 3; i++) {
                for(int j = startCol; j < startCol + 3; j++) {
                    if(board[i][j] == (char)(num + '0')) {
                        return false;
                    }
                }
            }
            return true;
        }
       
        public boolean solveSudoku(char[][] board, int row, int col) {
            if(row == board.length) {
                return true;
            }
           
            int nextRow = 0;
            int nextCol = 0;
           
            if(col == board.length - 1) {
                nextRow = row + 1;
                nextCol = 0;
            } else {
                nextRow = row;
                nextCol = col + 1;
            }
           
            if(board[row][col] != '.') {
                if(solveSudoku(board, nextRow, nextCol)) {
                    return true;
                }
            } else {
                // Fill the empty cell
                for(int num = 1; num <= 9; num++) {
                    if(isSafe(board, row, col, num)) {
                        board[row][col] = (char)(num + '0');
                        if(solveSudoku(board, nextRow, nextCol))
                            return true;
                        else
                            board[row][col] = '.';
                    }
                }
            }
                          
            return false;
        }
       
        public void solve(char[][] board) {
            solveSudoku(board, 0, 0);
        }
       
        public static void main(String[] args) {
            // Create an instance of SudokuSolver
            SudokuSolver solver = new SudokuSolver();
            
            // Define the sudoku board
            char[][] board = {
                {'2','.','.','3','.','.','.','.','.'},
                {'8','.','4','.','6','2','.','.','3'},
                {'.','1','3','8','.','.','2','.','.'},
                {'.','.','.','.','2','.','3','9','.'},
                {'5','.','7','.','.','.','6','2','1'},
                {'.','3','2','.','.','6','.','.','.'},
                {'.','2','.','.','.','9','1','4','.'},
                {'6','.','1','2','5','.','8','.','9'},
                {'.','.','.','.','.','1','.','.','2'}
            };
            
            // Solve the sudoku
            solver.solve(board);
            
            // Print the solved sudoku board
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
    
    

