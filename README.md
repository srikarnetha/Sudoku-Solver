# Sudoku-Solver


A sudoku solution must satisfy all of the following rules:
Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.




Code
StartingRow = 3*(row/3) & StartingCol = 3*(col/3)
StartingRow = row - row%3 & StartingCol = col - col%3
