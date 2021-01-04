package agh.cs.project.gui;

import agh.cs.project.render.Pawn;
import agh.cs.project.utility.Vector2;
import processing.core.PApplet;
import processing.event.MouseEvent;

public abstract class Widget extends Pawn {
    private Vector2 size;
    private boolean hidden;

    public Widget(Vector2 size) {
        super();
        this.size = size;
        hidden = false;
    }

    public Widget() {
        this(new Vector2(0,0));
    }

    public boolean isHidden() {
        return hidden;
    }
    public void hide() {
        hidden = true;
    }
    public void show() {
        hidden = false;
    }

    protected void onClick() {

    }

    public Vector2 getSize() {
        return size;
    }

    public void setSize(Vector2 size) {
        this.size = size;
    }

    final public void mouseClicked(Vector2 mousePosition) {
        if (
                !hidden &&
                mousePosition.biggerThan(getPosition()) &&
                mousePosition.smallerThan(getPosition().add(size))
        ) {
            onClick();
        }
    }
}
