package com.ygznsl.chess.game.exception;

import com.ygznsl.chess.game.Square;

public class EmptySquareException extends GameException
{

    protected final Square square;

    public EmptySquareException(Square square)
    {
        super(String.format("Square at position %C%d is empty", square.getPosition().getVertical(), square.getPosition().getHorizontal()));
        this.square = square;
    }

    public final Square getSquare()
    {
        return square;
    }

}
