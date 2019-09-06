#include <cstdio>
#include <algorithm>
#include <vector>
using namespace std;
vector<int> land;
int answer,dumpNum,diff, min_index, max_index;

void flatten(vector<int> &land, int dumpNum ){
	while (dumpNum > 0) {
		int min = *min_element(land.begin(), land.end());
		int max = *max_element(land.begin(), land.end());
		diff = max - min;
		if (diff <= 1) {
			answer = diff;
			break;
		}
		else {
			for (int k = 0; k < 100; ++k) {
				if (land[k] == min) {
					min_index = k;
					land[k] += 1;
					break;
				}
			}
			for (int t = 0; t < 100; ++t) {
				if (land[t] == max) {
					max_index = t;
					land[t] -= 1;
					break;
				}
			}
			int min = *min_element(land.begin(), land.end());
			int max = *max_element(land.begin(), land.end());
			diff = max - min;
		}
		dumpNum--;
	}
	answer = diff;
}
int main() {
	const int test_case = 10;
	for (int i = 1; i <= test_case; ++i) {
		answer = 0;
		land.resize(100);
		scanf("%d", &dumpNum);
		for (int j = 0; j < 100; ++j) {
			scanf("%d", &land[j]);
		}
		flatten(land, dumpNum);
		printf("#%d %d\n", i, answer);
	}	
	return 0;
}