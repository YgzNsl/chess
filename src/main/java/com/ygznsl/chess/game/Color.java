package com.ygznsl.chess.game;

import java.util.Objects;

public enum Color
{
    WHITE,
    BLACK;

    public Color invert()
    {
        return getOpponentsColor(this);
    }

    public boolean isOpponentOf(Color color)
    {
        return Objects.equals(invert(), color);
    }

    public static Color getOpponentsColor(Color color)
    {
        return Objects.equals(WHITE, color) ? BLACK : WHITE;
    }

}
