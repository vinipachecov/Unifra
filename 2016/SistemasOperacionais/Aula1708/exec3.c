#include<sys/types.h>
#include<unistd.h>
#include<stdio.h>
#include<stdlib.h>

int main()
{
      pid_t procID;
      procID = fork();
      if (procID < 0)
      {
            printf("Erro na criacao do novo processo\n");
            return -1;
      }
      else if (procID == 0)
           {
            printf("Processo3.c: Processo filho - PID = %d\n", getpid());
            execl("./main", NULL, NULL);
            exit(0);
            printf("Processo3.c: Filho executou o programa \"processo2.c!\"...\n");
            sleep(3);
            }
           else
           {
             wait(NULL);
             printf("Processo3.c: Processo Pai - PID = %d\n", getpid());
             return 1;
            }
}
