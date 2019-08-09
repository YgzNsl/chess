package com.ygznsl.chess.game.classic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.ygznsl.chess.game.Color;
import com.ygznsl.chess.game.Pawn;
import com.ygznsl.chess.game.position.Direction;
import com.ygznsl.chess.game.position.DirectionSequence;

public class ClassicPawn extends Pawn
{

    protected ClassicPawn(Color color)
    {
        super(color);
    }

    @Override
    protected List<DirectionSequence> getMovingDirectionSequenceList()
    {
        return Collections.singletonList(new DirectionSequence(1, Direction.NORTH));
    }

    @Override
    protected List<DirectionSequence> getThreateningDirectionSequenceList()
    {
        return Arrays.asList(
                new DirectionSequence(1, Direction.NORTH_EAST),
                new DirectionSequence(1, Direction.NORTH_WEST)
        );
    }

}
