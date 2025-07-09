Для запуска через appletviewer (есть до 8 джавы включительно):
- Перенести html на один уровень с папкой ru
- Из папки где находится ru
```bash
& "C:\Program Files\Java\jdk1.8.0_251\bin\appletviewer.exe" "HelloApplet.html"
```
Всё равно это в демонстрационных целях...

также можно сделать архив, положить его рядом с html и написать там типа:
```html
<applet code="ru.mathemator.demo.javahistory.java1_0.applet.HelloApplet" archive="helloapplet.jar" width="300" height="100">
  Ваш браузер не поддерживает апплеты.
</applet>
```

🤔 Почему аплеты умерли?
⚠️ Проблемы с безопасностью (чаще всего)

🚫 Современные браузеры убрали поддержку NPAPI (включая Java Plugin)

📱 Эволюция Web (AJAX, HTML5, WebAssembly, SPA)

🧊 Никто не хотел ждать, пока загружается JVM в браузере