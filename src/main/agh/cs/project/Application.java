package agh.cs.project;


import agh.cs.project.window.Window;
import processing.core.PApplet;

public class Application  {
    private PApplet window;

    public Application() {
        window = new Window();
    }

    public void run() {
        PApplet.runSketch(new String[]{"Simulation"}, window);
    }

}
