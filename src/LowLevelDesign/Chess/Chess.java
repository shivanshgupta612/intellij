package LowLevelDesign.Chess;

import java.util.ArrayList;
import java.util.List;

public class Chess {
    ChessBoard chessBoard;
}
class ChessBoard{
    static  Cell[][] cells = new Cell[8][8];
    public ChessBoard(){
        for(int j=0;j<8;j++){
            cells[1][j]= new Cell(new Pawn(Color.BLACK),1,j);
            cells[6][j]=new Cell(new Pawn(Color.WHITE),6,j);
        }
        cells[0][0]=new Cell(new Rook(Color.BLACK),0,0);cells[0][7]=new Cell(new Rook(Color.BLACK),0,7);
        cells[7][0]=new Cell(new Rook(Color.WHITE),7,0);cells[7][7]=new Cell(new Rook(Color.WHITE),7,7);
        cells[0][1]=new Cell(new Knight(Color.BLACK),0,1);cells[0][6]=new Cell(new Knight(Color.BLACK),0,6);
        cells[7][1]=new Cell(new Knight(Color.WHITE),7,1);cells[7][6]=new Cell(new Knight(Color.WHITE),7,6);
        cells[0][2]=new Cell(new Bishop(Color.BLACK),0,2);cells[0][5]=new Cell(new Bishop(Color.BLACK),0,5);
        cells[7][2]=new Cell(new Bishop(Color.WHITE),7,2);cells[7][5]=new Cell(new Bishop(Color.WHITE),7,5);
        cells[0][3]=new Cell(new King(Color.BLACK),0,3);cells[0][4]=new Cell(new Queen(Color.BLACK),0,4);
        cells[7][3]=new Cell(new Queen(Color.WHITE),7,3);cells[7][4]=new Cell(new King(Color.WHITE),7,4);
    }
}
class Cell{
    Piece piece;
    int row;
    int col;

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Cell(Piece piece, int row, int col) {
        this.piece = piece;
        this.row = row;
        this.col = col;
    }
}
enum Color {
    BLACK, WHITE;
}
abstract class Piece {
    private Color color; // Correct access modifier and name
    int row;
    int col;
    public Piece(Color color) {
        this.color = color;
    }
    // Getter for color
    public Color getColor() {
        return color;
    }
    // Abstract method to be implemented by subclasses
    abstract void makeMove(int fromRow,int fromColumn,int toRow, int toColumn);
}

class Pawn extends Piece{

    public Pawn(Color color) {
        super(color);
    }

    @Override
    void makeMove(int fromRow,int fromColumn,int toRow, int toColumn) {
        //normal move for white
        if(-toRow+fromRow==1 && toColumn==fromColumn && ){

        }
    }
}
class King extends Piece{

    public King(Color color) {
        super(color);
    }

    @Override
    void makeMove(int fromRow,int fromCol,int toRow, int toColumn) {

    }
}
class Queen extends Piece{

    public Queen(Color color) {
        super(color);
    }

    @Override
    void makeMove(int fromRow,int fromCol,int toRow, int toColumn) {

    }
}
class Knight extends Piece{

    public Knight(Color color) {
        super(color);
    }

    @Override
    void makeMove(int fromRow,int fromCol,int toRow, int toColumn) {

    }
}
class Bishop extends Piece{

    public Bishop(Color color) {
        super(color);
    }

    @Override
    void makeMove(int fromRow,int fromCol,int toRow, int toColumn) {

    }
}
class Rook extends Piece{

    public Rook(Color color) {
        super(color);
    }

    @Override
    void makeMove(int fromRow,int fromCol,int toRow, int toColumn) {

    }
}