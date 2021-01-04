package agh.cs.project.render;

import agh.cs.project.utility.Vector2;
import processing.core.PApplet;
import processing.core.PImage;

public class Sprite extends Pawn {
    public Sprite(PImage texture) {
        setTexture(texture);
    }

    public Vector2 getSize() {
        return size;
    }

    public void setTexture(PImage texture) {
        this.texture = texture;
        size = new Vector2(texture.width, texture.height);
    }

    public PImage getTexture() {
        return texture;
    }

    public void setCenterOrigin() {
        setRotationOrigin(new Vector2(size.x/2, size.y/2));
    }

    @Override
    final protected void drawPawn(PApplet context) {
        context.image(texture, 0, 0);
    }

    private Vector2 size;
    private PImage texture;
}
