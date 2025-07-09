package ru.mathemator.demo.javahistory.java1_0.awt;

import java.awt.*;


public class AwtExample extends Frame {

    Button openDialogButton;
    OkDialog dialog;

    public AwtExample() {
        super("AWT Example 1.0");

        setLayout(new FlowLayout());
        setSize(300, 200);
        setLocation(200, 200);

        openDialogButton = new Button("Нажми меня");
        add(openDialogButton);

        dialog = new OkDialog(this);

        setVisible(true);
    }

    public boolean handleEvent(Event e) {
        if (e.target == openDialogButton && e.id == Event.ACTION_EVENT) {
            dialog.show();
            return true;
        }

        if (e.id == Event.WINDOW_DESTROY) {
            dispose();
            System.exit(0);
            return true;
        }

        return super.handleEvent(e);
    }

    public static void main(String[] args) {
        new AwtExample();
    }
}

