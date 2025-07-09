package ru.mathemator.demo.javahistory.java1_0.awt;

import java.awt.*;

// Класс диалога с собственной обработкой событий
class OkDialog extends Dialog {

    Button okButton;

    OkDialog(Frame parent) {
        super(parent, "Сообщение", true);
        setLayout(new FlowLayout());
        setSize(200, 100);
        setLocation(250, 250);

        add(new Label("Привет из AWT 1.0!"));

        okButton = new Button("OK");
        add(okButton);
    }

    public boolean handleEvent(Event e) {
        if (e.target == okButton && e.id == Event.ACTION_EVENT) {
            hide();
            return true;
        }

        if (e.id == Event.WINDOW_DESTROY) {
            hide(); // Закрытие по крестику
            return true;
        }

        return super.handleEvent(e);
    }
}
