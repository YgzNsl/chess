package com.ygznsl.chess.game;

import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.ygznsl.chess.game.exception.EmptySquareException;
import com.ygznsl.chess.game.exception.GameException;
import com.ygznsl.chess.game.path.Path;
import com.ygznsl.chess.game.position.Position;

public abstract class Board
{

    protected final Square[][] squares = new Square[8][8];

    public Board()
    {
        final Map<Position, Piece> pieces = initializeBoard();
        if (Objects.nonNull(pieces))
        {
            Color color = Color.BLACK;
            for (char vertical = 'A'; vertical <= 'H'; vertical++)
            {
                for (int horizontal = 1; horizontal <= 8; horizontal++)
                {
                    final Position position = new Position(vertical, horizontal);
                    final Square square = new Square(this, position, color);

                    if (pieces.containsKey(position))
                    {
                        square.setOccupant(pieces.get(position));
                    }

                    squares[position.getVerticalIndex()][position.getHorizontalIndex()] = square;
                    color = color.invert();
                }

                color = color.invert();
            }
        }
    }

    protected final List<Piece> getPiecesByColor(Color color)
    {
        return Arrays
                .stream(squares)
                .flatMap(Arrays::stream)
                .filter(Objects::nonNull)
                .filter(Square::isOccupied)
                .map(Square::getOccupant)
                .filter(piece -> Objects.equals(color, piece.getColor()))
                .collect(Collectors.toList());
    }

    protected final void analyzeAvailablePaths(Piece piece, List<Path> paths)
    {
        for (final Path initialPath : paths)
        {
            Path path = initialPath;
            Piece previous = null;
            int index = 1;

            while (nonNull(path))
            {
                if (nonNull(path.getExtendz()) && path.getExtendz().isBlocked())
                    break;

                final List<Position> steps = path.getSteps();
                for (int i = index; i < steps.size(); i++)
                {
                    index++;

                    if (nonNull(previous))
                    {
                        path.setBlockedBy(previous);
                        previous = null;
                        break;
                    }

                    final Position step = steps.get(i);
                    final Square square = getSquare(step);

                    if (square.isOccupied())
                    {
                        final Piece occupant = square.getOccupant();
                        final boolean isOpponent = occupant
                                .getColor()
                                .isOpponentOf(piece.getColor());

                        if (isOpponent)
                        {
                            previous = occupant;
                        }
                        else
                        {
                            previous = null;
                            path.setBlockedBy(occupant);
                            break;
                        }
                    }
                    else
                    {
                        previous = null;
                    }
                }

                path = path.getExtension();
            }
        }
    }

    public final Square getSquare(Position position)
    {
        return squares[position.getVerticalIndex()][position.getHorizontalIndex()];
    }

    public final List<Piece> getWhitePieces()
    {
        return getPiecesByColor(Color.WHITE);
    }

    public final List<Piece> getBlackPieces()
    {
        return getPiecesByColor(Color.BLACK);
    }

    public final List<Piece> getAllPieces()
    {
        final ArrayList<Piece> allPieces = new ArrayList<>();
        allPieces.addAll(getWhitePieces());
        allPieces.addAll(getBlackPieces());
        allPieces.trimToSize();
        return allPieces;
    }

    public final List<Path> getAvailableMoves(Position position) throws GameException
    {
        final Square square = getSquare(position);
        if (!square.isOccupied())
            throw new EmptySquareException(square);

        final Piece occupant = square.getOccupant();
        final List<Path> allPaths = occupant.getAllPossiblePaths();
        analyzeAvailablePaths(occupant, allPaths);
        return allPaths;
    }

    protected abstract Map<Position, Piece> initializeBoard();

}
