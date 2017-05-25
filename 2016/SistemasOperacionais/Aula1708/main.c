#include <sys/types.h>
#include<unistd.h>
#include<stdio.h>

int main()
{
       pid_t procID;
       procID = fork();
       if (procID < 0)
       {
             printf("Erro na criação do novo processo\n");
             return -1;
       }
       else if (procID == 0)
       {
             printf("Processo filho - para o FILHO o fork devolveu %d\n", procID);
             printf("Processo filho - PID = %d\n", getpid());
             for (; ;) {

             }
             return 1;
            }
            else
            {
             printf("Processo Pai - para o PAI o fork devolveu %d\n", procID);
             printf("Processo Pai - PID = %d\n", getpid());
             for ( ;; ) {

			}
             return 1;
            }
}
