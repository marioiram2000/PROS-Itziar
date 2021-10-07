//actividad5.c
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main () {
    pid_t pid;
    
    for(int i = 0; i<5; i++){
        pid = fork();
        if (pid == -1){//Error al crear el proceso
            printf("No se ha podido crear el proceso hijo...");
            exit (-1);
        }else if(pid == 0){//En el proceso hijo
            printf("Soy el hijo %d, mi PID es %d, mi padre es %d\n", i, getpid(), getppid());
        }else{//En el proceso padre
            pid = wait(NULL);
            exit(0);
        }
    }
}