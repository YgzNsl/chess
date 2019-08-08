package com.ygznsl.chess.game.move;

import com.ygznsl.chess.game.Color;
import com.ygznsl.chess.game.Piece;
import com.ygznsl.chess.game.position.Position;

public class PlayedMove extends Move
{

    private Color playedBy;
    private Piece takes;
    private Long startedAt;
    private Long completedAt;

    public PlayedMove(Piece piece, Position from, Position to, boolean transforms)
    {
        super(piece, from, to, transforms);
    }

    public final Color getPlayedBy()
    {
        return playedBy;
    }

    public void setPlayedBy(Color playedBy)
    {
        this.playedBy = playedBy;
    }

    public final Piece getTakes()
    {
        return takes;
    }

    public void setTakes(Piece takes)
    {
        this.takes = takes;
    }

    public final Long getStartedAt()
    {
        return startedAt;
    }

    public void setStartedAt(Long startedAt)
    {
        this.startedAt = startedAt;
    }

    public final Long getCompletedAt()
    {
        return completedAt;
    }

    public void setCompletedAt(Long completedAt)
    {
        this.completedAt = completedAt;
    }

}
