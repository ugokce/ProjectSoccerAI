package arhrs.movement;

import arhrs.util.VectorUtils;
import math.geom2d.Vector2D;

import java.util.ArrayList;
import java.util.List;

public class LineSegmentsPath implements Path<Vector2D,Integer>{

    private static final double DistanceThreshold = 0.1;
    List<Vector2D> nodes= new ArrayList<>();

    public void addNode(Vector2D node)
    {
        nodes.add(node);
    }



    @Override
    public Integer getIndex(Vector2D currentPosition, Integer lastIndex) {
        if (lastIndex==null)
            return 0;
        if (lastIndex.intValue()==nodes.size()-1)
            return lastIndex;

        if (VectorUtils.distance(nodes.get(lastIndex),currentPosition)<DistanceThreshold)
            return lastIndex+1;
        else return lastIndex;


    }

    @Override
    public Vector2D getPosition(Integer o) {
        return nodes.get(o.intValue());
    }
}
