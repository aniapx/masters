int main() {
	int n;
	int a[n][n];
	
	#pragma scop
	for(int i=1;i<=n;i++)
		for(int j=1;j<=n;j++)
			a[i][j] = a[i][j-1] + a[i+1][j];
	#pragma endscop

	return 0;
}