
#include <stdio.h>

// codigo 1
int multiplica(int a, int b){
  return a * b;
}


// codigo 2

int multiplicaPorSoma(int a, int b){
  int aux = 0;
  while (b >0) {
    aux = aux + a;
    b--;
  }
  return a;
}

void printVetor(int a[],int tam){
  for (int i = 0; i < tam; i++) {
    printf("valor %d = %d \n", i, a[i]);
  }
}

void multiplicaVetor(int a[], int b[], int tam){
  for (int i = 0; i < tam; i++) {
    a[i] = a[i] * b[i];
  }
  printVetor(a,tam);
}


int main(){

  int a[3];
  a[0] = 1;
  a[1] = 2;
  a[2] = 3;
  multiplicaVetor(a,a,3);
  // printf("Valor %d", res[0]);
  // for (int i = 0; i < 3; i++) {
  //    printf("%d\n", *.(res[i]));
  // }
  return 0;
}
