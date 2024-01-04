// gcc mMux.c -o mux
// ./mux matrix1.txt matrix2.txt result.txt 800
// polycc mMux.c --tile --parallel & gcc mMux.pluto.c -lm -o muxpluto & ./muxpluto matrix1.txt matrix2.txt result.txt 1000
// ./muxpluto matrix1.txt matrix2.txt result.txt 800

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void multiplyMatrices(int **matrixA, int **matrixB, int **result, int size) {
#pragma scop
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            result[i][j] = 0;
            for (int k = 0; k < size; k++) {
                result[i][j] += matrixA[i][k] * matrixB[k][j];
            }
        }
    }
#pragma endscop
}

void readMatrixFromFile(const char *fileName, int **matrix, int size) {
    FILE *file = fopen(fileName, "r");
    if (file == NULL) {
        perror("Error opening file");
        exit(EXIT_FAILURE);
    }

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            if (fscanf(file, "%d", &matrix[i][j]) != 1) {
                fprintf(stderr, "Error reading from file\n");
                fclose(file);
                exit(EXIT_FAILURE);
            }
        }
    }

    fclose(file);
}

void writeMatrixToFile(const char *fileName, int **matrix, int size) {
    FILE *file = fopen(fileName, "w");
    if (file == NULL) {
        perror("Error opening file");
        exit(EXIT_FAILURE);
    }

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            fprintf(file, "%d ", matrix[i][j]);
        }
        fprintf(file, "\n");
    }

    fclose(file);
}

int main(int argc, char *argv[]) {
    clock_t startTime, endTime;

    startTime = clock();

    if (argc != 5) {
        fprintf(stderr, "Wrong number of arguments: %s matrixA_file matrixB_file result_file size\n", argv[0]);
        return EXIT_FAILURE;
    }

    int size = atoi(argv[4]);

    int **matrixA = malloc(size * sizeof(int *));
    int **matrixB = malloc(size * sizeof(int *));
    int **result = malloc(size * sizeof(int *));
    for (int i = 0; i < size; i++) {
        matrixA[i] = malloc(size * sizeof(int));
        matrixB[i] = malloc(size * sizeof(int));
        result[i] = malloc(size * sizeof(int));
    }
    readMatrixFromFile(argv[1], matrixA, size);
    readMatrixFromFile(argv[2], matrixB, size);
    // endTime = clock();

    // double elapsedTime1 = (double)(endTime - startTime) / CLOCKS_PER_SEC;

    // startTime = clock();
    multiplyMatrices(matrixA, matrixB, result, size);
    // endTime = clock();

    // double elapsedTime2 = (double)(endTime - startTime) / CLOCKS_PER_SEC;

    // startTime = clock();
    writeMatrixToFile(argv[3], result, size);

    for (int i = 0; i < size; i++) {
        free(matrixA[i]);
        free(matrixB[i]);
        free(result[i]);
    }
    free(matrixA);
    free(matrixB);
    free(result);
    
    endTime = clock();

    double elapsedTime3 = (double)(endTime - startTime) / CLOCKS_PER_SEC;

    // printf("Matrix multiplication completed successfully. Result saved in %s\n\n", argv[3]);
    // printf("Sequential time 1: %.6f\n", elapsedTime1);
    // printf("Parallel time:     %.6f\n", elapsedTime2);
    // printf("Sequential time 2: %.6f\n", elapsedTime3);

    // double sequentialRatio = ((elapsedTime1 + elapsedTime3) / (elapsedTime1 + elapsedTime2 + elapsedTime3)) * 100;
    // printf("Sequential code execution time: %.3f%%\n", sequentialRatio);

    printf("%.6f\n", elapsedTime3);
    
    return EXIT_SUCCESS;
}
