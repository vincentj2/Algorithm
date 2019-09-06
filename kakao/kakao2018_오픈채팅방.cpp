#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <map>

using namespace std;
vector<string> solution(vector<string> record) {
	vector<string> answer;
	queue < pair<string, string>> q;// "Enter, Leave" + Uid
	map <string, string> m; //uid 갱신
	
	for (int i = 0; i < record.size(); ++i) {
		string tmp;
		vector<string> v;
		for (int j = 0; j < record[i].size(); ++j) {
			if (record[i][j] == ' ') {
				v.push_back(tmp);
				tmp.clear();
			}
			else
				tmp.push_back(record[i][j]);
		}
		v.push_back(tmp);
		if (v[0] == "Change") {
			m[v[1]] = v[2];
		}
		else if (v[0] == "Leave") {
			q.push(make_pair(v[0], v[1]));
		}
		else {
			q.push(make_pair(v[0], v[1]));
			m[v[1]] = v[2];
		}
	}
	while (!q.empty())
	{
		string func = q.front().first;
		string uid = q.front().second;
		string result;
		q.pop();
		if (func == "Enter") {
			result = m[uid] + "님이 들어왔습니다.";
		}
		else
			result = m[uid] + "님이 나갔습니다.";
		answer.push_back(result);
	}
	return answer;
}