package com.ygznsl.chess.game;

import java.util.ArrayDeque;
import java.util.Deque;

import com.ygznsl.chess.game.exception.GameException;
import com.ygznsl.chess.game.move.PlayedMove;
import com.ygznsl.chess.game.position.Position;

public abstract class Game
{

    protected final Deque<PlayedMove> moves = new ArrayDeque<>();
    protected final Board board;
    protected Color turn;
    protected long turnStartedAt;
    protected boolean started = false;

    protected Game()
    {
        this.board = initializeBoard();
    }

    public final Board getBoard()
    {
        return board;
    }

    public final Color whoseTurn()
    {
        return turn;
    }

    public final boolean isStarted()
    {
        return started;
    }

    public final void move(Position from, Position to) throws GameException
    {
        //        try
        //        {
        //            Objects.requireNonNull(from, "Move requires a starting position.");
        //            Objects.requireNonNull(to, "Move requires a final position.");
        //        }
        //        catch (NullPointerException ex)
        //        {
        //            throw new GameException(ex);
        //        }
        //
        //        if (!started)
        //            throw new GameNotStartedException();
        //
        //        final Square startingSquare = board.getSquare(from);
        //        if (isNull(startingSquare) || !startingSquare.isOccupied())
        //            throw new PositionIsEmptyException(from);
        //
        //        final Piece piece = startingSquare.getOccupant();
        //        if (turn.isOpponentOf(piece.getColor()))
        //            throw new CannotMoveOpponentsPieceException(from);
        //
        //        final List<Move> availableMoves = piece.getAvailableMoves();
        //        final Move legalMove = availableMoves
        //                .stream()
        //                .filter(move -> Objects.equals(move.to(), to))
        //                .findFirst()
        //                .orElse(null);
        //
        //        if (isNull(legalMove))
        //            throw new IllegalMoveException(from, to);
        //
        //        try
        //        {
        //            piece.onMove();
        //        }
        //        catch (Exception ignored)
        //        {
        //        }
        //
        //        final Square finalSquare = board.getSquare(to);
        //        final Piece opponent = finalSquare.getOccupant();
        //        finalSquare.setOccupant(piece);
        //        startingSquare.clearOccupant();
        //
        //        final PlayedMove move = new PlayedMove(piece, from, to, legalMove.transforms());
        //        move.setPlayedBy(turn);
        //        move.setStartedAt(turnStartedAt);
        //        move.setCompletedAt(System.currentTimeMillis());
        //
        //        if (nonNull(opponent))
        //        {
        //            move.setTakes(opponent);
        //            opponent.setTaken();
        //        }
        //
        //        moves.addLast(move);
        //        switchTurn();
    }

    public final void switchTurn()
    {
        turn = turn.invert();
        turnStartedAt = System.currentTimeMillis();
    }

    public void start()
    {
        turn = getFirstMoveOwner();
        turnStartedAt = System.currentTimeMillis();
        started = true;
    }

    protected abstract Color getFirstMoveOwner();

    protected abstract Board initializeBoard();

}
