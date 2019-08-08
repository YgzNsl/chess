package com.ygznsl.chess.game.classic;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import com.ygznsl.chess.game.Board;
import com.ygznsl.chess.game.Color;
import com.ygznsl.chess.game.Piece;
import com.ygznsl.chess.game.position.Position;

public class ClassicBoard extends Board
{

    public ClassicBoard()
    {
    }

    private void initializeColor(Map<Position, Piece> map, Color color)
    {
        final boolean isWhite = Objects.equals(Color.WHITE, color);
        map.put(new Position('A', isWhite ? 1 : 8), new ClassicRook(color));
        map.put(new Position('B', isWhite ? 1 : 8), new ClassicKnight(color));
        map.put(new Position('C', isWhite ? 1 : 8), new ClassicBishop(color));
        map.put(new Position('D', isWhite ? 1 : 8), new ClassicQueen(color));
        map.put(new Position('E', isWhite ? 1 : 8), new ClassicKing(color));
        map.put(new Position('F', isWhite ? 1 : 8), new ClassicBishop(color));
        map.put(new Position('G', isWhite ? 1 : 8), new ClassicKnight(color));
        map.put(new Position('H', isWhite ? 1 : 8), new ClassicRook(color));

        for (char vertical = Position.VERTICAL_MIN; vertical <= Position.VERTICAL_MAX; vertical++)
        {
            map.put(new Position(vertical, isWhite ? 2 : 7), new ClassicPawn(color));
        }
    }

    private void initializeWhite(Map<Position, Piece> map)
    {
        initializeColor(map, Color.WHITE);
    }

    private void initializeBlack(Map<Position, Piece> map)
    {
        initializeColor(map, Color.BLACK);
    }

    @Override
    protected final Map<Position, Piece> initializeBoard()
    {
        final TreeMap<Position, Piece> map = new TreeMap<>();
        initializeWhite(map);
        initializeBlack(map);
        return map;
    }

}
