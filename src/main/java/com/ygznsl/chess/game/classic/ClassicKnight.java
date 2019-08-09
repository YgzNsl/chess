package com.ygznsl.chess.game.classic;

import java.util.Arrays;
import java.util.List;

import com.ygznsl.chess.game.Color;
import com.ygznsl.chess.game.Knight;
import com.ygznsl.chess.game.position.Direction;
import com.ygznsl.chess.game.position.DirectionSequence;

public class ClassicKnight extends Knight
{

    public ClassicKnight(Color color)
    {
        super(color);
    }

    @Override
    protected List<DirectionSequence> getMovingDirectionSequenceList()
    {
        return Arrays.asList(
                new DirectionSequence(1, Direction.NORTH, Direction.NORTH, Direction.WEST),
                new DirectionSequence(1, Direction.NORTH, Direction.NORTH, Direction.EAST),
                new DirectionSequence(1, Direction.NORTH, Direction.WEST, Direction.WEST),
                new DirectionSequence(1, Direction.NORTH, Direction.EAST, Direction.EAST),
                new DirectionSequence(1, Direction.SOUTH, Direction.SOUTH, Direction.WEST),
                new DirectionSequence(1, Direction.SOUTH, Direction.SOUTH, Direction.EAST),
                new DirectionSequence(1, Direction.SOUTH, Direction.WEST, Direction.WEST),
                new DirectionSequence(1, Direction.SOUTH, Direction.EAST, Direction.EAST)
        );
    }

    @Override
    protected boolean canJumpOverPieces()
    {
        return true;
    }

}
