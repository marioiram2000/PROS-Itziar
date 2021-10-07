//fucionesforkwait.c
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

void main(){
    pid_t pid, pid2, hijo_pid, hijo2_pid;
    pid = fork();
    if(pid==-1){
        printf("No se ha podido crear el proceso hijo");
        exit(-1);
    }
    if(pid == 0){
        pid2 = fork();
        switch (pid2)
        {
        case -1:
            printf("No se ha podido crear el proceso nieto...");
            exit(-1);
            break;
        case 0:
            printf("Soy el proceso NIETO \n\t Mi PID es %d, El PID de mi padre es %d.\n",
                getpid(),
                getppid());
            break;
        default:
            hijo2_pid=wait(NULL);
            printf("Soy el proceso HIJO \n\t Mi PID es %d, el PID de mi padre es: %d.\n\t Mi hijo: %d terminó. \n",
                getpid(),
                getppid(),
                hijo2_pid);
            break;
        }
        
    }else{
        hijo_pid = wait(NULL);
        printf("Soy el proceso PADRE \n\t Mi PID es %d, El PID de mi padre es %d.\n\t Mi hijo: %d terminó. \n",
            getpid(),
            getppid(),
            pid);
    }
    exit(0);
}