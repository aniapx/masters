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
        for (int j = 3; j <= n; j++) {
            aInput[i][j] = aInput[i][j-3];
        }
    }

    // wygenerowany
    for (int c0 = 0; c0 < floord(n + 1, 2); c0 += 1)
        for (int c1 = 0; c1 < (n + 1) / 2; c1 += 1)
            for (int c2 = 2 * c0 + 1; c2 <= min(n, 2 * c0 + 2); c2 += 1) {
                if (n >= 2 * c0 + 2) {
                    for (int c3 = 2 * c1 + 3; c3 <= min(n, 2 * c1 + 5); c3 += 1)
                        aGenerated[c2][c3] = aGenerated[c2][c3-3];
                } 
                else if (n >= 2 * c1 + 3) {
                    for (int c3 = 2 * c1 + 1; c3 <= 2 * c1 + 2; c3 += 1)
                        aGenerated[c2][c3] = aGenerated[c2][c3-3];
                } 
                else {
                    aGenerated[n][n] = aGenerated[n][n-3];
                }
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
