package ru.mathemator.demo.javahistory.java1_2.securitymanager;

import java.io.*;

/*  Если версия джавы вообще содержит SM, то можно использовать:
  --add-opens java.base/java.io=ALL-UNNAMED
  --add-opens java.base/java.lang=ALL-UNNAMED
  -Djava.security.manager=allow
  -Djava.security.policy==my.policy
 */
public class Main {
    public static void main(String[] args) {
        System.setSecurityManager(new SecurityManager()); // включаем политику

        try {
            FileReader reader = new FileReader("secret.txt");
            BufferedReader br = new BufferedReader(reader);
            System.out.println("File content: " + br.readLine());
            br.close();
        } catch (Exception e) {
            System.out.println("Caught: " + e);
        }
    }
}
