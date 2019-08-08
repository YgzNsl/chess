package com.ygznsl.chess.game.classic;

import com.ygznsl.chess.game.Color;
import com.ygznsl.chess.game.Rook;

public class ClassicRook extends Rook
{

    public ClassicRook(Color color)
    {
        super(color);
    }

    @Override
    protected final boolean canMoveNorth()
    {
        return true;
    }

    @Override
    protected final boolean canMoveSouth()
    {
        return true;
    }

    @Override
    protected final boolean canMoveWest()
    {
        return true;
    }

    @Override
    protected final boolean canMoveEast()
    {
        return true;
    }

    @Override
    protected final boolean canMoveNorthWest()
    {
        return false;
    }

    @Override
    protected final boolean canMoveNorthEast()
    {
        return false;
    }

    @Override
    protected final boolean canMoveSouthWest()
    {
        return false;
    }

    @Override
    protected final boolean canMoveSouthEast()
    {
        return false;
    }

    @Override
    protected final boolean canMoveLMotion()
    {
        return false;
    }

    @Override
    protected final int getMoveCount()
    {
        return -1;
    }

}
