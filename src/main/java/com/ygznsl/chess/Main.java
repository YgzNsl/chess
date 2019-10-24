package com.ygznsl.chess;

import com.ygznsl.chess.game.Game;
import com.ygznsl.chess.game.classic.ClassicGame;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Main
{

    public static void main(String[] args)
    {
        final Game game = new ClassicGame();
    }

}
