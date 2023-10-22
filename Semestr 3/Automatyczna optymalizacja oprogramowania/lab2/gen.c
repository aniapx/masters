int main() {
    int  c1,c2,n;
    int a[n][n];

    for (int c0 = 4; c0 <= 4 * n; c0 += 1)
        for (int c1 = max(1, floord(-n + c0 - 1, 3) + 1); c1 <= min(n, (c0 - 1) / 3); c1 += 1)
            (c0 - 3 * c1, c1);

}