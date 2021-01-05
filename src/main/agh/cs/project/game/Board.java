package agh.cs.project.game;

import agh.cs.project.assetsManager.AssetsManager;
import agh.cs.project.render.Pawn;
import agh.cs.project.utility.AppStyle;
import processing.core.PApplet;
import processing.core.PFont;
import processing.event.KeyEvent;

public class Board extends Pawn {
    private int size;
    private TilesManager tilesManager;

    public Board(int size) {
        this.size = size;
        tilesManager = new TilesManager(size);
    }

    public void keyReleased(KeyEvent event) {
        if(tilesManager.isGameLost()) {
            tilesManager = new TilesManager(size);
        }
        else {
            switch (event.getKeyCode()) {
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
    }

    public void update() {
        tilesManager.update();
    }

    @Override
    protected void drawPawn(PApplet context) {
        context.fill(AppStyle.BOARD_COLOR.getRGB());
        int boardSize = (size+1)*AppStyle.TILE_PIXEL_GAP + size*AppStyle.TILE_PIXEL_SIZE;
        context.rect(0, 0, boardSize, boardSize);
        tilesManager.draw(context);

        if(tilesManager.isGameLost()) {
            context.fill(255, 255, 255,128);
            context.rect(0, 0, (size+1)*AppStyle.TILE_PIXEL_GAP + size*AppStyle.TILE_PIXEL_SIZE, (size+1)*AppStyle.TILE_PIXEL_GAP + size*AppStyle.TILE_PIXEL_SIZE);
            context.textFont((PFont) AssetsManager.ASSETS.get(AppStyle.FONT));
            context.textAlign(PApplet.CENTER, PApplet.CENTER);
            context.fill(AppStyle.TILE_TEXT_COLOR.getRGB());
            context.textSize(AppStyle.TILE_VALUE_FONT_SIZE*1.7f);
            context.text("GAME OVER!", (float)boardSize/2.f, (float)boardSize/2.f);
            context.textSize(AppStyle.TILE_VALUE_FONT_SIZE*0.7f);

            context.fill(AppStyle.TILE_TEXT_COLOR.getRed(), AppStyle.TILE_TEXT_COLOR.getGreen(), AppStyle.TILE_TEXT_COLOR.getBlue(), 200);
            context.text("Click button to continue...", (float)boardSize/2.f, (float)boardSize/2.f+50.f);
        }

        context.noFill();
    }
}
