package com.ygznsl.chess.game;

public abstract class FirstMoveSpecificPiece extends Piece
{

    protected boolean firstMovePlayed = false;
    protected boolean firstMove = false;

    protected FirstMoveSpecificPiece(Pieces type, Color color)
    {
        super(type, color);
    }

    public final boolean isFirstMovePlayed()
    {
        return firstMovePlayed;
    }

    public final boolean isFirstMove()
    {
        return firstMove;
    }

    @Override
    protected void onMove()
    {
        if (firstMovePlayed)
        {
            if (firstMove)
            {
                firstMove = false;
            }
        }
        else
        {
            firstMovePlayed = true;
            firstMove = true;
        }
    }

}
