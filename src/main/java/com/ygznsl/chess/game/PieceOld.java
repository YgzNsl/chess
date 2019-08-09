package com.ygznsl.chess.game;

public abstract class PieceOld
{
    //
    //    protected final Pieces type;
    //    protected final Color color;
    //    protected boolean outOfGame = false;
    //    protected Square square = null;
    //
    //    PieceOld(Pieces type, Color color)
    //    {
    //        this.type = Objects.requireNonNull(type, "PieceOld type cannot be null.");
    //        this.color = Objects.requireNonNull(color, "PieceOld requires a color.");
    //    }
    //
    //    private void getSquares(boolean threats, Consumer<List<Direction[]>> directionSequenceListConsumer)
    //    {
    //        if (Objects.nonNull(directionSequenceListConsumer))
    //        {
    //            if (threats ? threatensNorth() : canMoveNorth())
    //                directionSequenceListConsumer.accept(Collections.singletonList(new Direction[]{Direction.NORTH}));
    //
    //            if (threats ? threatensSouth() : canMoveSouth())
    //                directionSequenceListConsumer.accept(Collections.singletonList(new Direction[]{Direction.SOUTH}));
    //
    //            if (threats ? threatensWest() : canMoveWest())
    //                directionSequenceListConsumer.accept(Collections.singletonList(new Direction[]{Direction.WEST}));
    //
    //            if (threats ? threatensEast() : canMoveEast())
    //                directionSequenceListConsumer.accept(Collections.singletonList(new Direction[]{Direction.EAST}));
    //
    //            if (threats ? threatensNorthWest() : canMoveNorthWest())
    //                directionSequenceListConsumer.accept(Collections.singletonList(new Direction[]{Direction.NORTH_WEST}));
    //
    //            if (threats ? threatensNorthEast() : canMoveNorthEast())
    //                directionSequenceListConsumer.accept(Collections.singletonList(new Direction[]{Direction.NORTH_EAST}));
    //
    //            if (threats ? threatensSouthWest() : canMoveSouthWest())
    //                directionSequenceListConsumer.accept(Collections.singletonList(new Direction[]{Direction.SOUTH_WEST}));
    //
    //            if (threats ? threatensSouthEast() : canMoveSouthEast())
    //                directionSequenceListConsumer.accept(Collections.singletonList(new Direction[]{Direction.SOUTH_EAST}));
    //
    //            if (threats ? threatensLMotion() : canMoveLMotion())
    //            {
    //                final List<Direction[]> directionSequences = Arrays.asList(
    //                        new Direction[]{Direction.NORTH_WEST, Direction.WEST},
    //                        new Direction[]{Direction.NORTH_WEST, Direction.NORTH},
    //                        new Direction[]{Direction.NORTH_EAST, Direction.EAST},
    //                        new Direction[]{Direction.NORTH_EAST, Direction.NORTH},
    //                        new Direction[]{Direction.SOUTH_WEST, Direction.WEST},
    //                        new Direction[]{Direction.SOUTH_WEST, Direction.SOUTH},
    //                        new Direction[]{Direction.SOUTH_EAST, Direction.EAST},
    //                        new Direction[]{Direction.SOUTH_EAST, Direction.SOUTH}
    //                );
    //
    //                directionSequenceListConsumer.accept(directionSequences);
    //            }
    //        }
    //    }
    //
    //    protected Predicate<Position> getPositionPredicateMethodFromDirection(Direction direction)
    //    {
    //        switch (direction)
    //        {
    //            case NORTH:
    //                return Position::hasNorth;
    //            case SOUTH:
    //                return Position::hasSouth;
    //            case WEST:
    //                return Position::hasWest;
    //            case EAST:
    //                return Position::hasEast;
    //            case NORTH_WEST:
    //                return Position::hasNorthWest;
    //            case NORTH_EAST:
    //                return Position::hasNorthEast;
    //            case SOUTH_WEST:
    //                return Position::hasSouthWest;
    //            case SOUTH_EAST:
    //                return Position::hasSouthEast;
    //            default:
    //                return null;
    //        }
    //    }
    //
    //    protected PositionSupplier getPositionSupplierMethodFromDirection(Direction direction, Position position)
    //    {
    //        switch (direction)
    //        {
    //            case NORTH:
    //                return position::getNorth;
    //            case SOUTH:
    //                return position::getSouth;
    //            case WEST:
    //                return position::getWest;
    //            case EAST:
    //                return position::getEast;
    //            case NORTH_WEST:
    //                return position::getNorthWest;
    //            case NORTH_EAST:
    //                return position::getNorthEast;
    //            case SOUTH_WEST:
    //                return position::getSouthWest;
    //            case SOUTH_EAST:
    //                return position::getSouthEast;
    //            default:
    //                return null;
    //        }
    //    }
    //
    //    protected PieceOld getOpponentInDirection(Direction direction)
    //    {
    //        if (Objects.isNull(square) || Objects.isNull(direction))
    //            return null;
    //
    //        final Position currentPosition = square.getPosition();
    //        final Predicate<Position> positionPredicate = getPositionPredicateMethodFromDirection(direction);
    //
    //        if (Objects.isNull(positionPredicate) || !positionPredicate.test(currentPosition))
    //            return null;
    //
    //        final PositionSupplier positionSupplier = getPositionSupplierMethodFromDirection(direction, currentPosition);
    //        if (Objects.isNull(positionSupplier))
    //            return null;
    //
    //        try
    //        {
    //            final Position targetPosition = positionSupplier.getPosition();
    //            if (Objects.isNull(targetPosition))
    //                return null;
    //
    //            final Square targetSquare = square
    //                    .getBoard()
    //                    .getSquare(targetPosition);
    //
    //            if (Objects.isNull(targetSquare) || !targetSquare.isOccupied())
    //                return null;
    //
    //            final PieceOld occupant = targetSquare.getOccupant();
    //            final boolean opponent = occupant
    //                    .getColor()
    //                    .isOpponentOf(color);
    //
    //            return opponent ? occupant : null;
    //        }
    //        catch (InvalidPositionException ex)
    //        {
    //            return null;
    //        }
    //    }
    //
    //    protected boolean checkOpponentExistsInDirection(Direction direction)
    //    {
    //        return Objects.nonNull(getOpponentInDirection(direction));
    //    }
    //
    //    protected boolean checkIfDirectionIsUnderKingThreat(Direction direction)
    //    {
    //        final Position currentPosition = getCurrentPosition();
    //        final Predicate<Position> positionPredicate = getPositionPredicateMethodFromDirection(direction);
    //        if (Objects.isNull(positionPredicate) || !positionPredicate.test(currentPosition))
    //            return false;
    //
    //        final PositionSupplier positionSupplier = getPositionSupplierMethodFromDirection(direction, currentPosition);
    //        if (Objects.isNull(positionSupplier))
    //            return false;
    //
    //        try
    //        {
    //            final Position position = positionSupplier.getPosition();
    //            final Square targetSquare = square
    //                    .getBoard()
    //                    .getSquare(position);
    //
    //            return Objects.nonNull(targetSquare) && targetSquare
    //                    .getThreateningPieceOlds()
    //                    .stream()
    //                    .anyMatch(piece -> piece instanceof King);
    //        }
    //        catch (InvalidPositionException ex)
    //        {
    //            return false;
    //        }
    //    }
    //
    //    protected Position getFinalPositionFromCurrentPosition(Position currentPosition, Direction[] directionSequence, boolean excludeBlockedMoves)
    //    {
    //        if (Objects.nonNull(square) && Objects.nonNull(currentPosition) && Objects.nonNull(directionSequence))
    //        {
    //            Position position = currentPosition;
    //
    //            for (Direction direction : directionSequence)
    //            {
    //                final Predicate<Position> positionPredicate = getPositionPredicateMethodFromDirection(direction);
    //                if (Objects.isNull(positionPredicate))
    //                    return null;
    //
    //                if (!positionPredicate.test(position))
    //                    return null;
    //
    //                final PositionSupplier positionSupplier = getPositionSupplierMethodFromDirection(direction, position);
    //                if (Objects.isNull(positionSupplier))
    //                    return null;
    //
    //                try
    //                {
    //                    position = positionSupplier.getPosition();
    //
    //                    if (excludeBlockedMoves)
    //                    {
    //                        final Square targetSquare = square
    //                                .getBoard()
    //                                .getSquare(position);
    //
    //                        if (targetSquare.isOccupied() && !canOvercomePieceOlds())
    //                        {
    //                            final boolean isOpponent = targetSquare
    //                                    .getOccupant()
    //                                    .getColor()
    //                                    .isOpponentOf(color);
    //
    //                            return isOpponent ? position : null;
    //                        }
    //                    }
    //                }
    //                catch (InvalidPositionException ignored)
    //                {
    //                }
    //            }
    //
    //            return position;
    //        }
    //
    //        return null;
    //    }
    //
    //    protected final Position getCurrentPosition()
    //    {
    //        return outOfGame || Objects.isNull(square) ? null : square.getPosition();
    //    }
    //
    //    protected void detectPositionsByDirectionSequences(List<Direction[]> directionSequences, boolean excludeBlockedMoves, Consumer<Position> positionConsumer)
    //    {
    //        final Position currentPosition = getCurrentPosition();
    //        if (Objects.nonNull(currentPosition) && Objects.nonNull(directionSequences))
    //        {
    //            final int moves = getMoveCount();
    //            int moved = 0;
    //
    //            for (Direction[] directionSequence : directionSequences)
    //            {
    //                Position position = currentPosition;
    //                while ((moves == -1 || moved < moves) && Objects.nonNull(position))
    //                {
    //                    position = getFinalPositionFromCurrentPosition(position, directionSequence, excludeBlockedMoves);
    //                    moved++;
    //
    //                    if (Objects.nonNull(position))
    //                    {
    //                        positionConsumer.accept(position);
    //                    }
    //                }
    //            }
    //        }
    //    }
    //
    //    protected void detectAvailableMoves(List<Move> availableMoves, List<Direction[]> directionSequences)
    //    {
    //        if (Objects.nonNull(availableMoves))
    //        {
    //            final Position currentPosition = getCurrentPosition();
    //            detectPositionsByDirectionSequences(directionSequences, true, finalPosition -> {
    //                final boolean transforms = checkMoveTransformsPieceOld(finalPosition);
    //                final Move move = new Move(this, currentPosition, finalPosition, transforms);
    //                availableMoves.add(move);
    //            });
    //        }
    //    }
    //
    //    protected void detectThreatenedSquares(List<Square> threatenedSquares, List<Direction[]> directionSequences)
    //    {
    //        if (Objects.nonNull(square) || Objects.nonNull(threatenedSquares))
    //        {
    //            detectPositionsByDirectionSequences(directionSequences, false, finalPosition -> {
    //                final Square threatenedSquare = square
    //                        .getBoard()
    //                        .getSquare(finalPosition);
    //
    //                threatenedSquares.add(threatenedSquare);
    //            });
    //        }
    //    }
    //
    //    protected final void setTaken()
    //    {
    //        this.outOfGame = true;
    //    }
    //
    //    public final Pieces getType()
    //    {
    //        return type;
    //    }
    //
    //    public final Color getColor()
    //    {
    //        return color;
    //    }
    //
    //    public final boolean isOutOfGame()
    //    {
    //        return outOfGame;
    //    }
    //
    //    public final Square getSquare()
    //    {
    //        return square;
    //    }
    //
    //    protected void setSquare(Square square)
    //    {
    //        this.square = square;
    //    }
    //
    //    public final boolean isBlack()
    //    {
    //        return Objects.equals(Color.BLACK, color);
    //    }
    //
    //    public final boolean isWhite()
    //    {
    //        return Objects.equals(Color.WHITE, color);
    //    }
    //
    //    public final List<Move> getAvailableMoves()
    //    {
    //        if (outOfGame || !canMove())
    //            return Collections.emptyList();
    //
    //        final LinkedList<Move> availableMoves = new LinkedList<>();
    //        getSquares(false, directions -> detectAvailableMoves(availableMoves, directions));
    //        return availableMoves;
    //    }
    //
    //    public final List<Square> getThreatenedSquares()
    //    {
    //        if (outOfGame || !canMove())
    //            return Collections.emptyList();
    //
    //        final LinkedList<Square> threatenedSquares = new LinkedList<>();
    //        getSquares(true, directions -> detectThreatenedSquares(threatenedSquares, directions));
    //        return threatenedSquares;
    //    }
    //
    //    protected void onMove()
    //    {
    //    }
    //
    //    protected boolean checkMoveTransformsPieceOld(Position finalPosition)
    //    {
    //        return false;
    //    }
    //
    //    protected boolean canMove()
    //    {
    //        return true;
    //    }
    //
    //    protected boolean canOvercomePieceOlds()
    //    {
    //        return false;
    //    }
    //
    //    protected abstract int getMoveCount();
    //
    //    protected abstract boolean canMoveNorth();
    //
    //    protected abstract boolean canMoveSouth();
    //
    //    protected abstract boolean canMoveWest();
    //
    //    protected abstract boolean canMoveEast();
    //
    //    protected abstract boolean canMoveNorthWest();
    //
    //    protected abstract boolean canMoveNorthEast();
    //
    //    protected abstract boolean canMoveSouthWest();
    //
    //    protected abstract boolean canMoveSouthEast();
    //
    //    protected abstract boolean canMoveLMotion();
    //
    //    protected boolean threatensNorth()
    //    {
    //        return canMoveNorth();
    //    }
    //
    //    protected boolean threatensSouth()
    //    {
    //        return canMoveSouth();
    //    }
    //
    //    protected boolean threatensWest()
    //    {
    //        return canMoveWest();
    //    }
    //
    //    protected boolean threatensEast()
    //    {
    //        return canMoveEast();
    //    }
    //
    //    protected boolean threatensNorthWest()
    //    {
    //        return canMoveNorthWest();
    //    }
    //
    //    protected boolean threatensNorthEast()
    //    {
    //        return canMoveNorthEast();
    //    }
    //
    //    protected boolean threatensSouthWest()
    //    {
    //        return canMoveSouthWest();
    //    }
    //
    //    protected boolean threatensSouthEast()
    //    {
    //        return canMoveSouthEast();
    //    }
    //
    //    protected boolean threatensLMotion()
    //    {
    //        return canMoveLMotion();
    //    }

}
