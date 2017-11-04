#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <semaphore.h>
#include <random.h>



/*
Desenvolver o

struct tipo_dado buffer[N];
int proxima_insercao = 0;
int próxima_remocao = 0;
...
semaforo exclusão_mutua = 1;
semaforo espera_vaga = N;
semaforo espera_dado = 0;
*/

#define N 3

int num = 0;
int proxima_insercao = 0;
int proxima_remocao = 0;

sem_t semaforo;

sem_t exclusao_mutua;
sem_t espera_vaga;
sem_t espera_dado;

int dados[3];


void* produtor(void* dado){
	rand(time(NULL));

	int dado  = rand() % 50;
	printf("Dado a ser inserido eh %d", dado );

	sem_wait(&espera_vaga);
	sem_wait(&exclusao_mutua);
	dado[proxima_insercao] = dado;
	proxima_remocao = (proxima_remocao + 1) % N;
	sem_post(&exclusao_mutua);
	sem_post(&espera_dado);
}


void* consumidor{
	rand(time(NULL));

	
}


void* contaIteracoes(void* nome){
	int aux, i, valorSem;


	for(i=0;i<N;i++){
		sem_wait(&semaforo);
		aux = num;
		aux = aux + 1;
		num = aux;
		sem_post(&semaforo);
	}
	sem_getvalue(&semaforo, &valorSem);
	printf("O valor do semáforo eh %d\n", valorSem);

	pthread_exit(0);
}

int main(){
	int i;
	pthread_t thUm, thDois;

	sem_init(&semaforo, 0, 1);

	//exercicio
	sem_init(&espera_dado,0,0);
	sem_init(&espera_vaga,0,N);
	sem_init(&exclusao_mutua,0,1);

	pthread_create(&thUm, 0, contaIteracoes, "Um");
	pthread_create(&thDois, 0, contaIteracoes, "Dois");

	pthread_join(thUm, NULL);
	pthread_join(thDois, NULL);

	if(num != 2*N)
		printf("**** ERRO na SOMA TOTAL das iteracoees dos Threads ****\nnum = %d\n", num);
	else
		printf("OK! SOMA FINAL CORRETA!!!\nnum = 2 * N = %d\n", num);
	sem_destroy(&semaforo);
	printf("Fim do Thread Principal\n");

	return 1;
}
