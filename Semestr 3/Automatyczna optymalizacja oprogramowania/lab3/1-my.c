int main() {
	int i;
	int j;
	int n;
	int a[n][n];
	
	#pragma scop
		for(i=1; i<=n; i++)
			for(j=2; j<=n; j++)
				a[i][j] = a[i][j-2];
	#pragma endscop

	return 0;
}