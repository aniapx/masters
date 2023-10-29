// gcc -fopenmp app2.c -lm && ./a.out

#include <stdio.h>
#include <math.h>
#define ceild(n,d)  ceil(((double)(n))/((double)(d)))
#define floord(n,d) floor(((double)(n))/((double)(d)))
#define max(x,y)    ((x) > (y)? (x) : (y))
#define min(x,y)    ((x) < (y)? (x) : (y))

int main() {
    int n = 6;
    int a[n*4][n];

    FILE *file = fopen("output2.txt", "w");
    if (file == NULL) {
        perror("Error opening file");
        return 1;
    }

    // równoległy - 
    for(int i=1; i<=n; i++) {}
        #pragma openmp parallel for 
        for(j=2; j<=n; j++) {
            fprintf(file, "%d ", a[i][j-2]);
        }
        fprintf(file, "\n");
    }

    fclose(file);

    return 0;
}
