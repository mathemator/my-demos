package ru.mathemator.demo.javahistory.java1_0.applet;

import java.applet.Applet;
import java.awt.Graphics;

public class HelloApplet extends Applet {
    public void paint(Graphics g) {
        g.drawString("Zdarova iz appleta!", 20, 20);
    }
}