#define P #pragma openmp parallel for 
#define S   a[i][j]=a[i][j-1];
#define i c0-c1  // zgodnie z pierwszym elementem pseudoinstrtukcji (c0 - c1, c1);
#define j c1 // zgodnie z drugim elementem pseudoinstrtukcji (c0 - c1, c1);

int main() {
    int  c1,c2,n = 10;
    int a[n][n];

    for (int c0 = 4; c0 <= 4 * n; c0 += 1) {
        P
        for (int c1 = max(1, floord(-n + c0 - 1, 3) + 1); c1 <= min(n, (c0 - 1) / 3); c1 += 1) {
            S
        }
    }
}