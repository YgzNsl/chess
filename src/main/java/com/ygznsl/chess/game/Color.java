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

    public boolean isFriendOf(Color color)
    {
        return Objects.equals(this, color);
    }

    public static Color getOpponentsColor(Color color)
    {
        return Objects.equals(WHITE, color) ? BLACK : WHITE;
    }

}
