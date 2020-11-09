package chessgame;

import java.io.Serializable;

/**
 * This class represents the Pawn chess piece.
 * 
 * @author Ki Sung Chung
 * @version 1.0
 */
public class Pawn extends Piece implements Serializable {
    /** Default Serial ID. */
    private static final long serialVersionUID = 1L;
    /** Checks if the first move has been made or not. */
    private boolean firstMove = true;

    /**
     * Creates a Pawn piece.
     * 
     * @param player as a String
     */
    public Pawn(Player player) {
        super(player);
    }

    /**
     * Gets the name of the Pawn piece.
     * 
     * @return name as a String
     */
    @Override
    public String getName() {
        return "Pawn";
    }

    @Override
    public boolean isValidMove(Square original, Square target) {
        if (this.getPlayerType().equals("p1")) {
            if (firstMove) {
                if ((original.getRow() + 2 == target.getRow()
                        && original.getCol() == target.getCol())
                        || (original.getRow() + 1 == target.getRow(
                                ) && original.getCol() == target.getCol())) {
                    firstMove = false;
                    return true;
                }
            } else {
                if (original.getRow() + 1 == target.getRow()
                        && original.getCol() == target.getCol()) {
                    return true;
                }
            }
        } else {
            if (firstMove) {
                if ((original.getRow() - 2 == target.getRow()
                        && original.getCol() == target.getCol())
                        || (original.getRow() - 1 == target.getRow()
                        && original.getCol() == target.getCol())) {
                    firstMove = false;
                    return true;
                }
            } else {
                if (original.getRow() - 1 == (target.getRow())
                        && original.getCol() == target.getCol()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isFree(Square original, Square target, Square[][] pieces) {
        // Checks for Black pieces
        if (this.getPlayerType().equals("p1")) {
            for (int i = original.getRow() + 1; i < target.getRow(); i++) {
                if (pieces[i][original.getCol()].hasPiece()) {
                    firstMove = true;
                    return false;
                }
            }
        // Checks for White pieces
        } else {
            for (int i = original.getRow() - 1; i > target.getRow(); i--) {
                if (pieces[i][original.getCol()].hasPiece()) {
                    firstMove = true;
                    return false;
                }
            }
        }
        return true;
    }

}
