package com.ygznsl.chess.game;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.ygznsl.chess.game.position.Position;

public class Square
{

    protected final Board board;
    protected final Position position;
    protected final Color color;
    protected Piece occupant = null;

    public Square(Board board, Position position, Color color)
    {
        this.board = Objects.requireNonNull(board, "Board cannot be null.");
        this.position = Objects.requireNonNull(position, "Board square requires a position.");
        this.color = Objects.requireNonNull(color, "Board square requires a color.");
    }

    public final Board getBoard()
    {
        return board;
    }

    public final Position getPosition()
    {
        return position;
    }

    public final Color getColor()
    {
        return color;
    }

    public final Piece getOccupant()
    {
        return occupant;
    }

    protected void setOccupant(Piece occupant)
    {
        this.occupant = Objects.requireNonNull(occupant, "Occupant cannot be null.");
        occupant.setSquare(this);
    }

    public final boolean isOccupied()
    {
        return Objects.nonNull(occupant);
    }

    public final boolean isBlack()
    {
        return Objects.equals(Color.BLACK, color);
    }

    public final boolean isWhite()
    {
        return Objects.equals(Color.WHITE, color);
    }

    public final void clearOccupant()
    {
        setOccupant(null);
    }

    public final List<Piece> getThreateningPieces()
    {
        final LinkedList<Piece> pieces = new LinkedList<>();
        final List<Piece> allPieces = board.getAllPieces();

        for (Piece piece : allPieces)
        {
            if (piece.getThreatenedSquares().contains(this))
            {
                pieces.add(piece);
            }
        }

        return pieces;
    }

    @Override
    public final boolean equals(Object that)
    {
        if (this == that)
            return true;

        if (that == null || getClass() != that.getClass())
            return false;

        final Square other = (Square) that;
        return getBoard().equals(other.getBoard())
                && getPosition().equals(other.getPosition())
                && getColor() == other.getColor();
    }

    @Override
    public final int hashCode()
    {
        return Objects.hash(getBoard(), getPosition(), getColor());
    }

}
