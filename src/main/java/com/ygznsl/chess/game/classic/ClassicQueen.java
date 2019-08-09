package com.ygznsl.chess.game.classic;

import java.util.Arrays;
import java.util.List;

import com.ygznsl.chess.game.Color;
import com.ygznsl.chess.game.Queen;
import com.ygznsl.chess.game.position.Direction;
import com.ygznsl.chess.game.position.DirectionSequence;

public class ClassicQueen extends Queen
{

    public ClassicQueen(Color color)
    {
        super(color);
    }

    @Override
    protected List<DirectionSequence> getMovingDirectionSequenceList()
    {
        return Arrays.asList(
                new DirectionSequence(-1, Direction.NORTH),
                new DirectionSequence(-1, Direction.SOUTH),
                new DirectionSequence(-1, Direction.WEST),
                new DirectionSequence(-1, Direction.EAST),
                new DirectionSequence(-1, Direction.NORTH_WEST),
                new DirectionSequence(-1, Direction.NORTH_EAST),
                new DirectionSequence(-1, Direction.SOUTH_WEST),
                new DirectionSequence(-1, Direction.SOUTH_EAST)
        );
    }

}
