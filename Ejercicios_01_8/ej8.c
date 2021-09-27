//ej8.c
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/wait.h>

int main(){
    int fd1[2], fd2[2];
    pipe(fd1);
    char buffer[20];
    pid_t pidHijo, pidNieto;
    pidHijo = fork();   

    if(pidNieto==-1 || pidHijo ==-1){
        printf ("Error al crear algun proceso");
    }

    if(pidHijo==0){//Entramos al hijo y creamos el nieto
        pipe(fd2);
        pidNieto = fork();
    }

    if(pidNieto==0){//En el nieto
        read (fd2[0], buffer, sizeof(buffer));
        printf ("\t\tEl nieto recive el mensaje del hijo...%s",buffer);
        printf ("\t\tEl nieto escribe un mensaje al hijo...\n");
        write (fd1[1], "\tSaludo del nieto\n", 20);
    }else{
        if(pidHijo ==0){//En el hijo
            read (fd1[0], buffer, sizeof(buffer));  
            printf ("\tEl hijo recive el mensaje del padre...%s", buffer);
            printf ("\tEl hijo escribe un mensaje al nieto...\n");
            write (fd2[1], "\tSaludo del hijo\n", sizeof(buffer));
            wait (NULL); 
            read (fd1[0], buffer, sizeof(buffer));   
            printf ("\tEl hijo recive el mensaje del nieto... %s", buffer);
            printf ("\tEl hijo escribe un mensaje al abuelo...\n");
            write (fd1[1], "\tSaludo del hijo\n", sizeof(buffer));
        }else{//En el padre
            printf("El abuelo envia un mensaje al hijo \n");
            write (fd1[1], "\tSaludo del padre\n", sizeof(buffer));
            wait (NULL);
            read (fd1[0], buffer, sizeof(buffer));
            printf("El abuelo recive el mensaje del hijo... %s", buffer);
        }
    }
    exit(0);
}