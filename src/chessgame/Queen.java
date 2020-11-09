package chessgame;

import java.io.Serializable;

/**
 * This class represents the Queen chess piece.
 * 
 * @author Ki Sung Chung
 * @version 1.0
 */
public class Queen extends Piece implements Serializable {
    /** Default Serial ID. */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a Queen piece.
     * 
     * @param player as a String
     */
    public Queen(Player player) {
        super(player);
    }

    /**
     * Gets the name of the Queen piece.
     * 
     * @return name as a String
     */
    @Override
    public String getName() {
        return "Queen";
    }

    @Override
    public boolean isValidMove(Square original, Square target) {
        // Vertical & Horizontal Move
        if (original.getRow() == target.getRow()
                || original.getCol() == target.getCol()) {
            return true;
        }

        // Diagonal Move
        if ((Math.abs(original.getRow() - target.getRow()))
                == (Math.abs(original.getCol() - target.getCol()))) {
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
        // Diagonal Up-Right
        } else if ((original.getCol() < target.getCol())
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
