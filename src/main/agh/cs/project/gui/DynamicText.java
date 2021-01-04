package agh.cs.project.gui;

import agh.cs.project.utility.Vector2;
import processing.core.PApplet;

import java.util.function.Consumer;

public class DynamicText extends Widget {
    private Consumer<Consumer<String>> callback;
    private String text;

    public DynamicText(Consumer<Consumer<String>> callback) {
        super(new Vector2(0,0));
        this.callback = callback;
        text = "";
    }


    @Override
    protected void drawPawn(PApplet context) {
        callback.accept((String str)->{
            text = str;
        });
        setSize(new Vector2( (int)context.textWidth(text), (int)(context.textAscent() + context.textDescent()) ));
        context.fill(255);
        context.textLeading(17.f);
        context.text(text, 0, 0);
    }
}
