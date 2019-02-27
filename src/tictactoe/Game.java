package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Game {
	
	static private Player player1 = new Player("One");
	static private Player player2 = new Player("Two");
	static private char turn;
	static private char[][] board = new char [3][3];
	static private Random ran = new Random();
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Insert Name Player One");
		player1.setName(scan.next());
		System.out.println("Insert Name Player Two");
		player2.setName(scan.next());
			
		while(player1.getScore() < 3 && player2.getScore() < 3) {
			
			System.out.println("Game TicTacToe Starts Best of 3");
			System.out.println("Player "+player1.getName()+" Score: "+player1.getScore());
			System.out.println("Player "+player2.getName()+" Score: "+player2.getScore());
			int random = ran.nextInt(2);
			
			if(random == 1) {
				System.out.println("Player "+ player1.getName()+ " First");
			} else System.out.println("Player "+ player2.getName()+ " First");
			
			setBoard();
			play(random);
		
		}
		
		if(player1.getScore() == 3) {
			System.out.println("Game Over Player "+player1.getName()+" Wins!!!");
		}
		else
			System.out.println("Game Over Player "+player2.getName()+" Wins!!!");
		
		
		
	}
	
	/** 
	 * Random : Integer Value that holds the which player's turn
	 * */
	public static void play(int random) {
		boolean playing = true;
		turn = 'X';
		int row = 0;
		int column = 0;
		Scanner scan = new Scanner(System.in);
		
		while(playing) {
			System.out.println("Enter row and column ex. 1 1");
			boolean empty = true;
			
			//check if the array is filled
			while(empty) {
			row = Integer.parseInt(scan.next())-1;
			column = Integer.parseInt(scan.next())-1;
			if(board[row][column] == '_') {
			board[row][column] = turn;
			empty = false;
			}
			else System.out.println("Oops box is filled. Try Again"); 
				
			}
			
			//check if there is a winner
			if(check(row,column)) {
				playing = false;
				
				if(random == 1) {
					if(turn == 'X') {
						player1.setScore();
						System.out.println("Player "+ player1.getName()+" wins!");
					}
					else {
						player2.setScore();
						System.out.println("Player "+ player2.getName()+" wins!");
					}
				}
				else {
					if(turn == 'X') {
						player2.setScore();
						System.out.println("Player "+ player2.getName()+" wins!");
					}
					else {
						player2.setScore();
						System.out.println("Player "+ player2.getName()+" wins!");
					}
				}
			}
			
			//check if draw
			if(draw()) {
				playing = false;
				System.out.println("Good Game Its a Draw!");
			}
			
			//print the board
			printBoard();
			
			//change turns
			if(turn == 'X') {
				turn = 'O';
			}else turn = 'X';
			
			if( turn == 'X' && playing != false ) {
				System.out.println("Player 'X' Turns to play");
			}
			else if( turn == 'O' && playing != false ) {
				System.out.println("Player 'O' Turns to play");
			}
		}
	}
	
	public static boolean check(int moveRow, int moveColumn) {
		
		if(board[moveRow][0] == board[moveRow][1] && board[moveRow][0] == board[moveRow][2])
			return true;
		if(board[0][moveColumn] == board[1][moveColumn] && board[0][moveColumn] == board[2][moveColumn])
			return true;
		if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1]!='_')
			return true;
		if(board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1]!='_')
			return true;
		
		
		return false;
	}
	
	public static void setBoard() {
		
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				board[i][j] = '_';
			}
		}
	}
	
	
	public static void printBoard() {
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3; j++) {
				if(j==0) {
					System.out.print("|");
				}
				System.out.print(" "+board[i][j]+" |");
			}
			System.out.println();
		}
	}
	
	public static boolean draw() {
		boolean checkIfAllBoxIsFilled = true;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0 ; j < 3; j++) {
				if(board[i][j]=='_') {
					checkIfAllBoxIsFilled = false;
				}
			}
		}
		return checkIfAllBoxIsFilled;
	}
}
