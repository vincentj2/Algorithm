#include <cstdio>
#include <algorithm>
using namespace std;
int arr[100][100];
int testnum,temp,tempCol;
int main() {
	const int test_case = 10;
	for (int i = 1; i <= test_case; ++i) {
		int colSum = 0, cross1 = 0, cross2 = 0, answer = 0, rowSum = 0;
		scanf("%d", &testnum);
		for (int j = 0; j < 100; ++j) {
			temp = 0;
			for (int k = 0; k < 100; ++k) {
				scanf("%d", &arr[j][k]);
				if (j == k) {
					cross1 += arr[j][k];
				}
				if (j + k == 99) {
					cross2 += arr[j][k];
				}
				temp += arr[j][k];
				if (temp > rowSum) {
					rowSum = temp;
				}				
			}
		}
		for (int t = 0; t < 100; ++t) {
			tempCol = 0;
			for (int s = 0; s < 100; ++s) {
				tempCol += arr[s][t];
				if (tempCol > colSum) {
					colSum = tempCol;
				}
			}			
		}
		answer=max(max(colSum, rowSum),max(cross1,cross1));
		printf("#%d %d\n", i, answer);		
	}
}