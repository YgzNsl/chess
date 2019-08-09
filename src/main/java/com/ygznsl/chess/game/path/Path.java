package com.ygznsl.chess.game.path;

import static java.util.Objects.nonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.ygznsl.chess.game.Piece;
import com.ygznsl.chess.game.position.Position;

public class Path implements Iterable<Position>
{

    protected final Way way;
    protected Path extendz;
    protected Path extension;
    protected Piece blockedBy;

    public Path()
    {
        way = new Way(this);
    }

    public final Path getExtendz()
    {
        return extendz;
    }

    public void setExtendz(Path extendz)
    {
        this.extendz = extendz;

        if (nonNull(this.extendz))
            this.extendz.setExtension(this);
    }

    public final Path getExtension()
    {
        return extension;
    }

    protected void setExtension(Path extension)
    {
        this.extension = extension;
    }

    public final Piece getBlockedBy()
    {
        return blockedBy;
    }

    public void setBlockedBy(Piece blockedBy)
    {
        this.blockedBy = blockedBy;
    }

    public boolean isBlocked()
    {
        return nonNull(blockedBy);
    }

    public List<Position> getSteps()
    {
        return way.steps;
    }

    public Position getFirstStep()
    {
        return way.steps.isEmpty() ? null : way.steps.getFirst();
    }

    public Position getLastStep()
    {
        return way.steps.isEmpty() ? null : way.steps.getLast();
    }

    public final void addPosition(Position position)
    {
        way.addPosition(position);
    }

    public final void addPositions(Collection<Position> collection)
    {
        way.addPositions(collection);
    }

    public final boolean hasExtension()
    {
        return nonNull(extension);
    }

    @Override
    public final Iterator<Position> iterator()
    {
        return way.getStepsIterator();
    }

}
