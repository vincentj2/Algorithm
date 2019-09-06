#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(const pair<float, int> &a, const pair<float, int> &b)
{
	if (a.first > b.first) return true;
	else if (a.first == b.first) return a.second < b.second;
	else return false;
}

vector<int> solution(int N, vector<int> stages) {
	vector<int> answer;
	vector<int> stage;
	vector<pair<float, int>>fail;
	int total = stages.size();

	int max = *max_element(stages.begin(), stages.end());
	if (max>N) stage.resize(max);
	else stage.resize(N);

	for (int i = 0; i < stages.size(); ++i) {
		int index = stages[i] - 1;
		stage[index]++;
	}
	for (int j = 0; j < N; ++j) {
		if (stage[j] == 0 || total == 0) {
			fail.push_back(make_pair(0, j));
		}
		else fail.push_back(make_pair((float)stage[j] / total, j));
		total -= stage[j];

	}
	sort(fail.begin(), fail.end(), cmp);

	for (int k = 0; k < fail.size(); ++k) {
		answer.push_back((fail[k].second) + 1);
	}
	return answer;
}