package chessgame;

import java.io.Serializable;

/**
 * This class represents the Bishop chess piece.
 * 
 * @author Ki Sung Chung
 * @version 1.0
 */
public class Bishop extends Piece implements Serializable {
    /** Default Serial ID. */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a Bishop piece.
     * 
     * @param player as a String
     */
    public Bishop(Player player) {
        super(player);
    }

    /**
     * Gets the name of the Bishop piece.
     * 
     * @return name as a String
     */
    @Override
    public String getName() {
        return "Bishop";
    }

    @Override
    public boolean isValidMove(Square original, Square target) {
        if ((Math.abs(original.getRow() - target.getRow()))
                == (Math.abs(original.getCol() - target.getCol()))) {
            return true;
        }
        
        return false;
    }

    @Override
    public boolean isFree(Square original, Square target, Square[][] pieces) {
        // Diagonal Up-Right
        if ((original.getCol() < target.getCol())
                && (original.getRow() > target.getRow())) {
            for (int i = target.getCol() - original.getCol(); i > 0; i--) {
                if (pieces[original.getRow() - i][original.getCol() + i]
                        .hasPiece()) {
                    return false;
                }
            }
        // Diagonal Up-Left
        } else if ((original.getCol() > target.getCol())
                && (original.getRow() > target.getRow())) {
            for (int i = original.getCol() - target.getCol(); i > 0; i--) {
                if (pieces[original.getRow() - i][original.getCol() - i]
                        .hasPiece()) {
                    return false;
                }
            }
        // Diagonal Down-Right
        } else if ((original.getCol() < target.getCol())
                && (original.getRow() < target.getRow())) {
            for (int i = target.getCol() - original.getCol(); i > 0; i--) {
                if (pieces[original.getRow() + i][original.getCol() + i]
                        .hasPiece()) {
                    return false;
                }
            }
        // Diagonal Down-Left
        } else if ((original.getCol() > target.getCol())
                && (original.getRow() < target.getRow())) {
            for (int i = original.getCol() - target.getCol(); i > 0; i--) {
                if (pieces[original.getRow() + i][original.getCol() - i]
                        .hasPiece()) {
                    return false;
                }
            }
        }
        return true;
    }
}
