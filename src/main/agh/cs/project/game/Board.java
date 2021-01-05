package agh.cs.project.game;

import agh.cs.project.render.Pawn;
import agh.cs.project.utility.AppStyle;
import processing.core.PApplet;
import processing.event.KeyEvent;

public class Board extends Pawn {
    private int size;
    private TilesManager tilesManager;

    public Board(int size) {
        this.size = size;
        tilesManager = new TilesManager(size);
    }

    public void keyReleased(KeyEvent event) {
        switch(event.getKeyCode()) {
            case PApplet.LEFT:
                tilesManager.moveLeft();
                break;
            case PApplet.RIGHT:
                tilesManager.moveRight();
                break;
            case PApplet.UP:
                tilesManager.moveUp();
                break;
            case PApplet.DOWN:
                tilesManager.moveDown();
                break;
        }
    }

    public void update() {
        tilesManager.update();
    }

    @Override
    protected void drawPawn(PApplet context) {
        context.fill(AppStyle.BOARD_COLOR.getRGB());
        context.rect(0, 0, (size+1)*AppStyle.TILE_PIXEL_GAP + size*AppStyle.TILE_PIXEL_SIZE, (size+1)*AppStyle.TILE_PIXEL_GAP + size*AppStyle.TILE_PIXEL_SIZE);

        tilesManager.draw(context);


        context.noFill();
    }
}
