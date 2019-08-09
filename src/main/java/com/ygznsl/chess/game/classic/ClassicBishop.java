package com.ygznsl.chess.game.classic;

import java.util.Arrays;
import java.util.List;

import com.ygznsl.chess.game.Bishop;
import com.ygznsl.chess.game.Color;
import com.ygznsl.chess.game.position.Direction;
import com.ygznsl.chess.game.position.DirectionSequence;

public class ClassicBishop extends Bishop
{

    public ClassicBishop(Color color)
    {
        super(color);
    }

    @Override
    protected List<DirectionSequence> getMovingDirectionSequenceList()
    {
        return Arrays.asList(
                new DirectionSequence(-1, Direction.NORTH_WEST),
                new DirectionSequence(-1, Direction.NORTH_EAST),
                new DirectionSequence(-1, Direction.SOUTH_WEST),
                new DirectionSequence(-1, Direction.SOUTH_EAST)
        );
    }

}
