#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void generateRandomMatrix(int n, int matrix[n][n]) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            matrix[i][j] = rand() % 100;
        }
    }
}

void saveMatrixToFile(int n, int matrix[n][n], const char *filename) {
    FILE *file = fopen(filename, "w");

    if (file == NULL) {
        perror("Unable to open the file");
        exit(EXIT_FAILURE);
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            fprintf(file, "%d ", matrix[i][j]);
        }
        fprintf(file, "\n");
    }

    fclose(file);
}

int main() {
    int n = 1000;

    srand(time(NULL));

    int matrix1[n][n];
    int matrix2[n][n];

    generateRandomMatrix(n, matrix1);
    generateRandomMatrix(n, matrix2);

    saveMatrixToFile(n, matrix1, "matrix1.txt");
    saveMatrixToFile(n, matrix2, "matrix2.txt");

    printf("Matrices have been generated and saved to files.\n");

    return 0;
}

