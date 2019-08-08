package com.ygznsl.chess.game.classic;

import com.ygznsl.chess.game.Board;
import com.ygznsl.chess.game.Color;
import com.ygznsl.chess.game.Game;

public class ClassicGame extends Game
{

    public ClassicGame()
    {
    }

    @Override
    protected final Color getFirstMoveOwner()
    {
        return Color.WHITE;
    }

    @Override
    protected final Board initializeBoard()
    {
        return new ClassicBoard();
    }

}
