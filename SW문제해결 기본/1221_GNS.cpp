#include <iostream>
#include <string>
using namespace std;
int test_case;
int main() {
	cin >> test_case;
	for (int i = 1; i <= test_case; ++i) {
		string num,word;
		int len=0;
		int answer[10] = { 0 };
		cin >> num >> len;
		for (int j = 0; j < len; ++j) {
			cin >> word;
			if (word == "ZRO") answer[0]++;
			else if (word == "ONE")answer[1]++;
			else if (word == "TWO")answer[2]++;
			else if (word == "THR")answer[3]++;
			else if (word == "FOR")answer[4]++;
			else if (word == "FIV")answer[5]++;
			else if (word == "SIX")answer[6]++;
			else if (word == "SVN")answer[7]++;
			else if (word == "EGT")answer[8]++;
			else answer[9]++;
		}		
		cout << "#" << i << endl;
		for (int k = 0; k < 10; ++k) {
			for (int t = 0; t < answer[k]; ++t) {
				if (k == 0) cout << "ZRO" << " ";
				if (k == 1) cout << "ONE" << " ";
				if (k == 2) cout << "TWO" << " ";
				if (k == 3) cout << "THR" << " ";
				if (k == 4) cout << "FOR" << " ";
				if (k == 5) cout << "FIV" << " ";
				if (k == 6) cout << "SIX" << " ";
				if (k == 7) cout << "SVN" << " ";
				if (k == 8) cout << "EGT" << " ";
				if (k == 9) cout << "NIN" << " ";
			}
		}
		cout << endl;
	}
	return 0;
}