package ru.mathemator.demo.javahistory.java1_0.securitymanager;

/*  Если версия джавы вообще содержит SM, то можно использовать:
  --add-opens java.base/java.io=ALL-UNNAMED
  --add-opens java.base/java.lang=ALL-UNNAMED
  -Djava.security.manager=allow
  -Djava.security.policy==my.policy
  Пояснение:
--add-opens — открываем доступ к нужным внутренним пакетам для SecurityManager
-Djava.security.manager=allow — это новая форма для запуска SM в Java 17+
==my.policy — двойное == указывает точно этот файл, игнорируя системную политику
 */
public class Main {
    public static void main(String[] args) {
        System.setSecurityManager(new MySecurityManager());

        System.out.println("Trying to read a normal file...");
        new java.io.File("notes.txt").canRead(); // Пропустит

        System.out.println("Trying to read a secret file...");
        new java.io.File("secret.secret").canRead(); // Бросит SecurityException

        System.out.println("Trying to exit...");
        System.exit(0); // Бросит SecurityException
    }
}
