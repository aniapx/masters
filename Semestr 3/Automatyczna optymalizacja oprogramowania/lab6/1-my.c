int main() {
	int n;
	int a[n][n];
	
	#pragma scop
	for (int i = 2; i <= n; i++)
		for (int j = 1; j <= n; j++)
			a[i][j] = a[i-2][j-1];
	#pragma endscop

	return 0;
}