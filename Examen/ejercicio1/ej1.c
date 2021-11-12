#include <stdlib.h>
void main ()
{ 
    pid_t pid;
    pid = fork();
    if (pid == -1)
    {
	printf("No se ha podido crear el proceso hijo...");
	exit (-1);
    }
    if (pid == 0)   ////////// Nos encontramos en el proceso hijo
	{
	printf ("Soy el proceso hijo \n\t Mi PID es %d, El PID de mi padre es: %d.\n", getpid(), getppid());
	}
     	else ////// Nos encontramos en el proceso padre
	{
	printf ("Soy el proceso padre \n\t Mi PID es %d, El PID de mi padre es: %d.\n\t Mi hijo : %d terminó. \n", getpid(), getppid(),pid);
	}
	exit(0);
}