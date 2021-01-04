package agh.cs.project.game;

import agh.cs.project.render.Pawn;
import agh.cs.project.utility.Vector2;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Random;

public class TilesManager extends Pawn {
    private Random random;

    private int size;

    private Tile tiles[][];
    private ArrayList<Tile> legacyTiles;

    public TilesManager(int size) {
        this.random = new Random();

        this.size = size;

        legacyTiles = new ArrayList<>();
        tiles = new Tile[size][size];
        for(int y = 0; y<size; ++y) {
            for(int x = 0; x<size; ++x) {
                tiles[y][x] = null;
                tiles[y][x] = null;
            }
        }

        Vector2 pos1 = new Vector2(random.nextInt(size), random.nextInt(size));
        Vector2 pos2;
        do {
            pos2 = new Vector2(random.nextInt(size), random.nextInt(size));
        } while(pos1.equals(pos2));
        //insertTile(pos1);
        //insertTile(pos2);
        insertTile(new Vector2(0, 3));
        insertTile(new Vector2(2, 3));

    }

    private void moved() {
        int count = 0;
        for(int y = 0; y<size; ++y) {
            for(int x = 0; x<size; ++x) {
                if(tiles[y][x] != null)
                    count++;
            }
        }
        System.out.println(count);

    }
    public void moveLeft() {
        MOVE LEFT JUZ DZIALA. PRZEKOPIUJ JEGO DZIALANIE DO RESZTY :D
        legacyTiles.clear();
        for(int y = 0; y<size; ++y) {
            int last = -1;
            for(int x = 0; x<size; ++x) {
                if(tiles[y][x] != null) {
                    if(last < 0 || tiles[y][last].getValue() != tiles[y][x].getValue()) {
                        last++;
                        if(x != last) {
                            tiles[y][last] = tiles[y][x];
                            tiles[y][last].setBoardPosition(new Vector2(last, y));
                            tiles[y][x] = null;
                        }
                    }
                    else {
                        tiles[y][last].combine();

                        tiles[y][x].setBoardPosition(new Vector2(last, y));
                        legacyTiles.add(tiles[y][x]);
                        tiles[y][x] = null;
                        last++;
                    }
                }
            }
        }
        moved();
    }

    /*public void moveLeft2() {
        legacyTiles.clear();
        for(int y = 0; y<size; ++y) {
            int last = -1;
            for(int x = 0; x<size; ++x) {
                if(tiles[y][x] != null) {
                    if(last < 0) {
                        tiles[y][0] = tiles[y][x];
                        tiles[y][0].setBoardPosition(new Vector2(0, y));
                        last = 0;
                    }
                    else if(tiles[y][last].getValue() == tiles[y][x].getValue()) {
                        tiles[y][last].combine();

                        tiles[y][x].setBoardPosition(new Vector2(last, y));
                        legacyTiles.add(tiles[y][x]);
                        tiles[y][x] = null;
                        last++;
                    }
                    else {
                        last++;
                        tiles[y][last] = tiles[y][x];
                        tiles[y][last].setBoardPosition(new Vector2(last, y));
                    }
                }
            }
            for(int x = last+1; x<size; ++x)
                tiles[y][x] = null;
        }
        moved();
    }*/
    public void moveRight() {
        legacyTiles.clear();
        for(int y = 0; y<size; ++y) {
            int last = size;
            for(int x = size-1; x>=0; --x) {
                if(tiles[y][x] != null) {
                    if(last > size-1) {
                        tiles[y][size-1] = tiles[y][x];
                        tiles[y][size-1].setBoardPosition(new Vector2(size-1, y));
                        last = size-1;
                    }
                    else if(tiles[y][last].getValue() == tiles[y][x].getValue()) {
                        tiles[y][last].combine();

                        tiles[y][x].setBoardPosition(new Vector2(last, y));
                        legacyTiles.add(tiles[y][x]);
                        tiles[y][x] = null;
                        last--;
                    }
                    else {
                        last--;
                        tiles[y][last] = tiles[y][x];
                        tiles[y][last].setBoardPosition(new Vector2(last, y));
                    }
                }
            }
            for(int x = last-1; x>=0; --x)
                tiles[y][x] = null;
        }
        moved();
    }
    public void moveDown() {
        legacyTiles.clear();
        for(int x = 0; x<size; ++x) {
            int last = size;
            for(int y = size-1; y>=0; --y) {
                if(tiles[y][x] != null) {
                    if(last > size-1) {
                        tiles[size-1][x] = tiles[y][x];
                        tiles[size-1][x].setBoardPosition(new Vector2(x, size-1));
                        last = size-1;
                    }
                    else if(tiles[last][x].getValue() == tiles[y][x].getValue()) {
                        tiles[last][x].combine();

                        tiles[y][x].setBoardPosition(new Vector2(x, last));
                        legacyTiles.add(tiles[y][x]);
                        tiles[y][x] = null;
                        last--;
                    }
                    else {
                        last--;
                        tiles[last][x] = tiles[y][x];
                        tiles[last][x].setBoardPosition(new Vector2(x, last));
                    }
                }
            }
            for(int y = last-1; y>=0; --y)
                tiles[y][x] = null;
        }
        moved();
    }
    /* last = 0
    t
    t
    n
    T+


     */
    public void moveUp() {
        legacyTiles.clear();
        for(int x = 0; x<size; ++x) {
            int last = -1;
            for(int y = 0; y<size; ++y) {
                if(tiles[y][x] != null) {
                    if(last < 0) {
                        tiles[0][x] = tiles[y][x];
                        tiles[0][x].setBoardPosition(new Vector2(x, 0));
                        last = 0;
                    }
                    else if(tiles[last][x].getValue() == tiles[y][x].getValue()) {
                        tiles[last][x].combine();

                        tiles[y][x].setBoardPosition(new Vector2(x, last));
                        legacyTiles.add(tiles[y][x]);
                        tiles[y][x] = null;
                        last++;
                    }
                    else {
                        last++;
                        tiles[last][x] = tiles[y][x];
                        tiles[last][x].setBoardPosition(new Vector2(x, last));
                    }
                }
            }
            for(int y = last+1; y<size; ++y)
                tiles[y][x] = null;
        }
        moved();
    }

    public void insertTile(Vector2 position) {
        if(tiles[position.y][position.x] != null)
            return;
        tiles[position.y][position.x] = new Tile(position, random.nextInt(4) == 0?4:2);
        tiles[position.y][position.x].setPosition(tiles[position.y][position.x].getTargetPosition());
    }

    public void update() {
        for(int y = 0; y<size; ++y) {
            for(int x = 0; x<size; ++x) {
                if(tiles[y][x] != null)
                    tiles[y][x].update();
            }
        }
        for(Tile tile : legacyTiles)
            tile.update();
    }

    Tile[][] getTiles() {
        return tiles;
    }


    @Override
    protected void drawPawn(PApplet context) {
        for(Tile tile : legacyTiles)
            tile.draw(context);
        for(int y = 0; y<size; ++y) {
            for(int x = 0; x<size; ++x) {
                if(tiles[y][x] != null)
                    tiles[y][x].draw(context);
            }
        }
    }
}
