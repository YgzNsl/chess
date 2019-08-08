package com.ygznsl.chess.game.classic;

import com.ygznsl.chess.game.Bishop;
import com.ygznsl.chess.game.Color;

public class ClassicBishop extends Bishop
{

    public ClassicBishop(Color color)
    {
        super(color);
    }

    @Override
    protected boolean canMoveNorth()
    {
        return false;
    }

    @Override
    protected boolean canMoveSouth()
    {
        return false;
    }

    @Override
    protected boolean canMoveWest()
    {
        return false;
    }

    @Override
    protected boolean canMoveEast()
    {
        return false;
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
