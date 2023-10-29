// gcc -fopenmp 5-parallel.c && ./a.out

#include <stdio.h>

int main() {
    int n = 6;
    int a[n+1][n+1];

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            a[i][j] = j;

    FILE *file = fopen("5-parallel.txt", "w");
    if (file == NULL) {
        perror("Error opening file");
        return 1;
    }

    // równoległy - wejściowy
    for (int i = 1; i <= n; i++) {
        #pragma openmp parallel for 
        for (int j = 2; j <= n; j++) {
            a[i][j] = a[i][j-2];
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            fprintf(file, "%02d ", a[i][j]);
        }
        fprintf(file, "\n");
    }

    fclose(file);

    return 0;
}
