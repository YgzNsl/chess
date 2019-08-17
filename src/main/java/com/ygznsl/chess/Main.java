package com.ygznsl.chess;

import java.util.List;

import com.ygznsl.chess.game.Board;
import com.ygznsl.chess.game.Game;
import com.ygznsl.chess.game.classic.ClassicGame;
import com.ygznsl.chess.game.path.Path;
import com.ygznsl.chess.game.position.Position;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Main
{

    public static void main(String[] args) throws Exception
    {
        final Game game = new ClassicGame();
        final Board board = game.getBoard();
        final List<Path> availablePaths = board.getAvailableMoves(new Position('B', 1));
        System.out.println(availablePaths);
    }

}
