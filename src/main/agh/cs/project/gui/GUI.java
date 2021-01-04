package agh.cs.project.gui;

import agh.cs.project.render.Pawn;
import agh.cs.project.utility.AppStyle;
import agh.cs.project.utility.Vector2;
import processing.core.PApplet;

import java.util.ArrayList;

public class GUI extends Pawn {
    private ArrayList<Widget> widgets;
    private ArrayList<Widget> widgetsToRemove;
    private ArrayList<Widget> widgetsToAdd;
    private Vector2 size;

    public GUI(Vector2 size) {
        widgets = new ArrayList<>();
        widgetsToRemove = new ArrayList<>();
        widgetsToAdd = new ArrayList<>();
        this.size = size;
    }

    public Widget addWidget(Widget widget) {
        widgetsToAdd.add(widget);
        return widget;
    }

    public void removeWidget(Widget widget) {
        widgetsToRemove.add(widget);
    }

    public boolean mouseClicked(Vector2 mousePosition) {
        if(
                mousePosition.biggerThan(getPosition()) &&
                mousePosition.smallerThan(getPosition().add(size))
        ) {
            mousePosition = mousePosition.sub(getPosition());
            for (Widget widget : widgets) {
                widget.mouseClicked(mousePosition);
            }
        }
        else
            return false;
        return true;
    }

    @Override
    protected void drawPawn(PApplet context) {
        while(!widgetsToRemove.isEmpty())
            widgets.remove(widgetsToRemove.remove(0));

        while(!widgetsToAdd.isEmpty())
            widgets.add(widgetsToAdd.remove(0));

        context.fill(AppStyle.MAIN_COLOR.getRGB());
        context.rect(0, 0, size.x, size.y);
        context.noFill();
        for(Widget widget : widgets) {
            widget.draw(context);
        }
    }
}
