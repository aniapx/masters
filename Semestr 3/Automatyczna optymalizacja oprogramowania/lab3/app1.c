// gcc app1.c -lm && ./a.out

#include <stdio.h>
#include <math.h>

int main() {
    int n = 6; 
    int a[n*4][n];

    FILE *file = fopen("output1.txt", "w");
    if (file == NULL) {
        perror("Error opening file");
        return 1;
    }

    // sekwencyjny - wygenerowany
    for (int c0 = 1; c0 <= n; c0 += 1) {
        for (int c2 = 2; c2 <= n; c2 += 1) {
            a[c0][c2] = a[c0][c2+1];
            fprintf(file, "%d ", a[c0][c2+1]);
        }
        fprintf(file, "\n");
    }

    fclose(file);

    return 0;
}
