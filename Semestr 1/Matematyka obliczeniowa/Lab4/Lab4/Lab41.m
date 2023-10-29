clc;
close all;
clear;
format long e;

eps = 0.01;

A = [1 2; 1 2+eps];
b = [4; 4+eps];

x_det = cond(A)

% analityczna
x_an = [2;1];

% metoda cramera
W = det(A);
for i = 1:max(size(A))
    A1 = A;
    A1(:, i) = b;
    W1 = det(A1);
    x_cramer(i, 1) = W1/W;
end
x_cramer

% odwracanie macierzy
x_inv = inv(A)*b

% Gauss
x_gauss = solveGauss(A, b)

% LU 1
[L, U] = lu(A);
x_LU1 = inv(U) * inv(L) * b

% LU 2
[L, U] = lu(A);
y = L \ b;
x_LU2 = U \ y

% QR 1
[Q, R] = qr(A);
x_QR1 = inv(R) * inv(Q) * b

% QR 2
[Q, R] = qr(A);
y = Q \ b;
x_QR2 = R \ y

% SVD
[U, S, V] = svd(A, 0);
x_SVD = V*((U'*b)./diag(S))

error_cramer = err(x_cramer, x_an)
error_inv = err(x_inv, x_an)
error_gauss = err(x_gauss, x_an)
error_LU1 = err(x_LU1, x_an)
error_LU2 = err(x_LU2, x_an)
error_QR1 = err(x_QR1, x_an)
error_QR2 = err(x_QR2, x_an)
error_SVD = err(x_SVD, x_an)

bar([error_cramer, error_inv, error_gauss, error_LU1, error_LU2, error_QR1, error_QR2, error_SVD])

function x = err(a, b)
    x = abs(a - b);
end

function x = solveGauss(A,B)
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
    x = W';
end 
