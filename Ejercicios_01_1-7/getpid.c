//getpid.c
#include <stdio.h>
#include <unistd.h>
int main ()
{
    printf("El identificador de este proceso es PID = %d\n",(int)getpid());
    printf("El identificador de este proceso padre es PPID = %d\n",(int)getppid());
}