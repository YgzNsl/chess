package com.ygznsl.chess.game.position;

import java.util.Objects;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.ygznsl.chess.game.exception.InvalidPositionException;

public class Position implements Comparable<Position>
{

    public static final char VERTICAL_MIN = 'A';
    public static final char VERTICAL_MAX = 'H';
    public static final int HORIZONTAL_MIN = 1;
    public static final int HORIZONTAL_MAX = 8;

    protected final char vertical;
    protected final int horizontal;

    public Position(char vertical, int horizontal)
    {
        if (vertical < VERTICAL_MIN || vertical > VERTICAL_MAX)
            throw new IllegalArgumentException("Vertical in a chess board should be in this interval: [A, H]");

        if (horizontal < HORIZONTAL_MIN || horizontal > HORIZONTAL_MAX)
            throw new IllegalArgumentException("Horizontal in a chess board should be in this interval: [1, 8]");

        this.vertical = vertical;
        this.horizontal = horizontal;
    }

    protected boolean checkPositionExists(PositionSupplier method)
    {
        try
        {
            return Objects.nonNull(method.getPosition());
        }
        catch (InvalidPositionException ex)
        {
            return false;
        }
    }

    public final char getVertical()
    {
        return vertical;
    }

    public final int getHorizontal()
    {
        return horizontal;
    }

    public final int getVerticalIndex()
    {
        return vertical - 'A';
    }

    public final int getHorizontalIndex()
    {
        return horizontal - 1;
    }

    public Position getNorth() throws InvalidPositionException
    {
        if (horizontal == 8)
            throw new InvalidPositionException(getVerticalIndex(), horizontal + 1);

        return new Position(vertical, horizontal + 1);
    }

    public Position getSouth() throws InvalidPositionException
    {
        if (horizontal == 1)
            throw new InvalidPositionException(getVerticalIndex(), horizontal - 1);

        return new Position(vertical, horizontal - 1);
    }

    public Position getWest() throws InvalidPositionException
    {
        if (vertical == 'A')
            throw new InvalidPositionException(vertical - 1, getHorizontalIndex());

        return new Position((char) (vertical - 1), horizontal);
    }

    public Position getEast() throws InvalidPositionException
    {
        if (vertical == 'H')
            throw new InvalidPositionException(vertical + 1, getHorizontalIndex());

        return new Position((char) (vertical + 1), horizontal);
    }

    public Position getNorthEast() throws InvalidPositionException
    {
        if (vertical == 'H' || horizontal == 8)
            throw new InvalidPositionException(vertical + 1, horizontal + 1);

        return new Position((char) (vertical + 1), horizontal + 1);
    }

    public Position getNorthWest() throws InvalidPositionException
    {
        if (vertical == 'A' || horizontal == 8)
            throw new InvalidPositionException(vertical - 1, horizontal + 1);

        return new Position((char) (vertical - 1), horizontal + 1);
    }

    public Position getSouthEast() throws InvalidPositionException
    {
        if (vertical == 'H' || horizontal == 1)
            throw new InvalidPositionException(vertical + 1, horizontal - 1);

        return new Position((char) (vertical + 1), horizontal - 1);
    }

    public Position getSouthWest() throws InvalidPositionException
    {
        if (vertical == 'A' || horizontal == 1)
            throw new InvalidPositionException(vertical - 1, horizontal - 1);

        return new Position((char) (vertical - 1), horizontal - 1);
    }

    public boolean hasNorth()
    {
        return checkPositionExists(this::getNorth);
    }

    public boolean hasSouth()
    {
        return checkPositionExists(this::getSouth);
    }

    public boolean hasWest()
    {
        return checkPositionExists(this::getWest);
    }

    public boolean hasEast()
    {
        return checkPositionExists(this::getEast);
    }

    public boolean hasNorthWest()
    {
        return checkPositionExists(this::getNorthWest);
    }

    public boolean hasNorthEast()
    {
        return checkPositionExists(this::getNorthEast);
    }

    public boolean hasSouthWest()
    {
        return checkPositionExists(this::getSouthWest);
    }

    public boolean hasSouthEast()
    {
        return checkPositionExists(this::getSouthEast);
    }

    public final boolean isFirstVertical()
    {
        return Objects.equals(VERTICAL_MIN, vertical);
    }

    public final boolean isLastVertical()
    {
        return Objects.equals(VERTICAL_MAX, vertical);
    }

    public final boolean isFirstHorizontal()
    {
        return Objects.equals(HORIZONTAL_MIN, horizontal);
    }

    public final boolean isLastHorizontal()
    {
        return Objects.equals(HORIZONTAL_MAX, horizontal);
    }

    @Override
    public boolean equals(Object that)
    {
        if (this == that)
            return true;

        if (that == null || getClass() != that.getClass())
            return false;

        final Position other = (Position) that;
        return Objects.equals(getVertical(), other.getVertical())
                && Objects.equals(getHorizontal(), other.getHorizontal());
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(getVertical(), getHorizontal());
    }

    @Override
    public String toString()
    {
        return "Position{" +
                "vertical=" + getVertical() +
                ", horizontal=" + getHorizontal() +
                ", vertialIndex=" + getVerticalIndex() +
                ", horizontalIndex=" + getHorizontalIndex() +
                '}';
    }

    @Override
    public int compareTo(Position that)
    {
        return !Objects.equals(getVertical(), that.getVertical())
                ? Character.compare(getVertical(), that.getVertical())
                : Integer.compare(getHorizontal(), that.getHorizontal());
    }

}
