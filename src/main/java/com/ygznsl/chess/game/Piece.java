package com.ygznsl.chess.game;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.ygznsl.chess.game.exception.InvalidPositionException;
import com.ygznsl.chess.game.path.Path;
import com.ygznsl.chess.game.position.Direction;
import com.ygznsl.chess.game.position.DirectionSequence;
import com.ygznsl.chess.game.position.Position;

public abstract class Piece
{

    protected final Pieces type;
    protected final Color color;
    protected boolean outOfGame = false;
    protected Square square = null;

    Piece(Pieces type, Color color)
    {
        this.type = requireNonNull(type, "Piece type cannot be null.");
        this.color = requireNonNull(color, "Piece requires a color.");
    }

    public final Pieces getType()
    {
        return type;
    }

    public final Color getColor()
    {
        return color;
    }

    public final boolean isOutOfGame()
    {
        return outOfGame;
    }

    public final boolean isWhite()
    {
        return Color.WHITE == color;
    }

    public final boolean isBlack()
    {
        return Color.BLACK == color;
    }

    protected void setOutOfGame(boolean outOfGame)
    {
        this.outOfGame = outOfGame;
    }

    public final Square getSquare()
    {
        return square;
    }

    protected void setSquare(Square square)
    {
        this.square = square;
    }

    public final Position getPosition()
    {
        return Optional
                .ofNullable(square)
                .map(Square::getPosition)
                .orElse(null);
    }

    protected final boolean hasPositionOnDirection(Position position, Direction direction)
    {
        switch (direction)
        {
            case NORTH:
                return position.hasNorth();
            case SOUTH:
                return position.hasSouth();
            case WEST:
                return position.hasWest();
            case EAST:
                return position.hasEast();
            case NORTH_WEST:
                return position.hasNorthWest();
            case NORTH_EAST:
                return position.hasNorthEast();
            case SOUTH_WEST:
                return position.hasSouthWest();
            case SOUTH_EAST:
                return position.hasSouthEast();
            default:
                return false;
        }
    }

    protected final Position getPositionOnDirection(Position position, Direction direction)
    {
        try
        {
            switch (direction)
            {
                case NORTH:
                    return position.getNorth();
                case SOUTH:
                    return position.getSouth();
                case WEST:
                    return position.getWest();
                case EAST:
                    return position.getEast();
                case NORTH_WEST:
                    return position.getNorthWest();
                case NORTH_EAST:
                    return position.getNorthEast();
                case SOUTH_WEST:
                    return position.getSouthWest();
                case SOUTH_EAST:
                    return position.getSouthEast();
                default:
                    return null;
            }
        }
        catch (InvalidPositionException ex)
        {
            return null;
        }
    }

    protected final Position getFinalPositionFromDirectionSequence(Position currentPosition, DirectionSequence directionSequence)
    {
        Position position = currentPosition;
        boolean loop;

        for (Direction direction : directionSequence)
        {
            loop = hasPositionOnDirection(position, direction);
            if (!loop)
                return null;

            position = getPositionOnDirection(position, direction);
        }

        return position;
    }

    protected final Path getPathFromDirectionSequence(Position currentPosition, DirectionSequence directionSequence)
    {
        final LinkedList<Position> steps = new LinkedList<>();
        steps.add(currentPosition);

        final int moves = directionSequence.getMoves();
        Position position = currentPosition;
        Path firstPath = null;
        Path path = null;
        int moved = 0;

        while ((moves == -1 || moved < moves) && nonNull(position))
        {
            position = getFinalPositionFromDirectionSequence(position, directionSequence);

            if (nonNull(position))
            {
                steps.add(position);

                final Path extension = new Path();
                extension.addPositions(steps);

                if (nonNull(path))
                    extension.setExtendz(path);

                if (isNull(firstPath))
                    firstPath = extension;

                path = extension;
            }

            moved++;
        }

        return firstPath;
    }

    public final List<Path> getAllPossiblePaths()
    {
        if (isNull(square) || outOfGame)
            return Collections.emptyList();

        final List<DirectionSequence> directionSequenceList = getMovingDirectionSequenceList();
        final LinkedList<Path> paths = new LinkedList<>();
        final Position currenPosition = getPosition();

        for (DirectionSequence directionSequence : directionSequenceList)
        {
            final Path path = getPathFromDirectionSequence(currenPosition, directionSequence);

            if (nonNull(path))
                paths.add(path);
        }

        return paths;
    }

    protected boolean canJumpOverPieces()
    {
        return false;
    }

    protected List<DirectionSequence> getThreateningDirectionSequenceList()
    {
        return getMovingDirectionSequenceList();
    }

    protected void onMove()
    {
    }

    protected abstract List<DirectionSequence> getMovingDirectionSequenceList();

}
