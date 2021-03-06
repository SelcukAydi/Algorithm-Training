#include "stdafx.h"
#include <Bits.h>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void prepare();
void copyArray(char tmp[]);

vector<string> v;
char alphabets[24];

int main()
{
	int n = 0;
	cin >> n;
	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		v.push_back(s);
	}

	prepare();

	int totalAcronyms = 0;

	for (int i = 0; i < v.size(); ++i) {
		char tmp[24];
		bool c = false;
		copyArray(tmp);
		tmp[(int)(v[i][0] - 'a')]--;
		for (int j = 0; j < v[i].length(); ++j) {
			if (tmp[(int)(v[i][j] - 'a')] > 0) {
				tmp[(int)(v[i][j] - 'a')]--;
				c = true;
			}
			else {
				c = false;
				break;
			}
		}
		if (c) {
			totalAcronyms++;
		}
	}



    return 0;
}


void prepare() {
	for (int i = 0; i < v.size(); i++) {
		alphabets[(int)(v[i][0] - 'a')]++;
	}
}

void copyArray(char tmp[]) {
	for (int i = 0; i < 24; i++) {
		tmp[i] = alphabets[i];
	}
}
