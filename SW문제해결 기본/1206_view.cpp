#include <algorithm>
#include <cstdio>
#include <vector>
using namespace std;
vector<int> land;
int answer, value;
int check[4] = { -1,-2,1,2 };

bool isView(const vector<int> &land, int index) {
	int height = land[index];
	value = height;
	for (int i = 0; i < 4; ++i) {
		if (height < land[index + check[i]]) return false;
		else {
			value = min(value, height - land[index + check[i]]);
		}
	}
	answer += value;
	return true;
}


int main() {
	int length, test_case = 10;
	for (int i = 1; i <= test_case; ++i) {
		answer = 0;
		scanf("%d", &length);
		land.resize(length);
		for (int j = 0; j < length; ++j) {
			scanf("%d", &land[j]);
		}
		for (int k = 2; k < length - 2; ++k) {
			if ((isView(land, k) == false))
				continue;
		}
		printf("#%d %d\n", i, answer);
	}
	return 0;
}