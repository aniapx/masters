#include <stdio.h>

int main()
{
    int n = 5;
    int a[n][n];

    for (int i = 1; i <= n; i++)
    {
        for (int j = 2; j <= n; j++)
        {
            a[i][j] = a[i][j + 3] + a[i + 3][j - 2];
        }
    }
}

/*
co trzeba zrobić:
znaleźć iteracja
przedstaiłcć zalezności na grafie
*/