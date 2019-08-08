package com.ygznsl.chess.game.classic;

import com.ygznsl.chess.game.Color;
import com.ygznsl.chess.game.Knight;

public class ClassicKnight extends Knight
{

    public ClassicKnight(Color color)
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
        return false;
    }

    @Override
    protected boolean canMoveNorthEast()
    {
        return false;
    }

    @Override
    protected boolean canMoveSouthWest()
    {
        return false;
    }

    @Override
    protected boolean canMoveSouthEast()
    {
        return false;
    }

    @Override
    protected boolean canMoveLMotion()
    {
        return true;
    }

    @Override
    protected int getMoveCount()
    {
        return 1;
    }

}
