package ru.mathemator.demo.javahistory.java1_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
    Тут используем листенеры - фишка 1.1
    Еще важно! Анонимные классы тоже 1.1
 */
public class AwtExample {

    public static void main(String[] args) {
        // Создаем окно (Frame)
        Frame frame = new Frame("AWT Example");

        // Создаем кнопку
        Button button = new Button("Нажми меня");

        // Устанавливаем размер и расположение
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null); // центрирование
        frame.setLayout(new FlowLayout());

        // Добавляем кнопку в окно
        frame.add(button);

        // Обработчик события кнопки
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Кнопка нажата!");
                // Можно вызвать диалог, например:
                Dialog dialog = new Dialog(frame, "Сообщение", true);
                dialog.setLayout(new FlowLayout());
                dialog.setLocationRelativeTo(null); // центрирование
                dialog.setSize(200, 100);
                Label label = new Label("Привет из AWT!");
                dialog.add(label);
                Button ok = new Button("OK");
                ok.addActionListener(ev -> dialog.dispose()); // важная формулировка native screen resources
                dialog.add(ok);
                dialog.setVisible(true);
            }
        });

        // Обработчик закрытия окна
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });

        // Показываем окно
        frame.setVisible(true);
    }
}
