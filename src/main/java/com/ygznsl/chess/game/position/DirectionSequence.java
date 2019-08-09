package com.ygznsl.chess.game.position;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DirectionSequence implements Iterable<Direction>
{

    protected final Direction[] sequence;
    protected final int moves;

    public DirectionSequence(int moves, Direction... sequence)
    {
        this.sequence = sequence;
        this.moves = moves;
    }

    public final int getMoves()
    {
        return moves;
    }

    public final Iterator<Direction> getSequenceIterator()
    {
        return new Iterator<Direction>()
        {
            private int index = -1;

            @Override
            public boolean hasNext()
            {
                return index + 1 < sequence.length;
            }

            @Override
            public Direction next()
            {
                if (!hasNext())
                    throw new NoSuchElementException();

                return sequence[++index];
            }

            @Override
            public void remove()
            {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public final Iterator<Direction> iterator()
    {
        return getSequenceIterator();
    }

}
