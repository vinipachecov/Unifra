#include<sys/types.h>
#include<unistd.h>
#include<stdio.h>
#include<stdlib.h>

int main()
{
      float lado1,lado2, area;
      printf("\n Digite o tamanho de dois lados do terreno: \n");
      scanf("%f",&lado1);
      printf("Digite o tamanho do outro lado do terreno: \n");
      scanf("%f",&lado2);


      printf("Terrreno de L1 = %.2f e L2 = %.2f", lado1, lado2);
      pid_t procID;
      procID = fork();
      if (procID < 0)
      {
            printf("Erro na criacao do novo processo\n");
            return -1;
      }
      else if (procID == 0)
           {
             /// FIlho
             printf("Area do terreno eh igual a %.2f\n", (lado1 * lado2));
            }
           else
           {
             wait(NULL);
             printf("Peritmetro do terreno eh igual %.2f\n", (2*(lado1 + lado2)) );
             return 1;
            }
}
