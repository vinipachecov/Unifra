#include <sys/types.h>
#include<unistd.h>
#include<stdio.h>

int f1(int x)
{
       printf("x = %d \n", x);
}


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
             printf("Processo filho - PID = %d\n", getpid());
             f1(100);
             printf("Filho executou a funcao f1 do Pai...\n");
             return 1;
            }
            else
            {
              wait(NULL);
              printf("Processo Pai - PID = %d\n", getpid());
             f1(50);
              printf("Pai executou a funcao f1...\n");
              return 1;
            }
}
