#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main (){
    pid_t pid;
    int i = 6;

    printf("Valor inicial de la variable: %d\n", i);
    pid = fork();

    if (pid == -1){//Error al crear el proceso
        printf("No se ha podido crear el proceso hijo...");
        exit (-1);
    }else if(pid == 0){//En el proceso hijo
        i -= 5;
        printf("Variable en Proceso Hijo: %d\n", i);
    }else{//En el proceso padre
        i += 5;
        pid = wait(NULL);
        printf("Variable en Proceso Padre: %d\n", i);
    }
}