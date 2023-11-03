// gcc -fopenmp 5-joined.c && ./a.out

#include <stdio.h>
#include <time.h>
#include <math.h>
#define ceild(n,d)  ceil(((double)(n))/((double)(d)))
#define floord(n,d) floor(((double)(n))/((double)(d)))
#define max(x,y)    ((x) > (y)? (x) : (y))
#define min(x,y)    ((x) < (y)? (x) : (y))

int main() {
    int n = 6; 
    int aParallel[n+1][n+1];
    int aGenerated[n+1][n+1];

    for (int i = 0; i <= n; i++)
        for (int j = 0; j <= n; j++) {
            aParallel[i][j] = j;
            aGenerated[i][j] = j;
    }

    // równoległy - wejściowy
    for (int i = 1; i <= n; i++) {
        #pragma openmp parallel for 
        for (int j = 2; j <= n; j++) {
            aParallel[i][j] = aParallel[i][j-1] + aParallel[i+1][j];
        }
    }

    // sekwencyjny - wygenerowany
    for (int c0 = 2; c0 <= 2 * n; c0 += 1)
        for (int c1 = max(1, -n + c0); c1 <= min(n, c0 - 1); c1 += 1) {
            aParallel[c0][c1] = aParallel[c0][c1-1] + aParallel[c0+1][c1];
    }

    printf("Parallel code result:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%02d ", aParallel[i][j]);
        }
        printf("\n");
    }

    printf("\nGenerated code result:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%02d ", aGenerated[i][j]);
        }
        printf("\n");
    }


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
        printf("\nResults are not identical. %d values do not match.\n", noMatchCount);
    else 
        printf("\nResults are identical.\n");

    return 0;
}
