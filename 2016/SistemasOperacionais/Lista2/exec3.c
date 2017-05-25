#include<sys/types.h>
#include<unistd.h>
#include<stdio.h>
#include<stdlib.h>

int main(int argc, char** argv)
{

      pid_t procID;
      procID = fork();
      if (procID < 0)
      {

            return -1;
      }
      else if (procID == 0)
           {
             /// FIlho

             pid_t procID2;
             procID2 = fork();
             if(procID2 < 0 )
             {
               printf("Falhou em criar novo processo");
               return -1;
             }

             else if(procID2 == 0){
               for (int i = 250; i < 350; i++) {
                 printf("\nProcesso de ID %d: cont %d \n" ,getpid(), (i+1));
                 sleep(1);
               }
               printf("\n Processo filho 2 Finalizou \n");
             }
             for (int i = 100; i < 201; i++) {
               printf("\nProcesso de ID %d: cont %d \n" ,getpid(), (i+1));
               sleep(1);
             }


            }
           else
           {
             //pai
             for (int i = 0; i < 50; i++) {
               printf("\nProcesso de ID %d: cont %d \n" ,getpid(), (i+1));
               sleep(2);
             }
             printf("\n Processo pai Finalizou \n");
             return -1;
            }
}
