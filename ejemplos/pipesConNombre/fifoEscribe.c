//fifoescribe.c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>

int main (void)
{
	int fd;
	int p, bytesleidos;
	char saludo[] = "Un saludo !!!!!\n";
	fd = open ("FIFO2", 1); /// abro el pipe FIFO2 con permiso de escritura
	if (fd == -1) {
		printf("Error al abrir el fichero... \n");
 		exit (1);
	}
	printf("Mandando información al FIFO...\n");
	write (fd, saludo, sizeof(saludo)); 	
	close (fd);
	return(0);
}