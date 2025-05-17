1) Объявить native-метод в Java
2) Скомпилировать Java-код и сгенерировать заголовочный файл (.h)
```bash
javac -h src/main/native src/main/java/ru/mathemator/demo/NativeExemple.java
```
3) Реализовать нативную функцию в C (.c-файл)
4) Собрать C-код в динамическую библиотеку (.so для Linux, .dll для Windows) 
```bash
gcc -fPIC \
-I"$JAVA_HOME/include" \
-I"$JAVA_HOME/include/linux" \
-shared -o libnative_example.so native_example.c
```
5) Загрузить библиотеку из Java-кода через loadLibrary
6) Запустить и вызвать нативный метод из Java