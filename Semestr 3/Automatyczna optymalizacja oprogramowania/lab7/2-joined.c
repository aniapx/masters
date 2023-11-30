// gcc -fopenmp 2-joined.c -lm && ./a.out

#include <stdio.h>
#include <time.h>
#include <math.h>
#define ceild(n,d)  ceil(((double)(n))/((double)(d)))
#define floord(n,d) floor(((double)(n))/((double)(d)))
#define max(x,y)    ((x) > (y)? (x) : (y))
#define min(x,y)    ((x) < (y)? (x) : (y))

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
    for (int i = 1; i <= n; i++) {
        for (int j = 2; j <= n; j++) {
            aInput[i][j] = aInput[i][j-2];
        }
    }

    // wygenerowany
    for (int c0 = 1; c0 < floord(n, 2); c0 += 1)
        #pragma openmp parallel for
        for (int c1 = 1; c1 <= n; c1 += 1)
            for (int c2 = 2 * c0; c2 <= min(n, 2 * c0 + 3); c2 += 1) {
                aGenerated[c1][c2] = aGenerated[c1][c2-2];
                printf("[c1 = %d, c2 = %d]   <=   [c1 = %d, c2 = %d]\n", c1, c2, c1, c2-2);
            }


    #pragma openmp parallel for
    for (int c1 = 3; c1 <= 6; c1 += 1) {
        aGenerated[2][c1] = aGenerated[2][c1-2];
        printf("[c1 = %d, c2 = %d]   <=   [c1 = %d, c2 = %d]\n", 2, c1, 2, c1-2);
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
            if (aInput[i][j] != aGenerated[i][j]) {
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
