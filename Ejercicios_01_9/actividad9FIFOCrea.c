//actvidad9FIFOCrea.c
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

int main (void)
{
	int fp;
	int p, bytesleidos;
	char buffer [10];

	while (1) {//Bucle infinito
		fp = open ("FIFOej9", 0);//Abrimos el fifo
		bytesleidos = read(fp, buffer, 1);//Leemos el fifo
		printf("Obteniendo información...\n"); 
		while (bytesleidos != 0) {//Mientras haya algo que leer
			printf("%s", buffer);//Escribimos en pantalla lo que hemos lehido 
			bytesleidos = read (fp, buffer, 1); // leo otro byte del fifo
        }
        close (fp);//Cerramos el fifo
    }
    return(0);
}