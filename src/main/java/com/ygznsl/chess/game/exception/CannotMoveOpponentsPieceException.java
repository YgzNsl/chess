package com.ygznsl.chess.game.exception;

import com.ygznsl.chess.game.position.Position;

public class CannotMoveOpponentsPieceException extends GameException
{

    private final Position position;

    public CannotMoveOpponentsPieceException(Position position)
    {
        super(String.format("Piece at %C%d belongs to your opponent. You cannot move it", position.getVertical(), position.getHorizontal()));
        this.position = position;
    }

    public Position getPosition()
    {
        return position;
    }

}
