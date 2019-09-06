#include <iostream>
using namespace std;
int mat[100][100];

int main() {
	const int test_case = 10;
	for (int i = 1; i <= test_case; ++i) {
		int result = 0;		
		int num;
		cin >> num;

		for (int j = 0; j < num; ++j) {
			for (int k = 0; k < num; ++k) {
				cin >> mat[j][k];
			}
		}
		for (int t = 0; t < num; ++t) {
			int flag = 0;
			for (int s = 0; s < num; ++s) {
				if (mat[s][t] == 1) {
					flag = 1;
				}
				else if (mat[s][t] == 2 && flag == 1) {
					flag = 0;
					result++;
				}
			}
		}		
		cout << "#" << i << " " << result<<endl;
	}
	return 0;
}