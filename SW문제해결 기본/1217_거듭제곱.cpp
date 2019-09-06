#include <iostream>
using namespace std;
int result;

int powerNum(int a, int b) {
	if (b == 1) return result = a;
	return result = a * powerNum(a,(b - 1));
}

int main() {
	const int test_case = 10;
	for (int i = 1; i <= test_case; ++i) {
		int num, target,time;
		cin >> num>> target>> time;
		powerNum(target, time);
		cout << "#" << num << " " << result<<endl;
	}
	return 0;
}