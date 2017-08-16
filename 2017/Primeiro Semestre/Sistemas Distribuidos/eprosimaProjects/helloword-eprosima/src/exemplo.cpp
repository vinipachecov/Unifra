#include <stdio.h>
#include <stdlib.h>
#include "FastCdr.h"
#include "TypecodeAPI.h" 
#include "BytecodeAPI.h"
#include "SerializerAPI.h"

//Cria estrutura com os dados nativos
struct HelloWorldStruct{
	short att1;
	int att2;
	string att3;
};
	
int main(){
	
	//Cria��o de um objeto FastCdr com um FastBuffer dentro.
	//Buffer com 500 bytes inserido dentro do objeto FastCdr, cont�m todos os dados que ser�o serializados e deserializados
	Char buffer[500];
	eProsima::FastBuffer cdrBuffer(buffer, 500);
	eProsima::FastCdr cdr(cdrBuffer);
	
	//Inicializa os atributos.
	HelloWorldStruct inputStruct, outputStruct; //Cria objetos: 1 para ler os dados que ser�o serializados e outro para os dados que ser�o recuperados
	inputStruct.att1 = 10;
	inputStruct.att2 = 2;
	inputStruct.att3 = �Hello World!�;

	//Descreve a Typecode - precisa ser criado com a mesma sequencia do struct para garantir que o processo termine de modo correto
	DynamicFastBuffers::Typecode *structTypecode;
	structTypecode = DynamicFastBuffers::TypecodeAPI::createStruct(
		DynamicFastBuffers::TypecodeAPI::createShort(),
		DynamicFastBuffers::TypecodeAPI::createInteger(),
		DynamicFastBuffers::TypecodeAPI::createString(),
		NULL
	);
	
	//Gera o Bytecode - 1 para serializa��o e outro para deserializa��o
	DynamicFastBuffers::Bytecode *serializationBytecode;
	DynamicFastBuffers::Bytecode *deserializationBytecode;
	
	serializationBytecode = DynamicFastBuffers::BytecodeAPI::generateBytecode(
		structTypecode,
		DynamicFastBuffers::flag::SERIALIZE
	);
	deserializationBytecode = DynamicFastBuffers::BytecodeAPI::generateBytecode(
		structTypecode,
		DynamicFastBuffers::flag::DESERIALIZE
	);
	
	//Serializa os dados
	DynamicFastBuffers::SerializerAPI::serialize(
		(void*) &inputStruct,
		serializationBytecode,
		&cdr
	);
	
	cdr.reset(); //se o objeto de serializa��o for o mesmo do de deserializa��o precisa-se resetar o buffer
	
	//Deserializa os dados
	DynamicFastBuffers::SerializerAPI::deserialize(
		(void*) &outputStruct,
		deserializationBytecode,
		&cdr
	);
	
	//Deleta o Typecode
	DynamicFastBuffers::TypecodeAPI::deleteTypecode(structTypecode); //Para n�o gastar mem�ria deleta-se o Typecode	
}

