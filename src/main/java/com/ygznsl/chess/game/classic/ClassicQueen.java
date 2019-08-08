package com.ygznsl.chess.game.classic;

import com.ygznsl.chess.game.Color;
import com.ygznsl.chess.game.Queen;

public class ClassicQueen extends Queen
{

    public ClassicQueen(Color color)
    {
        super(color);
    }

    @Override
    protected boolean canMoveNorth()
    {
        return true;
    }

    @Override
    protected boolean canMoveSouth()
    {
        return true;
    }

    @Override
    protected boolean canMoveWest()
    {
        return true;
    }

    @Override
    protected boolean canMoveEast()
    {
        return true;
    }

    @Override
    protected boolean canMoveNorthWest()
    {
        return true;
    }

    @Override
    protected boolean canMoveNorthEast()
    {
        return true;
    }

    @Override
    protected boolean canMoveSouthWest()
    {
        return true;
    }

    @Override
    protected boolean canMoveSouthEast()
    {
        return true;
    }

    @Override
    protected boolean canMoveLMotion()
    {
        return false;
    }

    @Override
    protected int getMoveCount()
    {
        return -1;
    }

}
