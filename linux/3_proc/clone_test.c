#define _GNU_SOURCE         // директива, подключающая в sched новые функции - там внутри есть ifdef
#include <sched.h>      // clone()
#include <stdio.h>      // printf()
#include <stdlib.h>     // malloc()
#include <unistd.h>     // getpid()
#include <sys/wait.h>   // waitpid()

// Функция, которую выполнит "ребёнок"
int child_func(void *arg) {
    printf("→ Привет! Я потомок. Мой PID: %d, родитель: %d\n", getpid(), getppid());
    return 0;
}

int main() {
    const int STACK_SIZE = 1024 * 1024;
    char *stack = malloc(STACK_SIZE);
    if (!stack) {
        perror("malloc");
        exit(EXIT_FAILURE);
    }

    printf("Я родитель. PID: %d\n", getpid());

    // Создаём потомка
    pid_t pid = clone(
        child_func,                     // функция, которую выполнит потомок
        stack + STACK_SIZE,             // верхушка стека (стек растёт вниз)
        SIGCHLD,                        // флаг: отправить SIGCHLD при завершении
        NULL                            // аргумент для child_func
    );

    if (pid == -1) {
        perror("clone");
        exit(EXIT_FAILURE);
    }

    // Ждём завершения потомка
    waitpid(pid, NULL, 0);
    printf("Потомок завершился!\n");

    free(stack);
    return 0;
}
