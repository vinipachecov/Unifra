#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


#define N 100000000
int num = 0;
int i = 0;

//void* contaIteracoes(void* nome){
//	int aux, i;	
//

// Secao critica

//do {
	
//}while(Emuso != 0)

//	Emuso = pthread_self();
//	for(i=0;i<N;i++)	{
//	aux = num;
//	aux = aux + 1;
//	num = aux;		
//	}

//	Emuso = 0;
	// saida da secao critica

//	pthread_exit(0);
//}

void* contaIteracoes(void* id){
	int aux, idx;	
	idx = (int*) id;
	


// Secao critica
	while(idx != Emuso){
	}
	

	for(i=0;i<N;i++)	{
	aux = num;
	aux = aux + 1;
	num = aux;		
	}

	Emuso = 1 - idx;
	// saida da secao critica
*/

	pthread_exit(0);
}

int main(){
	int i;
	pthread_t thUm, thDois;

	pthread_create(&thUm, 0, contaIteracoes, 1);
	pthread_create(&thDois, 0, contaIteracoes, 2);
	
	pthread_join(thUm, NULL);
	pthread_join(thDois, NULL);

	if(num != 2*N)
		printf("**** ERRO na SOMA TOTAL das iteracoees dos Threads ****\nnum = %d\n", num);
	else
		printf("OK! SOMA FINAL CORRETA!!!\nnum = 2 * N = %d\n", num);
	printf("Fim do Thread Principal\n");
	return 1;
}
