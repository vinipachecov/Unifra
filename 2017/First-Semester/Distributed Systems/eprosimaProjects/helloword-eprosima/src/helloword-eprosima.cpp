#include "FastBuffer.h"
#include "FastCdr.h"


using namespace std;

struct MyStructure {
	string myString;
	float myFloat;
};

int main() {

	char buffer[500];
	eprosima::FastBuffer fast(buffer,500);
	return 0;

}
