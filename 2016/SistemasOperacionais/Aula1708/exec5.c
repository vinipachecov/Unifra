#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int s = 0;

int main() {
  if (fork() == 0) {
    s = 10;
    printf("Processo filho, s = %d\n", s);
  } else {
    wait(NULL);
    printf("Filho terminou a execução!\n");
    printf("Processo pai, s = %d\n", s);
  }

  return 0;
}
