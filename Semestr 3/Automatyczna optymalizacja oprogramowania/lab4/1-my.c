int main() {
	int n;
	int a[n][n];
	
	#pragma scop
	for (int i=1; i<=n;i++)
		for (int j=1; j<=n;j++)
			a[i][j] = a[i][j-1] + a[i+1][j];
	// for (int c0 = 1; c0 <= n; c0 += 1)
	// 	for (int c1 = 1; c1 <= n; c1 += 1)
	// 		a[c0][c1] = a[c0][c1-1] + a[c0+1][c1];
	#pragma endscop

	return 0;
}