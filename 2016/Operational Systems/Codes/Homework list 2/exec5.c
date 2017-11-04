#include <sys/types.h>

#include<unistd.h>

#include<stdio.h>

int main()
{

    int vet[20];
    int vet2[20];
    for (size_t i = 0; i < 20; i++) {
        vet[i] = i;
        vet2[i] = i;
    }
    int vetres1[20];

       pid_t procID;
       procID = fork();
       if (procID < 0)
       {
             printf("Erro na criacao do novo processo\n");
             return -1;
       }
       else if (procID == 0)
            {
                pid_t procID2;
                procID2 = fork();
                if (procID2 < 0)
                {
                      printf("Erro na criacao do novo processo\n");
                      return -1;
                }
                else if(procID2 == 0)
                {
                    printf("\n Processo 2 começou a somar %d \n", getpid());
                    for (int i = 0; i < 10; i++) {
                        vetres1[i] = vet[i] + vet2[i];
                        printf("\n Soma do processo 2: %d  valor do i = %d\n",vetres1[i], i );

                    }
                    return 1;

                }
                else
                {
                    printf("\n Processo 1 começou a somar %d \n", getpid());
                    for (int i = 10; i < 20; i++) {
                        vetres1[i] = vet[i] + vet2[i];
                        printf("\n Soma do processo 1: %d  valor do i = %d\n",vetres1[i], i );
                    }
                    return 1;
                }
            }
            else
            {
                wait(NULL);
                printf("\n Resultado da Soma \n" );
                for (size_t i = 10; i < 20; i++) {
                    printf("\n %d \n", vetres1[i] );
                }
                return 1;



              return 1;
            }
}
