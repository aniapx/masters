#include <omp.h>
#include <math.h>
#define ceild(n,d)  ceil(((double)(n))/((double)(d)))
#define floord(n,d) floor(((double)(n))/((double)(d)))
#define max(x,y)    ((x) > (y)? (x) : (y))
#define min(x,y)    ((x) < (y)? (x) : (y))

// gcc mMux.c -o mux
// ./mux matrix1.txt matrix2.txt result.txt 800
// polycc mMux.c --tile --parallel & gcc mMux.pluto.c -lm -o muxpluto & ./muxpluto matrix1.txt matrix2.txt result.txt 1000
// ./muxpluto matrix1.txt matrix2.txt result.txt 800

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void multiplyMatrices(int **matrixA, int **matrixB, int **result, int size) {
/* Copyright (C) 1991-2020 Free Software Foundation, Inc.
   This file is part of the GNU C Library.

   The GNU C Library is free software; you can redistribute it and/or
   modify it under the terms of the GNU Lesser General Public
   License as published by the Free Software Foundation; either
   version 2.1 of the License, or (at your option) any later version.

   The GNU C Library is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
   Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public
   License along with the GNU C Library; if not, see
   <https://www.gnu.org/licenses/>.  */
/* This header is separate from features.h so that the compiler can
   include it implicitly at the start of every compilation.  It must
   not itself include <features.h> or any other header that includes
   <features.h> because the implicit include comes before any feature
   test macros that may be defined in a source file before it first
   explicitly includes a system header.  GCC knows the name of this
   header in order to preinclude it.  */
/* glibc's intent is to support the IEC 559 math functionality, real
   and complex.  If the GCC (4.9 and later) predefined macros
   specifying compiler intent are available, use them to determine
   whether the overall intent is to support these features; otherwise,
   presume an older compiler has intent to support these features and
   define these macros by default.  */
/* wchar_t uses Unicode 10.0.0.  Version 10.0 of the Unicode Standard is
   synchronized with ISO/IEC 10646:2017, fifth edition, plus
   the following additions from Amendment 1 to the fifth edition:
   - 56 emoji characters
   - 285 hentaigana
   - 3 additional Zanabazar Square characters */
  int t1, t2, t3, t4, t5, t6, t7;
 int lb, ub, lbp, ubp, lb2, ub2;
 register int lbv, ubv;
/* Start of CLooG code */
if (size >= 1) {
  lbp=0;
  ubp=floord(size-1,256);
#pragma omp parallel for private(lbv,ubv,t3,t4,t5,t6,t7)
  for (t2=lbp;t2<=ubp;t2++) {
    for (t3=0;t3<=floord(size-1,256);t3++) {
      for (t4=256*t2;t4<=min(size-1,256*t2+255);t4++) {
        lbv=256*t3;
        ubv=min(size-1,256*t3+255);
#pragma ivdep
#pragma vector always
        for (t5=lbv;t5<=ubv;t5++) {
          result[t4][t5] = 0;;
        }
      }
    }
  }
  lbp=0;
  ubp=floord(size-1,256);
#pragma omp parallel for private(lbv,ubv,t3,t4,t5,t6,t7)
  for (t2=lbp;t2<=ubp;t2++) {
    for (t3=0;t3<=floord(size-1,256);t3++) {
      for (t4=0;t4<=floord(size-1,256);t4++) {
        for (t5=256*t2;t5<=min(size-1,256*t2+255);t5++) {
          for (t6=256*t4;t6<=min(size-1,256*t4+255);t6++) {
            lbv=256*t3;
            ubv=min(size-1,256*t3+255);
#pragma ivdep
#pragma vector always
            for (t7=lbv;t7<=ubv;t7++) {
              result[t5][t7] += matrixA[t5][t6] * matrixB[t6][t7];;
            }
          }
        }
      }
    }
  }
}
/* End of CLooG code */
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
