int main() {
	int i;
	int j;
	int n;
	int a[n][n];
	
	#pragma scop
	for(i=1;i<=n;i++)
		for(j=1;j<=n;j++)
			a[i][j] = a[2*i-1][j-1];
	#pragma endscop

	return 0;
}