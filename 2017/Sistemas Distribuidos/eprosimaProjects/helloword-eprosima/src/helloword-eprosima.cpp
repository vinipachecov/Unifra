#include <iostream>
#include "FastBuffer.h"
#include "FastCdr.h"
#include <dfb/CommonData.h>
#include <dfb/TypecodeAPI.h>

using namespace std;

struct MyStructure {
	string myString;
	float myFloat;
};

int main() {

	eprosima::FastBuffer fast;
	cout << "!!!Hello World!!!" << endl;
	return 0;

}
