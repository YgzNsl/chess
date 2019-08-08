package com.ygznsl.chess.game.exception;

public class GameNotStartedException extends GameException
{

    public GameNotStartedException()
    {
        super("Game is not started yet");
    }

}
