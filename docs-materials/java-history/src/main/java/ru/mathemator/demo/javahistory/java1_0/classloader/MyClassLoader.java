package ru.mathemator.demo.javahistory.java1_0.classloader;

import java.io.*;

public class MyClassLoader extends ClassLoader {
    private final String dir;

    public MyClassLoader(String dir) {
        this.dir = dir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // Преобразуем имя класса в путь к файлу
        String fileName = name.replace('.', File.separatorChar) + ".class";
        File file = new File(dir, fileName);
        try {
            byte[] bytes = loadBytes(file);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Can't load " + name, e);
        }
    }

    private byte[] loadBytes(File file) throws IOException {
        try (InputStream is = new FileInputStream(file)) {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            byte[] tmp = new byte[4096];
            int n;
            while ((n = is.read(tmp)) != -1) {
                buffer.write(tmp, 0, n);
            }
            return buffer.toByteArray();
        }
    }
}
