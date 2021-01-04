package agh.cs.project.utility;

import processing.core.PApplet;

public class Logger {
    public static PApplet context = null;


    public static void log(String message) {
        System.out.println(message);
    }
}
