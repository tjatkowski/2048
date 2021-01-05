package agh.cs.project.utility;

import processing.core.PApplet;

import java.awt.*;

public class AppStyle {
    public static boolean DEBUG_MODE = false;

    public static Vector2 WINDOW_SIZE = new Vector2(1280, 720);

    public static Color MAIN_COLOR = new Color(45, 54, 64, 128);
    public static Color SECONDARY_COLOR = new Color(255, 255, 255,128);

    public static Color TEXT_COLOR = new Color(37, 37, 48);

    public static int BUTTON_FONT_SIZE = 15;
    public static int BUTTON_MARGIN = 10;

    public static int TILE_PIXEL_SIZE = 100;
    public static int TILE_PIXEL_GAP = 15;
    public static int TILE_ROUNDNESS = 8;

    public static int TILE_SPEED = 50;
    public static float TILE_FADE_SPEED = 0.1f;
    public static float TILE_VALUE_FONT_SIZE = 35.f;
    public static Color[] TILE_COLORS = new Color[]{
            new Color(255, 244, 230),
            new Color(255, 215, 195),
            new Color(255, 165, 150),
            new Color(255, 156, 145),
            new Color(255, 96, 122),
            new Color(255, 92, 184),
            new Color(244, 87, 255),
            new Color(203, 107, 255),
            new Color(136, 124, 255),
            new Color(110, 192, 255),
            new Color(116, 253, 255),
            new Color(149, 255, 165),
            new Color(255, 254, 163),
    };
    public static Color BOARD_COLOR = new Color(183, 173, 168, 255);
    public static Color TILE_TEXT_COLOR = new Color(84, 79, 77, 255);
    public static int TILE_COLORS_AMOUNT = 13;

    public static String FONT = "font";
}
