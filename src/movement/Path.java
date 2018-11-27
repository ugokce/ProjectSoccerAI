package arhrs.movement;

public interface Path<Position, Index> {

    Index getIndex(Position currentPosition, Index lastIndex);
    Position getPosition(Index index);

}
