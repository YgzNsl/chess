package com.ygznsl.chess.game.classic;

import com.ygznsl.chess.game.Color;
import com.ygznsl.chess.game.King;
import com.ygznsl.chess.game.position.Direction;

public class ClassicKing extends King
{

    public ClassicKing(Color color)
    {
        super(color);
    }

    @Override
    protected boolean canMoveNorth()
    {
        return !checkIfDirectionIsUnderKingThreat(Direction.NORTH);
    }

    @Override
    protected boolean canMoveSouth()
    {
        return !checkIfDirectionIsUnderKingThreat(Direction.SOUTH);
    }

    @Override
    protected boolean canMoveWest()
    {
        return !checkIfDirectionIsUnderKingThreat(Direction.WEST);
    }

    @Override
    protected boolean canMoveEast()
    {
        return !checkIfDirectionIsUnderKingThreat(Direction.EAST);
    }

    @Override
    protected boolean canMoveNorthWest()
    {
        return !checkIfDirectionIsUnderKingThreat(Direction.NORTH_WEST);
    }

    @Override
    protected boolean canMoveNorthEast()
    {
        return !checkIfDirectionIsUnderKingThreat(Direction.NORTH_EAST);
    }

    @Override
    protected boolean canMoveSouthWest()
    {
        return !checkIfDirectionIsUnderKingThreat(Direction.SOUTH_WEST);
    }

    @Override
    protected boolean canMoveSouthEast()
    {
        return !checkIfDirectionIsUnderKingThreat(Direction.SOUTH_EAST);
    }

    @Override
    protected boolean canMoveLMotion()
    {
        return false;
    }

    @Override
    protected int getMoveCount()
    {
        return 1;
    }

}
