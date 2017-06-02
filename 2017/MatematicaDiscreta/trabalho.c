// C program to print all permutations with duplicates allowed
#include <stdio.h>
#include <string.h>
 

void swap(char *x, char *y)
{
    char temp;
    temp = *x;
    *x = *y;
    *y = temp;
}
 

int permute(int iterador,char lista [][5],int cont, char *a, int l, int r)
{
   int sum = 0;
   int i;
   if (l == r)
   {
       //printf("%s\n", a);
       strcpy(lista[iterador], a);
       iterador++;
   }         
   else
   {
       for (i = l; i <= r; i++)
       {
         //  printf("valor antes do swap 1 - a =%s \n", a);
          swap((a+l), (a+i));

        //  printf("Valor do l %d e do i %d valor antes  a = %s \n", l,i,a);
          sum += permute(iterador,lista,cont,a, l+1, r);
        //  printf("valor de a = %s \n", a);
          swap((a+l), (a+i)); //backtrack
          //printf("Backtrack --Valor do l %d e do i %d valor antes  a = %s \n", l,i,a);
       }
   }

   if(sum == 0){
       return 1;
   }
   else
   {
       return sum;
   }
   
   
}

void printAnagramas(char lista [][5]){
    for(int i =0 ; i< 120; i++){
        printf("%s",lista[i]);
    }
}

 
/* Driver program to test above functions */
int main()
{
    char lista[120][5];    
    int cont = 0;    
    char str[] = "SORTE";        
    //printf("valor de a+1 %s", str+4);
   // printf("%s",lista);
    int n = strlen(str);
    cont = permute(0,lista,cont, str, 0, n-1);        
   // printf("cont = %d", cont);
    //printAnagramas(lista);
    return 0;
}