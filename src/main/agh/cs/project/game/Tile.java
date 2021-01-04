package agh.cs.project.game;

import agh.cs.project.render.Pawn;
import agh.cs.project.utility.AppStyle;
import agh.cs.project.utility.Vector2;
import processing.core.PApplet;

public class Tile extends Pawn {
    private int value;
    private Vector2 boardPosition;
    public Tile(Vector2 boardPosition, int value) {
        this.boardPosition = boardPosition;
        this.value = Math.max(2, value);
    }

    public void setBoardPosition(Vector2 boardPosition) {
        this.boardPosition = boardPosition;
    }

    public int getValue() {
        return value;
    }

    public void combine() {
        value *= 2;
    }

    public Vector2 getTargetPosition() {
        return new Vector2(
                AppStyle.TILE_PIXEL_GAP + boardPosition.x * (AppStyle.TILE_PIXEL_GAP + AppStyle.TILE_PIXEL_SIZE),
                AppStyle.TILE_PIXEL_GAP + boardPosition.y * (AppStyle.TILE_PIXEL_GAP + AppStyle.TILE_PIXEL_SIZE)
        );
    }

    public void update() {
        Vector2 targetPosition = getTargetPosition();

        Vector2 delta = targetPosition.sub(getPosition());
        if(delta.length() <= AppStyle.TILE_SPEED )
            setPosition(targetPosition);
        else
            move(delta.withLength(AppStyle.TILE_SPEED));

    }

    @Override
    protected void drawPawn(PApplet context) {
        context.fill(
                AppStyle.TILE_COLORS[
                        Math.min(
                                Math.max(1, (int)(Math.log(value)/Math.log(2))),
                                AppStyle.TILE_COLORS_AMOUNT
                        ) - 1
                        ].getRGB()
        );
        context.rect(
                0,
                0,
                AppStyle.TILE_PIXEL_SIZE,
                AppStyle.TILE_PIXEL_SIZE,
                AppStyle.TILE_ROUNDNESS
        );
        context.textAlign(PApplet.CENTER, PApplet.CENTER);
        context.fill(AppStyle.TEXT_COLOR.getRGB());
        context.textSize(AppStyle.TILE_VALUE_FONT_SIZE);
        context.text(Integer.toString(value), (float)AppStyle.TILE_PIXEL_SIZE/2.f, (float)AppStyle.TILE_PIXEL_SIZE/2.f);
        context.noFill();
    }
}
