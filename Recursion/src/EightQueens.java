
public class EightQueens {
	public static int[][] board;
	
	//constructor - initializes board of zeros
	public EightQueens(int n){
		board = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = 0;
			}
		}
	
	}
	
	//checks if can place
	public boolean canPlace(int[][] board, int row, int col){
		//checks to the right 
		for(int i = 0; i < col; i++){
			if(board[row][i] == 1){
				return false;
			}
		}
		//checks upper diagonal
		for (int r = row, c = col; r >= 0 && c >= 0; r--, c--) {
			if (board[r][c] == 1) {
				return false;
			}
		}
		//checks lower diagonal
		for (int r = row, c = col; r < board.length && c >= 0; r++, c--) {
			if (board[r][c] == 1) {
				return false;
			}
		}
		return true;
	}
	
	//place queens, uses backtracking
	public boolean place(int board[][], int col, int n)
    {
        if (col >= n)
            return true;
 
        for (int row = 0; row < n; row++)
        {
            if (canPlace(board, row, col))
            {
                board[row][col] = 1;
                if (place(board, col + 1, n) == true){
                    return true;
                }
                board[row][col] = 0; 
            }
        }
        return false;
    }
 
	
	//helper function to print results
	public void print(int n){
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(" " + board[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]){
		EightQueens q1 = new EightQueens(4);
		q1.place(board, 0, 4);
		q1.print(4);
		
	}
}
