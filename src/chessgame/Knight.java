package chessgame;

import java.io.Serializable;

/**
 * This class represents the Knight chess piece.
 * 
 * @author Ki Sung Chung
 * @version 1.0
 */
public class Knight extends Piece implements Serializable {
    /** Default Serial ID. */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a Knight piece.
     * 
     * @param player as a String
     */
    public Knight(Player player) {
        super(player);
    }

    /**
     * Gets the name of the Knight piece.
     * 
     * @return name as a String
     */
    @Override
    public String getName() {
        return "Knight";
    }

    @Override
    public boolean isValidMove(Square original, Square target) {
        if (((Math.abs(original.getRow() - target.getRow()) == 2)
                && (Math.abs(original.getCol() - target.getCol()) == 1))
                || ((Math.abs(original.getRow() - target.getRow()) == 1)
                && (Math.abs(original.getCol() - target.getCol()) == 2))) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isFree(Square original, Square target, Square[][] pieces) {
        return true;
    }
}
