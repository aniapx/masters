// gcc comparator.c && ./a.out

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int compareFiles(const char *file1, const char *file2) {
    FILE *f1 = fopen(file1, "r");
    FILE *f2 = fopen(file2, "r");

    if (f1 == NULL || f2 == NULL) {
        perror("Error opening files");
        return -1;
    }

    int c1, c2;
    int position = 0;

    while ((c1 = fgetc(f1)) != EOF && (c2 = fgetc(f2)) != EOF) {
        position++;

        if (c1 != c2) {
            printf("Files differ at position %d\n", position);
            fclose(f1);
            fclose(f2);
            return position;
        }
    }

    if (c1 == EOF && c2 == EOF) {
        printf("Files are identical\n");
    } else {
        printf("Files have different lengths\n");
    }

    fclose(f1);
    fclose(f2);
    return 0;
}

int main() {
    const char *file1 = "output1.txt";
    const char *file2 = "output2.txt";

    int result = compareFiles(file1, file2);

    if (result == 0) {
        printf("Files are identical.\n");
    } else if (result == -1) {
        printf("Error opening files.\n");
    } else {
        printf("Files differ at position %d.\n", result);
    }

    return 0;
}
