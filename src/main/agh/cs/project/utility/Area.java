package agh.cs.project.utility;

public class Area {
    public Area(Vector2 position, Vector2 size) {
        this.position = position;
        this.size = size;
    }

    public boolean contains(Vector2 point) {
        return point.biggerThan(position) && point.smallerThan(position.add(new Vector2(size.x-1, size.y-1)));
    }

    public Vector2 position;
    public Vector2 size;
}
