package com.ygznsl.chess.game.position;

import com.ygznsl.chess.game.exception.InvalidPositionException;

public interface PositionSupplier
{
    Position getPosition() throws InvalidPositionException;
}
