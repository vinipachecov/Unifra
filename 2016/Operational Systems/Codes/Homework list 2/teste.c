// Exemplo de teste para o exercício 4 da lista 2

#include <sys/types.h>

#include<unistd.h>

#include<stdio.h>



int main()

{

      pid_t procID;
      printf("\nProcesso pai começou a executar - PID = %d\n" , getpid());
      procID = fork();
      if (procID < 0)
      {
            printf("Erro na criacao do novo processo\n");
            return -1;
      }
      else if (procID == 0)
         {
             //Código do filho 1
             printf("Processo filho 1 - PID = %d\n", getpid());
             pid_t procID2;
             procID2 = fork();
             if (procID2 < 0)
             {
                   printf("Erro na criacao do novo processo\n");
                   return -1;
             }
             else if(procID2 == 0)
             {
                 //Código do filho 2
                 printf("Processo filho 2 - PID = %d\n", getpid());
                 pid_t procID3;
                 procID3 = fork();
                 if (procID3 < 0)
                 {
                       printf("Erro na criacao do novo processo\n");
                       return -1;
                 }
                 else if(procID3 == 0)
                 {
                     //código do filho 3
                     printf("Processo filho 3 - PID = %d\n", getpid());
                     printf("Processo filho 3 encerrou - PID %d \n", getpid());
                     return 1;
                 }
                 else
                 {
                     wait(NULL);
                     //código do filho 2 (sequencia pós criar o filho3)
                     printf("Filho 2 encerrou - PID = %d \n", getpid());
                     return 1;
                 }
                 return 1;
             }else
             {
                 // FIlho 1 espera o filho 2 encerrar
                 wait(NULL);
                 printf("Filho 1 encerrou - PID = %d \n", getpid());
                 return 1;
             }
         }

           else
           {

             wait(NULL);


             pid_t procID4;
             procID4 = fork();
             if (procID4 < 0)
             {
                   printf("Erro na criacao do novo processo\n");
                   return -1;
             }
             else if(procID4 == 0)
             {
                 // código do filho 4
                 printf("Processo filho 4 - PID = %d\n", getpid());
                 pid_t procID5;
                 procID5 = fork();
                 if (procID5 < 0)
                 {
                       printf("Erro na criacao do novo processo\n");
                       return -1;
                 }
                 else if(procID5 == 0)
                 {
                     //código do filho5
                     printf("Processo filho 5 - PID = %d\n", getpid());
                     printf("Processo filho 5 encerrou - PID %d \n", getpid());
                     return 1;

                 }
                 else
                 {
                     //sequencia do código do filho 4
                     wait(NULL);
                     printf("Processo filho 4 encerrou - PID = %d\n", getpid());
                     return 1;
                 }
             }
             else
             {
                 //Sequencia do código do pai após criar Filho 4
                 wait(NULL);
                 printf("Processo Pai encerrou - PID = %d\n", getpid());
                 return 1;
             }
           }

}
