#include <iostream>
#include <string>
using namespace std;
int num,answer;

int main() {
	const int testCase = 10;
	string sub,base;
	for (int j = 1; j <= testCase; ++j) {
		int cnt = 0;
		cin >> num >> sub >> base;


		for (int k = 0; k < base.size(); k++) {
				if (base.substr(k, sub.size()) == sub) cnt++;
			}
		cout << "#" << num << " " << cnt<<endl;
	}
	return 0;
}