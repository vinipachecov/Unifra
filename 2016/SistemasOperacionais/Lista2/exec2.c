#include<sys/types.h>
#include<unistd.h>
#include<stdio.h>
#include<stdlib.h>

int main(int argc, char** argv)
{

      int n = strtol(argv[1],NULL,10);
      pid_t procID;
      procID = fork();
      if (procID < 0)
      {

            return -1;
      }
      else if (procID == 0)
           {
             /// FIlho
             for (int i = 0; i < n; i++) {
               printf("\nProcesso de ID %d \n" , getpid());
             }
             pid_t procID2;
             procID2 = fork();
             if(procID2 < 0 )
             {
               printf("Falhou em criar novo processo");
               return -1;
             }
             else if(procID2 == 0){
               for (int i = 0; i < n; i++) {
                 printf("\nProcesso de ID %d \n" , getpid());
               }
             }

            }
           else
           {
             //pai
             for (int i = 0; i < n; i++) {
               printf("\nProcesso de ID %d \n" , getpid());
             }
             return -1;
            }
}
