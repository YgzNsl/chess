package com.ygznsl.chess.game.classic;

import com.ygznsl.chess.game.Color;
import com.ygznsl.chess.game.position.Direction;
import com.ygznsl.chess.game.Pawn;

public class ClassicPawn extends Pawn
{

    public ClassicPawn(Color color)
    {
        super(color);
    }

    @Override
    protected final boolean canMoveNorth()
    {
        return isWhite();
    }

    @Override
    protected final boolean canMoveSouth()
    {
        return isBlack();
    }

    @Override
    protected final boolean canMoveWest()
    {
        return false;
    }

    @Override
    protected final boolean canMoveEast()
    {
        return false;
    }

    @Override
    protected final boolean canMoveNorthWest()
    {
        return isWhite() && (checkEnPassant(Direction.WEST) || checkOpponentExistsInDirection(Direction.NORTH_WEST));
    }

    @Override
    protected final boolean canMoveNorthEast()
    {
        return isWhite() && (checkEnPassant(Direction.EAST) || checkOpponentExistsInDirection(Direction.NORTH_EAST));
    }

    @Override
    protected final boolean canMoveSouthWest()
    {
        return isBlack() && (checkEnPassant(Direction.WEST) || checkOpponentExistsInDirection(Direction.SOUTH_WEST));
    }

    @Override
    protected final boolean canMoveSouthEast()
    {
        return isBlack() && (checkEnPassant(Direction.EAST) || checkOpponentExistsInDirection(Direction.SOUTH_EAST));
    }

    @Override
    protected final boolean canMoveLMotion()
    {
        return false;
    }

    @Override
    protected final int getMoveCount()
    {
        return firstMovePlayed ? 1 : 2;
    }

    @Override
    protected final boolean threatensNorth()
    {
        return false;
    }

    @Override
    protected final boolean threatensSouth()
    {
        return false;
    }

}
