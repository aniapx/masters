int main() {
	int n;
	int a[n+1][n+1];
	
	#pragma scop
	for(int i = 1; i <= n; i++)
		for(int j = 3; j <= n; j++)
			a[i][j] = a[i][j-3];
	#pragma endscop

	return 0;
}