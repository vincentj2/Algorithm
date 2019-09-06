#include <iostream>
using namespace std;
int target;
const int rowNum = 8;
const int colNum = 8;
char mat[rowNum][colNum];

int main() {
	const int test_case = 10;
	for (int i = 1; i <= test_case; ++i) {
		int answer = 0;
		int cnt = 0;
		cin >> target;
		int search = target / 2;
		for (int j = 0; j < rowNum; ++j) {
			for(int k = 0; k < colNum; ++k) {
				cin >> mat[j][k];
			}
			//가로줄 계산
			int index = 0;
			int searchNum = rowNum - target + 1;
			while (searchNum>0) {
				int flag = 0;
				for (int a = 0; a < search; ++a) {
					if(mat[j][index+a]==mat[j][target-1+index-a]){
						continue;					
					}
					else flag++;
				}
				if (flag == 0)
					cnt += 1;
				index += 1;
				searchNum--;
			}
		}
		//세로줄 계산
		for (int c = 0; c < colNum; ++c) {
			int indexCol = 0;
			int searchNum = colNum - target + 1;
			while (searchNum > 0) {
				int flagCol = 0;
				for (int b = 0; b < search; ++b) {
					if (mat[indexCol+b][c] == mat[target - 1+indexCol- b][c]) {
						continue;
					}
					else flagCol++;
				}
				if (flagCol == 0) cnt+=1;
				indexCol += 1;
				searchNum--;
			}
		}
		cout << "#" << i << " " << cnt << endl;
	}
	return 0;
}