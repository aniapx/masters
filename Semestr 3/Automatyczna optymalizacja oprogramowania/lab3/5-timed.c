// gcc -fopenmp 5-timed.c && ./a.out

#include <stdio.h>
#include<time.h>

int main() {
    int n = 6; 
    int aParallel[n+1][n+1];
    int aGenerated[n+1][n+1];

	clock_t startP, endP, startG, endG;

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++) {
            aParallel[i][j] = j;
            aGenerated[i][j] = j;
    }

    // równoległy - wejściowy
	startP = clock();
    for (int i = 1; i <= n; i++) {
        #pragma openmp parallel for 
        for (int j = 2; j <= n; j++) {
            aParallel[i][j] = aParallel[i][j-2];
        }
    }
	endP = clock();
    printf("Parallel loop execution time:  %fms\n", (double)(endP - startP));

    // sekwencyjny - wygenerowany
	startG = clock();
    for (int c0 = 1; c0 <= n; c0 += 1)
        for (int c2 = 2; c2 <= n; c2 += 1) {
            aGenerated[c0][c2] = aGenerated[c0][c2-2];
    }
	endG = clock();
    printf("Generated loop execution time: %fms\n", (double)(endG - startG));


    int noMatchCount = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (aParallel[i][j] != aGenerated[i][j]) {
                noMatchCount++;
                // printf("Not matching at: [%d][%d]\n", i, j);
            }
        }
    }

    if (noMatchCount > 0)
        printf("Results are not identical. %d values do not match.\n", noMatchCount);
    else 
        printf("Results are identical.\n");

    return 0;
}
