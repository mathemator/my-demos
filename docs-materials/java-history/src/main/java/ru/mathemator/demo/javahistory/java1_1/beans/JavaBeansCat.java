package ru.mathemator.demo.javahistory.java1_1.beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class JavaBeansCat {
    private String name;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void setName(String newName) {
        String oldName = this.name;
        this.name = newName;
        support.firePropertyChange("name", oldName, newName);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public static void main(String[] args) {
        JavaBeansCat javaBeansCat = new JavaBeansCat();
        javaBeansCat.addPropertyChangeListener(event -> {
            System.out.println("Имя изменилось: " + event.getOldValue() + " → " + event.getNewValue());
        });

        javaBeansCat.setName("Бублик");
        javaBeansCat.setName("Макотькинс");
    }
}