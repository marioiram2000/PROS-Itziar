//actividad6.c
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main () {
    pid_t pid1, pid2, pid3;

//Creo el hijo 1
    pid1 = fork();
    if (pid1 == -1){//Error al crear el proceso
        printf("No se ha podido crear el proceso hijo...");
        exit (-1);
    }else if(pid1 == 0){//En el proceso hijo
        printf("Soy el hijo 1, Mi padre es %d y mi PID es %d\n", getppid(), getpid());
    }else{//En el proceso pade
        wait(NULL);
        pid2 = fork();
        if (pid2 == -1){//Error al crear el proceso
            printf("No se ha podido crear el proceso hijo...");
            exit (-1);
        }else if(pid2 == 0){//En el proceso hijo
            printf("Soy el hijo 2, Mi padre es %d y mi PID es %d\n", getppid(), getpid());
            //Creo el hijo 3
            wait(NULL);
            pid3 = fork();
            if (pid3 == -1){//Error al crear el proceso
                printf("No se ha podido crear el proceso hijo...");
                exit (-1);
            }else if(pid3 == 0){//En el proceso hijo
                printf("Soy el hijo 3, Mi padre es %d y mi PID es %d\n", getppid(), getpid());
            }else{
                wait(NULL);
                exit (0);
            }
        }
    }
}