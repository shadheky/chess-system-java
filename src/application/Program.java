package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		ChessMatch chessMatch = new ChessMatch();
		Scanner sc = new Scanner(System.in);
		List <ChessPiece> captured = new ArrayList<>();
		while(true) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch,captured);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] posibleMoves = chessMatch.posibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), posibleMoves);
				
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				System.out.println();
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				if (capturedPiece != null) {
					captured.add(capturedPiece);
				}
				
			}catch(ChessException e) {
				 System.out.println(e.getMessage());
				 sc.nextLine();
			}catch(InputMismatchException e) {
				 System.out.println(e.getMessage());
				 sc.nextLine();
			}
		}
		
	}

}
