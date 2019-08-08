package com.ygznsl.chess;

import com.ygznsl.chess.game.classic.ClassicGame;
import com.ygznsl.chess.game.position.Position;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Main
{

    public static void main(String[] args) throws Exception
    {
        final ClassicGame game = new ClassicGame();
        game.start();
        game.move(new Position('A', 1), new Position('A', 5));
        System.out.println();
    }

}
