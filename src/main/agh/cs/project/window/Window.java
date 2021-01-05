package agh.cs.project.window;

import agh.cs.project.assetsManager.AssetsManager;
import agh.cs.project.game.Board;
import agh.cs.project.gui.Button;
import agh.cs.project.gui.GUI;
import agh.cs.project.utility.AppStyle;
import agh.cs.project.utility.Logger;
import agh.cs.project.utility.Vector2;
import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

import java.util.ArrayList;

public class Window extends PApplet {
    private ArrayList<GUI> gui;

    private Board board;

    private int size = 7;


    private void loadAssets() {
        try {
            AssetsManager.ASSETS.put(AppStyle.FONT, createFont("Arial Bold", 15.f));
        }
        catch(Exception e) {
            Logger.log("Cannot load assets");
        }
    }


    @Override
    public void setup() {
        loadAssets();

        getSurface().setTitle("Simulation");

        noFill();
        noStroke();
        textSize(AppStyle.BUTTON_FONT_SIZE);

        gui = new ArrayList<>();
        board = new Board(size);
    }

    @Override
    public void settings() {
        size(
                (size+1)*AppStyle.TILE_PIXEL_GAP + size*AppStyle.TILE_PIXEL_SIZE,
                (size+1)*AppStyle.TILE_PIXEL_GAP + size*AppStyle.TILE_PIXEL_SIZE
        );
    }

    @Override
    public void draw() {
        background(130,130,130);

        board.update();
        board.draw(this);

        for(GUI gui : gui)
            gui.draw(this);
    }

    @Override
    public void keyReleased(KeyEvent event) {
        board.keyReleased(event);
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        if(event.getButton()==LEFT) {
            boolean guiClicked = false;
            Vector2 mousePosition = new Vector2(event.getX(), event.getY());
            for(GUI gui : gui) {
                if (gui.mouseClicked(mousePosition))
                    guiClicked = true;
            }
        }
    }
}
