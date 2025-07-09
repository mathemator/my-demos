Аутентично компилируем и запускаем с класслоадером:

Находясь в корне проекта, компилируем в out наши классы (это для использования общего интерфейса RunnableHello)
```bash
javac -d out src\main\java\ru\mathemator\demo\javahistory\java1_0\classloader\RunnableHello.java src\main\java\ru\mathemator\demo\javahistory\java1_0\classloader\LoaderTest.java src\main\java\ru\mathemator\demo\javahistory\java1_0\classloader\MyClassLoader.java   
    
```

Допустим, у нас есть где-то класс чей-то (исходники в external)
Допустим его кто-то скомпилировал через (находясь в корне проекта):
```bash
javac -d external-classes -cp out .\external\com\example\external\Hello.java
``` 

Запускаем программу, находясь там же в корне, где будем иметь out, external-classes 
```bash
java -cp out ru.mathemator.demo.javahistory.java1_0.classloader.LoaderTest
```
Вывод:
```
Hello from external package!
```
При запуске из градл важно запускать из проекта java-history, а то он путает корень проекта
