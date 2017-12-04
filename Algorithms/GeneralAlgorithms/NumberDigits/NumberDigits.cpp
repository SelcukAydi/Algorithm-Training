//============================================================================
// Name        : NumberDigits.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <vector>
using namespace std;

int main() {

	int n;
	int p = 10;
	vector<int> v;

	cout<<"Please type in the number :";
	cin>>n;

	for(int i = 1; i < 5; ++i){
		int k = n % p;

		if((n / p) < 1){
			v.push_back(n/(p / 10));
			break;
		}

		if(k < 10){
			v.push_back(k);
		}
		else {
			k = k / (p / 10);
			v.push_back(k);
			k = k * (p / 10);
		}
		n = n - (k);
		p *= 10;
	}

	for(int i = v.size() - 1; i >= 0; --i){
		cout<<v[i];
	}

	return 0;
}