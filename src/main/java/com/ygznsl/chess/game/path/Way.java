package com.ygznsl.chess.game.path;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collectors;

import com.ygznsl.chess.game.position.Position;

public class Way implements Iterable<Position>
{

    protected final LinkedList<Position> steps = new LinkedList<>();
    protected final Path path;

    protected Way(Path path)
    {
        this.path = path;
    }

    public final Path getPath()
    {
        return path;
    }

    public void addPosition(Position position)
    {
        steps.add(position);
    }

    public final void addPositions(Collection<Position> collection)
    {
        steps.addAll(collection);
    }

    public final Iterator<Position> getStepsIterator()
    {
        return steps.iterator();
    }

    @Override
    public final Iterator<Position> iterator()
    {
        return getStepsIterator();
    }

    @Override
    public final String toString()
    {
        return steps
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(" -> "));
    }

}
