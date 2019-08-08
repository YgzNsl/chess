package com.ygznsl.chess.game.exception;

public class InvalidPositionException extends GameException
{

    private final int verticalIndex;
    private final int horizontalIndex;

    public InvalidPositionException(int verticalIndex, int horizontalIndex)
    {
        super(String.format("Invalid chess board position: (%d, %d)", verticalIndex, horizontalIndex));
        this.verticalIndex = verticalIndex;
        this.horizontalIndex = horizontalIndex;
    }

    public final int getVerticalIndex()
    {
        return verticalIndex;
    }

    public final int getHorizontalIndex()
    {
        return horizontalIndex;
    }

}
