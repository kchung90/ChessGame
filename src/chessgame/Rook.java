package chessgame;

import java.io.Serializable;

/**
 * This class represents the Rook chess piece.
 * 
 * @author Ki Sung Chung
 * @version 1.0
 */
public class Rook extends Piece implements Serializable {
    /** Default Serial ID. */
    private static final long serialVersionUID = 1L;
    
    /**
     * Creates a Rook piece.
     * 
     * @param player as a String
     */
    public Rook(Player player) {
        super(player);
    }

    /**
     * Gets the name of the Rook piece.
     * 
     * @return name as a String
     */
    @Override
    public String getName() {
        return "Rook";
    }

    @Override
    public boolean isValidMove(Square original, Square target) {
        if (original.getRow() == target.getRow()
                || original.getCol() == target.getCol()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFree(Square original, Square target, Square[][] pieces) {
        // Up
        if ((original.getRow() > target.getRow())
                && (original.getCol() == target.getCol())) {
            for (int i = original.getRow() - 1; i > target.getRow(); i--) {
                if (pieces[i][original.getCol()].hasPiece()) {
                    return false;
                }
            }
        // Down
        } else if ((original.getRow() < target.getRow())
                && (original.getCol() == target.getCol())) {
            for (int i = original.getRow() + 1; i < target.getRow(); i++) {
                if (pieces[i][original.getCol()].hasPiece()) {
                    return false;
                }
            }
        // Left
        } else if ((original.getRow() == target.getRow())
                && (original.getCol() > target.getCol())) {
            for (int i = original.getCol() - 1; i > target.getCol(); i--) {
                if (pieces[original.getRow()][i].hasPiece()) {
                    return false;
                }
            }
        // Right
        } else if ((original.getRow() == target.getRow())
                && (original.getCol() < target.getCol())) {
            for (int i = original.getCol() + 1; i < target.getCol(); i++) {
                if (pieces[original.getRow()][i].hasPiece()) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
