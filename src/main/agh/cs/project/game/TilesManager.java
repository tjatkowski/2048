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

    private Boolean gameLost;

    public TilesManager(int size) {
        this.random = new Random();

        this.size = size;
        this.gameLost = null;

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
        insertTile(pos1);
        insertTile(pos2);

    }

    public Boolean isGameLost() {
        if(gameLost == null) {
            for(int y = 0; y<size; ++y) {
                for (int x = 0; x < size; ++x) {
                    if(tiles[y][x] == null) {
                        gameLost = false;
                        return false;
                    }
                }
            }
            for(int y = 0; y<size; ++y) {
                for (int x = 0; x < size-1; ++x) {
                    if(tiles[y][x].getValue() == tiles[y][x+1].getValue()) {
                        gameLost = false;
                        return false;
                    }
                }
            }
            for(int y = 0; y<size-1; ++y) {
                for (int x = 0; x < size; ++x) {
                    if(tiles[y][x].getValue() == tiles[y+1][x].getValue()) {
                        gameLost = false;
                        return false;
                    }
                }
            }
            gameLost = true;
            return true;
        }
        else
            return gameLost;
    }

    private void moved() {
        ArrayList<Vector2> emptySpaces = new ArrayList<>();

        for(int y = 0; y<size; ++y) {
            for (int x = 0; x < size; ++x) {
                if(tiles[y][x] == null)
                    emptySpaces.add(new Vector2(x, y));
            }
        }
        if(emptySpaces.size() > 0)
            insertTile( emptySpaces.get(random.nextInt(emptySpaces.size())) );
        gameLost = null;

    }
    public void moveLeft() {
        legacyTiles.clear();
        for(int y = 0; y<size; ++y) {
            int last = -1;
            for(int x = 0; x<size; ++x) {
                if(tiles[y][x] != null) {
                    if(last < 0 || tiles[y][last] == null || tiles[y][last].getValue() != tiles[y][x].getValue()) {
                        if(last < 0 || tiles[y][last] != null)
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
    public void moveRight() {
        legacyTiles.clear();
        for(int y = 0; y<size; ++y) {
            int last = size;
            for(int x = size-1; x>=0; --x) {
                if(tiles[y][x] != null) {
                    if(last > size-1 || tiles[y][last] == null || tiles[y][last].getValue() != tiles[y][x].getValue()) {
                        if(last > size-1 || tiles[y][last] != null)
                            last--;
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
                        last--;
                    }
                }
            }
        }
        moved();
    }

    public void moveUp() {
        legacyTiles.clear();
        for(int x = 0; x<size; ++x) {
            int last = -1;
            for(int y = 0; y<size; ++y) {
                if(tiles[y][x] != null) {
                    if(last < 0 || tiles[last][x] == null || tiles[last][x].getValue() != tiles[y][x].getValue()) {
                        if(last < 0 || tiles[last][x] != null)
                            last++;
                        if(y != last) {
                            tiles[last][x] = tiles[y][x];
                            tiles[last][x].setBoardPosition(new Vector2(x, last));
                            tiles[y][x] = null;
                        }
                    }
                    else {
                        tiles[last][x].combine();

                        tiles[y][x].setBoardPosition(new Vector2(x, last));
                        legacyTiles.add(tiles[y][x]);
                        tiles[y][x] = null;
                        last++;
                    }
                }
            }
        }
        moved();
    }

    public void moveDown() {
        legacyTiles.clear();
        for(int x = 0; x<size; ++x) {
            int last = size;
            for(int y = size-1; y>=0; --y) {
                if(tiles[y][x] != null) {
                    if(last > size-1 || tiles[last][x] == null || tiles[last][x].getValue() != tiles[y][x].getValue()) {
                        if(last > size-1 || tiles[last][x] != null)
                            last--;
                        if(y != last) {
                            tiles[last][x] = tiles[y][x];
                            tiles[last][x].setBoardPosition(new Vector2(x, last));
                            tiles[y][x] = null;
                        }
                    }
                    else {
                        tiles[last][x].combine();

                        tiles[y][x].setBoardPosition(new Vector2(x, last));
                        legacyTiles.add(tiles[y][x]);
                        tiles[y][x] = null;
                        last--;
                    }
                }
            }
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
