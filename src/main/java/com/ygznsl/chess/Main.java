package com.ygznsl.chess;

import com.ygznsl.chess.game.Board;
import com.ygznsl.chess.game.Game;
import com.ygznsl.chess.game.classic.ClassicGame;
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
        board.getAvailableMoves(new Position('A', 1));
        System.out.println();
    }

}
