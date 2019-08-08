package com.ygznsl.chess.game.exception;

import com.ygznsl.chess.game.position.Position;

public class IllegalMoveException extends GameException
{

    private final Position from;
    private final Position to;

    public IllegalMoveException(Position from, Position to)
    {
        super(String.format("Move from %C%d to %C%d is illegal", from.getVertical(), from.getHorizontal(), to.getVertical(), to.getHorizontal()));
        this.from = from;
        this.to = to;
    }

    public Position getFrom()
    {
        return from;
    }

    public Position getTo()
    {
        return to;
    }

}
