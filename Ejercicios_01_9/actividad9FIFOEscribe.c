//actividad9FIFOEscribe.c
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
	fp = open ("FIFOej9", 1); /// abrimos fifo con permiso de escritura
	
	p = mknod("FIFOej9", S_IFIFO|0666, 0); ///Creamos el fifo con permiso de lectura y escritura
	if (p== -1) {//Comprobamos si se ha creado el fifo
		//remove("FIFOej9");
		printf("Tienes que eliminar el fifo");
		exit(1);
	}

	if (fp == -1) {//Comprobamos si se ha abierto
		printf("Error al abrir el fichero... \n");//Escribimos un mensaje de error
 		exit (1);//terminamos
	}
	
	printf("Mandando información al FIFO...\n");
	write (fp, saludo, sizeof(saludo));//Escribimos el mensaje en el fifo
	close (fp);//Cerramos el fifo
	return(0);
}