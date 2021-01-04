package agh.cs.project.gui;

import agh.cs.project.utility.AppStyle;
import agh.cs.project.utility.Vector2;
import processing.core.PApplet;

import java.util.function.Consumer;

public class Button extends Widget {
    private Consumer<Button> callback;
    private String text;

    private int margin;
    private int fontSize;

    public Button(PApplet context, String text, Consumer<Button> callback) {
        this.text = text;
        this.callback = callback;

        context.textSize(AppStyle.BUTTON_FONT_SIZE);
        setSize(new Vector2(
                2*AppStyle.BUTTON_MARGIN + (int)context.textWidth(text),
                2*AppStyle.BUTTON_MARGIN + (int)context.textAscent()
        ));

    }

    public Button setCallback(Consumer<Button> callback) {
        this.callback = callback;
        return this;
    }

    @Override
    protected void onClick() {
        if(callback != null)
            callback.accept(this);
    }

    @Override
    protected void drawPawn(PApplet context) {
        if(isHidden())
            return;
        context.fill(AppStyle.SECONDARY_COLOR.getRGB());
        context.rect(0, 0, getSize().x, getSize().y, 7);


        context.fill(AppStyle.TEXT_COLOR.getRGB());
        context.textSize(AppStyle.BUTTON_FONT_SIZE);
        context.text(text, AppStyle.BUTTON_MARGIN, getSize().y-AppStyle.BUTTON_MARGIN);
        context.noFill();
    }
}
