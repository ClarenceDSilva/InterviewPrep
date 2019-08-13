package com.neu.learn;

/*Leetcode #348: Design a Tic-Tac-Toe*/
public class TicTacToe {
	int[] rows;
	int[] cols;
	int diag;
	int revDiag;
	int n;
	
	//Constructor
	public TicTacToe(int n) {
		//Note: The game board needs to be a square matrix
		this.n = n;
		this.rows = new int[n];
		this.cols = new int[n];
	}
	
	/** Player {player} makes a move at ({row}, {col}).
    @param row The row of the board.
    @param col The column of the board.
    @param player The player, can be either 1 or 2.
    @return The current winning condition, can be either:
            0: No one wins.
            1: Player 1 wins.
            2: Player 2 wins. */
	
	public int move(int row, int col, int player) {
		// If player1 makes a move, increment the count. Else, decrement the count
		int move = player == 1 ? 1 : -1;
		
		// Incrementing the count
		rows[row] += move;
		cols[col] += move;
		// Condition for checking if a move is also at a diag cell
		if(row == col) {
			diag += move;
		}
		//*** Condition for checking if a move is also at a revDiag cell
		if(row == n - col - 1) {
			revDiag += move;
		}
		// Adding conditions for winning
		if(Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(revDiag) == n) {
			// Considering the player who is making the move right now is the only one who can win, we can return the player directly 
			return player;
		}else {
			return 0;
		}
	}
}
