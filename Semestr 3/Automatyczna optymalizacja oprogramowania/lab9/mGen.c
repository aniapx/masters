// gcc mGen.c -o gen
// ./gen 800 matrix1.txt & ./gen 800 matrix2.txt

#include <stdio.h>
#include <stdlib.h>

void generateAndSaveMatrix(int size, const char *filename) {
    FILE *file = fopen(filename, "w");

    if (file == NULL) {
        perror("Unable to open the file for writing");
        exit(EXIT_FAILURE);
    }

    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            fprintf(file, "%d ", rand() % 100);
        }
        fprintf(file, "\n");
    }

    fclose(file);
}

int main(int argc, char *argv[]) {
    if (argc != 3) {
        fprintf(stderr, "Usage: %s <matrix_size> <file_name>\n", argv[0]);
        return EXIT_FAILURE;
    }

    int size = atoi(argv[1]);

    if (size <= 0) {
        fprintf(stderr, "Error: Matrix size must be a positive number.\n");
        return EXIT_FAILURE;
    }

    const char *filename = argv[2];

    generateAndSaveMatrix(size, filename);

    printf("A matrix of size %d x %d has been saved to the file %s.\n", size, size, filename);

    return EXIT_SUCCESS;
}
