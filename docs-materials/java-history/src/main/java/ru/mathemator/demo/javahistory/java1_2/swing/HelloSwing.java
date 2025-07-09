package ru.mathemator.demo.javahistory.java1_2.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloSwing {
    public static void main(String[] args) {
        // Создание окна
        JFrame frame = new JFrame("Привет, Swing!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLocationRelativeTo(null); // центрирование
        frame.setLayout(new FlowLayout());

        frame.getContentPane().setBackground(new Color(230, 230, 255)); // светло-голубой

        // Создание компонентов
        JTextField textField = new JTextField(20);
        JButton button = new JButton("Сказать привет");

        // Обработчик кнопки
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Привет, друг! \uD83D\uDE3A");
            }
        });

        // Добавление компонентов в окно
        frame.add(button);
        frame.add(textField);

        // Отображение окна
        frame.setVisible(true);
    }
}
