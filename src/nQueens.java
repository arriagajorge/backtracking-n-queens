public class nQueens {
    
    /**
     * Creates a board of size n.
     * @param n the size of the board
     * @return the board
     */
    public int[][] createBoard(int n){
        int[][] board = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = 0;
            }
        }
        return board;
    }

    /**
     * Coloques a queen in the board.
     * @param board the board
     * @param row the row
     * @param col the column
     */
    public void coloqueQueen(int[][] board, int row, int col){
        board[row][col] = 1;
    }

    /**
     * Removes a queen from the board.
     * @param board the board
     * @param row the row
     * @param col the column
     */
    public void removeQueen(int[][] board, int row, int col){
        board[row][col] = 0;
    }
    
    /**
     * Checks if the queen can be placed in the board.
     * @param board the board
     * @param row the row
     * @param col the column
     * @return true if the queen can be placed, false otherwise
     */
    public boolean canPlace(int[][] board, int row, int col){
        if(canPlaceRow(board, row, col) == true && canPlaceCol(board, row, col) == true && canPlaceDiag(board, row, col) == true){
            return true;
        }
        return false;
    }

    /**
     * Checks if the queen can be placed in the row.
     * @param board the board
     * @param row the row
     * @param col the column
     * @return true if the queen can be placed, false otherwise
     */
    public boolean canPlaceRow(int[][] board, int row, int col){
        for(int i = 0; i < board.length; i++){
            if(board[row][i] == 1){
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the queen can be placed in the column.
     * @param board the board
     * @param row the row
     * @param col the column
     * @return true if the queen can be placed, false otherwise
     */
    public boolean canPlaceCol(int[][] board, int row, int col){
        for(int i = 0; i < board.length; i++){
            if(board[i][col] == 1){
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the queen can be placed in the diagonal.
     * @param board the board
     * @param row the row
     * @param col the column
     * @return true if the queen can be placed, false otherwise
     */
    public boolean canPlaceDiag(int[][] board, int row, int col){
        int colAux = col;
        int rowAux = row;
        while(rowAux >= 0 && colAux >= 0){
            if(rowAux == -1){
                rowAux = 0;
            }
            if(colAux == -1){
                colAux = 0;
            }

            if(board[rowAux][colAux] == 1){
                return false;
            }
            rowAux--;
            colAux--;
        }

        colAux = col;
        rowAux = row;
        while(rowAux < board.length && col < board.length){
            if(rowAux == board.length){
                rowAux = board.length - 1;
            }
            if(colAux == board.length){
                colAux = board.length - 1;
            }

            if(board[rowAux][colAux] == 1){
                return false;
            }
            rowAux++;
            colAux++;
        }

        colAux = col;
        rowAux = row;
        while(rowAux >= 0 && colAux < board.length){
            if(rowAux == -1){
                rowAux = 0;
            }
            if(colAux == board.length){
                colAux = board.length - 1;
            }

            if(board[rowAux][colAux] == 1){
                return false;
            }
            rowAux--;
            colAux++;
        }

        colAux = col;
        rowAux = row;
        while(rowAux < board.length && colAux >= 0){
            if(rowAux == board.length){
                rowAux = board.length - 1;
            }
            if(colAux == -1){
                colAux = 0;
            }

            if(board[rowAux][colAux] == 1){
                return false;
            }
            rowAux++;
            colAux--;
        }
        return true;
    }


    /**
     * Solves the N-Queens problem by backstracking for n queens.
     * @param n the number of queens
     */
    public void solveNQueens(int n){
        int[][] board = createBoard(n);
        int colAux = 0;
        int rowAux = 0;

        int[] rowAnt = new int[n];
        int[] colAnt = new int[n];

        for(int i = 0; i < n; i++){
            rowAnt[i] = -1;
            colAnt[i] = -1;
        }

        while(rowAux < n){
            if(colAux >= n){
                rowAux--;
                removeQueen(board, rowAnt[rowAux], colAnt[rowAux]);
                colAux = colAnt[rowAux] + 1;
                printBoard(board);
                continue;
            }
            if(canPlace(board, rowAux, colAux)){
                coloqueQueen(board, rowAux, colAux);
                rowAnt[rowAux] = rowAux;
                colAnt[rowAux] = colAux;
                rowAux++;
                colAux = 0;
                printBoard(board);
                continue;
            }
            colAux++;
        }



        // while (rowAux < n) {
        //     if(colAux == n){
        //         removeQueen(board, rowAnt[rowAux], colAnt[rowAux]); 
        //         colAux = colAnt[rowAux] + 1;
        //         rowAux--;
        //         continue;
        //     }
        //     if(canPlace(board, rowAux, colAux)){
        //         coloqueQueen(board, rowAux, colAux);
        //         rowAnt[rowAux] = rowAux;
        //         colAnt[rowAux] = colAux;
        //         rowAux++;
        //         colAux = 0;
        //         printBoard(board);
        //         continue;
        //     }
        //     colAux++;
        // }
        // printBoard(board);
    }



    /**
     * Prints the board.
     * @param board the board to be printed
     */
    public void printBoard(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }
}