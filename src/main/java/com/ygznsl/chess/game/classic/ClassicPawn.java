package com.ygznsl.chess.game.classic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ygznsl.chess.game.Color;
import com.ygznsl.chess.game.Pawn;
import com.ygznsl.chess.game.position.Direction;
import com.ygznsl.chess.game.position.DirectionSequence;
import com.ygznsl.chess.game.position.Position;

public class ClassicPawn extends Pawn
{

    public ClassicPawn(Color color)
    {
        super(color);
    }

    @Override
    protected List<DirectionSequence> getMovingDirectionSequenceList()
    {
        return Collections.singletonList(new DirectionSequence(
                isFirstMovePlayed() ? 1 : 2,
                isWhite() ? Direction.NORTH : Direction.SOUTH)
        );
    }

    @Override
    protected List<DirectionSequence> getThreateningDirectionSequenceList()
    {
        final ArrayList<DirectionSequence> list = new ArrayList<>(2);
        final Position currentPosition = getPosition();

        final Direction westCorner = isWhite() ? Direction.NORTH_WEST : Direction.SOUTH_WEST;
        final Direction eastCorner = isWhite() ? Direction.NORTH_EAST : Direction.SOUTH_EAST;

        if (hasOpponentOnDirection(currentPosition, westCorner))
        {
            list.add(new DirectionSequence(1, westCorner));
        }

        if (hasOpponentOnDirection(currentPosition, eastCorner))
        {
            list.add(new DirectionSequence(1, eastCorner));
        }

        return list;
    }

}
