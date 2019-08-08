package com.ygznsl.chess.game.move;

import java.util.Objects;

import com.ygznsl.chess.game.Piece;
import com.ygznsl.chess.game.position.Position;

public class Move
{

    protected final Piece piece;
    protected final Position from;
    protected final Position to;
    protected final boolean transforms;

    public Move(Piece piece, Position from, Position to, boolean transforms)
    {
        this.piece = Objects.requireNonNull(piece, "Move requires a piece.");
        this.from = Objects.requireNonNull(from, "Move requires a starting position.");
        this.to = Objects.requireNonNull(to, "Move requires a final position.");
        this.transforms = transforms;
    }

    public final Piece piece()
    {
        return piece;
    }

    public final Position from()
    {
        return from;
    }

    public final Position to()
    {
        return to;
    }

    public boolean transforms()
    {
        return transforms;
    }

}
