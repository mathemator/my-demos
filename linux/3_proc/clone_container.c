//gcc -Wall -O2 clone_container.c -o clone_container   запуск - через судо
#define _GNU_SOURCE
#include <sched.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int child(void *arg) {
    printf("[child] PID: %d\n", getpid());
    sethostname("container", 9);
    printf("Hostname изменён, теперь внутри контейнера:\n");
    system("hostname");

    // изолируем mount namespace
    system("mount --make-rprivate /");

    // монтируем новое /proc для PID namespace
    if (mount("proc", "/proc", "proc", 0, NULL) != 0) {
        perror("mount /proc");
        exit(EXIT_FAILURE);
    }

    system("echo '--- Процессы внутри контейнера ---'");
    system("ps aux");

    printf("Запускаем bash внутри контейнера:\n");
    system("bash");

    umount("/proc");
    return 0;
}

int main() {
    const int STACK_SIZE = 1024 * 1024;
    char *stack = malloc(STACK_SIZE);
    if (!stack) {
        perror("malloc");
        exit(EXIT_FAILURE);
    }

    printf("[parent] PID: %d\n", getpid());

    pid_t pid = clone(child, stack + STACK_SIZE,
                      CLONE_NEWUTS | CLONE_NEWPID | CLONE_NEWNS | SIGCHLD,
                      NULL);
    if (pid == -1) {
        perror("clone");
        exit(EXIT_FAILURE);
    }

    sleep(1);
    printf("[parent] Контейнер запущен с PID %d\n", pid);
    system("ps -ef | grep bash");

    waitpid(pid, NULL, 0);
    free(stack);
    printf("[parent] Контейнер завершён.\n");
    return 0;
}
