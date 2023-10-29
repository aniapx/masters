function [ W ] = Plust_g( A, B )

W = 1;

[w, k] = size(A);

for i = 1 : w
    B(i) = B(i) ./ A(i, i);
    A(i, :) = A(i, :) ./ A(i, i);
    for j = i + 1:w
         B(j) = B(j) - B(i) * A(j, i);
         A(j, :) = A(j, :) - A(i, :) * A(j, i);
    end
end

W(w) = B(w);

for i = w-1 : -1 : 1
    W(i) = B(i);
    for j = w : -1 : i+1
        W(i) = B(i) - A(i, j) * W(j);
    end
end

W

