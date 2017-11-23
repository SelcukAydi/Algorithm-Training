//============================================================================
// Name        : HeapSort.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
using namespace std;

void HeapIFY(int A[], int i);
void BuildMaxHeap(int A[]);
void HeapSort(int A[]);
int Left(int i);
int Right(int i);
void SwapElements(int i, int largest, int A[]);
void printArray(int A[], int length);

int length = 10;
int heapSize = length - 1;

int main() {

	int A[length] = { 0,4,3,10,7,1,2,8,14,16 };
	HeapSort(A);
	printArray(A, length);

	cout<<"\nDone"<<endl;

	return 0;
}

void HeapIFY(int A[], int i) {
	int left = Left(i);
	int right = Right(i);
	int largest;

	if(left <= heapSize && A[left] > A[i])
		largest = left;
	else
		largest = i;

	if(right <= heapSize && A[right] > A[largest])
		largest = right;

	if(largest != i){
		SwapElements(i, largest, A);
		HeapIFY(A, largest);
	}
}

void BuildMaxHeap(int A[]) {
	for(int i = (length / 2) - 1; i >= 0; i--) {
		HeapIFY(A, i);
	}
}

void HeapSort(int A[]) {
	BuildMaxHeap(A);
	for(int i = length - 1; i >= 1; i--) {
		SwapElements(i, 0, A);
		heapSize--;
		HeapIFY(A, 0);
	}
}

int Left(int i) {
	return (i * 2) + 1;
}

int Right(int i) {
	return Left(i) + 1;
}

void SwapElements(int i, int largest, int A[]) {
	int tmp = A[i];
	A[i] = A[largest];
	A[largest] = tmp;
}

void printArray(int A[], int length) {
	for(int i = 0; i < length; i++) {
		cout<<A[i]<<" ";
	}
}
