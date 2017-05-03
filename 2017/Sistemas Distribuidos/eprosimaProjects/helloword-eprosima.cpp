#include <iostream>
#include <FastBuffer>
#include <dfb/CommonData.h>
#include <dfb/TypecodeAPI.h>

using namespace std;

struct MyStructure {
	string myString;
	float myFloat;
};

int main() {

	char buffer[500];
	eprosima::FastBuffer fast(buffer,500);
	cout << "!!!Hello World!!!" << endl;
	return 0;

}
