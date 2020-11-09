package chessgame;

import java.io.Serializable;

/**
 * This class represents the King chess piece.
 * 
 * @author Ki Sung Chung
 * @version 1.0
 */
public class King extends Piece implements Serializable {
    /** Default Serial ID. */
    private static final long serialVersionUID = 1L;
    
    /**
     * Creates a King piece.
     * 
     * @param player as a String
     */
    public King(Player player) {
        super(player);
    }

    /**
     * Gets the name of the King piece.
     * 
     * @return name as a String
     */
    @Override
    public String getName() {
        return "King";
    }

    @Override
    public boolean isValidMove(Square original, Square target) {
        // Vertical Move
        if ((original.getRow() == target.getRow()) 
                && (Math.abs(original.getCol() - target.getCol()) == 1)) {
            return true;
        }
        
        // Horizontal Move
        if ((original.getCol() == target.getCol()) 
                && (Math.abs(original.getRow() - target.getRow()) == 1)) {
            return true;
        }
        
        // Diagonal Move
        if (((original.getRow() + 1 == target.getRow())
                && (original.getCol() + 1 == target.getCol()))
                || ((original.getRow() + 1 == target.getRow())
                        && (original.getCol() - 1 == target.getCol()))
                || ((original.getRow() - 1 == target.getRow()) 
                        && (original.getCol() + 1 == target.getCol())) 
                || ((original.getRow() - 1 == target.getRow())
                        && (original.getCol() - 1 == target.getCol()))) {
            return true;
        }
        
        return false;
    }

    @Override
    public boolean isFree(Square original, Square target, Square[][] pieces) {
        return true;
    }
}
