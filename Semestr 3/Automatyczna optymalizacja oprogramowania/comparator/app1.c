// gcc -fopenmp app1.c -lm && ./a.out

#include <stdio.h>
#include <math.h>
#define ceild(n,d)  ceil(((double)(n))/((double)(d)))
#define floord(n,d) floor(((double)(n))/((double)(d)))
#define max(x,y)    ((x) > (y)? (x) : (y))
#define min(x,y)    ((x) < (y)? (x) : (y))

// #define P #pragma openmp parallel for 
#define S   a[i][j]=a[i][j-1];
#define i c0-c1  // zgodnie z pierwszym elementem pseudoinstrtukcji (c0 - c1, c1);
#define j c1 // zgodnie z drugim elementem pseudoinstrtukcji (c0 - c1, c1);

int main() {
    int n = 6; 
    int a[n*4][n];

    FILE *file = fopen("output1.txt", "w");
    if (file == NULL) {
        perror("Error opening file");
        return 1;
    }

    for (int c0 = 4; c0 <= 4 * n; c0 += 1) {
        #pragma openmp parallel for 
        for (int c1 = max(1, floord(-n + c0 - 1, 3) + 1); c1 <= min(n, (c0 - 1) / 3); c1 += 1) {
            S
            fprintf(file, "%d ", a[i][j]);
        }
        fprintf(file, "\n");
    }

    fclose(file);

    return 0;
}
