//============================================================================
// Name        : Merge_Sort.cpp
// Author      : Selcuk Ilhan AYDI
// Version     : 1.0
// Copyright   : GNU Free Licence
// Description : Merge Sort Algorithm
//============================================================================

#include <iostream>
using namespace std;

void printArr(int* arr, int len);
void printArr(int *arr, int low, int high);
void Merge(int *arr, int l, int m, int h);
void SubArr(int *arr, int low, int high);


int main() {

	int arr[7] = { 99, 5, 8, 1, 6, 7, 89 };

	//Merge(arr, 0, 2, 5);
	SubArr(arr, 0, 6);
	printArr(arr, 7);
	return 0;
}

void Merge(int *arr, int l, int m, int h) {

	cout<<"Left  -> ";
	printArr(arr, l, m);
	cout<<"Right -> ";
	printArr(arr, m + 1, h);

	int n1 = m - l + 1;
	int n2 = h - m;
	int left[n1 + 1], right[n2 + 1];

	for(int i = 0; i < n1; ++i)
		left[i] = arr[l + i];
	for(int i = 0; i < n2; ++i)
		right[i] = arr[m + i + 1];

	left[n1] = 999999;
	right[n2] = 999999;

	for(int k = l, i = 0, j = 0; k <= h; ++k) {
		if(left[i] <= right[j]) {
			arr[k] = left[i];
			++i;
		}
		else {
			arr[k] = right[j];
			++j;
		}
	}
}

void printArr(int *arr, int len) {
	for(int i = 0; i < len; ++i) {
		cout<<arr[i]<<" ";
	}
}

void printArr(int *arr, int low, int high) {
	for(int i = low; i <= high; i++){
		cout<<arr[i]<<" ";
	}
	cout<<endl;
}

void SubArr(int *arr, int low, int high) {
	if(low >= high) {
		//cout<<"["<<arr[low]<<"]"<<endl; // There is only one element so let's print it.
		return;
	}
	int mid = (high + low) / 2;
	SubArr(arr, low, mid);
	SubArr(arr, mid + 1, high);
	Merge(arr, low, mid, high);
}
