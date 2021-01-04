package agh.cs.project.render;

import agh.cs.project.utility.Vector2;
import processing.core.PApplet;

public class Transformable {
    private Vector2 position;
    private float scale;
    private float rotation;
    private Vector2 origin;

    public Transformable() {
        position = new Vector2(0, 0);
        scale = 1.0f;
        rotation = 0.0f;
        origin = new Vector2(0,0 );
    }

    protected void applyTransformation(PApplet context) {
        context.translate(position.x+origin.x, position.y+origin.y);
        context.rotate(rotation);
        context.translate(-origin.x, -origin.y);
        context.scale(scale);
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void move(Vector2 offset) {
        position = position.add(offset);
    }

    public Vector2 getPosition() {
        return position;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public void scale(float scale) {
        this.scale *= scale;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public void rotate(float rotation) {
        this.rotation += rotation;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotationOrigin(Vector2 origin) {
        this.origin = origin;
    }

    public Vector2 getRotationOrigin() {
        return origin;
    }

}
