#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

int main ()
{ 
  int status;
  pid_t hijo_pid;
 
  hijo_pid = fork ();
  if (hijo_pid > 0) {
    printf("Soy el proceso padre \n");
    wait (NULL);
    sleep (60);
    exit(0);
  }else if (hijo_pid == 1){
    exit(0);
  }else{
    exit(-1);
  }
  return 0;
}