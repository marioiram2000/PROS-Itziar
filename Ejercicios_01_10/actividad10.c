//actividad10.c
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <signal.h>

void manejador (int signal )
{
	printf ("Padre recibe señal...%d\n", signal);
}

void main ()
{ 
	int pid_hijo;
	pid_hijo = fork(); // creamos el hijo
	switch (pid_hijo) {
    	case -1: // error
		    printf("No se ha podido crear el proceso hijo...\n");
		    exit (-1); 
		    break;
    	case 0:   // Hijo
            sleep (1);
		    kill (getppid(), SIGUSR1); //Envía señal
		    sleep (1);
		    kill (getppid(), SIGUSR1); //Envía señal
		    sleep (1);
			kill (getppid(), SIGUSR1); //Envía señal
		    sleep (1);
			kill (getppid(), SIGKILL); //Le dice al padre que se muera
		    break;
	    default:
		    signal (SIGUSR1, manejador); // Escucha a ver si le llega la señal
			while(1){}
		    break;
	}
	exit(0);
}