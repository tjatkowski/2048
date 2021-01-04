package agh.cs.project.render;

import processing.core.PApplet;

public abstract class Pawn extends Transformable implements Drawable {
    public Pawn() {
        super();
    }

    abstract protected void drawPawn(PApplet context);

    @Override
    final public void draw(PApplet context) {
        context.pushMatrix();
        applyTransformation(context);

        this.drawPawn(context);

        context.popMatrix();
    }
}
