// gcc 5-generated.c && ./a.out

#include <stdio.h>

int main() {
    int n = 6; 
    int a[n+1][n+1];

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            a[i][j] = j;

    FILE *file = fopen("5-generated.txt", "w");
    if (file == NULL) {
        perror("Error opening file");
        return 1;
    }

    // sekwencyjny - wygenerowany
    for (int c0 = 1; c0 <= n; c0 += 1)
        for (int c2 = 2; c2 <= n; c2 += 1)
            a[c0][c2] = a[c0][c2-2];

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            fprintf(file, "%02d ", a[i][j]);
        }
        fprintf(file, "\n");
    }

    fclose(file);

    return 0;
}
