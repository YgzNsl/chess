package com.ygznsl.chess.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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

    public final Square getSquare(Position position)
    {
        Objects.requireNonNull(position);
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

    protected abstract Map<Position, Piece> initializeBoard();

}
