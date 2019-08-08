package com.ygznsl.chess.game;

import static java.util.Objects.isNull;

import com.ygznsl.chess.game.position.Position;

public abstract class King extends FirstMoveSpecificPiece
{

    protected King(Color color)
    {
        super(Pieces.KING, color);
    }

    private Position getCastleRookPosition(Castle castle)
    {
        if (isNull(castle))
            return null;

        if (isWhite())
        {
            switch (castle)
            {
                case SHORT:
                    return new Position(Position.VERTICAL_MAX, 1);
                case LONG:
                    return new Position(Position.VERTICAL_MIN, 1);
            }
        }
        else
        {
            switch (castle)
            {
                case SHORT:
                    return new Position(Position.VERTICAL_MAX, 8);
                case LONG:
                    return new Position(Position.VERTICAL_MIN, 8);
            }
        }

        return null;
    }

    protected boolean checkCastle(Castle castle)
    {
        if (isFirstMovePlayed())
            return false;

        final Position rookPosition = getCastleRookPosition(castle);
        if (isNull(rookPosition))
            return false;

        final Square rookSquare = square
                .getBoard()
                .getSquare(rookPosition);

        if (isNull(rookSquare) || !rookSquare.isOccupied())
            return false;

        final Piece occupant = rookSquare.getOccupant();
        return (occupant instanceof Rook) && !((Rook) occupant).isFirstMovePlayed();
    }

    protected boolean checkLongCastle()
    {
        return checkCastle(Castle.LONG);
    }

    protected boolean checkShortCastle()
    {
        return checkCastle(Castle.SHORT);
    }

}
