package com.ygznsl.chess.game;

public abstract class Pawn extends FirstMoveSpecificPiece
{

    protected Pawn(Color color)
    {
        super(Pieces.PAWN, color);
    }

    //    protected boolean checkEnPassant(Direction direction)
    //    {
    //        if (Objects.isNull(square) || Objects.isNull(direction))
    //            return false;
    //
    //        if (Arrays.asList(Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST).contains(direction))
    //            return false;
    //
    //        if (isWhite() && (direction == Direction.SOUTH_WEST || direction == Direction.SOUTH_EAST))
    //            return false;
    //
    //        if (isBlack() && (direction == Direction.NORTH_WEST || direction == Direction.NORTH_EAST))
    //            return false;
    //
    //        Piece opponent = null;
    //
    //        if (direction == Direction.NORTH_WEST || direction == Direction.SOUTH_WEST)
    //            opponent = getOpponentInDirection(Direction.WEST);
    //        else if (direction == Direction.NORTH_EAST || direction == Direction.SOUTH_EAST)
    //            opponent = getOpponentInDirection(Direction.EAST);
    //
    //        if (Objects.isNull(opponent))
    //            return false;
    //
    //        if (!(opponent instanceof Pawn))
    //            return false;
    //
    //        return ((Pawn) opponent).isFirstMove();
    //    }
    //
    //    @Override
    //    protected boolean checkMoveTransformsPiece(Position finalPosition)
    //    {
    //        return Objects.nonNull(finalPosition) &&
    //                ((isWhite() && finalPosition.isLastHorizontal()) || (isBlack() && finalPosition.isFirstHorizontal()));
    //    }

}
