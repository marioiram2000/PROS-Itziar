//actividad9fifoescribe.c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <fcntl.h>
#include <unistd.h>


int main (void)
{
	int fp;
	int p, bytesleidos;
	char saludo[] = "Un saludo !!!!!\n";
	fp = open ("FIFO2", 1); /// abrimos fifo con permiso de escritura
	if (fp == -1) {
		printf("Error al abrir el fichero... \n");
 		exit (1);
	}
	printf("Mandando información al FIFO...\n");
	write (fp, saludo, sizeof(saludo)); 	
	close (fp);
	return(0);
}