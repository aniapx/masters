// gcc -fopenmp 2-joined.c && ./a.out

#include <stdio.h>
#include <time.h>
#include <math.h>

int main() {
    int n = 6; 
    int aInput[n+1][n+1];
    int aGenerated[n+1][n+1];

    for (int i = 0; i <= n; i++)
        for (int j = 0; j <= n; j++) {
            aInput[i][j] = j;
            aGenerated[i][j] = j;
    }

    // wejściowy
	for (int i = 2; i <= n; i++)
		for (int j = 1; j <= n; j++)
			aInput[i][j] = aInput[i-2][j-1];

    // wygenerowany
    if (n >= 2) {
        #pragma parallel for
        for (int c0 = 2; c0 <= n; c0 += 1)
            for (int c3 = 1; c3 <= n; c3 += 1)
                aGenerated[c0][c3] = aGenerated[c0-2][c3-1];
    }

    printf("Initial code result:\n");
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= n; j++) {
            printf("%02d ", aInput[i][j]);
        }
        printf("\n");
    }

    printf("\nGenerated code result:\n");
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= n; j++) {
            printf("%02d ", aGenerated[i][j]);
        }
        printf("\n");
    }


    int noMatchCount = 0;
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= n; j++) {
            if (aInput[i][j] != aGenerated[i][j])
                noMatchCount++;
        }
    }

    if (noMatchCount > 0)
        printf("\nResults are not identical. %d values do not match.\n", noMatchCount);
    else 
        printf("\nResults are identical.\n");

    return 0;
}
