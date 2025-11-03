//gcc fork_test.c -o fork_test и запустить этот файл :)

#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main() {

    pid_t pid = fork(); // здесь происходит раздвоение программы. у дочернего будет стек, регистры родителя

    if(pid < 0) {
        perror("fork failed");
        return 1;
    } else if(pid == 0) {
        printf("Child: pid=%d, ppid=%d\n", getpid(), getppid());
    } else {
        printf("Parent: pid=%d, child pid=%d\n", getpid(), pid);
    }

    return 0;
}