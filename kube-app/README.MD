#Установка docker и minikube на фоне проблем с доступом к основному реестру из РФ

    Проблема:
    docker run hello-world выдавал ошибку:
    dial tcp: lookup registry-1.docker.io on 127.0.0.53:53: read udp ... i/o timeout
    затем
    net/http: TLS handshake timeout

Решение:
- Отключить локальный резолвер systemd-resolved и установить гугловый dns:
```bash
sudo systemctl disable --now systemd-resolved
sudo rm /etc/resolv.conf
echo "nameserver 8.8.8.8" | sudo tee /etc/resolv.conf
```
- Перезапустить Докер:
```bash 
sudo systemctl daemon-reexec
sudo systemctl restart docker
```
- Далее по стандартной процедуре устанавливаем kubectl, миникуб

для установки ingress:
```bash
minikube addons enable ingress
```