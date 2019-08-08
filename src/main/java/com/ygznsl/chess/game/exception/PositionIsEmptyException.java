package com.ygznsl.chess.game.exception;

import com.ygznsl.chess.game.position.Position;

public class PositionIsEmptyException extends GameException
{

    private final Position position;

    public PositionIsEmptyException(Position position)
    {
        super(String.format("Position %C%d is empty", position.getVertical(), position.getHorizontal()));
        this.position = position;
    }

    public final Position getPosition()
    {
        return position;
    }

}
