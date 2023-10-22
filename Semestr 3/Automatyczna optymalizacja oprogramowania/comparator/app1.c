#include <stdio.h>
#include <math.h>
#define ceild(n,d)  ceil(((double)(n))/((double)(d)))
#define floord(n,d) floor(((double)(n))/((double)(d)))
#define max(x,y)    ((x) > (y)? (x) : (y))
#define min(x,y)    ((x) < (y)? (x) : (y))

int runApp1() {
    int n = 2;
    int a[n*4+1][n];

    int index = 0;

    for (int i = 0; i < n*4+1; i++) {
        for (int j = 0; j < n; j++) {
            a[i][j] = i + j;
        }
    }

// DO NOT CHANGE
    for (int c0 = 4; c0 <= 4 * n; c0 += 1) {
        for (int c1 = max(1, floord(-n + c0 - 1, 3) + 1); c1 <= min(n, (c0 - 1) / 3); c1 += 1) {
            a[c0-c1][c1] = a[c0-c1][c1-1];
        }
    }
// DO NOT CHANGE

    for (int i = 0; i < n*4+1; i++) {
        printf("\n [%d]   ", i);
        for (int j = 0; j < n; j++) {
            printf("%d  ", a[i][j]);
        }
    }

    return 0;
}