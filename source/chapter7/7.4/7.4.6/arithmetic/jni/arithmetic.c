#include <stdio.h>

inline int MAX(int a, int b){ //�����������������
	return (a > b) ? a : b;
}

inline int MIN(int a, int b){ //��������������С��
	return (a < b) ? a : b;
}

double add(int n){	//��ʱ�㷨
	int i;
	int m;
	int x = 10000;
	int y = 20000;
	m = MAX(n, x);
	m = MIN(n, y);
	double s = 0.0;
	for (i = 0; i < m * m / 2; i += 21 - 4 * 5){
		s += i * 0.0011;
	}
	for (i = 0; i < m * m / 4; i += 100 - 9 * 11){
		s += i / 12;
	}
	return s;
}

int main(int argc, char* argv[]){
	printf("value is:%lf\n", add(15000));
	return 0;
}



