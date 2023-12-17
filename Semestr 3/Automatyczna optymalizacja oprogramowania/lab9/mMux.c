#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void readMatrixFromFile(int n, int matrix[n][n], const char *filename) {
    FILE *file = fopen(filename, "r");


    if (file == NULL) {
        perror("Unable to open the file");
        exit(EXIT_FAILURE);
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            fscanf(file, "%d", &matrix[i][j]);
        }
    }

    fclose(file);
}

void matrixMultiply(int n, int matrix1[n][n], int matrix2[n][n], int result[n][n]) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            result[i][j] = 0;
            for (int k = 0; k < n; k++) {
                result[i][j] += matrix1[i][k] * matrix2[k][j];
            }
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

    int **matrix1 = (int **)malloc(n * sizeof(int *));
    int **matrix2 = (int **)malloc(n * sizeof(int *));
    int **result = (int **)malloc(n * sizeof(int *));
    for (int i = 0; i < n; i++)
    {
        matrix1[i] = (int *)malloc(n * sizeof(int));
        matrix2[i] = (int *)malloc(n * sizeof(int));
        result[i] = (int *)malloc(n * sizeof(int));
    }

    readMatrixFromFile(n, matrix1, "matrix1.txt");
    readMatrixFromFile(n, matrix2, "matrix2.txt");

    clock_t begin = clock();

    #pragma scop
    matrixMultiply(n, matrix1, matrix2, result);
	#pragma endscop

    clock_t end = clock();
    double timeSpent = (double)(end - begin) / CLOCKS_PER_SEC;
    printf("Time spent on : %f\n", timeSpent);

    saveMatrixToFile(n, result, "result.txt");

    printf("Matrix multiplication result has been saved to 'result.txt'.\n");

    return 0;
}
