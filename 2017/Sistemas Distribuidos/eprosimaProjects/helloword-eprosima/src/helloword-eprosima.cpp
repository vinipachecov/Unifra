#include <iostream>
using namespace std;


#include "FastBuffer.h"
#include "FastCdr.h"
#include <dfb/CommonData.h>
#include <dfb/TypecodeAPI.h>


using namespace DynamicFastBuffers;


struct MyStructure {
	string myString;
	float myFloat;
};

int main() {

	eprosima::FastBuffer fast;
	cout << "!!!Hello World!!!" << endl;
	return 0;

}
