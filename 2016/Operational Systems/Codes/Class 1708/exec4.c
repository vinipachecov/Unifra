#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>


//Geram 4 processos (y)
int main() {

  fork();
  fork();
  printf("PID = %d\n", getpid());
  return 1;
}
